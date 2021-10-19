package com.skyon.project.system.domain.vo;


import com.skyon.framework.web.domain.BaseEntity;

import java.util.List;

public class SignDownListVo extends BaseEntity {

    /**
     * 任务状态
     */
    private String Status;

    private List<String> id;

    private String DistributeModel;
    /**
     * 信号风险等级
     */
    private String warningLevel;
    /**
     * 信号触发时间
     */
    private String signalTriggerTime;
    /**
     * 预警信号信号类别
     */
    private String warningObjectType;
    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public List<String> getId() {
        return id;
    }

    public void setId(List<String> id) {
        this.id = id;
    }
}
