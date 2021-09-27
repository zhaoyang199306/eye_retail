package com.skyon.common.enums;

/**
 * 环节流转节点备选人
 *
 */
public enum WFRole {

    WFROLE101("WF_ROLE_101","客户经理处理"),

    WFROLE201("WF_ROLE_201","支行主管处理"),

    WFROLE301("WF_ROLE_301","分行风险检测岗审核"),
    WFROLE302("WF_ROLE_302","分行检测审核岗审核"),
    WFROLE303("WF_ROLE_303","分行风险管理部主管审核"),

    WFROLEFZ301("WF_ROLE_FZ_301","福州分行风险监测岗审核"),
    WFROLEFZ302("WF_ROLE_FZ_302","福州分行监测审核岗审核"),
    WFROLEFZ303("WF_ROLE_FZ_303","福州分行风险管理部主管审核"),

    WFROLE401("WF_ROLE_401","总行风险管理部监测岗审核"),
    WFROLE402("WF_ROLE_402","总行风险管理部审核岗审核"),
    WFROLE403("WF_ROLE_403","总行风险管理部主管审核");


    private final String code;
    private final String info;


    WFRole(String code, String info) {
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
