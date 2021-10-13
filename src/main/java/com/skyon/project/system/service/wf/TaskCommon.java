package com.skyon.project.system.service.wf;

import com.skyon.common.utils.ServletUtils;
import com.skyon.framework.security.service.TokenService;
import com.skyon.project.system.domain.eye.SeWfTaskInfo;
import com.skyon.project.system.domain.eye.TaskInfoSubmitPojo;
import com.skyon.project.system.domain.sys.SysUser;
import com.skyon.project.system.service.activiti.RunWFService;
import com.skyon.project.system.service.activiti.TaskWFService;
import com.skyon.project.system.service.eye.SeWfTaskExecuteFeedbackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.Map;

/**
 * 任务提交类公告类
 */
public abstract class TaskCommon {
    protected static final Logger LOGGERCOMMON = LoggerFactory.getLogger(TaskCommon.class);

    @Autowired
    private TaskWFService taskWFService;
    @Autowired
    private SeWfTaskExecuteFeedbackService feedbackService;
    @Autowired
    private RunWFService runWFService;

    /**
     * 保存任务流转
     */
    public void commonSubmit(SeWfTaskInfo seWfTaskInfo, SysUser user) {

        LOGGERCOMMON.info("当前事务名2：{}", TransactionSynchronizationManager.getCurrentTransactionName());

        // 获取组装参数
        Map<String, Object> map = this.assembleParam(seWfTaskInfo, user);

        if (map.get("first") != null && (Boolean) map.get("first")) {
            // 某个任务，启动流程
            runWFService.startWf(seWfTaskInfo.getTaskNo(), map);
        }

        // 根据任务编号 - taskInfoNo 执行任务
        String taskName = taskWFService.exeTaskByTaskInfoNo(seWfTaskInfo.getTaskNo(),
                String.valueOf(user.getUserId()), map);

        // 额外操作 修改某些字段
        this.updateField(seWfTaskInfo);

        LOGGERCOMMON.info("----taskNO:{}----taskName----: {}", seWfTaskInfo.getTaskNo(), taskName);

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
        LOGGERCOMMON.info("{},提交----{}", user.getUserName(), seWfTaskInfo.getTaskNo());
    }

    // 组装参数 交给每个角色处理
    protected abstract Map<String, Object> assembleParam(SeWfTaskInfo seWfTaskInfo, SysUser user);

    // 修改某些字段 交给每个角色处理
    protected void updateField(SeWfTaskInfo seWfTaskInfo){

    }

}
