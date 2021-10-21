package com.skyon.project.system.domain.eye.waringSings;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.skyon.project.system.domain.eye.BasePojo;
import com.skyon.project.system.domain.eye.SeWfWarningObject;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 预警信号表
 * SE_WF_WARNING_SIGNS
 *
 */
public class SeWfWarningSigns extends BasePojo {

    @ApiModelProperty(name="signalId",value="信号id(物理主键id)",required=false)
    private String signalId;
    @ApiModelProperty(name="lpOrgNo",value="法人机构标识",required=false)
    private String lpOrgNo;
    @ApiModelProperty(name="warningObjectId",value="预警对象id",required=false)
    private String warningObjectId;
    @ApiModelProperty(name="signalNo",value="信号编号",required=false)
    private String signalNo;
    @ApiModelProperty(name="signalName",value="信号名称",required=false)
    private String signalName;
    @ApiModelProperty(name="signalCreateModel",value="信号生成方式",required=false)
    private String signalCreateModel;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name="signalTriggerTime",value="信号触发时间",required=false)
    private Date signalTriggerTime;
    @JsonFormat(pattern = "yyyy/MM/dd")
    @ApiModelProperty(name="signalDueDay",value="信号观察期到期日",required=false)
    private Date signalDueDay;
    @ApiModelProperty(name="warningLevel",value="信号风险等级",required=false)
    private String warningLevel;
    @ApiModelProperty(name="signalType",value="信号分类",required=false)
    private String signalType;
    @ApiModelProperty(name="warnDsc",value="风险信息描述",required=false)
    private String warnDsc;
    @ApiModelProperty(name="isWarnFlag",value="是否生成风险提示单",required=false)
    private String isWarnFlag;
    @ApiModelProperty(name="warnNo",value="风险提示单编号",required=false)
    private String warnNo;
    @ApiModelProperty(name="sendPeople",value="发送对象",required=false)
    private String sendPeople;
    @ApiModelProperty(name="recipientPeople",value="抄送对象",required=false)
    private String recipientPeople;
    @ApiModelProperty(name="opposeAdvice",value="应对措施及管控建议",required=false)
    private String opposeAdvice;
    @ApiModelProperty(name="attachedFile",value="附件",required=false)
    private String attachedFile;
    @ApiModelProperty(name="signalDataSource",value="信号数据来源",required=false)
    private String signalDataSource;
    @ApiModelProperty(name="signalRuleId",value="信号规则id",required=false)
    private String signalRuleId;
    @ApiModelProperty(name="triggerNum",value="触发次数",required=false)
    private String triggerNum;
    @ApiModelProperty(name="isRelaFlag",value="是否关联信号",required=false)
    private String isRelaFlag;
    @ApiModelProperty(name="relaSignalNo",value="关联预警信号编号",required=false)
    private String relaSignalNo;
    @ApiModelProperty(name="isMergeFlag",value="是否合并信号",required=false)
    private String isMergeFlag;
    @ApiModelProperty(name="mergeSignalNo",value="合并预警信号编号",required=false)
    private String mergeSignalNo;
    @ApiModelProperty(name="signalStatus",value="信号状态",required=false)
    private String signalStatus;
    @ApiModelProperty(name="distributeStatus",value="下发状态",required=false)
    private String distributeStatus;
    @ApiModelProperty(name="distributeTime",value="下发时间",required=false)
    private Date distributeTime;
    @ApiModelProperty(name="distributeModel",value="下发模式",required=false)
    private String distributeModel;
    @ApiModelProperty(name="disposalMode",value="认定处置模式",required=false)
    private String disposalMode;
    @ApiModelProperty(name="noDistributeReason",value="不下发原因",required=false)
    private String noDistributeReason;
    @ApiModelProperty(name="disableReason",value="失效原因",required=false)
    private String disableReason;
    @ApiModelProperty(name="taskId",value="任务id",required=false)
    private String taskId;
    @ApiModelProperty(name="feedbackStatus",value="反馈状态",required=false)
    private String feedbackStatus;
    @ApiModelProperty(name="feedbackDesc",value="反馈意见描述",required=false)
    private String feedbackDesc;
    @ApiModelProperty(name="handlerUserId",value="经办人id",required=false)
    private String handlerUserId;
    @ApiModelProperty(name="handleRoleId",value="经办角色id",required=false)
    private String handleRoleId;
    @ApiModelProperty(name="currHandlerId",value="当前处理人id",required=false)
    private String currHandlerId;
    @ApiModelProperty(name="currRoleId",value="当前处理角色id",required=false)
    private String currRoleId;
    @ApiModelProperty(name="approvalRulesCond",value="审批规则条件",required=false)
    private String approvalRulesCond;
    @ApiModelProperty(name="rmark",value="备注",required=false)
    private String rmark;
    @ApiModelProperty(name="createId",value="创建人id",required=false)
    private String createId;
    @ApiModelProperty(name="createName",value="创建人名称",required=false)
    private String createName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name="createTime",value="创建时间",required=false)
    private Date createTime;
    @ApiModelProperty(name="updateId",value="修改人id",required=false)
    private String updateId;
    @ApiModelProperty(name="updateName",value="修改人名称",required=false)
    private String updateName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name="updateTime",value="修改时间",required=false)
    private Date updateTime;
    @ApiModelProperty(name="delFlag",value="删除标识",required=false)
    private String delFlag;
    @ApiModelProperty(name="confirmStatus",value="认定状态",required=false)
    private String confirmStatus;

    //  ----------------------------  关联---------------------------

    private SeWfWarningObject seWfWarningObject; // 预警对象


    //-----------------------------------toString----------------------------------------

    @Override
    public String toString() {
        return "SeWfWarningSigns{" +
                "signalId='" + signalId + '\'' +
                ", lpOrgNo='" + lpOrgNo + '\'' +
                ", warningObjectId='" + warningObjectId + '\'' +
                ", signalNo='" + signalNo + '\'' +
                ", signalName='" + signalName + '\'' +
                ", signalCreateModel='" + signalCreateModel + '\'' +
                ", signalTriggerTime=" + signalTriggerTime +
                ", signalDueDay=" + signalDueDay +
                ", warningLevel='" + warningLevel + '\'' +
                ", signalType='" + signalType + '\'' +
                ", warnDsc='" + warnDsc + '\'' +
                ", isWarnFlag='" + isWarnFlag + '\'' +
                ", warnNo='" + warnNo + '\'' +
                ", sendPeople='" + sendPeople + '\'' +
                ", recipientPeople='" + recipientPeople + '\'' +
                ", opposeAdvice='" + opposeAdvice + '\'' +
                ", attachedFile='" + attachedFile + '\'' +
                ", signalDataSource='" + signalDataSource + '\'' +
                ", signalRuleId='" + signalRuleId + '\'' +
                ", triggerNum='" + triggerNum + '\'' +
                ", isRelaFlag='" + isRelaFlag + '\'' +
                ", relaSignalNo='" + relaSignalNo + '\'' +
                ", isMergeFlag='" + isMergeFlag + '\'' +
                ", mergeSignalNo='" + mergeSignalNo + '\'' +
                ", signalStatus='" + signalStatus + '\'' +
                ", distributeStatus='" + distributeStatus + '\'' +
                ", distributeTime=" + distributeTime +
                ", distributeModel='" + distributeModel + '\'' +
                ", disposalMode='" + disposalMode + '\'' +
                ", noDistributeReason='" + noDistributeReason + '\'' +
                ", disableReason='" + disableReason + '\'' +
                ", taskId='" + taskId + '\'' +
                ", feedbackStatus='" + feedbackStatus + '\'' +
                ", feedbackDesc='" + feedbackDesc + '\'' +
                ", handlerUserId='" + handlerUserId + '\'' +
                ", handleRoleId='" + handleRoleId + '\'' +
                ", currHandlerId='" + currHandlerId + '\'' +
                ", currRoleId='" + currRoleId + '\'' +
                ", approvalRulesCond='" + approvalRulesCond + '\'' +
                ", rmark='" + rmark + '\'' +
                ", createId='" + createId + '\'' +
                ", createName='" + createName + '\'' +
                ", createTime=" + createTime +
                ", updateId='" + updateId + '\'' +
                ", updateName='" + updateName + '\'' +
                ", updateTime=" + updateTime +
                ", delFlag='" + delFlag + '\'' +
                ", confirmStatus='" + confirmStatus + '\'' +
                ", seWfWarningObject=" + seWfWarningObject +
                '}';
    }


    //-----------------------------------get/set----------------------------------------


    public String getConfirmStatus() {
        return confirmStatus;
    }

    public void setConfirmStatus(String confirmStatus) {
        this.confirmStatus = confirmStatus;
    }

    public Date getDistributeTime() {
        return distributeTime;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    public SeWfWarningObject getSeWfWarningObject() {
        return seWfWarningObject;
    }

    public void setSeWfWarningObject(SeWfWarningObject seWfWarningObject) {
        this.seWfWarningObject = seWfWarningObject;
    }

    public String getSignalId() {
        return signalId;
    }

    public void setSignalId(String signalId) {
        this.signalId = signalId;
    }

    @Override
    public String getLpOrgNo() {
        return lpOrgNo;
    }

    @Override
    public void setLpOrgNo(String lpOrgNo) {
        this.lpOrgNo = lpOrgNo;
    }

    public String getWarningObjectId() {
        return warningObjectId;
    }

    public void setWarningObjectId(String warningObjectId) {
        this.warningObjectId = warningObjectId;
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

    public void setDistributeTime(Date distributeTime) {
        this.distributeTime = distributeTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public String getIsWarnFlag() {
        return isWarnFlag;
    }

    public void setIsWarnFlag(String isWarnFlag) {
        this.isWarnFlag = isWarnFlag;
    }

    public String getWarnNo() {
        return warnNo;
    }

    public void setWarnNo(String warnNo) {
        this.warnNo = warnNo;
    }

    public String getSendPeople() {
        return sendPeople;
    }

    public void setSendPeople(String sendPeople) {
        this.sendPeople = sendPeople;
    }

    public String getRecipientPeople() {
        return recipientPeople;
    }

    public void setRecipientPeople(String recipientPeople) {
        this.recipientPeople = recipientPeople;
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

    public String getSignalRuleId() {
        return signalRuleId;
    }

    public void setSignalRuleId(String signalRuleId) {
        this.signalRuleId = signalRuleId;
    }

    public String getTriggerNum() {
        return triggerNum;
    }

    public void setTriggerNum(String triggerNum) {
        this.triggerNum = triggerNum;
    }

    public String getIsRelaFlag() {
        return isRelaFlag;
    }

    public void setIsRelaFlag(String isRelaFlag) {
        this.isRelaFlag = isRelaFlag;
    }

    public String getRelaSignalNo() {
        return relaSignalNo;
    }

    public void setRelaSignalNo(String relaSignalNo) {
        this.relaSignalNo = relaSignalNo;
    }

    public String getIsMergeFlag() {
        return isMergeFlag;
    }

    public void setIsMergeFlag(String isMergeFlag) {
        this.isMergeFlag = isMergeFlag;
    }

    public String getMergeSignalNo() {
        return mergeSignalNo;
    }

    public void setMergeSignalNo(String mergeSignalNo) {
        this.mergeSignalNo = mergeSignalNo;
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

    public String getFeedbackStatus() {
        return feedbackStatus;
    }

    public void setFeedbackStatus(String feedbackStatus) {
        this.feedbackStatus = feedbackStatus;
    }

    public String getFeedbackDesc() {
        return feedbackDesc;
    }

    public void setFeedbackDesc(String feedbackDesc) {
        this.feedbackDesc = feedbackDesc;
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

    public String getApprovalRulesCond() {
        return approvalRulesCond;
    }

    public void setApprovalRulesCond(String approvalRulesCond) {
        this.approvalRulesCond = approvalRulesCond;
    }

    public String getRmark() {
        return rmark;
    }

    public void setRmark(String rmark) {
        this.rmark = rmark;
    }

    @Override
    public String getCreateId() {
        return createId;
    }

    @Override
    public void setCreateId(String createId) {
        this.createId = createId;
    }

    @Override
    public String getCreateName() {
        return createName;
    }

    @Override
    public void setCreateName(String createName) {
        this.createName = createName;
    }

    @Override
    public String getUpdateId() {
        return updateId;
    }

    @Override
    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }

    @Override
    public String getUpdateName() {
        return updateName;
    }

    @Override
    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    @Override
    public Date getUpdateTime() {
        return updateTime;
    }

    @Override
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }
}
