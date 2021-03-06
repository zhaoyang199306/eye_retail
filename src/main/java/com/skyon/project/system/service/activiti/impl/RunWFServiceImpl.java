package com.skyon.project.system.service.activiti.impl;

import com.skyon.project.system.service.activiti.RunWFService;
import com.skyon.project.system.service.wf.TaskCommon;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

// 流程运行类
@Service
public class RunWFServiceImpl implements RunWFService {
    protected static final Logger logger = LoggerFactory.getLogger(RunWFServiceImpl.class);

    /**
     * 某个任务，启动流程
     *
     * @param taskInfoNo 任务编号
     * @param map        启动后所需参数
     *                   userid 节点的操作人
     */
    @Override
    public void startWf(String taskInfoNo, Map map) {
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();

        // 启动不同的流程：eye_retail_1
        ProcessInstance myProcess_1 = defaultProcessEngine.getRuntimeService().startProcessInstanceByKey(map.get("processKey").toString(), taskInfoNo, map);

        logger.info("++++++++++{},启动流程实例id:{}", taskInfoNo, myProcess_1.getId());
    }


}
