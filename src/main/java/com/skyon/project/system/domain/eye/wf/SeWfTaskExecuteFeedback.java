package com.skyon.project.system.domain.eye.wf;

import com.skyon.project.system.domain.eye.BasePojo;

/**
 * 任务执行反馈表单
 * SE_WF_TASK_EXECUTE_FEEDBACK
 */
public class SeWfTaskExecuteFeedback extends BasePojo {

    private String taskExecuteId; // not null  任务执行ID

    private String taskId;  // not null  任务ID

    private String taskType; // 执行任务  预警认定/处置跟踪

    private String riskLevel; // 客户风险等级 红色/橙色/黄色/蓝色/绿色

    private String pdRiskLevel; // 产品风险等级 高风险/低风险 ---\\零售

    private String partnerRiskLevel; // 合作方风险等级

    private String attachedFile; // 附件

    private String currentRiskChanges; // 本次风险变化情况

    private String currentConclusions; // 本次检查结论

    private String currentFeedback; // 本次反馈意见

    private String currentControlMeasures; // 本次风险管控措施

    private String otherControlMeasures; //

    private String oneFamilyOnePolicy; // 一户一策计划

    private String isFinish; // 是否处置完成  处置完成，状态转“已归档”

    private String taskHandler; // 当前处理人

    private String taskHandlePost; // 当前处理岗

    //-----------------------------------toString----------------------------------------

    @Override
    public String toString() {
        return "SeWfTaskExecuteFeedback{" +
                "taskExecuteId='" + taskExecuteId + '\'' +
                ", taskId='" + taskId + '\'' +
                ", taskType='" + taskType + '\'' +
                ", riskLevel='" + riskLevel + '\'' +
                ", pdRiskLevel='" + pdRiskLevel + '\'' +
                ", partnerRiskLevel='" + partnerRiskLevel + '\'' +
                ", attachedFile='" + attachedFile + '\'' +
                ", currentRiskChanges='" + currentRiskChanges + '\'' +
                ", currentConclusions='" + currentConclusions + '\'' +
                ", currentFeedback='" + currentFeedback + '\'' +
                ", currentControlMeasures='" + currentControlMeasures + '\'' +
                ", otherControlMeasures='" + otherControlMeasures + '\'' +
                ", oneFamilyOnePolicy='" + oneFamilyOnePolicy + '\'' +
                ", isFinish='" + isFinish + '\'' +
                ", taskHandler='" + taskHandler + '\'' +
                ", taskHandlePost='" + taskHandlePost + '\'' +
                '}';
    }


    //-----------------------------------get/set----------------------------------------


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

    public String getTaskExecuteId() {
        return taskExecuteId;
    }

    public void setTaskExecuteId(String taskExecuteId) {
        this.taskExecuteId = taskExecuteId;
    }



    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
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

    public String getAttachedFile() {
        return attachedFile;
    }

    public void setAttachedFile(String attachedFile) {
        this.attachedFile = attachedFile;
    }

    public String getCurrentRiskChanges() {
        return currentRiskChanges;
    }

    public void setCurrentRiskChanges(String currentRiskChanges) {
        this.currentRiskChanges = currentRiskChanges;
    }

    public String getCurrentConclusions() {
        return currentConclusions;
    }

    public void setCurrentConclusions(String currentConclusions) {
        this.currentConclusions = currentConclusions;
    }

    public String getCurrentFeedback() {
        return currentFeedback;
    }

    public void setCurrentFeedback(String currentFeedback) {
        this.currentFeedback = currentFeedback;
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

    public String getIsFinish() {
        return isFinish;
    }

    public void setIsFinish(String isFinish) {
        this.isFinish = isFinish;
    }
}
