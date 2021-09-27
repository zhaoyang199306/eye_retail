package com.skyon.project.system.service.wf.impl;

import com.skyon.common.enums.RoleName;
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
 *  总行风险管理部主管 审核
 */
@Service
public class Head403TaskSubmitServiceImpl extends TaskCommon implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        WfDealRoleRegisterFactory.register(RoleName.HEAD_RISK_DEPARTMENT_SUPERVISOR.getInfo(), this);
    }

    @Override
    protected Map<String, Object> assembleParam(TaskInfoSubmitPojo task, SysUser user) {
        Map<String, Object> map = new HashMap<>();
        boolean isAutomatic = true; // 非自动/自动判断
        return map;
    }
}
