package com.skyon.project.system.service.wf;

import com.skyon.common.utils.ServletUtils;
import com.skyon.framework.security.service.TokenService;
import com.skyon.project.system.domain.eye.TaskInfoSubmitPojo;
import com.skyon.project.system.domain.sys.SysUser;
import com.skyon.project.system.service.activiti.RunWFService;
import com.skyon.project.system.service.activiti.TaskWFService;
import com.skyon.project.system.service.eye.SeWfTaskExecuteFeedbackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * 任务提交类公告类
 */
public abstract class TaskCommon {
    protected static final Logger LOGGERCOMMON = LoggerFactory.getLogger(TaskCommon.class);

    @Autowired
    private TokenService tokenService;
    @Autowired
    private TaskWFService taskWFService;
    @Autowired
    private SeWfTaskExecuteFeedbackService feedbackService;
    @Autowired
    private RunWFService runWFService;

    /**
     * 保存任务流转
     */
    public void commonSubmit(TaskInfoSubmitPojo task) {
        // 当前登录用户信息
        SysUser user = tokenService.getLoginUser(ServletUtils.getRequest()).getUser();

        // 获取组装参数
        Map<String, Object> map = this.assembleParam(task, user);

        if (map.get("first") != null && (Boolean) map.get("first")) {
            // 某个任务，启动流程
            runWFService.startWf(task.getTaskInfoNo(), map);
        }

        // 根据任务编号 - taskInfoNo 执行任务
        String taskName = taskWFService.exeTaskByTaskInfoNo(task.getTaskInfoNo(),
                String.valueOf(user.getUserId()), map);

        LOGGERCOMMON.info("----taskNO:{}----taskName----: {}", task.getTaskInfoNo(), taskName);

        // insert环节流转
//        if (WFRole.WFROLE301.getInfo().equals(taskName)) {
//            linkLogService.insertWLinkLog(task.getTaskInfoNo(),
//                    DealType.RD.getCode(),
//                    WFRole.WFROLE301.getInfo(),
//                    user.getUserName(),
//                    ProjectContants.SUBMIT_BUTTON,
//                    JSON.toJSONString(task.getRiskControlMeasures()),
//                    task.getExaminValue());
//        }
        LOGGERCOMMON.info("提交----{}",task.getTaskInfoNo());
    }

    // 组装参数 交给每个角色处理
    protected abstract Map<String, Object> assembleParam(TaskInfoSubmitPojo task, SysUser user);

}
