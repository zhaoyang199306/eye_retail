package com.skyon.common.enums;

/**
 * 预警对象类别枚举类
 *
 * @author xinglj
 */
public enum WarningObjectCategory {
    PUBLIC("01", "对公客户"),
    PEERS("02", "同业主体"),
    PRIVATE("03", "个人客户"),
    SMALLPUBLIC("04", "小微客户"),
    PARTNER("05", "合作方"),
    CASTGROUP("06", "投组"),
    BOND("07", "债券"),
    PRODUCTION("08", "零售产品"),
    NSO_PRIVATE("09", "非自营零售客户"),//Non self operated,

    NOPEERS("10", "非同业主体"),
    ASSETS("11", "资产");

    private final String code;
    private final String info;

    WarningObjectCategory(String code, String info) {
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
