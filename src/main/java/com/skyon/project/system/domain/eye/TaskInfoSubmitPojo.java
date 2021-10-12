package com.skyon.project.system.domain.eye;

import com.skyon.project.system.domain.eye.waringSings.SeWfWarningSigns;

import java.util.List;

public class TaskInfoSubmitPojo {

    public TaskInfoSubmitPojo() {
    }

    private String taskInfoNo;
    private String riskControlMeasures; // 风险管控措施
    private String radio;
    private String examinValue;
    private String personalRiskLevel;
    private String checkResult;
    private String devolutionDate;

    private List<SeWfWarningSigns> warnSignalList;

    public String getTaskInfoNo() {
        return taskInfoNo;
    }

    public void setTaskInfoNo(String taskInfoNo) {
        this.taskInfoNo = taskInfoNo;
    }

    public Object getRiskControlMeasures() {
        return riskControlMeasures;
    }

    public void setRiskControlMeasures(String riskControlMeasures) {
        this.riskControlMeasures = riskControlMeasures;
    }

    public String getRadio() {
        return radio;
    }

    public void setRadio(String radio) {
        this.radio = radio;
    }

    public String getExaminValue() {
        return examinValue;
    }

    public void setExaminValue(String examinValue) {
        this.examinValue = examinValue;
    }

    public String getPersonalRiskLevel() {
        return personalRiskLevel;
    }

    public void setPersonalRiskLevel(String personalRiskLevel) {
        this.personalRiskLevel = personalRiskLevel;
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    public List<SeWfWarningSigns> getWarnSignalList() {
        return warnSignalList;
    }

    public void setWarnSignalList(List<SeWfWarningSigns> warnSignalList) {
        this.warnSignalList = warnSignalList;
    }

    public String getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(String devolutionDate) {
        this.devolutionDate = devolutionDate;
    }
}
