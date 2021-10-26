package com.skyon.project.system.service.activiti.impl;

import com.skyon.common.constant.ProjectContants;
import com.skyon.common.utils.StringUtils;
import com.skyon.project.system.domain.sys.SysRole;
import com.skyon.project.system.domain.sys.SysUser;
import com.skyon.project.system.service.activiti.TaskWFService;
import com.skyon.project.system.service.wf.DeleteTaskCommand;
import com.skyon.project.system.service.wf.JumpCommand;
import org.activiti.bpmn.model.FlowElement;
import org.activiti.bpmn.model.FlowNode;
import org.activiti.bpmn.model.Process;
import org.activiti.engine.*;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.identity.GroupQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Service
public class TaskWFServiceImpl implements TaskWFService {

    @Resource
    private RepositoryService repositoryService;
    @Resource
    private TaskService taskService;
    @Resource
    private ManagementService managementService;
    @Resource
    private RuntimeService runtimeService;
    @Resource
    private HistoryService historyService;


    /**
     * 执行回退
     *
     * @param taskId     需要回退的节点
     * @param taskInfoNo 任务编号
     */
    public void taskBack(String taskId, String taskInfoNo) {
        HistoricTaskInstance historicTaskInstance = historyService.createHistoricTaskInstanceQuery().taskId(taskId).singleResult();
        // 根据任务 查询整个进程
        Process mainProcess = repositoryService.getBpmnModel(historicTaskInstance.getProcessDefinitionId()).getMainProcess();
        // 获取需要回退的节点
        FlowNode flowNode = (FlowNode) mainProcess.getFlowElement(historicTaskInstance.getTaskDefinitionKey());
        // 获取当前任务
        Task task = taskService.createTaskQuery().processInstanceBusinessKey(taskInfoNo).singleResult();
        // 删除当前任务
        String executionId = managementService.executeCommand(new DeleteTaskCommand(task.getId()));
        // 回退
        managementService.executeCommand(new JumpCommand(flowNode, executionId));
    }


    /**
     * 根据用户id查询代办任务
     *
     * @param user 用户id
     * @return 任务编号, 任务节点名
     */
    @Override
    public Map<String, Long> taskWfUser(SysUser user) {
        Map<Long, List<Task>> map = new HashMap<>();
        List<SysRole> roles = user.getRoles();
        for (SysRole role : roles) {
            // 查询已经分配了具体操作人  的任务
            List<Task> listAssignee = taskService.createTaskQuery().taskAssignee(String.valueOf(user.getUserId())).list();
            // 查询当前登录人在为候选人组时的所有任务
            List<Task> listGroup = taskService.createTaskQuery().taskCandidateGroup(String.valueOf(role.getRoleId())).list();

            listAssignee.addAll(listGroup);
            map.put(role.getRoleId(), listAssignee);
        }

        // 查询自己的任务编号
        return getTaskInfoList(map);
    }

    @Override
    public List taskWfGroup(String user) {
        return null;
    }

    /**
     * @param user
     * @param groups
     * @return <任务编号,任务节点名>
     */
    @Override
    public Map<String, String> taskWfByUserGroup(String user, List<String> groups) {
//        System.out.println("taskWfByUserGroup group:" + groups);
//
//        // 获取任务对象
//        // 查询当前登录人在为候选人组时的所有任务
//        List<Task> list = taskService.createTaskQuery().taskAssignee(user).list();
//        List<Task> list1 = taskService.createTaskQuery().taskCandidateUser(user).list();
//        List<Task> list3 = taskService.createTaskQuery().taskCandidateGroup("52").list();
//        List<Task> list2 = taskService.createTaskQuery().taskCandidateGroupIn(groups).list();
//        list.addAll(list1);
//        list.addAll(list2);
//
//        // 查询自己的任务编号
//        return getTaskInfoList(list);

        return new HashMap<>();

    }

    /**
     * 执行任务
     *
     * @param taskInfoNo 任务编号
     * @param user       用户号
     * @param map        参数
     *                   comtwoid 预警认定审批员id
     * @return reMap
     */
    @Override
    public Map<String, String> exeTaskByTaskInfoNo(String taskInfoNo, String user, Map map) {
        Map<String, String> reMap = new HashMap<>();
        // 获取当前任务
        Task task = taskService.createTaskQuery().processInstanceBusinessKey(taskInfoNo).singleResult();
        if (task != null) {
            String idID = task.getId();
            // 如果未分配任务的先分配任务
            if (task.getAssignee() == null) {
                // 分配任务
                taskService.claim(idID, user);
            }
            // 执行任务
            taskService.complete(idID, map);
            reMap.put(ProjectContants.CURRENT_NAME, task.getName()); // 当前处理环节名字
            reMap.put(ProjectContants.CURRENT_ID, idID); // 当前处理环节id
            reMap.put(ProjectContants.PROCESSIN_STANCE_ID, task.getProcessInstanceId()); // 当前环节的
        }
        return reMap;
    }

    @Override
    public Task getCurrentTaskByNo(String taskInfoNo) {
        return null;
    }

    @Override
    public void claimAssigneeByTask(HistoricTaskInstance taskInstance, String taskInfoNo) {

    }

    /**
     * 分配任务
     *
     * @param taskInfoNo 任务编号
     * @param user       用户名
     * @return
     */
    @Override
    public String claimAssigneeByTaskInfoNo(String taskInfoNo, String user) {
        return claim(taskInfoNo, user);
    }

    @Override
    public Set findlActAll(String user) {
        return null;
    }

    /**
     * 改派任务
     *
     * @param taskInfoNo 任务编号
     * @param user       人
     * @return
     */
    @Override
    public void updateAssignee(String taskInfoNo, String user) {
        Task task = taskService.createTaskQuery().processInstanceBusinessKey(taskInfoNo).singleResult();
        taskService.setAssignee(task.getId(), user);
    }

    /**
     * 根据实例删除
     */
    @Override
    public void deleteInstance(String taskInfoNo) {
        ProcessInstance processInstance = runtimeService.createProcessInstanceQuery().processInstanceBusinessKey(taskInfoNo).singleResult();
        String processInstanceId = processInstance.getProcessInstanceId();
        runtimeService.deleteProcessInstance(processInstanceId, "手动删除");
    }


    // 分配任务
    private String claim(String taskInfoNo, String user) {
        Task task = taskService.createTaskQuery().processInstanceBusinessKey(taskInfoNo).singleResult();
        if (task != null) {
            String idID = task.getId();
            // 分配任务
            taskService.claim(idID, user);
            return task.getName();
        }
        return "";
    }

    // 根据任务查询任务编号
    private Map<String, Long> getTaskInfoList(Map<Long, List<Task>> map) {
        // map 存储 key : 任务号id ; value : 任务节点名
        Map<String, Long> returnMap = new HashMap<>();
        Set<Map.Entry<Long, List<Task>>> entries = map.entrySet();
        for (Map.Entry<Long, List<Task>> entry : entries) {
            List<Task> valueList = entry.getValue();
            Long key = entry.getKey();
            for (Task task : valueList) {
                ProcessInstance pi = runtimeService.createProcessInstanceQuery().
                        processInstanceId(task.getProcessInstanceId()).singleResult();
                System.out.println("------------" + task.getAssignee());
                if (StringUtils.isNotEmpty(pi.getBusinessKey())) returnMap.put(pi.getBusinessKey(), key);
            }
        }
        return returnMap;
    }

    /**
     * 判断该任务是否已经在 工作流任务中
     *
     * @param taskInfoNo
     */
    public boolean confirmTaskIsExit(String taskInfoNo) {
        Task task = taskService.createTaskQuery().processInstanceBusinessKey(taskInfoNo).singleResult();
        return task == null;
    }
}
