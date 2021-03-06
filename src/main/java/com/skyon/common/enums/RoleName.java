package com.skyon.common.enums;

/**
 * 角色枚举
 */
public enum RoleName {

    /**
     * 总行行领导
     */
    WF_ROLE_166("76","WF_ROLE_163"),
    /**
     * 分行分管风险行领导
     */
    WF_ROLE_165("112","WF_ROLE_162"),

    /**
     * 总行风险管理部审核岗(公司)
     */
    WF_ROLE_161("80", "WF_ROLE_161"),
    /**
     * 总行风险管理部审核岗(金融市场)
     */
    WF_ROLE_162("81", "WF_ROLE_162"),
    /**
     * 总行风险管理部审核岗(投行资管)
     */
    WF_ROLE_163("82", "WF_ROLE_163"),
    /**
     *总行风险管理部审核岗(零售)
     */
    WF_ROLE_164("83", "WF_ROLE_164"),
    /**
     *总行风险管理部复核岗(公司)
     */
    WF_ROLE_151("84", "WF_ROLE_151"),
    /**
     *总行风险管理部复核岗(金融市场)
     */
    WF_ROLE_152("85", "WF_ROLE_152"),
    /**
     *总行风险管理部复核岗(投行资管)
     */
    WF_ROLE_153("86", "WF_ROLE_153"),
    /**
     *总行风险管理部复核岗(零售)
     */
    WF_ROLE_154("87", "WF_ROLE_154"),
    /**
     *总行风险管理部监测岗(公司)
     */
    WF_ROLE_141("88", "WF_ROLE_141"),
    /**
     *总行风险管理部监测岗(金融市场)
     */
    WF_ROLE_142("89", "WF_ROLE_142"),
    /**
     *总行风险管理部监测岗(投行资管)
     */
    WF_ROLE_143("90", "WF_ROLE_143"),
    /**
     *总行风险管理部监测岗(零售)
     */
    WF_ROLE_144("91", "WF_ROLE_144"),

    WF_ROLE_131("92", "WF_ROLE_131"), // 总行监测主管(公司)
    WF_ROLE_132("93", "WF_ROLE_132"), // 总行监测主管(金融市场)
    WF_ROLE_133("94", "WF_ROLE_133"), // 总行监测主管(投行资管)
    WF_ROLE_134("95", "WF_ROLE_134"), // 总行监测主管(零售)

    WF_ROLE_121("96", "WF_ROLE_121"), // 总行监测审核岗(公司)
    WF_ROLE_122("97", "WF_ROLE_122"), // 总行监测审核岗(金融市场部)
    WF_ROLE_123("98", "WF_ROLE_123"), // 总行监测审核岗(投行资管部)
    WF_ROLE_124("99", "WF_ROLE_124"), // 总行监测审核岗(合作方)

    //------------------------------------------------------------------------------
    WF_ROLE_111("100", "WF_ROLE_111"), // 总行风险监测岗(公司)
    WF_ROLE_112("101", "WF_ROLE_112"), // 总行风险监测岗(金融市场部)
    WF_ROLE_113("102", "WF_ROLE_113"), // 总行风险监测岗(投行资管部)
    WF_ROLE_114("103", "WF_ROLE_114"), // 总行风险监测岗(合作方)

    //------------------------------------------------------------------------------
    WF_ROLE_101("104", "WF_ROLE_101"), // 总行业务部门监测主管(金融市场部)
    WF_ROLE_102("105", "WF_ROLE_102"), // 总行业务部门监测主管(投行资管部)

    WF_ROLE_091("106", "WF_ROLE_091"), // 总行业务部门监测审核岗(金融市场部)
    WF_ROLE_092("107", "WF_ROLE_092"), // 总行业务部门监测审核岗(投行资管部)

    WF_ROLE_081("108", "WF_ROLE_081"), // 总行业务部门风险监测岗(金融市场部)
    WF_ROLE_082("109", "WF_ROLE_082"), // 总行业务部门风险监测岗(投行资管部)
    //------------------------------------------------------------------------------

    WF_ROLE_071("110", "WF_ROLE_071"), // 风险审核岗(零售)
    WF_ROLE_061("111", "WF_ROLE_061"), // 风险监测岗(零售)
    WF_ROLE_060("112", "WF_ROLE_060"), // 分行分管风险行领导

    WF_ROLE_051("113", "WF_ROLE_051"), // 分行监测主管(公司)
    WF_ROLE_052("114", "WF_ROLE_052"), // 分行监测主管(金融市场部)
    WF_ROLE_053("115", "WF_ROLE_053"), // 分行监测主管(投行资管部)
    WF_ROLE_054("116", "WF_ROLE_054"), // 分行监测主管(零售)

    WF_ROLE_041("117", "WF_ROLE_041"), // 分行监测审核岗(公司)
    WF_ROLE_042("118", "WF_ROLE_042"), // 分行监测审核岗(金融市场部)
    WF_ROLE_043("119", "WF_ROLE_043"), // 分行监测审核岗(投行资管部)
    WF_ROLE_044("120", "WF_ROLE_044"), // 分行监测审核岗(零售)
    WF_ROLE_045("121", "WF_ROLE_045"), // 分行监测审核岗(合作方)

    WF_ROLE_031("122", "WF_ROLE_031"), // 分行风险监测岗(公司)
    WF_ROLE_032("123", "WF_ROLE_032"), // 分行风险监测岗(金融市场部)
    WF_ROLE_033("124", "WF_ROLE_033"), // 分行风险监测岗(投行资管部)
    WF_ROLE_034("125", "WF_ROLE_034"), // 分行风险监测岗(零售)
    WF_ROLE_035("126", "WF_ROLE_035"), // 分行风险监测岗(合作方)

    //------------------------------------------------------------------------------
    WF_ROLE_021("127", "WF_ROLE_021"), // 支行(部门)主管
    //------------------------------------------------------------------------------
    WF_ROLE_011("128", "WF_ROLE_011"); // 客户经理



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
