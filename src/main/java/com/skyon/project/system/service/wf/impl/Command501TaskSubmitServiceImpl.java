package com.skyon.project.system.service.wf.impl;

import com.skyon.common.enums.RoleName;
import com.skyon.common.enums.WFRole;
import com.skyon.framework.manager.factory.WfDealRoleRegisterFactory;
import com.skyon.project.system.domain.eye.SeWfTaskInfo;
import com.skyon.project.system.domain.sys.SysUser;
import com.skyon.project.system.service.wf.TaskCommon;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 指挥部风险监测岗 审核
 */
@Service
public class Command501TaskSubmitServiceImpl extends TaskCommon implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        WfDealRoleRegisterFactory.register(RoleName.HEADQUARTERS_RISK_MONITORING_POST.getInfo(), this);
    }

    @Override
    protected Map<String, Object> assembleParam(SeWfTaskInfo seWfTaskInfo, SysUser user) {
        Map<String, Object> map = new HashMap<>();
        // 执行指挥部风险审核
        map.put(WFRole.WFROLE502.getCode(), "75"); // 下个任务   组ID
        return map;
    }
}
