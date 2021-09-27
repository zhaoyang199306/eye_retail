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
 * 分行风险管理部主管 审核
 */
@Service
public class Branch303TaskSubmitServiceImpl extends TaskCommon implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        WfDealRoleRegisterFactory.register(RoleName.BRANCH_RISK_MONITORING_POST.getInfo(),this);
    }

    @Override
    protected Map<String, Object> assembleParam(TaskInfoSubmitPojo task, SysUser user) {
        Map<String, Object> map = new HashMap<>();
        // 其他参数判断
        boolean isFuZhou = true; // 任务签收是否属于福州分行
        map.put(WFRole.WFROLEFZ301.getCode(), "57"); // 下个任务  福州分行风险监测岗 组ID

        boolean isHeadOffice = true; // 客户是否属于总行权限
        map.put(WFRole.WFROLE401.getCode(), "61"); // 下个任务  总行风险管理部监测岗 组ID
        boolean isAutomatic = true; // 非自动/自动判断
        return map;
    }
}
