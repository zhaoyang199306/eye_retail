package com.skyon.project.system.domain.eye;

/**
 * 预警对象表
 * SE_WF_WARNING_OBJECT
 */
public class SeWfWarningObject extends BasePojo{

    private String warningObjectId; //  not null 预警对象ID

    // 自营个人、自营小微、非自营零售户、合作方、非同业主体、同业主体、资产、投组、产品
    private String warningObjectCategory; // not null 预警对象类别

    private String warningObjectCid; // not null 预警对象内码

    private String warningObjectName; // 预警对象名称

    private String warningObjectType; // 监测对象类型

    // 预警对象标签：例如（发债、上市、黑名单、灰名单...）,待确认标签范围
    private String warningObjectLabel; // 预警对象标签

    private String currentRiskLevel; // 当前风险等级 未分类/红色/橙色/黄色/蓝色/绿色

    private String pdRiskLevel; // 产品风险等级  未分类/有风险/无风险 ---\\零售&同业

    private String partnerRiskLevel; // 合作方风险等级  未分类/高风险/低风险 ---\\零售

    private String execuCustMgr;  // 管户客户经理

    private String execuOrg; // 管户机构

    private String adSubBra; // 所属支行

    private String adBra; // 所属分行

    private String businessOrg; // 业务责任机构

    private String relWarningObjectId; // 关联预警对象ID

    //-----------------------------------toString----------------------------------------


    @Override
    public String toString() {
        return "SeWfWarningObject{" +
                "warningObjectId='" + warningObjectId + '\'' +
                ", warningObjectCategory='" + warningObjectCategory + '\'' +
                ", warningObjectCid='" + warningObjectCid + '\'' +
                ", warningObjectName='" + warningObjectName + '\'' +
                ", warningObjectType='" + warningObjectType + '\'' +
                ", warningObjectLabel='" + warningObjectLabel + '\'' +
                ", currentRiskLevel='" + currentRiskLevel + '\'' +
                ", pdRiskLevel='" + pdRiskLevel + '\'' +
                ", partnerRiskLevel='" + partnerRiskLevel + '\'' +
                ", execuCustMgr='" + execuCustMgr + '\'' +
                ", execuOrg='" + execuOrg + '\'' +
                ", adSubBra='" + adSubBra + '\'' +
                ", adBra='" + adBra + '\'' +
                ", businessOrg='" + businessOrg + '\'' +
                ", relWarningObjectId='" + relWarningObjectId + '\'' +
                '}';
    }

    //-----------------------------------get/set----------------------------------------


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

    public String getWarningObjectCid() {
        return warningObjectCid;
    }

    public void setWarningObjectCid(String warningObjectCid) {
        this.warningObjectCid = warningObjectCid;
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

    public String getWarningObjectLabel() {
        return warningObjectLabel;
    }

    public void setWarningObjectLabel(String warningObjectLabel) {
        this.warningObjectLabel = warningObjectLabel;
    }

    public String getCurrentRiskLevel() {
        return currentRiskLevel;
    }

    public void setCurrentRiskLevel(String currentRiskLevel) {
        this.currentRiskLevel = currentRiskLevel;
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

    public String getExecuCustMgr() {
        return execuCustMgr;
    }

    public void setExecuCustMgr(String execuCustMgr) {
        this.execuCustMgr = execuCustMgr;
    }

    public String getExecuOrg() {
        return execuOrg;
    }

    public void setExecuOrg(String execuOrg) {
        this.execuOrg = execuOrg;
    }

    public String getAdSubBra() {
        return adSubBra;
    }

    public void setAdSubBra(String adSubBra) {
        this.adSubBra = adSubBra;
    }

    public String getAdBra() {
        return adBra;
    }

    public void setAdBra(String adBra) {
        this.adBra = adBra;
    }

    public String getBusinessOrg() {
        return businessOrg;
    }

    public void setBusinessOrg(String businessOrg) {
        this.businessOrg = businessOrg;
    }

    public String getRelWarningObjectId() {
        return relWarningObjectId;
    }

    public void setRelWarningObjectId(String relWarningObjectId) {
        this.relWarningObjectId = relWarningObjectId;
    }
}
