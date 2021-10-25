package com.skyon.project.system.domain.eye;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.skyon.project.system.domain.eye.waringSings.SeWfWarningSigns;
import com.skyon.project.system.domain.eye.wf.SeWfTaskExecuteFeedback;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

/**
 * 任务信息表
 * SE_WF_TASK_INFO
 */
@ApiModel(value = "任务信息表实体类",description ="任务信息表实体类")
public class SeWfTaskInfo extends BasePojo {

    @ApiModelProperty(name = "taskId" , value = "任务ID(物理主键ID)", required = false)
    private String taskId;  
    @ApiModelProperty(name = "warningObjectId" , value = "法人机构标识", required = false)
    private String warningObjectId;  
    @ApiModelProperty(name = "taskNo" , value = "预警对象ID", required = false)
    private String taskNo;  
    @ApiModelProperty(name = "taskCreateTime" , value = "任务生成时间", required = false)
    private String taskCreateTime;  
    @ApiModelProperty(name = "taskDeadline" , value = "要求任务完成截止日", required = false)
    private String taskDeadline;  
    @ApiModelProperty(name = "taskEndDate" , value = "任务实际完成日期", required = false)
    private String taskEndDate;  
    @ApiModelProperty(name = "taskType" , value = "任务类型", required = false)
    private String taskType;  
    @ApiModelProperty(name = "taskStatus" , value = "任务状态", required = false)
    private String taskStatus;  
    @ApiModelProperty(name = "handlerUserId" , value = "经办人ID", required = false)
    private String handlerUserId;  
    @ApiModelProperty(name = "handleRoleId" , value = "经办角色ID", required = false)
    private String handleRoleId;  
    @ApiModelProperty(name = "taskWorking" , value = "当前任务工作", required = false)
    private String taskWorking;  
    @ApiModelProperty(name = "workingStatus" , value = "当前工作状态", required = false)
    private String workingStatus;  
    @ApiModelProperty(name = "currHandlerId" , value = "当前处理人ID", required = false)
    private String currHandlerId;  
    @ApiModelProperty(name = "currRoleId" , value = "当前处理角色ID", required = false)
    private String currRoleId;  
    @ApiModelProperty(name = "currProcSteps" , value = "当前处理步骤", required = false)
    private String currProcSteps;  
    @ApiModelProperty(name = "warningIdentifyModel" , value = "预警认定模式", required = false)
    private String warningIdentifyModel;  
    @ApiModelProperty(name = "sysRiskLevel" , value = "系统认定客户风险等级", required = false)
    private String sysRiskLevel;  
    @ApiModelProperty(name = "riskLevel" , value = "客户风险等级", required = false)
    private String riskLevel;  
    @ApiModelProperty(name = "riskIdentify" , value = "主体风险认定情况", required = false)
    private String riskIdentify;  
    @ApiModelProperty(name = "initialIdentifyConclusions" , value = "初始检查结论", required = false)
    private String initialIdentifyConclusions;  
    @ApiModelProperty(name = "identifyConclusions" , value = "最终认定检查结论", required = false)
    private String identifyConclusions;  
    @ApiModelProperty(name = "identifyFile" , value = "最终认定附件", required = false)
    private String identifyFile;  
    @ApiModelProperty(name = "identifyDate" , value = "认定生效日期", required = false)
    private String identifyDate;  
    @ApiModelProperty(name = "isFinish" , value = "是否处置完成", required = false)
    private String isFinish;  
    @ApiModelProperty(name = "disposalTraceModel" , value = "处置跟踪模式", required = false)
    private String disposalTraceModel;  
    @ApiModelProperty(name = "initialTraceDate" , value = "初始处置跟踪完成日期", required = false)
    private String initialTraceDate;  
    @ApiModelProperty(name = "nextTraceDate" , value = "下次处置跟踪完成日期", required = false)
    private String nextTraceDate;  
    @ApiModelProperty(name = "endTraceDate" , value = "最终处置跟踪完成日期", required = false)
    private String endTraceDate;  
    @ApiModelProperty(name = "riskChanges" , value = "最近风险变化情况", required = false)
    private String riskChanges;  
    @ApiModelProperty(name = "traceFile" , value = "当前跟踪反馈附件", required = false)
    private String traceFile;  
    @ApiModelProperty(name = "disposalTraceFeedback" , value = "当前处置跟踪反馈意见", required = false)
    private String disposalTraceFeedback;  
    @ApiModelProperty(name = "initialControlMeasures" , value = "初始风险管控措施", required = false)
    private String initialControlMeasures;  
    @ApiModelProperty(name = "currentControlMeasures" , value = "当前风险管控措施", required = false)
    private String currentControlMeasures;  
    @ApiModelProperty(name = "otherControlMeasures" , value = "其他风险管控措施描述", required = false)
    private String otherControlMeasures;  
    @ApiModelProperty(name = "oneFamilyOnePolicy" , value = "一户一策计划", required = false)
    private String oneFamilyOnePolicy;  
    @ApiModelProperty(name = "controlFile" , value = "当前风险管控措施附件", required = false)
    private String controlFile;  
    @ApiModelProperty(name = "isNewDisposalTrace" , value = "是否产生新跟踪任务", required = false)
    private String isNewDisposalTrace;  
    @ApiModelProperty(name = "newTaskId" , value = "新任务ID", required = false)
    private String newTaskId;  
    @ApiModelProperty(name = "parentTaskId" , value = "父任务ID", required = false)
    private String parentTaskId;  
    @ApiModelProperty(name = "approvalRulesCond" , value = "审批规则条件", required = false)
    private String approvalRulesCond;  
    @ApiModelProperty(name = "warningTaskKind" , value = "预警任务种类 01 预警任务（自动认定） 02 预警任务（非自动认定） 03 预警任务（人工信号认定） 04 签收任务", required = false)
    private String warningTaskKind;  // 预警任务种类 01 预警任务（自动认定） 02 预警任务（非自动认定） 03 预警任务（人工信号认定） 04 签收任务


    //  ----------------------------  关联---------------------------

    private SeWfWarningObject seWfWarningObject; // 预警对象

    private List<SeWfWarningSigns> seWfWarningSigns; // 预警信号

    private SeWfTaskExecuteFeedback seWfTaskExecuteFeedback; // 执行反馈表

    private List<SeWfTaskExecuteFeedback> seWfTaskExecuteFeedbacks; // 过程意见


//-----------------------------------toString----------------------------------------

    @Override
    public String toString() {
        return "SeWfTaskInfo{" +
                "taskId='" + taskId + '\'' +
                ", warningObjectId='" + warningObjectId + '\'' +
                ", taskNo='" + taskNo + '\'' +
                ", taskCreateTime='" + taskCreateTime + '\'' +
                ", taskDeadline='" + taskDeadline + '\'' +
                ", taskEndDate='" + taskEndDate + '\'' +
                ", taskType='" + taskType + '\'' +
                ", taskStatus='" + taskStatus + '\'' +
                ", handlerUserId='" + handlerUserId + '\'' +
                ", handleRoleId='" + handleRoleId + '\'' +
                ", taskWorking='" + taskWorking + '\'' +
                ", workingStatus='" + workingStatus + '\'' +
                ", currHandlerId='" + currHandlerId + '\'' +
                ", currRoleId='" + currRoleId + '\'' +
                ", currProcSteps='" + currProcSteps + '\'' +
                ", warningIdentifyModel='" + warningIdentifyModel + '\'' +
                ", sysRiskLevel='" + sysRiskLevel + '\'' +
                ", riskLevel='" + riskLevel + '\'' +
                ", riskIdentify='" + riskIdentify + '\'' +
                ", initialIdentifyConclusions='" + initialIdentifyConclusions + '\'' +
                ", identifyConclusions='" + identifyConclusions + '\'' +
                ", identifyFile='" + identifyFile + '\'' +
                ", identifyDate='" + identifyDate + '\'' +
                ", isFinish='" + isFinish + '\'' +
                ", disposalTraceModel='" + disposalTraceModel + '\'' +
                ", initialTraceDate='" + initialTraceDate + '\'' +
                ", nextTraceDate='" + nextTraceDate + '\'' +
                ", endTraceDate='" + endTraceDate + '\'' +
                ", riskChanges='" + riskChanges + '\'' +
                ", traceFile='" + traceFile + '\'' +
                ", disposalTraceFeedback='" + disposalTraceFeedback + '\'' +
                ", initialControlMeasures='" + initialControlMeasures + '\'' +
                ", currentControlMeasures='" + currentControlMeasures + '\'' +
                ", otherControlMeasures='" + otherControlMeasures + '\'' +
                ", oneFamilyOnePolicy='" + oneFamilyOnePolicy + '\'' +
                ", controlFile='" + controlFile + '\'' +
                ", isNewDisposalTrace='" + isNewDisposalTrace + '\'' +
                ", newTaskId='" + newTaskId + '\'' +
                ", parentTaskId='" + parentTaskId + '\'' +
                ", approvalRulesCond='" + approvalRulesCond + '\'' +
                ", warningTaskKind='" + warningTaskKind + '\'' +
                ", seWfWarningObject=" + seWfWarningObject +
                ", seWfWarningSigns=" + seWfWarningSigns +
                ", seWfTaskExecuteFeedback=" + seWfTaskExecuteFeedback +
                ", seWfTaskExecuteFeedbacks=" + seWfTaskExecuteFeedbacks +
                '}';
    }


//-----------------------------------get/set----------------------------------------


    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getWarningObjectId() {
        return warningObjectId;
    }

    public void setWarningObjectId(String warningObjectId) {
        this.warningObjectId = warningObjectId;
    }

    public String getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo;
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

    public String getTaskEndDate() {
        return taskEndDate;
    }

    public void setTaskEndDate(String taskEndDate) {
        this.taskEndDate = taskEndDate;
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

    public String getHandlerUserId() {
        return handlerUserId;
    }

    public void setHandlerUserId(String handlerUserId) {
        this.handlerUserId = handlerUserId;
    }

    public String getHandleRoleId() {
        return handleRoleId;
    }

    public void setHandleRoleId(String handleRoleId) {
        this.handleRoleId = handleRoleId;
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

    public String getCurrHandlerId() {
        return currHandlerId;
    }

    public void setCurrHandlerId(String currHandlerId) {
        this.currHandlerId = currHandlerId;
    }

    public String getCurrRoleId() {
        return currRoleId;
    }

    public void setCurrRoleId(String currRoleId) {
        this.currRoleId = currRoleId;
    }

    public String getCurrProcSteps() {
        return currProcSteps;
    }

    public void setCurrProcSteps(String currProcSteps) {
        this.currProcSteps = currProcSteps;
    }

    public String getWarningIdentifyModel() {
        return warningIdentifyModel;
    }

    public void setWarningIdentifyModel(String warningIdentifyModel) {
        this.warningIdentifyModel = warningIdentifyModel;
    }

    public String getSysRiskLevel() {
        return sysRiskLevel;
    }

    public void setSysRiskLevel(String sysRiskLevel) {
        this.sysRiskLevel = sysRiskLevel;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getRiskIdentify() {
        return riskIdentify;
    }

    public void setRiskIdentify(String riskIdentify) {
        this.riskIdentify = riskIdentify;
    }

    public String getInitialIdentifyConclusions() {
        return initialIdentifyConclusions;
    }

    public void setInitialIdentifyConclusions(String initialIdentifyConclusions) {
        this.initialIdentifyConclusions = initialIdentifyConclusions;
    }

    public String getIdentifyConclusions() {
        return identifyConclusions;
    }

    public void setIdentifyConclusions(String identifyConclusions) {
        this.identifyConclusions = identifyConclusions;
    }

    public String getIdentifyFile() {
        return identifyFile;
    }

    public void setIdentifyFile(String identifyFile) {
        this.identifyFile = identifyFile;
    }

    public String getIdentifyDate() {
        return identifyDate;
    }

    public void setIdentifyDate(String identifyDate) {
        this.identifyDate = identifyDate;
    }

    public String getIsFinish() {
        return isFinish;
    }

    public void setIsFinish(String isFinish) {
        this.isFinish = isFinish;
    }

    public String getDisposalTraceModel() {
        return disposalTraceModel;
    }

    public void setDisposalTraceModel(String disposalTraceModel) {
        this.disposalTraceModel = disposalTraceModel;
    }

    public String getInitialTraceDate() {
        return initialTraceDate;
    }

    public void setInitialTraceDate(String initialTraceDate) {
        this.initialTraceDate = initialTraceDate;
    }

    public String getNextTraceDate() {
        return nextTraceDate;
    }

    public void setNextTraceDate(String nextTraceDate) {
        this.nextTraceDate = nextTraceDate;
    }

    public String getEndTraceDate() {
        return endTraceDate;
    }

    public void setEndTraceDate(String endTraceDate) {
        this.endTraceDate = endTraceDate;
    }

    public String getRiskChanges() {
        return riskChanges;
    }

    public void setRiskChanges(String riskChanges) {
        this.riskChanges = riskChanges;
    }

    public String getTraceFile() {
        return traceFile;
    }

    public void setTraceFile(String traceFile) {
        this.traceFile = traceFile;
    }

    public String getDisposalTraceFeedback() {
        return disposalTraceFeedback;
    }

    public void setDisposalTraceFeedback(String disposalTraceFeedback) {
        this.disposalTraceFeedback = disposalTraceFeedback;
    }

    public String getInitialControlMeasures() {
        return initialControlMeasures;
    }

    public void setInitialControlMeasures(String initialControlMeasures) {
        this.initialControlMeasures = initialControlMeasures;
    }

    public String getCurrentControlMeasures() {
        return currentControlMeasures;
    }

    public void setCurrentControlMeasures(String currentControlMeasures) {
        this.currentControlMeasures = currentControlMeasures;
    }

    public String getOtherControlMeasures() {
        return otherControlMeasures;
    }

    public void setOtherControlMeasures(String otherControlMeasures) {
        this.otherControlMeasures = otherControlMeasures;
    }

    public String getOneFamilyOnePolicy() {
        return oneFamilyOnePolicy;
    }

    public void setOneFamilyOnePolicy(String oneFamilyOnePolicy) {
        this.oneFamilyOnePolicy = oneFamilyOnePolicy;
    }

    public String getControlFile() {
        return controlFile;
    }

    public void setControlFile(String controlFile) {
        this.controlFile = controlFile;
    }

    public String getIsNewDisposalTrace() {
        return isNewDisposalTrace;
    }

    public void setIsNewDisposalTrace(String isNewDisposalTrace) {
        this.isNewDisposalTrace = isNewDisposalTrace;
    }

    public String getNewTaskId() {
        return newTaskId;
    }

    public void setNewTaskId(String newTaskId) {
        this.newTaskId = newTaskId;
    }

    public String getParentTaskId() {
        return parentTaskId;
    }

    public void setParentTaskId(String parentTaskId) {
        this.parentTaskId = parentTaskId;
    }

    public String getApprovalRulesCond() {
        return approvalRulesCond;
    }

    public void setApprovalRulesCond(String approvalRulesCond) {
        this.approvalRulesCond = approvalRulesCond;
    }

    public String getWarningTaskKind() {
        return warningTaskKind;
    }

    public void setWarningTaskKind(String warningTaskKind) {
        this.warningTaskKind = warningTaskKind;
    }

    public SeWfWarningObject getSeWfWarningObject() {
        return seWfWarningObject;
    }

    public void setSeWfWarningObject(SeWfWarningObject seWfWarningObject) {
        this.seWfWarningObject = seWfWarningObject;
    }

    public List<SeWfWarningSigns> getSeWfWarningSigns() {
        return seWfWarningSigns;
    }

    public void setSeWfWarningSigns(List<SeWfWarningSigns> seWfWarningSigns) {
        this.seWfWarningSigns = seWfWarningSigns;
    }

    public SeWfTaskExecuteFeedback getSeWfTaskExecuteFeedback() {
        return seWfTaskExecuteFeedback;
    }

    public void setSeWfTaskExecuteFeedback(SeWfTaskExecuteFeedback seWfTaskExecuteFeedback) {
        this.seWfTaskExecuteFeedback = seWfTaskExecuteFeedback;
    }

    public List<SeWfTaskExecuteFeedback> getSeWfTaskExecuteFeedbacks() {
        return seWfTaskExecuteFeedbacks;
    }

    public void setSeWfTaskExecuteFeedbacks(List<SeWfTaskExecuteFeedback> seWfTaskExecuteFeedbacks) {
        this.seWfTaskExecuteFeedbacks = seWfTaskExecuteFeedbacks;
    }
}
