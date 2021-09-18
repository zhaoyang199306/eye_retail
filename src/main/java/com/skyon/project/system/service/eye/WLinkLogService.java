package com.skyon.project.system.service.eye;

import com.skyon.project.system.domain.eye.WLinkLog;

import java.util.List;

public interface WLinkLogService {

    // 插入流程信息
    public int insertWLinkLog(String taskINfoNo, String taskType, String dealRole, String dealUser, String operation,
                                String riskValue, String examinValue);

    // 根据taskInfoNo查询流程信息
    public List<WLinkLog> getList(String taskInfoNo);

    // 根据taskInfoNo删除流程信息
    public int deleteList(String taskInfoNo);
}
