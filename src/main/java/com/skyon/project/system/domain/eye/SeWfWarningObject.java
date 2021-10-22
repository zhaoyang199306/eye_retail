package com.skyon.project.system.domain.eye;

import io.swagger.annotations.ApiModelProperty;

/**
 * 预警对象表
 * SE_WF_WARNING_OBJECT
 */
public class SeWfWarningObject extends BasePojo{

    @ApiModelProperty(name = "warningObjectId", value = "预警对象ID(物理主键ID)", required = false)
    private  String warningObjectId;
    @ApiModelProperty(name = "warningObjectCategory", value = "预警对象类别", required = false)
    private  String warningObjectCategory;
    @ApiModelProperty(name = "warningObjectCid", value = "预警对象内码", required = false)
    private  String warningObjectCid;
    @ApiModelProperty(name = "warningObjectName", value = "预警对象名称", required = false)
    private  String warningObjectName;
    @ApiModelProperty(name = "warningObjectType", value = "监测对象类型", required = false)
    private  String warningObjectType;
    @ApiModelProperty(name = "warningObjectSort", value = "监测对象管辖类别", required = false)
    private  String warningObjectSort;
    @ApiModelProperty(name = "riskLevel", value = "客户风险等级", required = false)
    private  String riskLevel;
    @ApiModelProperty(name = "riskHighLevel", value = "客户历史最高风险等级", required = false)
    private  String riskHighLevel;
    @ApiModelProperty(name = "riskIdentify", value = "主体风险认定情况", required = false)
    private  String riskIdentify;
    @ApiModelProperty(name = "execuMgrNo", value = "管户客户经理编号", required = false)
    private  String execuMgrNo;
    @ApiModelProperty(name = "execuOrgNo", value = "管户机构编号", required = false)
    private  String execuOrgNo;
    @ApiModelProperty(name = "adminSubbranchNo", value = "所属支行编号", required = false)
    private  String adminSubbranchNo;
    @ApiModelProperty(name = "adminBranchNo", value = "所属分行编号", required = false)
    private  String adminBranchNo;
    @ApiModelProperty(name = "businessOrgNo", value = "业务责任机构编号", required = false)
    private  String businessOrgNo;
    @ApiModelProperty(name = "relWarningObjectId", value = "关联预警对象ID", required = false)
    private  String relWarningObjectId;


    //-----------------------------------toString----------------------------------------

    @Override
    public String toString() {
        return "SeWfWarningObject{" +
                "warningObjectId='" + warningObjectId + '\'' +
                ", warningObjectCategory='" + warningObjectCategory + '\'' +
                ", warningObjectCid='" + warningObjectCid + '\'' +
                ", warningObjectName='" + warningObjectName + '\'' +
                ", warningObjectType='" + warningObjectType + '\'' +
                ", warningObjectSort='" + warningObjectSort + '\'' +
                ", riskLevel='" + riskLevel + '\'' +
                ", riskHighLevel='" + riskHighLevel + '\'' +
                ", riskIdentify='" + riskIdentify + '\'' +
                ", execuMgrNo='" + execuMgrNo + '\'' +
                ", execuOrgNo='" + execuOrgNo + '\'' +
                ", adminSubbranchNo='" + adminSubbranchNo + '\'' +
                ", adminBranchNo='" + adminBranchNo + '\'' +
                ", businessOrgNo='" + businessOrgNo + '\'' +
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

    public String getWarningObjectSort() {
        return warningObjectSort;
    }

    public void setWarningObjectSort(String warningObjectSort) {
        this.warningObjectSort = warningObjectSort;
    }

    public String getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(String riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getRiskHighLevel() {
        return riskHighLevel;
    }

    public void setRiskHighLevel(String riskHighLevel) {
        this.riskHighLevel = riskHighLevel;
    }

    public String getRiskIdentify() {
        return riskIdentify;
    }

    public void setRiskIdentify(String riskIdentify) {
        this.riskIdentify = riskIdentify;
    }

    public String getExecuMgrNo() {
        return execuMgrNo;
    }

    public void setExecuMgrNo(String execuMgrNo) {
        this.execuMgrNo = execuMgrNo;
    }

    public String getExecuOrgNo() {
        return execuOrgNo;
    }

    public void setExecuOrgNo(String execuOrgNo) {
        this.execuOrgNo = execuOrgNo;
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

    public String getBusinessOrgNo() {
        return businessOrgNo;
    }

    public void setBusinessOrgNo(String businessOrgNo) {
        this.businessOrgNo = businessOrgNo;
    }

    public String getRelWarningObjectId() {
        return relWarningObjectId;
    }

    public void setRelWarningObjectId(String relWarningObjectId) {
        this.relWarningObjectId = relWarningObjectId;
    }
}
