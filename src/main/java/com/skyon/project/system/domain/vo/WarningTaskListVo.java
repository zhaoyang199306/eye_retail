package com.skyon.project.system.domain.vo;

import com.skyon.framework.web.domain.BaseEntity;

public class WarningTaskListVo extends BaseEntity {

    private String taskHandler;

    private String taskNo;

    private String warningObjectName;

    private String warningObjectId;

    private String adBra;

    private String adSubBra;

    private String taskType;

    private String taskStatus;

    public String getTaskHandler() {
        return taskHandler;
    }

    public void setTaskHandler(String taskHandler) {
        this.taskHandler = taskHandler;
    }

    public String getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo;
    }

    public String getWarningObjectName() {
        return warningObjectName;
    }

    public void setWarningObjectName(String warningObjectName) {
        this.warningObjectName = warningObjectName;
    }

    public String getWarningObjectId() {
        return warningObjectId;
    }

    public void setWarningObjectId(String warningObjectId) {
        this.warningObjectId = warningObjectId;
    }

    public String getAdBra() {
        return adBra;
    }

    public void setAdBra(String adBra) {
        this.adBra = adBra;
    }

    public String getAdSubBra() {
        return adSubBra;
    }

    public void setAdSubBra(String adSubBra) {
        this.adSubBra = adSubBra;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }
}
