package com.skyon.project.system.domain.eye.waringSings;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.skyon.project.system.domain.eye.BasePojo;

import java.util.Date;

/**
 * 预警信号表
 * SE_WF_WARNING_SIGNS
 *
 */
public class SeWfWarningSigns extends BasePojo {

    private String warningSignalId;  // 预警信号ID not null
    private String signalNo;  // 信号编号 not null
    private String signalName; // 信号名称
    private String signalCreateModel; // 信号生成方式
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date signalTriggerTime; // 信号触发时间
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date signalDueDay;  // 信号观察期到期日
    private String warningLevel; // 信号风险等级 一级预警信号 01/二级预警信号 02 /三级预警信号 03
    private String signalType; // 信号大类
    private String warnDsc; // 风险信息描述 clob
    private String warningObjectId;  // 预警对象id not null
    private String warningObjectCategory; // 预警对象类别
    private String warningObjectNo; // 预警对象编号
    private String warningObjectName; // 预警对象名称
    private String warningObjectType; // 监测对象类型
    private String isWarnFlag; // 是否生成风险提示单
    private String opposeAdvice; // 应对措施及管控建议
    private String attachedFile; // 附件
    private String signalDataSource; // 信号数据来源
    private String triggerRuleId; // 触发规则ID
    private long triggerNumber; // 触发次数
    private String isSignalMerge; // 是否合并信号
    private String signalMergeId; // 合并预警信号ID
    private String signalStatus; // 信号状态 not null  录入 01/正常 02 /失效 03
    private String distributeStatus; //  下发状态
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date distributeTime;  // 下发时间
    private String distributeModel;  // 下发模式 自动/人工/不下发
    private String disposalMode; // 处置模式   自动 01/人工 02 /混合 03
    private String noDistributeReason; // 不下发原因
    private String disableReason; // 失效原因
    private String taskId; //任务ID not null
    private String confirmStatus; // 认定状态 属实/不属实
    private String feedback; // 反馈结论
    private String feedbackDesc; // 反馈意见描述




    //-----------------------------------toString----------------------------------------

    @Override
    public String toString() {
        return "SeWfWarningSigns{" +
                "warningSignalId='" + warningSignalId + '\'' +
                ", signalNo='" + signalNo + '\'' +
                ", signalName='" + signalName + '\'' +
                ", signalCreateModel='" + signalCreateModel + '\'' +
                ", signalTriggerTime='" + signalTriggerTime + '\'' +
                ", signalDueDay=" + signalDueDay +
                ", warningLevel='" + warningLevel + '\'' +
                ", signalType='" + signalType + '\'' +
                ", warnDsc='" + warnDsc + '\'' +
                ", warningObjectId='" + warningObjectId + '\'' +
                ", warningObjectCategory='" + warningObjectCategory + '\'' +
                ", warningObjectNo='" + warningObjectNo + '\'' +
                ", warningObjectName='" + warningObjectName + '\'' +
                ", warningObjectType='" + warningObjectType + '\'' +
                ", isWarnFlag='" + isWarnFlag + '\'' +
                ", opposeAdvice='" + opposeAdvice + '\'' +
                ", attachedFile='" + attachedFile + '\'' +
                ", signalDataSource='" + signalDataSource + '\'' +
                ", triggerRuleId='" + triggerRuleId + '\'' +
                ", triggerNumber=" + triggerNumber +
                ", isSignalMerge='" + isSignalMerge + '\'' +
                ", signalMergeId='" + signalMergeId + '\'' +
                ", signalStatus='" + signalStatus + '\'' +
                ", distributeStatus='" + distributeStatus + '\'' +
                ", distributeTime=" + distributeTime +
                ", distributeModel='" + distributeModel + '\'' +
                ", disposalMode='" + disposalMode + '\'' +
                ", noDistributeReason='" + noDistributeReason + '\'' +
                ", disableReason='" + disableReason + '\'' +
                ", taskId='" + taskId + '\'' +
                ", confirmStatus='" + confirmStatus + '\'' +
                ", feedback='" + feedback + '\'' +
                ", feedbackDesc='" + feedbackDesc + '\'' +
                '}';
    }


    //-----------------------------------get/set----------------------------------------

    public String getWarningSignalId() {
        return warningSignalId;
    }

    public void setWarningSignalId(String warningSignalId) {
        this.warningSignalId = warningSignalId;
    }

    public String getSignalNo() {
        return signalNo;
    }

    public void setSignalNo(String signalNo) {
        this.signalNo = signalNo;
    }

    public String getSignalName() {
        return signalName;
    }

    public void setSignalName(String signalName) {
        this.signalName = signalName;
    }

    public String getSignalCreateModel() {
        return signalCreateModel;
    }

    public void setSignalCreateModel(String signalCreateModel) {
        this.signalCreateModel = signalCreateModel;
    }

    public Date getSignalTriggerTime() {
        return signalTriggerTime;
    }

    public void setSignalTriggerTime(Date signalTriggerTime) {
        this.signalTriggerTime = signalTriggerTime;
    }

    public Date getSignalDueDay() {
        return signalDueDay;
    }

    public void setSignalDueDay(Date signalDueDay) {
        this.signalDueDay = signalDueDay;
    }

    public String getWarningLevel() {
        return warningLevel;
    }

    public void setWarningLevel(String warningLevel) {
        this.warningLevel = warningLevel;
    }

    public String getSignalType() {
        return signalType;
    }

    public void setSignalType(String signalType) {
        this.signalType = signalType;
    }

    public String getWarnDsc() {
        return warnDsc;
    }

    public void setWarnDsc(String warnDsc) {
        this.warnDsc = warnDsc;
    }

    public String getWarningObjectId() {
        return warningObjectId;
    }

    public void setWarningObjectId(String warningObjectId) {
        this.warningObjectId = warningObjectId;
    }

    public String getWarningObjectCategory() {
        return warningObjectCategory;
    }

    public void setWarningObjectCategory(String warningObjectCategory) {
        this.warningObjectCategory = warningObjectCategory;
    }

    public String getWarningObjectNo() {
        return warningObjectNo;
    }

    public void setWarningObjectNo(String warningObjectNo) {
        this.warningObjectNo = warningObjectNo;
    }

    public String getWarningObjectName() {
        return warningObjectName;
    }

    public void setWarningObjectName(String warningObjectName) {
        this.warningObjectName = warningObjectName;
    }

    public String getWarningObjectType() {
        return warningObjectType;
    }

    public void setWarningObjectType(String warningObjectType) {
        this.warningObjectType = warningObjectType;
    }

    public String getIsWarnFlag() {
        return isWarnFlag;
    }

    public void setIsWarnFlag(String isWarnFlag) {
        this.isWarnFlag = isWarnFlag;
    }

    public String getOpposeAdvice() {
        return opposeAdvice;
    }

    public void setOpposeAdvice(String opposeAdvice) {
        this.opposeAdvice = opposeAdvice;
    }

    public String getAttachedFile() {
        return attachedFile;
    }

    public void setAttachedFile(String attachedFile) {
        this.attachedFile = attachedFile;
    }

    public String getSignalDataSource() {
        return signalDataSource;
    }

    public void setSignalDataSource(String signalDataSource) {
        this.signalDataSource = signalDataSource;
    }

    public String getTriggerRuleId() {
        return triggerRuleId;
    }

    public void setTriggerRuleId(String triggerRuleId) {
        this.triggerRuleId = triggerRuleId;
    }

    public long getTriggerNumber() {
        return triggerNumber;
    }

    public void setTriggerNumber(long triggerNumber) {
        this.triggerNumber = triggerNumber;
    }

    public String getIsSignalMerge() {
        return isSignalMerge;
    }

    public void setIsSignalMerge(String isSignalMerge) {
        this.isSignalMerge = isSignalMerge;
    }

    public String getSignalMergeId() {
        return signalMergeId;
    }

    public void setSignalMergeId(String signalMergeId) {
        this.signalMergeId = signalMergeId;
    }

    public String getSignalStatus() {
        return signalStatus;
    }

    public void setSignalStatus(String signalStatus) {
        this.signalStatus = signalStatus;
    }

    public String getDistributeStatus() {
        return distributeStatus;
    }

    public void setDistributeStatus(String distributeStatus) {
        this.distributeStatus = distributeStatus;
    }

    public Date getDistributeTime() {
        return distributeTime;
    }

    public void setDistributeTime(Date distributeTime) {
        this.distributeTime = distributeTime;
    }

    public String getDistributeModel() {
        return distributeModel;
    }

    public void setDistributeModel(String distributeModel) {
        this.distributeModel = distributeModel;
    }

    public String getDisposalMode() {
        return disposalMode;
    }

    public void setDisposalMode(String disposalMode) {
        this.disposalMode = disposalMode;
    }

    public String getNoDistributeReason() {
        return noDistributeReason;
    }

    public void setNoDistributeReason(String noDistributeReason) {
        this.noDistributeReason = noDistributeReason;
    }

    public String getDisableReason() {
        return disableReason;
    }

    public void setDisableReason(String disableReason) {
        this.disableReason = disableReason;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getConfirmStatus() {
        return confirmStatus;
    }

    public void setConfirmStatus(String confirmStatus) {
        this.confirmStatus = confirmStatus;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getFeedbackDesc() {
        return feedbackDesc;
    }

    public void setFeedbackDesc(String feedbackDesc) {
        this.feedbackDesc = feedbackDesc;
    }

}
