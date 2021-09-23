package com.skyon.common.enums;

/**
 * 系统认定风险等级
 * 未分类/红色/橙色/黄色/蓝色/绿色
 */
public enum SysRiskLevelEnum {

    UNCLASSIFIED("00","未分类"),
    RED("01","红色"),
    ORANGE("02","橙色"),
    YELLOW("03","黄色"),
    BLUE("04","蓝色"),
    GREEN("04","绿色");

    private final String code;
    private final String info;


    private SysRiskLevelEnum(String code, String info){
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
