package com.skyon.project.system.controller.eyeController;

import com.skyon.common.constant.ProjectContants;
import com.skyon.common.enums.RoleName;
import com.skyon.common.enums.WFLink;
import com.skyon.common.enums.WfCode;
import com.skyon.common.utils.ServletUtils;
import com.skyon.framework.aspectj.lang.annotation.DataScope;
import com.skyon.framework.manager.factory.WfDealRoleRegisterFactory;
import com.skyon.framework.security.LoginUser;
import com.skyon.framework.security.service.TokenService;
import com.skyon.framework.web.controller.BaseController;
import com.skyon.framework.web.domain.AjaxResult;
import com.skyon.project.system.domain.eye.*;
import com.skyon.project.system.domain.eye.waringSings.SeWfWarningSigns;
import com.skyon.project.system.domain.eye.wf.SeWfTaskExecuteFeedback;
import com.skyon.project.system.domain.sys.SysRole;
import com.skyon.project.system.domain.sys.SysUser;
import com.skyon.project.system.domain.vo.WarningTaskListVo;
import com.skyon.project.system.service.activiti.ActivityService;
import com.skyon.project.system.service.activiti.RunWFService;
import com.skyon.project.system.service.activiti.TaskWFService;
import com.skyon.project.system.service.eye.*;
import com.skyon.project.system.service.wf.TaskCommon;
import com.skyon.project.system.util.StringUtil;
import com.skyon.project.system.util.TaskInfoUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.springframework.transaction.annotation.Isolation.READ_COMMITTED;

@Api(tags = "????????????")
@RestController
@RequestMapping("/taskInfo")
public class TaskInfoController extends BaseController {

    @Autowired
    private SignalManualSevice signalManualSevice;
    @Autowired
    private RunWFService runWFService;
    @Autowired
    private TaskWFService taskWFService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private WLinkLogService linkLogService;

    @Autowired
    private WTaskInfoService taskInfoService;

    @Autowired
    private SeWfTaskExecuteFeedbackService seWfTaskExecuteFeedbackService;

    @Autowired
    private SeWfWarningSignsService seWfWarningSignsService;
    @Autowired
    private ActivityService activityService;


    /**
     * ??????????????????????????????
     *
     * @param taskNo ????????????
     * @return
     */
    @ApiOperation(value="??????????????????????????????")
    @GetMapping("/claimTaskByID/{taskNo}")
    public AjaxResult claimTaskByID(@PathVariable("taskNo") String taskNo) {
        SysUser user = tokenService.getLoginUser(ServletUtils.getRequest()).getUser();
        String userId = user.getUserId().toString();
        String roleId = user.getRoleIds()[0].toString();
        taskInfoService.claimTaskByID(taskNo,userId,roleId);
        return AjaxResult.success("????????????");
    }

    /**
     * ??????????????????????????????
     *
     * @param taskNo ????????????
     * @param taskNo ????????????
     * @param taskNo ????????????
     * @return
     */
    @GetMapping("/cancelClaimTaskByID/{taskNo}")
    public AjaxResult cancelClaimTaskByID(@PathVariable("taskNo") String taskNo) {
        SysUser user = tokenService.getLoginUser(ServletUtils.getRequest()).getUser();
        taskInfoService.cancelClaimTaskByID(taskNo);
        return AjaxResult.success("??????????????????");
    }
    /**
     * ??????????????????  ??????????????????
     * ???????????????????????????????????????????????????????????????
     *
     * @param warningTaskListVo
     * @return
     */
    @ApiOperation(value="????????????????????????")
    @GetMapping("/list")
    @DataScope(deptAlias = "d")
    public AjaxResult getAllTaskList( WarningTaskListVo warningTaskListVo) {
        List<TaskInfoListPojo> list = new ArrayList<>();
        List<TaskInfoListPojo> listAct = new ArrayList<>();

        SysUser user = tokenService.getLoginUser(ServletUtils.getRequest()).getUser();
        List<SysRole> roles = user.getRoles();

        try {
            // ?????? ???????????? ????????? ??? ?????????
            if (user.hasRoleId(RoleName.WF_ROLE_011.getCode())) { // ?????? ????????????????????????
                //warningTaskListVo.setTaskHandler(String.valueOf(user.getUserId()));
                list = taskInfoService.getWTaskInfoListByRole(warningTaskListVo);
            }

            // ?????????????????????????????? ????????????id??????????????????
            Map<String, Long> mapTask = taskWFService.taskWfUser(user);
            Set setOwner = mapTask.keySet();


            // ???????????????
            if (setOwner.size() > 0)
                listAct = taskInfoService.getWTaskInfoByList1(setOwner);


            listAct.addAll(list);
            //??????????????????????????????
            if(user != null){
                if(user.hasRoleId(RoleName.WF_ROLE_166.getCode())){
                    listAct.addAll(taskInfoService.getAllTaskListByOrg("04","01",user.getDeptId().toString()));
                }
                //??????????????????????????????
                if(user.hasRoleId(RoleName.WF_ROLE_165.getCode())){
                    listAct.addAll(taskInfoService.getAllTaskListByOrg("04","02",user.getDeptId().toString()));
                }
                //??????????????????????????????
                if(user.hasRoleId(RoleName.WF_ROLE_021.getCode())){
                    listAct.addAll(taskInfoService.getAllTaskListByOrg("04","03",user.getDeptId().toString()));
                }
            }

            return AjaxResult.success(listAct);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error("?????????????????????");
        }

    }
    /**
     * ??????????????????  ??????????????????
     * ???????????????????????????????????????????????????????????????
     *
     * @param warningTaskListVo
     * @return
     */
    @ApiOperation(value="????????????????????????")
    @GetMapping("/listTask")
    @DataScope(deptAlias = "d")
    public AjaxResult getHandingTaskList( WarningTaskListVo warningTaskListVo) {
        List<TaskInfoListPojo> list = new ArrayList<>();
        List<TaskInfoListPojo> listAct = new ArrayList<>();

        SysUser user = tokenService.getLoginUser(ServletUtils.getRequest()).getUser();
        List<SysRole> roles = user.getRoles();

        try {

            // ?????????????????????????????? ????????????id??????????????????
            Map mapTask = taskWFService.taskWfUser(user);
            Set setOwner = mapTask.keySet();


            // ???????????????
            if (setOwner.size() > 0)
                listAct = taskInfoService.getWTaskInfoByList1(setOwner);


            listAct.addAll(list);
            //??????????????????????????????
            if(user.hasRoleId(RoleName.WF_ROLE_011.getCode())){
                listAct.addAll(taskInfoService.getAllTaskListByOrg("02","01",user.getDeptId().toString()));
            }
            //??????????????????????????????
            if(user.hasRoleId(RoleName.WF_ROLE_165.getCode())){
                listAct.addAll(taskInfoService.getAllTaskListByOrg("02","02",user.getDeptId().toString()));
            }
            //??????????????????????????????
            if(user.hasRoleId(RoleName.WF_ROLE_166.getCode())){
                listAct.addAll(taskInfoService.getAllTaskListByOrg("02","03",user.getDeptId().toString()));
            }

            return AjaxResult.success(listAct);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error("?????????????????????");
        }

    }
    /**
     * ????????????-- ???????????????????????????
     *
     * @return AjaxResult
     * @RequestParam("taskInfoNo") String taskInfoNo,
     * @RequestParam("riskControlMeasures") String riskControlMeasures,
     * @RequestParam("radio") Object radio,
     * @RequestParam("examinValue") String examinValue,
     * @RequestParam("personalRiskLevel") String personalRiskLevel,
     * @RequestParam("checkResult") String checkResult,
     * DpApWarningSign warnSignalList
     */
    @ApiOperation(value="????????????????????????")
    @PostMapping("/submitTask")
    @Transactional
    public AjaxResult submitTask(@RequestBody TaskInfoSubmitPojo prjo) {

        logger.info("----submitTask----: ???????????????{}", prjo.getTaskNo());
        SysUser user = tokenService.getLoginUser(ServletUtils.getRequest()).getUser();
        List<SysRole> roles = user.getRoles();

        // ???????????????
        List<SeWfWarningSigns> list = prjo.getWarnSignalList();
        for (SeWfWarningSigns seWfWarningSigns : list) {
            seWfWarningSignsService.updateSeWfWarningSigns(seWfWarningSigns);
        }
        //int signCnt = signalManualSevice.updateSignalManualList(prjo.getWarnSignalList());
        //???????????????  ?????????????????????
        int taskCnt = taskInfoService.updateAffirmTask(prjo);

        SeWfTaskInfo seWfTaskInfo = taskInfoService.selectSeWfTaskInfoByTaskNo(prjo.getTaskNo());

        if(StringUtil.isEmp(user.getDept().getAncestors()))
            return AjaxResult.error("????????????????????????");
        //??????????????????
        WfCode code = TaskInfoUtil.getWfCode(seWfTaskInfo,user);


        // ????????????
        TaskCommon service = WfDealRoleRegisterFactory.getService(String.valueOf(roles.get(0).getRoleId()));
        // ???????????????????????? ???id ??? ???????????? ??? ????????????id
        Map<String, String> reMap =  service.commonSubmit(seWfTaskInfo.getTaskNo(), code, user, "");
        // ??????????????????????????????id ??? ????????????
        Map map = activityService.selectNextNode(reMap.get(ProjectContants.PROCESSIN_STANCE_ID));

        // ?????? ????????????????????????
        SeWfTaskExecuteFeedback seWfTaskExecuteFeedback = seWfTaskInfo.getSeWfTaskExecuteFeedback();
        seWfTaskExecuteFeedback.setTaskNo(seWfTaskInfo.getTaskId());
        seWfTaskExecuteFeedback.setCurrProcSteps(reMap.get(ProjectContants.CURRENT_NAME));
        seWfTaskExecuteFeedback.setCurrHandlerId(user.getUserName());
        seWfTaskExecuteFeedback.setCurrRoleId(roles.get(0).getRoleName());

        SeWfTaskExecuteFeedback lastTaskExecuteFeedback = seWfTaskExecuteFeedbackService.getLastTaskExecuteFeedback(seWfTaskInfo.getTaskNo());
        if (lastTaskExecuteFeedback == null) {
            seWfTaskExecuteFeedback.setCurrProcSteps("");
        } else {
            seWfTaskExecuteFeedback.setCurrProcSteps(lastTaskExecuteFeedback.getCurrProcSteps());
        }

        String roleId = "";
//        Map<String, String> map =taskWFService.taskWfUser(user.getUserId().toString());
//        roleId = map.get(seWfTaskInfo.getTaskNo());
        seWfTaskExecuteFeedbackService.insertTaskExecuteFeedback(seWfTaskExecuteFeedback);
        int taskNameCnt = taskInfoService.updateHandleRoleId(roleId,prjo.getTaskNo());

        return AjaxResult.success("????????????");
    }

    @GetMapping("/ttt/{code}")
    @Transactional
    public void ttt(@PathVariable String code){
        System.out.println(code);
        SysUser user = tokenService.getLoginUser(ServletUtils.getRequest()).getUser();
        List<SysRole> roles = user.getRoles();
        TaskCommon service = WfDealRoleRegisterFactory.getService(String.valueOf(roles.get(0).getRoleId()));
        Map<String, String> reMap = service.commonSubmit(code, WfCode.WF2101, user,
                "000000000000000");
        Map map = activityService.selectNextNode(reMap.get(ProjectContants.PROCESSIN_STANCE_ID));
        System.out.println(reMap);
    }


    /**
     * ????????????????????????????????????
     *
     * @param taskNo ????????????
     * @param taskNo ????????????
     * @param taskNo ????????????
     * @return
     */
    @GetMapping("/getTaskDetail/{taskNo}")
    public AjaxResult getTaskDetail(@PathVariable("taskNo") String taskNo) {

        SeWfTaskInfo seWfTaskInfo = taskInfoService.selectSeWfTaskInfoByTaskNo(taskNo);
        String signalCreateModel = seWfTaskInfo.getSeWfWarningSigns().get(0).getSignalCreateModel();

        List<SeWfTaskExecuteFeedback> allSeWfTaskExecuteFeedbackByTaskNo = seWfTaskExecuteFeedbackService.getAllSeWfTaskExecuteFeedbackByTaskNo(taskNo);
        seWfTaskInfo.setSeWfTaskExecuteFeedbacks(allSeWfTaskExecuteFeedbackByTaskNo);
        return AjaxResult.success(seWfTaskInfo);
    }


    /**
     * ????????????????????????????????????
     *
     * @param warningObjectId ????????????
     * @return
     */
    @GetMapping("/getHistoryTask/{warningObjectId}")
    public AjaxResult getHistoryTask(@PathVariable("warningObjectId") String warningObjectId) {

        List<SeWfTaskInfo> seWfTaskInfo = taskInfoService.selectSeWfTaskInfoByWarningObjectId(warningObjectId);

        return AjaxResult.success(seWfTaskInfo);
    }


}
