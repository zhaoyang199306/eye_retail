package com.skyon.project.system.service.wf.impl;

import com.skyon.common.enums.RoleName;
import com.skyon.common.enums.WFRole;
import com.skyon.common.utils.ServletUtils;
import com.skyon.framework.manager.factory.WfDealRoleRegisterFactory;
import com.skyon.framework.security.service.TokenService;
import com.skyon.project.system.domain.eye.SeWfTaskInfo;
import com.skyon.project.system.domain.eye.TaskInfoSubmitPojo;
import com.skyon.project.system.domain.sys.SysUser;
import com.skyon.project.system.service.activiti.TaskWFService;
import com.skyon.project.system.service.eye.SeWfTaskExecuteFeedbackService;
import com.skyon.project.system.service.wf.TaskCommon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 支行主管处理
 * 任务的流转 -- 提交
 */
@Service(value = "subBranchSupervisorTaskSubmitServiceImpl")
public class SubBranchSupervisorTaskSubmitServiceImpl extends TaskCommon implements InitializingBean {

    /**
     * Bean 初始化时，把该Bean注册进   流程的工厂类 - WfDealRoleRegisterFactory
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        WfDealRoleRegisterFactory.register(RoleName.SUB_BRANCH_SUPERVISOR.getInfo(), this);
    }


    @Override
    protected Map<String, Object> assembleParam(SeWfTaskInfo seWfTaskInfo, SysUser user) {
        Map<String, Object> map = new HashMap<>();
        // 执行分行风险检测岗审核
        map.put(WFRole.WFROLE301.getCode(), "53"); // 下个任务  分行风险监测岗 组ID
        return map;
    }
}
