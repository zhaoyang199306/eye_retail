package com.skyon.project.system.service.activiti;

import java.util.Map;

import com.skyon.common.enums.WarningObjectCategory;
/**
 * 启动一个工作流实例
 * @author xinglj
 *
 */
public interface PeersRunWFService {
	/**
	 * 同业主体流程定义
	 */
    public static final String PROCESS_EYE_PEERS = "eye_peers";
	/**
	 * 非同业主体流程定义
	 */
    public static final String PROCESS_EYE_NOPEERS = "eye_nopeers";
    /**
     * 投组流程定义
     */
    public static final String PROCESS_EYE_CASTGROUP = "eye_castgroup";
    
    /**
     * 启动工作流实例
     */
    public void startWf(String taskInfoNo, Map map, String category);
}
