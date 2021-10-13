package com.skyon.project.system.service.wf.impl;

import com.skyon.common.enums.RoleName;
import com.skyon.common.enums.WFRole;
import com.skyon.common.utils.ServletUtils;
import com.skyon.framework.manager.factory.WfDealRoleRegisterFactory;
import com.skyon.project.system.domain.eye.SeWfTaskInfo;
import com.skyon.project.system.domain.eye.TaskInfoSubmitPojo;
import com.skyon.project.system.domain.sys.SysUser;
import com.skyon.project.system.service.activiti.TaskWFService;
import com.skyon.project.system.service.eye.WLinkLogService;
import com.skyon.project.system.service.wf.TaskCommon;
import com.skyon.project.system.service.wf.WFTaskFlagHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 福州分行检测审核岗 审核
 */
@Service
public class FZBranch302TaskSubmitServiceImpl extends TaskCommon implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        WfDealRoleRegisterFactory.register(RoleName.FZ_BRANCH_MONITORING_AUDIT_POST.getInfo(), this);
    }

    @Override
    protected Map<String, Object> assembleParam(SeWfTaskInfo seWfTaskInfo, SysUser user) {
        Map<String, Object> map = new HashMap<>();

        // 其他参数

        WFTaskFlagHandle handle = new WFTaskFlagHandle(seWfTaskInfo);

        map.put("director2", handle.isSupervisor());// 是否需要主管审核
        map.put(WFRole.WFROLEFZ303.getCode(), "60"); // 下个任务  福州分行风险管理部主管 组ID

        map.put("HeadOffice", handle.isHead());// 客户是否属于总行权限
        map.put(WFRole.WFROLE401.getCode(), "61"); // 下个任务  总行风险管理部监测岗 组ID

        map.put("automatic", handle.isAutomatic());// 非自动/自动判断

        map.put("upYellow", handle.resultIsUpYellow());// 是否黄色及以上

        map.put("YCYH", handle.isYCYHPlan());// 是否制定一户一策计划
        return map;
    }
}
