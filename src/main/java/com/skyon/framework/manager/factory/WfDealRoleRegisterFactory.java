package com.skyon.framework.manager.factory;

import com.skyon.project.system.service.wf.TaskCommon;

import java.util.HashMap;

/**
 *  环节流转 根据角色处理流程的工厂类
 */
public class WfDealRoleRegisterFactory {

    private static HashMap<String, TaskCommon> map = new HashMap<>();

    /**
     * 根据角色获取对应的环节处理类
     * @param role 角色名
     * @return
     */
    public static TaskCommon getService(String role){
        return map.get(role);
    }

    /**
     *
     * @param role 角色名
     * @param service 不同的任务处理类
     */
    public static void register(String role, TaskCommon common){
        map.put(role, common);
    }






}
