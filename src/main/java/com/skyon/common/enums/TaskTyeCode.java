package com.skyon.common.enums;

/**
 * 任务类型
 *
 * @author xinglj
 */
public enum TaskTyeCode {
    SING_TASK("01", "签收任务"),
    PRE_TASK("02", "预定任务"),
    DISPOSAL_TRACK("03", "处置跟踪"),
    SIGNAL_OBJECTION("04", "信号异议"),
    RISK_OBJECTION("05", "风险异议"),
    PARTNER_FEEDBACK_PROCESS("06", "合作方反馈处理");

    private final String code;
    private final String info;

    TaskTyeCode(String code, String info) {
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
