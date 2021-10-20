package com.skyon.project.system.domain.eye;

import com.skyon.project.system.domain.eye.waringSings.SeWfWarningSigns;

import java.util.List;

public class TaskInfoListPojo {

    public TaskInfoListPojo() {
    }

        private String taskExecuteId; //
        private String warningObjectName;
        private String warningObjectNo;
        private String riskLevel; //
        private String taskStatus;
        private String taskType; //
        private String sysRiskLevel;
        private String handleRoleId;
        private String oneLevelCount;
        private String twoLevelCount;
        private String threeLevelCount;
        private String adminSubbranchNo;
        private String adminBranchNo; //
        private String taskCreateTime; //
        private String taskDeadline; //
        private String warningObjectCategory;

    public String getTaskExecuteId() {
        return taskExecuteId;
    }

    public void setTaskExecuteId(String taskExecuteId) {
        this.taskExecuteId = taskExecuteId;
    }

    public String getWarningObjectName() {
        return warningObjectName;
    }

    public void setWarningObjectName(String warningObjectName) {
        this.warningObjectName = warningObjectName;
    }

    public String getWarningObjectNo() {
        return warningObjectNo;
    }

    public void setWarningObjectNo(String warningObjectNo) {
        this.warningObjectNo = warningObjectNo;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getSysRiskLevel() {
        return sysRiskLevel;
    }

    public void setSysRiskLevel(String sysRiskLevel) {
        this.sysRiskLevel = sysRiskLevel;
    }

    public String getHandleRoleId() {
        return handleRoleId;
    }

    public void setHandleRoleId(String handleRoleId) {
        this.handleRoleId = handleRoleId;
    }

    public String getOneLevelCount() {
        return oneLevelCount;
    }

    public void setOneLevelCount(String oneLevelCount) {
        this.oneLevelCount = oneLevelCount;
    }

    public String getTwoLevelCount() {
        return twoLevelCount;
    }

    public void setTwoLevelCount(String twoLevelCount) {
        this.twoLevelCount = twoLevelCount;
    }

    public String getThreeLevelCount() {
        return threeLevelCount;
    }

    public void setThreeLevelCount(String threeLevelCount) {
        this.threeLevelCount = threeLevelCount;
    }

    public String getAdminSubbranchNo() {
        return adminSubbranchNo;
    }

    public void setAdminSubbranchNo(String adminSubbranchNo) {
        this.adminSubbranchNo = adminSubbranchNo;
    }

    public String getAdminBranchNo() {
        return adminBranchNo;
    }

    public void setAdminBranchNo(String adminBranchNo) {
        this.adminBranchNo = adminBranchNo;
    }

    public String getTaskCreateTime() {
        return taskCreateTime;
    }

    public void setTaskCreateTime(String taskCreateTime) {
        this.taskCreateTime = taskCreateTime;
    }

    public String getTaskDeadline() {
        return taskDeadline;
    }

    public void setTaskDeadline(String taskDeadline) {
        this.taskDeadline = taskDeadline;
    }

    public String getWarningObjectCategory() {
        return warningObjectCategory;
    }

    public void setWarningObjectCategory(String warningObjectCategory) {
        this.warningObjectCategory = warningObjectCategory;
    }
}
