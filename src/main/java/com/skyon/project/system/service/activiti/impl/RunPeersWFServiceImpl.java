package com.skyon.project.system.service.activiti.impl;

import com.skyon.project.system.service.activiti.RunPeersWFService;
import com.skyon.project.system.service.activiti.RunWFService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Service;

import java.util.Map;

// 同业认定的流程启动实现类
@Service
public class RunPeersWFServiceImpl implements RunPeersWFService  {

    /**
     * 某个任务，启动流程
      * @param taskInfoNo 任务编号
     * @param map 启动后所需参数
     */
    @Override
    public void startWf(String taskInfoNo, Map map) {
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();

        // 启动流程  
        ProcessInstance myProcess_1 = defaultProcessEngine.getRuntimeService().startProcessInstanceByKey("eye_peers", taskInfoNo, map);
        System.out.println("启动流程实例id:" + myProcess_1.getId());
    }
}
