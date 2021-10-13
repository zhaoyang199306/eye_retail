package com.skyon.project.system.service.wf;

import com.skyon.common.enums.SignalCreateModelEnum;
import com.skyon.common.enums.SysRiskLevelEnum;
import com.skyon.common.enums.WarningTaskKindEnum;
import com.skyon.common.utils.StringUtils;
import com.skyon.project.system.domain.eye.SeWfTaskInfo;
import com.skyon.project.system.domain.eye.waringSings.SeWfWarningSigns;
import org.junit.Test;

/**
 * 流程环节控制的各种标志 类
 */
public class WFTaskFlagHandle {

    private SeWfTaskInfo seWfTaskInfo;


    public WFTaskFlagHandle() {
    }

    public WFTaskFlagHandle(SeWfTaskInfo seWfTaskInfo) {
        this.seWfTaskInfo = seWfTaskInfo;
    }

    // ----------------------------------------------基本标志------------------------------------

    // 是否人工信号录入  是返回1  否则 0
    public String isHandMade() {
        if (seWfTaskInfo.getSeWfWarningSigns().size() == 0) {
            throw new RuntimeException("该任务没有任何预警信号！" + seWfTaskInfo.getTaskNo());
        }
        // 判断录入方式都是一样的
        for (int i = 0; i < seWfTaskInfo.getSeWfWarningSigns().size(); i++) {

        }

        if (StringUtils.isEmpty(seWfTaskInfo.getSeWfWarningSigns().get(0).getSignalCreateModel())) {
            throw new RuntimeException("该任务的录入方式为空！" + seWfTaskInfo.getTaskNo());
        }
        return SignalCreateModelEnum.HANDMADE.getKey().
                equals(seWfTaskInfo.getSeWfWarningSigns().get(0).getSignalCreateModel()) ? "1" : "0";
    }

    // 是否系统自动认定风险等级  是 返回1
    public String isSysRiskLevel() {
        if (StringUtils.isEmpty(seWfTaskInfo.getSysRiskLevel())) {
            throw new RuntimeException("该任务的系统自定义风险等级为空！" + seWfTaskInfo.getTaskNo());
        }
        return !SysRiskLevelEnum.UNCLASSIFIED.getCode().equals(seWfTaskInfo.getSysRiskLevel()) ? "1" : "0";
    }

    // 是否蓝色及以下风险  是 返回1
    public String isDownBlue() {
        return (SysRiskLevelEnum.BLUE.getCode().equals(seWfTaskInfo.getSysRiskLevel()) ||
                SysRiskLevelEnum.GREEN.getCode().equals(seWfTaskInfo.getSysRiskLevel())) ? "1" : "0";
    }

    // 是否黄色及以上风险  是 返回1
    public String isUpYellow() {
        return (SysRiskLevelEnum.RED.getCode().equals(seWfTaskInfo.getSysRiskLevel()) ||
                SysRiskLevelEnum.ORANGE.getCode().equals(seWfTaskInfo.getSysRiskLevel()) ||
                SysRiskLevelEnum.YELLOW.getCode().equals(seWfTaskInfo.getSysRiskLevel())) ? "1" : "0";
    }

    // 是否灰名单  是 返回1
    public String isGreyList() {
        return "0";
    }

    // 判断客户是否为风险客户 是返回1
    public String isRiskCustomer() {
        return "0";
    }

    // 信号风险等级是否高于原风险等级 是 返回 1
    public String isRiskLEvelHighOld() {
        return "0";
    }

    // 客户经理判断是否属实  是 返回 1
    public String singsIsTrueByManager() {
        for (SeWfWarningSigns seWfWarningSign : seWfTaskInfo.getSeWfWarningSigns()) {
            if ("02".equals(seWfWarningSign.getConfirmStatus()))
                return "0"; // 只要有一个是不属实就返回0;
        }
        return "1";
    }

    // 判断是否全部不属实  是 返回 1
    public String singsIsAllNotTrueByManager() {
        for (SeWfWarningSigns seWfWarningSign : seWfTaskInfo.getSeWfWarningSigns()) {
            if ("01".equals(seWfWarningSign.getConfirmStatus()))
                return "0";
        }
        return "1";
    }

    // 是否需要主管审核  是 返回1
    public String isSupervisor() {
        return "0";
    }

    // 是否属于福州支行
    public String isFuZhou() {
        return "0";
    }

    // 是否属于总行权限
    public String isHead() {
        return "0";
    }

    // 风险认定结果判断 是否黄色及以上
    public String resultIsUpYellow() {
        return (SysRiskLevelEnum.RED.getCode().equals(seWfTaskInfo.getRiskLevel()) ||
                SysRiskLevelEnum.ORANGE.getCode().equals(seWfTaskInfo.getRiskLevel()) ||
                SysRiskLevelEnum.YELLOW.getCode().equals(seWfTaskInfo.getRiskLevel())) ? "1" : "0";
    }

    // 风险认定结果判断 是否蓝色及以下
    public String resultIsDownBlue() {
        return (SysRiskLevelEnum.BLUE.getCode().equals(seWfTaskInfo.getRiskLevel()) ||
                SysRiskLevelEnum.GREEN.getCode().equals(seWfTaskInfo.getRiskLevel())) ? "1" : "0";
    }

    // 是否制定一户一策计划
    public String isYCYHPlan() {
        return StringUtils.isNotEmpty(seWfTaskInfo.getSeWfTaskExecuteFeedback().getOneFamilyOnePolicy()) ? "1" : "0";
    }

    // 是否签收任务
    public boolean isSignTask() {
        return WarningTaskKindEnum.sign.getCode().equals(seWfTaskInfo.getWarningTaskKind());

    }

    // 是否自定认定  是返回true
    public String isAutomatic() {
        return WarningTaskKindEnum.Automatic.getCode().equals(seWfTaskInfo.getWarningTaskKind()) ? "1" : "0";
    }


    //----------------------------------------------加工标志------------------------------------

    // 判断是否签收
//    public boolean isSignTask(){
//        if (this.isHandMade()){ // 是人工信号
//            if(this.isSysRiskLevel()){ // 是系统自动认定风险等级
//                if(this.isDownBlue()){ // 是蓝色及以下风险
//                    return true;
//                } else if (this.isUpYellow()){ // 是黄色及以上
//                    if(this.isGreyList()){ // 是灰名单
//                        return true;
//                    } else {
//                        if (this.isRiskCustomer()){ // 是风险客户
//                            if (!this.isRiskLEvelHighOld()){ // 信号风险等级 没有 高于原风险等级
//                                return true;
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return false;
//    }


}
