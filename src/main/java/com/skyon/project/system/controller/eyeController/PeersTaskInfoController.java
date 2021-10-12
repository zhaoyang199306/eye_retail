package com.skyon.project.system.controller.eyeController;

import com.skyon.common.enums.RoleName;
import com.skyon.common.utils.ServletUtils;
import com.skyon.framework.manager.factory.WfDealRoleRegisterFactory;
import com.skyon.framework.security.LoginUser;
import com.skyon.framework.security.service.TokenService;
import com.skyon.framework.web.controller.BaseController;
import com.skyon.framework.web.domain.AjaxResult;
import com.skyon.project.system.domain.eye.*;
import com.skyon.project.system.domain.sys.SysRole;
import com.skyon.project.system.domain.sys.SysUser;
import com.skyon.project.system.domain.vo.WarningTaskListVo;
import com.skyon.project.system.service.activiti.RunWFService;
import com.skyon.project.system.service.activiti.TaskWFService;
import com.skyon.project.system.service.eye.SignalManualSevice;
import com.skyon.project.system.service.eye.WLinkLogService;
import com.skyon.project.system.service.eye.WTaskInfoService;
import com.skyon.project.system.service.wf.TaskCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.*;

@RestController
@RequestMapping("/peersTaskInfo")
public class PeersTaskInfoController extends BaseController {

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


    /**
     * 根据角色查询  预警业务列表
     *      如果角色是客户经理，则根据客户经理名称查询
     * @param warningTaskListVo
     * @return
     */
    @GetMapping("/list")
    @Transactional
    public AjaxResult getSignalManualList(WarningTaskListVo warningTaskListVo) {
        List<Map> list = new ArrayList<>();

        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        SysUser user = loginUser.getUser();
        List<SysRole> roles = user.getRoles();

        
        // 还没有开启工作流实例. 查询 客户经理 初始时 的 列表。
        if (RoleName.ACCOUNT_MANAGER.getInfo().equals(roles.get(0).getRoleName())) {  
            warningTaskListVo.setTaskHandler(String.valueOf(user.getUserId()));
            list = taskInfoService.getWTaskInfoListByRole(warningTaskListVo);
        }
        // 工作流实例中的.根据用户id查询代办任务/根据角色查询代办任务
        Map mapTask = taskWFService.taskWfUser(String.valueOf(user.getUserId()));


        return AjaxResult.success(list);
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

    @PostMapping("/submitTask")
    @Transactional
    public AjaxResult submitTask(@RequestBody SeWfTaskInfo seWfTaskInfo) throws IOException {

        logger.info("----submitTask----: 任务编号：{}", seWfTaskInfo.getTaskNo());

        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        SysUser user = loginUser.getUser();
        List<SysRole> roles = user.getRoles();

//        // 任务提交
//        TaskCommon service = WfDealRoleRegisterFactory.getService(roles.get(0).getRoleName());
//        service.commonSubmit(seWfTaskInfo);

        return AjaxResult.success("成功提交");
    }

//    @PostMapping("/submitTaskTest/{taskNO}")
//    @Transactional
//    public AjaxResult submitTaskTest(@PathVariable("taskNO") String taskNo) throws IOException {
//
//        logger.info("----submitTask----: 任务编号：{}", taskNo);
//
//        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
//        SysUser user = loginUser.getUser();
//        List<SysRole> roles = user.getRoles();
//
//        TaskInfoSubmitPojo pojo = new TaskInfoSubmitPojo();
//        pojo.setTaskInfoNo(taskNo);
//        // 任务提交
//        TaskCommon service = WfDealRoleRegisterFactory.getService(roles.get(0).getRoleName());
//        service.commonSubmit(pojo);
//
//        return AjaxResult.success("成功提交");
//    }

    /**
     * 根据任务编号查询任务详情
     * @param taskNo 任务编号
     * @return
     */
    @GetMapping("/getTaskDetail/{taskNo}")
    public AjaxResult getTaskDetail(@PathVariable("taskNo") String taskNo) {

        SeWfTaskInfo seWfTaskInfo = taskInfoService.selectSeWfTaskInfoByTaskNo(taskNo);
        String signalCreateModel = seWfTaskInfo.getSeWfWarningSigns().get(0).getSignalCreateModel();
        seWfTaskInfo.setSignalSource(signalCreateModel);

        return AjaxResult.success(seWfTaskInfo);
    }


    /**
     * 根据客户编号查询历史任务
     * @param warningObjectId 客户编号
     * @return
     */
    @GetMapping("/getHistoryTask/{warningObjectId}")
    public AjaxResult getHistoryTask(@PathVariable("warningObjectId") String warningObjectId) {

        List<SeWfTaskInfo> seWfTaskInfo = taskInfoService.selectSeWfTaskInfoByWarningObjectId(warningObjectId);

        return AjaxResult.success(seWfTaskInfo);
    }



}
