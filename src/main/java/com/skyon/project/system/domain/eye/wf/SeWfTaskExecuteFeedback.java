package com.skyon.project.system.domain.eye.wf;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.skyon.project.system.domain.eye.BasePojo;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 任务执行反馈表单
 * SE_WF_TASK_EXECUTE_FEEDBACK
 */
public class SeWfTaskExecuteFeedback extends BasePojo {

    @ApiModelProperty(name="innerId",value="主键id",required=true)
    private String innerId;
    @ApiModelProperty(name="warningObjectId",value="预警对象id",required=false)
    private String warningObjectId;
    @ApiModelProperty(name="taskNo",value="任务编号",required=false)
    private String taskNo;
    @ApiModelProperty(name="workingStatus",value="当前工作状态",required=false)
    private String workingStatus;
    @ApiModelProperty(name="currHandlerId",value="当前处理人id",required=false)
    private String currHandlerId;
    @ApiModelProperty(name="currRoleId",value="当前处理角色id",required=false)
    private String currRoleId;
    @ApiModelProperty(name="currProcSteps",value="当前处理步骤",required=false)
    private String currProcSteps;
    @ApiModelProperty(name="sysRiskLevel",value="系统认定客户风险等级",required=false)
    private String sysRiskLevel;
    @ApiModelProperty(name="riskLevel",value="客户风险等级",required=false)
    private String riskLevel;
    @ApiModelProperty(name="riskIdentify",value="主体风险认定情况",required=false)
    private String riskIdentify;
    @ApiModelProperty(name="identifyConclusions",value="认定检查结论(理由)",required=false)
    private String identifyConclusions;
    @ApiModelProperty(name="identifyFile",value="认定附件",required=false)
    private String identifyFile;
    @ApiModelProperty(name="isFinish",value="是否处置完成",required=false)
    private String isFinish;
    @ApiModelProperty(name="traceDate",value="本次处置跟踪完成日期",required=false)
    private String traceDate;
    @ApiModelProperty(name="nextTraceDate",value="下次处置跟踪完成日期",required=false)
    private String nextTraceDate;
    @ApiModelProperty(name="riskChanges",value="本次风险变化情况",required=false)
    private String riskChanges;
    @ApiModelProperty(name="traceFile",value="最新跟踪反馈附件",required=false)
    private String traceFile;
    @ApiModelProperty(name="disposalTraceFeedback",value="当前处置跟踪反馈意见",required=false)
    private String disposalTraceFeedback;
    @ApiModelProperty(name="currentControlMeasures",value="当前风险管控措施",required=false)
    private String currentControlMeasures;
    @ApiModelProperty(name="otherControlMeasures",value="其他风险管控措施描述",required=false)
    private String otherControlMeasures;
    @ApiModelProperty(name="oneFamilyOnePolicy",value="一户一策计划",required=false)
    private String oneFamilyOnePolicy;
    @ApiModelProperty(name="controlFile",value="当前风险管控措施附件",required=false)
    private String controlFile;
    @ApiModelProperty(name="isNewDisposalTrace",value="是否产生新跟踪任务",required=false)
    private String isNewDisposalTrace;




    //-----------------------------------toString----------------------------------------

    @Override
    public String toString() {
        return "SeWfTaskExecuteFeedback{" +
                "innerId='" + innerId + '\'' +
                ", warningObjectId='" + warningObjectId + '\'' +
                ", taskNo='" + taskNo + '\'' +
                ", workingStatus='" + workingStatus + '\'' +
                ", currHandlerId='" + currHandlerId + '\'' +
                ", currRoleId='" + currRoleId + '\'' +
                ", currProcSteps='" + currProcSteps + '\'' +
                ", sysRiskLevel='" + sysRiskLevel + '\'' +
                ", riskLevel='" + riskLevel + '\'' +
                ", riskIdentify='" + riskIdentify + '\'' +
                ", identifyConclusions='" + identifyConclusions + '\'' +
                ", identifyFile='" + identifyFile + '\'' +
                ", isFinish='" + isFinish + '\'' +
                ", traceDate='" + traceDate + '\'' +
                ", nextTraceDate='" + nextTraceDate + '\'' +
                ", riskChanges='" + riskChanges + '\'' +
                ", traceFile='" + traceFile + '\'' +
                ", disposalTraceFeedback='" + disposalTraceFeedback + '\'' +
                ", currentControlMeasures='" + currentControlMeasures + '\'' +
                ", otherControlMeasures='" + otherControlMeasures + '\'' +
                ", oneFamilyOnePolicy='" + oneFamilyOnePolicy + '\'' +
                ", controlFile='" + controlFile + '\'' +
                ", isNewDisposalTrace='" + isNewDisposalTrace + '\'' +
                '}';
    }


    //-----------------------------------get/set----------------------------------------


    public String getInnerId() {
        return innerId;
    }

    public void setInnerId(String innerId) {
        this.innerId = innerId;
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

    public String getIsFinish() {
        return isFinish;
    }

    public void setIsFinish(String isFinish) {
        this.isFinish = isFinish;
    }

    public String getTraceDate() {
        return traceDate;
    }

    public void setTraceDate(String traceDate) {
        this.traceDate = traceDate;
    }

    public String getNextTraceDate() {
        return nextTraceDate;
    }

    public void setNextTraceDate(String nextTraceDate) {
        this.nextTraceDate = nextTraceDate;
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


}
