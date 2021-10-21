package com.skyon.project.system.domain.vo;

import java.util.List;

import com.skyon.framework.web.domain.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.omg.CORBA.Request;

@ApiModel(value = "预警页面请求信息",description ="预警页面请求信息查询")
public class WarningTaskListVo extends BaseEntity {

    @ApiModelProperty(value = "经办人", name = "taskHandler", required = false)
    private String taskHandler;

    @ApiModelProperty(value = "查询任务", name = "taskNo", required = false)
    private String taskNo;

    @ApiModelProperty(value = "带查询任务（后端使用）", name = "taskNoList", required = false)
    private List<String> taskNoList;

    @ApiModelProperty(value = "模糊查询参数", name = "warningObjectLikeParam", required = false)
    private String  warningObjectLikeParam;

    @ApiModelProperty(value = "预警对象名称", name = "warningObjectLikeParam", required = false)
    private String warningObjectName;

    @ApiModelProperty(value = "预警对象编号", name = "warningObjectId", required = false)
    private String warningObjectId;

    @ApiModelProperty(value = "管护人", name = "adBra", required = false)
    private String adBra;

    @ApiModelProperty(value = "管护机构", name = "adSubBra", required = false)
    private String adSubBra;

    @ApiModelProperty(value = "任务类型", name = "taskType", required = false)
    private String taskType;

    @ApiModelProperty(value = "任务状态", name = "taskStatus", required = false)
    private String taskStatus;

    public String getWarningObjectLikeParam() {
        return warningObjectLikeParam;
    }

    public void setWarningObjectLikeParam(String warningObjectLikeParam) {
        this.warningObjectLikeParam = warningObjectLikeParam;
    }

    public String getTaskHandler() {
        return taskHandler;
    }

    public void setTaskHandler(String taskHandler) {
        this.taskHandler = taskHandler;
    }

    public String getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo;
    }

    public String getWarningObjectName() {
        return warningObjectName;
    }

    public void setWarningObjectName(String warningObjectName) {
        this.warningObjectName = warningObjectName;
    }

    public String getWarningObjectId() {
        return warningObjectId;
    }

    public void setWarningObjectId(String warningObjectId) {
        this.warningObjectId = warningObjectId;
    }

    public String getAdBra() {
        return adBra;
    }

    public void setAdBra(String adBra) {
        this.adBra = adBra;
    }

    public String getAdSubBra() {
        return adSubBra;
    }

    public void setAdSubBra(String adSubBra) {
        this.adSubBra = adSubBra;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

	public List<String> getTaskNoList() {
		return taskNoList;
	}

	public void setTaskNoList(List<String> taskNoList) {
		this.taskNoList = taskNoList;
	}
}
