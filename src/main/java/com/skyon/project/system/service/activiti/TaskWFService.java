package com.skyon.project.system.service.activiti;

import com.skyon.project.system.domain.sys.SysUser;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.task.Task;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface TaskWFService {

    /**
     *  查询个人任务
     * @param user
     * @return Map of ProcessInstance.businessKey,ProcessInstance.name
     */
    public Map<String, Long> taskWfUser(SysUser user);

    // 查询候选任务
    public List taskWfGroup(String user);

    /**
     * 根据任务编号完成任务
     * @param taskInfoNo
     * @param user
     * @param map
     * @return
     */
    public String exeTaskByTaskInfoNo(String taskInfoNo, String user, Map map);

    // 根据任务编号获取当前任务
    public Task getCurrentTaskByNo(String taskInfoNo);

    // 根据历史任务分配处理人
    public void claimAssigneeByTask(HistoricTaskInstance taskInstance, String taskInfoNo);

    // 根据任务编号分配处理人
    public String claimAssigneeByTaskInfoNo(String taskInfoNo, String user);

    // 根据代理人查询历史所有任务实例id 任务编号需通过实例id查询出来
    public Set findlActAll(String user);

    // 改派
    public void updateAssignee(String taskInfoNo, String user);


    // 删除一个流程实例
    public void deleteInstance(String taskInfoNo);

	/**
	 * 
	 * @param user
	 * @param groups 
	 * @return <任务编号,任务节点名>
	 */
	Map<String,String> taskWfByUserGroup(String user, List<String> groups);

    /**
     * 判断该任务是否已经在 工作流任务中
     * @param taskInfoNo
     * @param user
     */
    public boolean confirmTaskIsExit(String taskInfoNo);
}
