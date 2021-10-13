package com.skyon.common.enums;

/**
 * 预警任务种类
 * 01 预警任务（自动认定） 02 预警任务（非自动认定） 03 预警任务（人工信号认定） 04 签收任务
 */
public enum WarningTaskKindEnum {

    Automatic("01","自动认定"),
    NoAutomatic("02","非自动认定"),
    Artificial("03","人工信号认定"),
    sign("04","签收任务");

    private final String code;
    private final String info;

    WarningTaskKindEnum(String code, String info) {
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
