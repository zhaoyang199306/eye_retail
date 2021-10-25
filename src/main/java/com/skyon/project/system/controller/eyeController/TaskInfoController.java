package com.skyon.project.system.controller.eyeController;

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
import com.skyon.project.system.service.activiti.RunWFService;
import com.skyon.project.system.service.activiti.TaskWFService;
import com.skyon.project.system.service.eye.*;
import com.skyon.project.system.service.wf.TaskCommon;
import com.skyon.project.system.util.StringUtil;
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

@Api(tags = "预警任务")
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


    /**
     * 根据任务编号认领任务
     *
     * @param taskNo 任务编号
     * @return
     */
    @ApiOperation(value="预警任务列表认领功能")
    @GetMapping("/claimTaskByID/{taskNo}")
    public AjaxResult claimTaskByID(@PathVariable("taskNo") String taskNo) {
        SysUser user = tokenService.getLoginUser(ServletUtils.getRequest()).getUser();
        String userId = user.getUserId().toString();
        String roleId = user.getRoleIds()[0].toString();
        taskInfoService.claimTaskByID(taskNo,userId,roleId);
        return AjaxResult.success("认领成功");
    }

    /**
     * 根据任务编号认领任务
     *
     * @param taskNo 任务编号
     * @param taskNo 任务编号
     * @param taskNo 任务编号
     * @return
     */
    @GetMapping("/cancelClaimTaskByID/{taskNo}")
    public AjaxResult cancelClaimTaskByID(@PathVariable("taskNo") String taskNo) {
        SysUser user = tokenService.getLoginUser(ServletUtils.getRequest()).getUser();
        taskInfoService.cancelClaimTaskByID(taskNo);
        return AjaxResult.success("取消认领成功");
    }
    /**
     * 根据角色查询  预警业务列表
     * 如果角色是客户经理，则根据客户经理名称查询
     *
     * @param warningTaskListVo
     * @return
     */
    @ApiOperation(value="预警任务列表查询")
    @GetMapping("/list")
    @DataScope(deptAlias = "d")
    public AjaxResult getAllTaskList( WarningTaskListVo warningTaskListVo) {
        List<TaskInfoListPojo> list = new ArrayList<>();
        List<TaskInfoListPojo> listAct = new ArrayList<>();

        SysUser user = tokenService.getLoginUser(ServletUtils.getRequest()).getUser();
        List<SysRole> roles = user.getRoles();

        try {
            // 查询 客户经理 初始时 的 列表。
            if (1==1 ||RoleName.WF_ROLE_011.getCode().equals(roles.get(0).getRoleId())) { // 后续 传页面展示的角色
                warningTaskListVo.setTaskHandler(String.valueOf(user.getUserId()));
                list = taskInfoService.getWTaskInfoListByRole(warningTaskListVo);
            }

            // 其余角色包括客户经理 根据用户id查询代办任务
            Map mapTask = taskWFService.taskWfUser(String.valueOf(user.getUserId()));
            Set setOwner = mapTask.keySet();


            // 查询待办箱
            if (setOwner.size() > 0)
                listAct = taskInfoService.getWTaskInfoByList1(setOwner);


            listAct.addAll(list);
            //添加总行管理员的查看
            if(user != null){
                if(user.hasRoleId(RoleName.WF_ROLE_011.getCode())){
                    listAct.addAll(taskInfoService.getAllTaskListByOrg("04","01",user.getDeptId().toString()));
                }
                //添加支行管理员的查看
                if(user.hasRoleId(RoleName.WF_ROLE_165.getCode())){
                    listAct.addAll(taskInfoService.getAllTaskListByOrg("04","02",user.getDeptId().toString()));
                }
                //添加分行管理员的查看
                if(user.hasRoleId(RoleName.WF_ROLE_166.getCode())){
                    listAct.addAll(taskInfoService.getAllTaskListByOrg("04","03",user.getDeptId().toString()));
                }
            }

            return AjaxResult.success(listAct);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error("列表查询异常！");
        }

    }
    /**
     * 根据角色查询  预警业务列表
     * 如果角色是客户经理，则根据客户经理名称查询
     *
     * @param warningTaskListVo
     * @return
     */
    @ApiOperation(value="预警任务列表查询")
    @GetMapping("/listTask")
    @DataScope(deptAlias = "d")
    public AjaxResult getHandingTaskList( WarningTaskListVo warningTaskListVo) {
        List<TaskInfoListPojo> list = new ArrayList<>();
        List<TaskInfoListPojo> listAct = new ArrayList<>();

        SysUser user = tokenService.getLoginUser(ServletUtils.getRequest()).getUser();
        List<SysRole> roles = user.getRoles();

        try {

            // 其余角色包括客户经理 根据用户id查询代办任务
            Map mapTask = taskWFService.taskWfUser(String.valueOf(user.getUserId()));
            Set setOwner = mapTask.keySet();


            // 查询待办箱
            if (setOwner.size() > 0)
                listAct = taskInfoService.getWTaskInfoByList1(setOwner);


            listAct.addAll(list);
            //添加总行管理员的查看
            if(user.hasRoleId(RoleName.WF_ROLE_011.getCode())){
                listAct.addAll(taskInfoService.getAllTaskListByOrg("02","01",user.getDeptId().toString()));
            }
            //添加支行管理员的查看
            if(user.hasRoleId(RoleName.WF_ROLE_165.getCode())){
                listAct.addAll(taskInfoService.getAllTaskListByOrg("02","02",user.getDeptId().toString()));
            }
            //添加分行管理员的查看
            if(user.hasRoleId(RoleName.WF_ROLE_166.getCode())){
                listAct.addAll(taskInfoService.getAllTaskListByOrg("02","03",user.getDeptId().toString()));
            }

            return AjaxResult.success(listAct);
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error("列表查询异常！");
        }

    }
    /**
     * 预警认定-- 反馈和审批提交入口
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
    @ApiOperation(value="预警任务详情提交")
    @PostMapping("/submitTask")
    @Transactional
    public AjaxResult submitTask(@RequestBody TaskInfoSubmitPojo prjo) {

        logger.info("----submitTask----: 任务编号：{}", prjo.getTaskNo());
        SysUser user = tokenService.getLoginUser(ServletUtils.getRequest()).getUser();
        List<SysRole> roles = user.getRoles();

        // 更新信号表
        List<SeWfWarningSigns> list = prjo.getWarnSignalList();
        for (SeWfWarningSigns seWfWarningSigns : list) {
            seWfWarningSignsService.updateSeWfWarningSigns(seWfWarningSigns);
        }
        //int signCnt = signalManualSevice.updateSignalManualList(prjo.getWarnSignalList());
       //更新任务表  不确定是否需要
        int taskCnt = taskInfoService.updateAffirmTask(prjo);

        SeWfTaskInfo seWfTaskInfo = taskInfoService.selectSeWfTaskInfoByTaskNo(prjo.getTaskNo());

        if(StringUtil.isEmp(user.getDept().getAncestors()))
            return AjaxResult.error("该用户未分配机构");
        //对应流程判断
        WfCode code = null ;
        //是否人工信号录入
        if("07".equals(seWfTaskInfo.getTaskType())){
            //预警对象类型=’个人客户’ OR 预警对象类型=’小微客户’
            if("03".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())||"04".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())){
                //是否总行
                if(StringUtil.countStr(user.getDept().getAncestors(),",")==0 && user.hasRoleId(RoleName.WF_ROLE_144.getCode()))
                    code = WfCode.WF1103;
                //是否分行
                if(StringUtil.countStr(user.getDept().getAncestors(),",")==1 && user.hasRoleId(RoleName.WF_ROLE_034.getCode()))
                    code = WfCode.WF1102;
                //是否支行
                if(StringUtil.countStr(user.getDept().getAncestors(),",")==2 && user.hasRoleId(RoleName.WF_ROLE_011.getCode()))
                    code = WfCode.WF1101;
            //预警对象类型='合作方'
            }else if("05".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())){
                //是否总行
                if(StringUtil.countStr(user.getDept().getAncestors(),",")==0 && user.hasRoleId(RoleName.WF_ROLE_114.getCode()))
                    code = WfCode.WF1104;
                //是否分行
                if(StringUtil.countStr(user.getDept().getAncestors(),",")==1 && user.hasRoleId(RoleName.WF_ROLE_035.getCode()))
                    code = WfCode.WF1105;
            //预警对象类型=’对公客户’ OR 预警对象类型=’同业主体’
            }else if("01".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())||"02".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())){
                //经办角色=’总行业务部门风险监测岗(金融市场部)
                if(user.hasRoleId(RoleName.WF_ROLE_081.getCode()))
                    code = WfCode.WF1001;
                //经办角色=’总行业务部门风险监测岗(投行资管部)
                if(user.hasRoleId(RoleName.WF_ROLE_082.getCode()))
                    code = WfCode.WF1002;
                //经办角色=’分行风险监测岗(投行资管部)
                if(user.hasRoleId(RoleName.WF_ROLE_033.getCode()))
                    code = WfCode.WF1003;
            }
        //预警认定审批流程
        }else if("02".equals(seWfTaskInfo.getTaskType())){
            //预警对象类型=’个人客户’ OR 预警对象类型=’小微客户’
            if("03".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())||"04".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())){
                code=WfCode.WF2101;
            //预警对象类型=’零售产品’
            }else if("08".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())){
                code=WfCode.WF2102;
            //预警对象类型=’合作方’
            }else if("05".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())){
                code=WfCode.WF2103;
            //预警对象类型=’对公客户’
            }else if("01".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())){
                code=WfCode.WF2001;
            //预警对象类型=’同业主体’
            }else if("02".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())){
                //经办角色=’客户经理’ AND 经办机构级别=’分行’
                if(StringUtil.countStr(user.getDept().getAncestors(),",")==1 && user.hasRoleId(RoleName.WF_ROLE_011.getCode()))
                    code = WfCode.WF2002;
                //经办角色=’客户经理’ AND 经办机构级别=’总行’
                if(StringUtil.countStr(user.getDept().getAncestors(),",")==0 && user.hasRoleId(RoleName.WF_ROLE_011.getCode()))
                    code = WfCode.WF2003;
            //投组
            }else if("06".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())){
                //经办角色=’总行业务部门风险监测岗(金融市场部)’ AND 经办机构级别=’总行’
                if(StringUtil.countStr(user.getDept().getAncestors(),",")==0 && user.hasRoleId(RoleName.WF_ROLE_081.getCode()))
                    code = WfCode.WF2004;
                //经办角色=’总行业务部门风险监测岗(投行资管部))’ AND 经办机构级别=’总行’
                if(StringUtil.countStr(user.getDept().getAncestors(),",")==0 && user.hasRoleId(RoleName.WF_ROLE_082.getCode()))
                    code = WfCode.WF2005;
                //经办角色=’分行风险监测岗(金融市场部)’ AND 经办机构级别=’分行’
                if(StringUtil.countStr(user.getDept().getAncestors(),",")==0 && user.hasRoleId(RoleName.WF_ROLE_032.getCode()))
                    code = WfCode.WF2006;
                //经办角色=’分行风险监测岗(投行资管部)’ AND 经办机构级别=’分行’
                if(StringUtil.countStr(user.getDept().getAncestors(),",")==0 && user.hasRoleId(RoleName.WF_ROLE_033.getCode()))
                    code = WfCode.WF2007;
            }
        }else if("03".equals(seWfTaskInfo.getTaskType())){
            //预警对象类型=’个人客户’ OR 预警对象类型=’小微客户’
            if("03".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())||"04".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory()))
                code=WfCode.WF2101;
            //预警对象类型=’对公客户’
            if("01".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory()))
                code=WfCode.WF2011;
            //预警对象类型=’同业客户’
            if("02".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())) {
                //经办角色=’客户经理’ AND 经办机构级别=’分行’
                if (StringUtil.countStr(user.getDept().getAncestors(), ",") == 1 && user.hasRoleId(RoleName.WF_ROLE_011.getCode()))
                    code = WfCode.WF2012;
                //经办角色=’客户经理’ AND 经办机构级别=’总行’
                if (StringUtil.countStr(user.getDept().getAncestors(), ",") == 0 && user.hasRoleId(RoleName.WF_ROLE_011.getCode()))
                    code = WfCode.WF2013;
            }
        }else if("06".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())) {
            //经办角色=’总行业务部门风险监测岗(金融市场部)’ AND 经办机构级别=’总行’
            if (StringUtil.countStr(user.getDept().getAncestors(), ",") == 0 && user.hasRoleId(RoleName.WF_ROLE_081.getCode()))
                code = WfCode.WF2014;
            //经办角色=’总行业务部门风险监测岗(投行资管部))’ AND 经办机构级别=’总行’
            if (StringUtil.countStr(user.getDept().getAncestors(), ",") == 0 && user.hasRoleId(RoleName.WF_ROLE_082.getCode()))
                code = WfCode.WF2015;
            //经办角色=’分行风险监测岗(金融市场部)’ AND 经办机构级别=’分行’
            if (StringUtil.countStr(user.getDept().getAncestors(), ",") == 0 && user.hasRoleId(RoleName.WF_ROLE_032.getCode()))
                code = WfCode.WF2016;
            //经办角色=’分行风险监测岗(投行资管部)’ AND 经办机构级别=’分行’
            if (StringUtil.countStr(user.getDept().getAncestors(), ",") == 0 && user.hasRoleId(RoleName.WF_ROLE_033.getCode()))
                code = WfCode.WF2017;
        //信号异议审批流程-信号异议
        }else if("04".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())){
            code = WfCode.WF2104;
        //信号异议审批流程-风险异议
        }else if("05".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())){
            code = WfCode.WF2101;
        //预警解除审批流程
        }else if("08".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())){
            //预警对象类型=’个人客户’ OR 预警对象类型=’小微客户’
            if("03".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())||"04".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory()))
                code=WfCode.WF3101;
            //预警对象类型=’对公客户’
            if("01".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory()))
                code=WfCode.WF3001;
            //预警对象类型=’同业客户’
            if("02".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())) {
                //预警对象类别=’同业主体’ AND 经办机构级别=’分行’
                if (StringUtil.countStr(user.getDept().getAncestors(), ",") == 1 && "02".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory()))
                    code = WfCode.WF3002;
                //预警对象类别=’同业主体’ AND 经办机构级别=’总行’
                if (StringUtil.countStr(user.getDept().getAncestors(), ",") == 0 && "02".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory()))
                    code = WfCode.WF3003;
            }
        //灰名单管理审批流程
        }else if("08".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())){
            //预警对象类型=’同业客户’
            if("02".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())){
                code = WfCode.PEER_WF3102;
            }else{
                code = WfCode.RETAIL_WF3102;
            }
        //黑名单管理审批流程
        }else if("08".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())){
            //预警对象类型=’同业客户’
            if("02".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())){
                code = WfCode.PEER_WF3103;
            }else{
                code = WfCode.RETAIL_WF3103;
            }
        //合作方高风险名单审批流程
        }else if("08".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())){
            //预警对象类型=’同业客户’
            if("02".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())){
                code = WfCode.PEER_WF3104;
            }else{
                code = WfCode.RETAIL_WF3104;
            }
        //任务改派审批流程
        }else if("08".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())){
            //code = WfCode.WF4001;
        }




            // 任务提交
        TaskCommon service = WfDealRoleRegisterFactory.getService(roles.get(0).getRoleName());
        String taskName = service.commonSubmit(seWfTaskInfo.getTaskNo(), code, user);

        // 保存 任务执行反馈表单
        SeWfTaskExecuteFeedback seWfTaskExecuteFeedback = seWfTaskInfo.getSeWfTaskExecuteFeedback();
        seWfTaskExecuteFeedback.setTaskNo(seWfTaskInfo.getTaskId());
        seWfTaskExecuteFeedback.setCurrProcSteps(taskName);
        seWfTaskExecuteFeedback.setCurrHandlerId(user.getUserName());
        seWfTaskExecuteFeedback.setCurrRoleId(roles.get(0).getRoleName());

        SeWfTaskExecuteFeedback lastTaskExecuteFeedback = seWfTaskExecuteFeedbackService.getLastTaskExecuteFeedback(seWfTaskInfo.getTaskNo());
        if (lastTaskExecuteFeedback == null) {
            seWfTaskExecuteFeedback.setCurrProcSteps("");
        } else {
            seWfTaskExecuteFeedback.setCurrProcSteps(lastTaskExecuteFeedback.getCurrProcSteps());
        }


        seWfTaskExecuteFeedbackService.insertTaskExecuteFeedback(seWfTaskExecuteFeedback);
        int taskNameCnt = taskInfoService.updateHandleRoleId(taskName,prjo.getTaskNo());

        return AjaxResult.success("成功提交");
    }


    /**
     * 根据任务编号查询任务详情
     *
     * @param taskNo 任务编号
     * @param taskNo 任务编号
     * @param taskNo 任务编号
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
     * 根据客户编号查询历史任务
     *
     * @param warningObjectId 客户编号
     * @return
     */
    @GetMapping("/getHistoryTask/{warningObjectId}")
    public AjaxResult getHistoryTask(@PathVariable("warningObjectId") String warningObjectId) {

        List<SeWfTaskInfo> seWfTaskInfo = taskInfoService.selectSeWfTaskInfoByWarningObjectId(warningObjectId);

        return AjaxResult.success(seWfTaskInfo);
    }


}
