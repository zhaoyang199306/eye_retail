package com.skyon.common.enums;

/**
 * 任务处理角色名
 *
 * 总行风险管理部监测岗
 * 总行风险管理部审核岗
 * 总行风险管理部主管
 *
 * 总分行普惠金融中心查询岗
 * 总行零售预警查询岗
 *
 * 总行领导
 *
 * 总行用户管理员
 * 分行用户管理员
 * 超级管理员
 * 规则开发岗
 * 名单录入岗
 * 名单审核岗
 * 信号筛查岗
 */
public enum RoleName {

    ACCOUNT_MANAGER("01","客户经理"),

    SUB_BRANCH_SUPERVISOR("02","支行主管"),

    BRANCH_RISK_MONITORING_POST ("03","分行风险监测岗"),
    BRANCH_MONITORING_AUDIT_POST("04","分行监测审核岗"),
    BRANCH_RISK_DEPARTMENT_SUPERVISOR("05","分行风险管理部主管"),

    FZ_BRANCH_RISK_MONITORING_POST ("06","福州分行风险监测岗"),
    FZ_BRANCH_MONITORING_AUDIT_POST("07","福州分行监测审核岗"),
    FZ_BRANCH_RISK_DEPARTMENT_SUPERVISOR("08","福州分行风险管理部主管"),

    HEAD_RISK_MONITORING_POST ("09","总行风险监测岗"),
    HEAD_MONITORING_AUDIT_POST("10","总行监测审核岗"),
    HEAD_RISK_DEPARTMENT_SUPERVISOR("11","总行风险管理部主管"),

    HEADQUARTERS_RISK_MONITORING_POST("12","指挥部风险监测岗"),
    HEADQUARTERS_RISK_REVIEW_POST("13","指挥部风险审核岗");



    private final String code;
    private final String info;


    private RoleName(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public String getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }
}
