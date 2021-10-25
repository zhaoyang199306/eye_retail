package com.skyon.project.system.service.wf.impl;

import com.skyon.common.enums.RoleName;
import com.skyon.common.enums.WfCode;
import com.skyon.framework.manager.factory.WfDealRoleRegisterFactory;
import com.skyon.project.system.domain.sys.SysUser;
import com.skyon.project.system.service.wf.TaskCommon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 二级分行风险监测岗（零售）审核
 * 任务的流转 -- 提交
 */
@Service
public class WF034_1SubmitServiceImpl extends TaskCommon implements InitializingBean {

    private static final Logger logger = LoggerFactory.getLogger(WF034_1SubmitServiceImpl.class);

    /**
     * Bean 初始化时，把该Bean注册进   流程的工厂类 - WfDealRoleRegisterFactory
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        WfDealRoleRegisterFactory.register(RoleName.WF_ROLE_034.getCode() + "_1", this);
    }

    /**
     * 二级分行风险监测岗（零售）审核
     *
     * @param taskNo           任务编号
     * @param code             流程启动编号
     * @param user             用户信息
     * @param processCondition 流程码值
     * @return
     */
    @Override
    protected Map<String, Object> assembleParam(String taskNo, WfCode code, SysUser user, String processCondition) {
        Map<String, Object> map = new HashMap<>();
        map.put(RoleName.WF_ROLE_034.getInfo(), user.getUserId()); // 二级分行风险监测岗(零售)

        if (code == WfCode.WF1101) {

        } else if (code == WfCode.WF2101) { // 预警任务审核流程-自营业务
            map.put(RoleName.WF_ROLE_044.getInfo(), RoleName.WF_ROLE_044.getCode()); // 一级分行检测审核岗（零售）审核
        }

        return map;
    }

}
