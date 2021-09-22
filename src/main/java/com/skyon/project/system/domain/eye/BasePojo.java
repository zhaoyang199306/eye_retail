package com.skyon.project.system.domain.eye;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class BasePojo {

    private String remark; // 备注
    private String lpOrgNo; // 法人机构标识
    private String createId; // 创建人ID
    private String createName; // 创建人名称
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime; // 创建时间
    private String updateId;
    private String updateName;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    private String deleteLogo;  // 删除标识 not null

    //-----------------------------------get/set----------------------------------------


    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getLpOrgNo() {
        return lpOrgNo;
    }

    public void setLpOrgNo(String lpOrgNo) {
        this.lpOrgNo = lpOrgNo;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }

    public String getUpdateName() {
        return updateName;
    }

    public void setUpdateName(String updateName) {
        this.updateName = updateName;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDeleteLogo() {
        return deleteLogo;
    }

    public void setDeleteLogo(String deleteLogo) {
        this.deleteLogo = deleteLogo;
    }
}
