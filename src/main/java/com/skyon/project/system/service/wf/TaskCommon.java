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
    private RunWFService runWFService;

    /**
     * 保存任务流转
     */
    public String commonSubmit(SeWfTaskInfo seWfTaskInfo, SysUser user) {

        LOGGERCOMMON.info("当前事务名2：{}", TransactionSynchronizationManager.getCurrentTransactionName());

        // 获取组装参数
        Map<String, Object> map = this.assembleParam(seWfTaskInfo, user);

        // 未启动流程的，先启动流程
        if ((Boolean) map.get("first")) {
            runWFService.startWf(seWfTaskInfo.getTaskNo(), map);
        }

        // 根据任务编号 - taskInfoNo 执行任务
        String taskName = taskWFService.exeTaskByTaskInfoNo(seWfTaskInfo.getTaskNo(),
                String.valueOf(user.getUserId()), map);

        // 额外操作 修改某些字段
        this.updateField(seWfTaskInfo);

        LOGGERCOMMON.info("{}提交,编号：{},环节：{}", user.getUserName(), seWfTaskInfo.getTaskNo(),taskName);

        return taskName;
    }

    // 组装参数 交给每个角色处理
    protected abstract Map<String, Object> assembleParam(SeWfTaskInfo seWfTaskInfo, SysUser user);

    // 修改某些字段 交给每个角色处理
    protected void updateField(SeWfTaskInfo seWfTaskInfo){

    }

}
