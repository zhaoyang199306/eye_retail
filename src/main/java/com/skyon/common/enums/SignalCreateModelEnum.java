package com.skyon.common.enums;

/**
 * 信号生成方式枚举
 */
public enum SignalCreateModelEnum {

    HANDMADE("01","人工录入"),
    SYSMADE("02","系统生成");

    SignalCreateModelEnum(String key, String info) {
        this.key = key;
        this.info = info;
    }

    private final String key;
    private final String info;

    public String getKey() {
        return key;
    }

    public String getInfo() {
        return info;
    }
}
