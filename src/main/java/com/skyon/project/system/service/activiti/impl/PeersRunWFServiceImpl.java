package com.skyon.project.system.service.activiti.impl;

import com.skyon.common.enums.WarningObjectCategory;
import com.skyon.project.system.service.activiti.PeersRunWFService;
import com.skyon.project.system.service.activiti.RunWFService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.stereotype.Service;

import java.util.Map;

// 流程启动实现类
@Service
public class PeersRunWFServiceImpl implements PeersRunWFService  {

	/**
     * 某个任务，启动流程
      * @param taskInfoNo 任务编号
	 * @param map 启动后所需参数
     */
    @Override
    public void startWf(String taskInfoNo, Map map, WarningObjectCategory category) {
        ProcessEngine defaultProcessEngine = ProcessEngines.getDefaultProcessEngine();

        String processKey=null;
        if(category==WarningObjectCategory.PEERS )
        	processKey=PeersRunWFService.PROCESS_EYE_PEERS;
        else
        	throw new RuntimeException("预警对象类型"+category+"的流程未定义");
        
		// 启动流程  
        ProcessInstance myProcess_1 = defaultProcessEngine.getRuntimeService().startProcessInstanceByKey(processKey, taskInfoNo, map);
        System.out.println("启动流程实例id:" + myProcess_1.getId());
    }
}
