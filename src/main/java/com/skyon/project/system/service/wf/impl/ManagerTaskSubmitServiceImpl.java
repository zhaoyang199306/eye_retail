package com.skyon.project.system.service.wf.impl;

import com.skyon.common.enums.RoleName;
import com.skyon.common.enums.SignalCreateModelEnum;
import com.skyon.common.enums.SysRiskLevelEnum;
import com.skyon.common.enums.WFRole;
import com.skyon.common.utils.ServletUtils;
import com.skyon.framework.manager.factory.WfDealRoleRegisterFactory;
import com.skyon.framework.security.LoginUser;
import com.skyon.framework.security.service.TokenService;
import com.skyon.project.system.domain.eye.SeWfTaskInfo;
import com.skyon.project.system.domain.eye.TaskInfoSubmitPojo;
import com.skyon.project.system.domain.eye.wf.SeWfTaskExecuteFeedback;
import com.skyon.project.system.domain.sys.SysUser;
import com.skyon.project.system.service.activiti.RunWFService;
import com.skyon.project.system.service.activiti.TaskWFService;
import com.skyon.project.system.service.eye.SeWfTaskExecuteFeedbackService;
import com.skyon.project.system.service.eye.TWarnSignalService;
import com.skyon.project.system.service.eye.WTaskInfoService;
import com.skyon.project.system.service.wf.TaskCommon;
import com.skyon.project.system.service.wf.WFTaskFlagHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * 客户经理
 * 任务的流转 -- 提交
 */
@Service(value = "managerTaskSubmitServiceImpl")
public class ManagerTaskSubmitServiceImpl extends TaskCommon implements InitializingBean {

    private static final Logger logger = LoggerFactory.getLogger(ManagerTaskSubmitServiceImpl.class);

    /**
     * Bean 初始化时，把该Bean注册进   流程的工厂类 - WfDealRoleRegisterFactory
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        WfDealRoleRegisterFactory.register(RoleName.ACCOUNT_MANAGER.getInfo(), this);
    }

    /**
     * 客户经理执行任务  第一次执行  开启流程
     * 有三种情况；
     * 一、非自动认定（即 风险等级为待认定）
     * 二、自动认定非自动签收（即  有系统认定风险等级 且 风险等级黄色及以上  且 不是灰名单 且 （客户不是风险客户 或 是风险客户且风险等级高于原风险等级）
     * 三、自动认定签收（即 上面的另一面）
     *
     * @param seWfTaskInfo 参数
     */
    @Override
    protected Map<String, Object> assembleParam(SeWfTaskInfo seWfTaskInfo, SysUser user) {
        Map<String, Object> map = new HashMap<>();
        // 先查询一下是否启动过流程  （有重新回到客户经理手里的情况）

        WFTaskFlagHandle handle = new WFTaskFlagHandle(seWfTaskInfo);
        boolean signTask = handle.isSignTask();

        map.put(WFRole.WFROLE101.getCode(), user.getUserId()); // 客户经理操作人id
        map.put("first", Boolean.TRUE);

        if (signTask) {  // 签收
            map.put("wfStart", "2"); // 走流程2
        } else { // 非签收
            map.put("wfStart", "1"); // 走流程1
            map.put(WFRole.WFROLE201.getCode(), "52"); // 下一环节 支行主管角色 id
        }
        return map;
    }

}
