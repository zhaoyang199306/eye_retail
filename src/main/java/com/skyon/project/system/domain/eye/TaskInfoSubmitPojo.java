package com.skyon.project.system.domain.eye;

import com.skyon.project.system.domain.eye.waringSings.SeWfWarningSigns;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "预警详情提交参数",description ="预警详情提交相关参数")
public class TaskInfoSubmitPojo {


    @ApiModelProperty(name = "taskNo" , value = "任务ID(物理主键ID)", required = true)
    private String taskNo;
    @ApiModelProperty(name = "initialControlMeasures" , value = "初始风险管控措施", required = false)
    private String initialControlMeasures; //
    @ApiModelProperty(name = "currentControlMeasures" , value = "当前风险管控措施", required = true)
    private String currentControlMeasures; //
    @ApiModelProperty(name = "sysRiskLevel" , value = "系统认定客户风险等级", required = false)
    private String sysRiskLevel;
    @ApiModelProperty(name = "riskLevel" , value = "客户风险等级", required = false)
    private String riskLevel;
    @ApiModelProperty(name = "taskDeadline" , value = "要求任务完成截止日", required = false)
    private String taskDeadline;
    @ApiModelProperty(name = "initialIdentifyConclusions" , value = "初始检查结论", required = false)
    private String initialIdentifyConclusions;
    @ApiModelProperty(name = "identifyConclusions" , value = "最终认定检查结论(理由)", required = true)
    private String identifyConclusions;
    @ApiModelProperty(name = "identifyFile" , value = "附件", required = false)
    private String identifyFile;
    @ApiModelProperty(name = "warnSignalList" , value = "预警信号列表", required = false)
    private List<SeWfWarningSigns> warnSignalList;





    public String getInitialControlMeasures() {
        return initialControlMeasures;
    }

    public void setInitialControlMeasures(String initialControlMeasures) {
        this.initialControlMeasures = initialControlMeasures;
    }

    public String getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo;
    }

    public String getCurrentControlMeasures() {
        return currentControlMeasures;
    }

    public void setCurrentControlMeasures(String currentControlMeasures) {
        this.currentControlMeasures = currentControlMeasures;
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

    public String getTaskDeadline() {
        return taskDeadline;
    }

    public void setTaskDeadline(String taskDeadline) {
        this.taskDeadline = taskDeadline;
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

    public List<SeWfWarningSigns> getWarnSignalList() {
        return warnSignalList;
    }

    public void setWarnSignalList(List<SeWfWarningSigns> warnSignalList) {
        this.warnSignalList = warnSignalList;
    }
}
