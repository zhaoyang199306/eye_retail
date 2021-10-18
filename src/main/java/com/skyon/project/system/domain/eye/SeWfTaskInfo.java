package com.skyon.project.system.domain.eye;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.skyon.project.system.domain.eye.waringSings.SeWfWarningSigns;
import com.skyon.project.system.domain.eye.wf.SeWfTaskExecuteFeedback;

import java.util.Date;
import java.util.List;

/**
 * 任务信息表
 * SE_WF_TASK_INFO
 */
public class SeWfTaskInfo extends BasePojo {

    private String taskId; // 任务ID 主键   not null
    private String taskNo; // 任务编号 not null
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date taskStartTime; // 任务开始日期
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date taskDeadline; // 任务完成截止日
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date taskEndTime; // 任务实际完成日期
    private String warningObjectId; // 预警对象ID not null
    private String warningObjectCategory; // 预警对象类别
    private String warningObjectNo; // 预警对象编号
    private String warningObjectName; // 预警对象名称
    private String warningObjectType; //监测对象类型

    private String taskStatus; // not null 任务状态（待处理、处理中）

    private String taskType;// not null 任务类型（预警任务、处置跟踪）

    private String taskHandler; // 任务经办人

    private String taskHandlePost; // 任务经办岗

    private String sysRiskLevel; // 系统认定客户风险等级 红色/橙色/黄色/蓝色/绿色

    private String riskLevel; // 客户风险等级  红色/橙色/黄色/蓝色/绿色

    private String pdRiskLevel; // 产品风险等级

    private String partnerRiskLevel; // 合作方风险等级

    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date initialTraceDate; // 初始跟踪完成日期

    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date confirmTraceDate; // 确认跟踪完成日期

    private String attachedFile; // 附件

    private String recentRiskChanges; // 最近风险变化情况

    private String initialConclusions; // 初始检查结论

    private String currentConclusions; // 当前检查结论

    private String disposalTraceFeedback; // 处置跟踪反馈意见

    private String initialControlMeasures; // 初始风险管控措施

    private String currentControlMeasures; // 当前风险管控措施

    private String oneFamilyOnePolicy; // 一户一策计划

    private String isFinish; // 是否处置完成

    private String isNewDisposalTrace; // 是否产生新跟踪任务

    private String newTaskId; // 新任务ID

    private String parentTaskId; // 父任务ID

    private String warningConfirmModel; // 预警认定模式

    private String disposalTraceModel; // 处置跟踪模式

    private String signalSource; // 信号来源

    private String warningTaskKind; // 预警任务种类 01 预警任务（自动认定） 02 预警任务（非自动认定） 03 预警任务（人工信号认定） 04 签收任务

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
                ", taskNo='" + taskNo + '\'' +
                ", taskStartTime=" + taskStartTime +
                ", taskDeadline=" + taskDeadline +
                ", taskEndTime=" + taskEndTime +
                ", warningObjectId='" + warningObjectId + '\'' +
                ", warningObjectCategory='" + warningObjectCategory + '\'' +
                ", warningObjectNo='" + warningObjectNo + '\'' +
                ", warningObjectName='" + warningObjectName + '\'' +
                ", warningObjectType='" + warningObjectType + '\'' +
                ", taskStatus='" + taskStatus + '\'' +
                ", taskType='" + taskType + '\'' +
                ", taskHandler='" + taskHandler + '\'' +
                ", taskHandlePost='" + taskHandlePost + '\'' +
                ", sysRiskLevel='" + sysRiskLevel + '\'' +
                ", riskLevel='" + riskLevel + '\'' +
                ", pdRiskLevel='" + pdRiskLevel + '\'' +
                ", partnerRiskLevel='" + partnerRiskLevel + '\'' +
                ", initialTraceDate=" + initialTraceDate +
                ", confirmTraceDate=" + confirmTraceDate +
                ", attachedFile='" + attachedFile + '\'' +
                ", recentRiskChanges='" + recentRiskChanges + '\'' +
                ", initialConclusions='" + initialConclusions + '\'' +
                ", currentConclusions='" + currentConclusions + '\'' +
                ", disposalTraceFeedback='" + disposalTraceFeedback + '\'' +
                ", initialControlMeasures='" + initialControlMeasures + '\'' +
                ", currentControlMeasures='" + currentControlMeasures + '\'' +
                ", oneFamilyOnePolicy='" + oneFamilyOnePolicy + '\'' +
                ", isFinish='" + isFinish + '\'' +
                ", isNewDisposalTrace='" + isNewDisposalTrace + '\'' +
                ", newTaskId='" + newTaskId + '\'' +
                ", parentTaskId='" + parentTaskId + '\'' +
                ", warningConfirmModel='" + warningConfirmModel + '\'' +
                ", disposalTraceModel='" + disposalTraceModel + '\'' +
                ", seWfWarningObject=" + seWfWarningObject +
                ", seWfWarningSigns=" + seWfWarningSigns +
                ", seWfTaskExecuteFeedback=" + seWfTaskExecuteFeedback +
                ", seWfTaskExecuteFeedbacks=" + seWfTaskExecuteFeedbacks +
                '}';
    }


//-----------------------------------get/set----------------------------------------


    public String getWarningTaskKind() {
        return warningTaskKind;
    }

    public void setWarningTaskKind(String warningTaskKind) {
        this.warningTaskKind = warningTaskKind;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo;
    }

    public Date getTaskStartTime() {
        return taskStartTime;
    }

    public void setTaskStartTime(Date taskStartTime) {
        this.taskStartTime = taskStartTime;
    }

    public Date getTaskDeadline() {
        return taskDeadline;
    }

    public void setTaskDeadline(Date taskDeadline) {
        this.taskDeadline = taskDeadline;
    }

    public Date getTaskEndTime() {
        return taskEndTime;
    }

    public void setTaskEndTime(Date taskEndTime) {
        this.taskEndTime = taskEndTime;
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

    public String getTaskHandler() {
        return taskHandler;
    }

    public void setTaskHandler(String taskHandler) {
        this.taskHandler = taskHandler;
    }

    public String getTaskHandlePost() {
        return taskHandlePost;
    }

    public void setTaskHandlePost(String taskHandlePost) {
        this.taskHandlePost = taskHandlePost;
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

    public String getPdRiskLevel() {
        return pdRiskLevel;
    }

    public void setPdRiskLevel(String pdRiskLevel) {
        this.pdRiskLevel = pdRiskLevel;
    }

    public String getPartnerRiskLevel() {
        return partnerRiskLevel;
    }

    public void setPartnerRiskLevel(String partnerRiskLevel) {
        this.partnerRiskLevel = partnerRiskLevel;
    }

    public Date getInitialTraceDate() {
        return initialTraceDate;
    }

    public void setInitialTraceDate(Date initialTraceDate) {
        this.initialTraceDate = initialTraceDate;
    }

    public Date getConfirmTraceDate() {
        return confirmTraceDate;
    }

    public void setConfirmTraceDate(Date confirmTraceDate) {
        this.confirmTraceDate = confirmTraceDate;
    }

    public String getAttachedFile() {
        return attachedFile;
    }

    public void setAttachedFile(String attachedFile) {
        this.attachedFile = attachedFile;
    }

    public String getRecentRiskChanges() {
        return recentRiskChanges;
    }

    public void setRecentRiskChanges(String recentRiskChanges) {
        this.recentRiskChanges = recentRiskChanges;
    }

    public String getInitialConclusions() {
        return initialConclusions;
    }

    public void setInitialConclusions(String initialConclusions) {
        this.initialConclusions = initialConclusions;
    }

    public String getCurrentConclusions() {
        return currentConclusions;
    }

    public void setCurrentConclusions(String currentConclusions) {
        this.currentConclusions = currentConclusions;
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

    public String getOneFamilyOnePolicy() {
        return oneFamilyOnePolicy;
    }

    public void setOneFamilyOnePolicy(String oneFamilyOnePolicy) {
        this.oneFamilyOnePolicy = oneFamilyOnePolicy;
    }

    public String getIsFinish() {
        return isFinish;
    }

    public void setIsFinish(String isFinish) {
        this.isFinish = isFinish;
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

    public String getWarningConfirmModel() {
        return warningConfirmModel;
    }

    public void setWarningConfirmModel(String warningConfirmModel) {
        this.warningConfirmModel = warningConfirmModel;
    }

    public String getDisposalTraceModel() {
        return disposalTraceModel;
    }

    public void setDisposalTraceModel(String disposalTraceModel) {
        this.disposalTraceModel = disposalTraceModel;
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

    public String getSignalSource() {
        return signalSource;
    }

    public void setSignalSource(String signalSource) {
        this.signalSource = signalSource;
    }

    public List<SeWfTaskExecuteFeedback> getSeWfTaskExecuteFeedbacks() {
        return seWfTaskExecuteFeedbacks;
    }

    public void setSeWfTaskExecuteFeedbacks(List<SeWfTaskExecuteFeedback> seWfTaskExecuteFeedbacks) {
        this.seWfTaskExecuteFeedbacks = seWfTaskExecuteFeedbacks;
    }
}
