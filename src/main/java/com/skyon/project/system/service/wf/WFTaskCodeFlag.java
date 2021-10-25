package com.skyon.project.system.service.wf;

/**
 * 环节流转的标识类
 *
 */
public class WFTaskCodeFlag {

    /**
     *  福州行审批
     * @param processCondition
     * @return 1是  0否
     */
    public static String code01(String processCondition){
        return processCondition.substring(0,1);
    }

    /**
     *  总行审批权限
     * @param processCondition
     * @return 1是  0否
     */
    public static String code02(String processCondition){
        return processCondition.substring(1,2);
    }

    /**
     *  分行监测主管（零售）审核
     * @param processCondition
     * @return 1是  0否
     */
    public static String code04(String processCondition){
        return processCondition.substring(3,4);
    }

    /**
     *  二级分行分管风险行领导审核
     * @param processCondition
     * @return 1是  0否
     */
    public static String code08(String processCondition){
        return processCondition.substring(7,8);
    }

    /**
     *  一级分行分管风险行领导审核
     * @param processCondition
     * @return 1是  0否
     */
    public static String code09(String processCondition){
        return processCondition.substring(8,9);
    }






}
