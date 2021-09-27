package com.skyon.project.system.service.wf.impl;

import com.skyon.common.enums.RoleName;
import com.skyon.common.enums.WFRole;
import com.skyon.common.utils.ServletUtils;
import com.skyon.framework.manager.factory.WfDealRoleRegisterFactory;
import com.skyon.project.system.domain.eye.TaskInfoSubmitPojo;
import com.skyon.project.system.domain.sys.SysUser;
import com.skyon.project.system.service.activiti.TaskWFService;
import com.skyon.project.system.service.eye.WLinkLogService;
import com.skyon.project.system.service.wf.TaskCommon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 福州分行风险监测岗 审核
 */
@Service
public class FZBranch301TaskSubmitServiceImpl extends TaskCommon implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        WfDealRoleRegisterFactory.register(RoleName.FZ_BRANCH_RISK_MONITORING_POST.getInfo(), this);
    }

    @Override
    protected Map<String, Object> assembleParam(TaskInfoSubmitPojo task, SysUser user) {
        Map<String, Object> map = new HashMap<>();
        // 福州分行等闲监测岗
        map.put(WFRole.WFROLEFZ302.getCode(), "58"); // 下个任务  福州分行监测审核岗 组ID
        return map;
    }
}
