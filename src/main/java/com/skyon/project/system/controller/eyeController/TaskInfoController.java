package com.skyon.project.system.controller.eyeController;

import com.skyon.common.enums.RoleName;
import com.skyon.common.enums.WFLink;
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
     * @param taskNo 任务编号
     * @param taskNo 任务编号
     * @return
     */
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
    public AjaxResult getSignalManualList( WarningTaskListVo warningTaskListVo) {
        List<TaskInfoListPojo> list = new ArrayList<>();
        List<TaskInfoListPojo> listAct = new ArrayList<>();

        SysUser user = tokenService.getLoginUser(ServletUtils.getRequest()).getUser();
        List<SysRole> roles = user.getRoles();

        try {
            // 查询 客户经理 初始时 的 列表。
            if (1==1 ||RoleName.ACCOUNT_MANAGER.getInfo().equals(roles.get(0).getRoleName())) { // 后续 传页面展示的角色
                warningTaskListVo.setTaskHandler(String.valueOf(user.getUserId()));
                list = taskInfoService.getWTaskInfoListByRole(warningTaskListVo);
            }

            // 其余角色包括客户经理 根据用户id查询代办任务
            Map<String, Long> mapTask = taskWFService.taskWfUser(user);
            Set setOwner = mapTask.keySet();

            // 查询待办箱
            if (setOwner.size() > 0)
                listAct = taskInfoService.getWTaskInfoByList1(setOwner);

            listAct.addAll(list);

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
    public AjaxResult submitTask(@RequestBody SeWfTaskInfo seWfTaskInfo) {

        logger.info("----submitTask----: 任务编号：{}", seWfTaskInfo.getTaskNo());
        SysUser user = tokenService.getLoginUser(ServletUtils.getRequest()).getUser();
        List<SysRole> roles = user.getRoles();

        // 更新信号表
        List<SeWfWarningSigns> list = seWfTaskInfo.getSeWfWarningSigns();
        for (SeWfWarningSigns seWfWarningSigns : list) {
            seWfWarningSignsService.updateSeWfWarningSigns(seWfWarningSigns);
        }

        // 任务提交
        TaskCommon service = WfDealRoleRegisterFactory.getService(roles.get(0).getRoleName());
        String taskName = service.commonSubmit(seWfTaskInfo, user);

        // 保存 任务执行反馈表单
        SeWfTaskExecuteFeedback seWfTaskExecuteFeedback = seWfTaskInfo.getSeWfTaskExecuteFeedback();
        seWfTaskExecuteFeedback.setTaskId(seWfTaskInfo.getTaskId());
        seWfTaskExecuteFeedback.setProcessName(taskName);
        seWfTaskExecuteFeedback.setTaskHandler(user.getUserName());
        seWfTaskExecuteFeedback.setTaskHandlePost(roles.get(0).getRoleName());

        SeWfTaskExecuteFeedback lastTaskExecuteFeedback = seWfTaskExecuteFeedbackService.getLastTaskExecuteFeedback(seWfTaskInfo.getTaskNo());
        if (lastTaskExecuteFeedback == null) {
            seWfTaskExecuteFeedback.setLastProcessName("");
        } else {
            seWfTaskExecuteFeedback.setLastProcessName(lastTaskExecuteFeedback.getProcessName());
        }


        seWfTaskExecuteFeedbackService.insertTaskExecuteFeedback(seWfTaskExecuteFeedback);

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
