package com.skyon.project.system.service.wf;


import org.activiti.engine.impl.cmd.NeedsActiveTaskCmd;
import org.activiti.engine.impl.interceptor.CommandContext;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.activiti.engine.impl.persistence.entity.TaskEntityManagerImpl;

public class DeleteTaskCommand extends NeedsActiveTaskCmd<String> {

    public DeleteTaskCommand(String taskId) {
        super(taskId);
    }


    @Override
    public String execute(CommandContext commandContext, TaskEntity currentTask){
        //获取所需服务
        TaskEntityManagerImpl taskEntityManager = (TaskEntityManagerImpl)commandContext.getTaskEntityManager();
        //获取当前任务的来源任务及来源节点信息
        ExecutionEntity executionEntity = currentTask.getExecution();
        //删除当前任务,来源任务
        taskEntityManager.deleteTask(currentTask, "jumpReason", false, false);
        return executionEntity.getId();
    }
}
