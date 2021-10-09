package com.skyon.common.enums;

/**
 * 同业角色，同业环境候选人
 *
 */
public enum PeersRole {

	SubBranchSupervisor("WF_ROLE_201","支行主管"),

    BranchDetector("WF_ROLE_301","分行风险检测岗"),
    BranchAuditor("WF_ROLE_302","分行检测审核岗"),
    BranchSupervisor("WF_ROLE_303","分行风险管理部主管"),

    HeadDetector("WF_ROLE_401","总行风险管理部监测岗"),
    HeadAuditor("WF_ROLE_402","总行风险管理部审核岗"),
    HeadSupervisor("WF_ROLE_403","总行风险管理部主管");


    private final String code;
    private final String info;


    PeersRole(String code, String info) {
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
