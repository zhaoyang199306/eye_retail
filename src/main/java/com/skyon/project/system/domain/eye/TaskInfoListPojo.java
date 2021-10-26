package com.skyon.project.system.domain.eye;

import com.skyon.framework.web.domain.BaseEntity;
import com.skyon.project.system.domain.eye.waringSings.SeWfWarningSigns;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
@ApiModel(value = "预警页面返回参数",description ="预警页面返回参数")
public class TaskInfoListPojo {

    @ApiModelProperty(value = "任务编号", name = "taskNo", required = true)
    private String taskNo;
    @ApiModelProperty(value = "预警对象名", name = "warningObjectName", required = true)
    private String warningObjectName;
    @ApiModelProperty(value = "预警对象编号", name = "warningObjectNo", required = true)
    private String warningObjectNo;
    @ApiModelProperty(value = "风险等级", name = "riskLevel", required = true)
    private String riskLevel; //
    @ApiModelProperty(value = "任务状态", name = "taskStatus", required = true)
    private String taskStatus;
    @ApiModelProperty(value = "任务类型", name = "taskType", required = true)
    private String taskType; //
    @ApiModelProperty(value = "系统认定风险等级", name = "sysRiskLevel", required = true)
    private String sysRiskLevel;
    @ApiModelProperty(value = "经办角色", name = "handleRoleId", required = true)
    private String handleRoleId;
    @ApiModelProperty(value = "经办角色", name = "handleRoleName", required = true)
    private String handleRoleName;
    @ApiModelProperty(value = "一级风险等级", name = "oneLevelCount", required = true)
    private String oneLevelCount;
    @ApiModelProperty(value = "二级风险等级", name = "twoLevelCount", required = true)
    private String twoLevelCount;
    @ApiModelProperty(value = "三级风险等级", name = "threeLevelCount", required = true)
    private String threeLevelCount;
    @ApiModelProperty(value = "所属支行", name = "adminSubbranchNo", required = true)
    private String adminSubbranchNo;
    @ApiModelProperty(value = "所属分行", name = "adminBranchNo", required = true)
    private String adminBranchNo; //
    @ApiModelProperty(value = "任务生成时间", name = "taskCreateTime", required = true)
    private String taskCreateTime; //
    @ApiModelProperty(value = "要求任务完成截止日", name = "taskDeadline", required = true)
    private String taskDeadline; //
    @ApiModelProperty(value = "预警对象类型", name = "warningObjectCategory", required = true)
    private String warningObjectCategory;
    @ApiModelProperty(value = "监测主体类型", name = "warningObjectType", required = true)
    private String warningObjectType;
    @ApiModelProperty(value = "当前任务工作", name = "taskWorking", required = true)
    private String taskWorking;
    @ApiModelProperty(value = "当前工作状态", name = "workingStatus", required = true)
    private String workingStatus;


    public String getWarningObjectType() {
        return warningObjectType;
    }

    public void setWarningObjectType(String warningObjectType) {
        this.warningObjectType = warningObjectType;
    }

    public String getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo;
    }

    public String getHandleRoleName() {
        return handleRoleName;
    }

    public void setHandleRoleName(String handleRoleName) {
        this.handleRoleName = handleRoleName;
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

    public String getTaskWorking() {
        return taskWorking;
    }

    public void setTaskWorking(String taskWorking) {
        this.taskWorking = taskWorking;
    }

    public String getWorkingStatus() {
        return workingStatus;
    }

    public void setWorkingStatus(String workingStatus) {
        this.workingStatus = workingStatus;
    }
}
