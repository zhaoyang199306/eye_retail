package com.skyon.project.system.service.wf.impl;

import com.alibaba.fastjson.JSON;
import com.skyon.common.constant.ProjectContants;
import com.skyon.common.enums.DealType;
import com.skyon.common.enums.RoleName;
import com.skyon.common.enums.WFLink;
import com.skyon.common.enums.WFRole;
import com.skyon.common.utils.ServletUtils;
import com.skyon.framework.manager.factory.WfDealRoleRegisterFactory;
import com.skyon.framework.security.LoginUser;
import com.skyon.framework.security.service.TokenService;
import com.skyon.project.system.domain.eye.TaskInfoSubmitPojo;
import com.skyon.project.system.domain.sys.SysUser;
import com.skyon.project.system.service.activiti.TaskWFService;
import com.skyon.project.system.service.eye.WLinkLogService;
import com.skyon.project.system.service.wf.TaskSubmitService;
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
public class SubBranchSupervisorTaskSubmitServiceImpl implements TaskSubmitService, InitializingBean {

    private static final Logger logger = LoggerFactory.getLogger(SubBranchSupervisorTaskSubmitServiceImpl.class);

    @Autowired
    private TaskWFService taskWFService;
    @Autowired
    private WLinkLogService linkLogService;
    @Autowired
    private TokenService tokenService;

    @Override
    public void taskSubmitMethod(TaskInfoSubmitPojo task) {
        SysUser user = tokenService.getLoginUser(ServletUtils.getRequest()).getUser();

        Map<String, Object> map = new HashMap<>();
        // 执行分行风险检测岗审核
        map.put(WFRole.WFROLE301.getCode(), 53); // 下个任务  分行风险监测岗 组ID

        // 根据任务编号 - taskInfoNo 执行任务
        String taskName = taskWFService.exeTaskByTaskInfoNo(task.getTaskInfoNo(),
                String.valueOf(user.getUserId()), map);

        logger.info("----taskNO:{}----taskName----: {}",task.getTaskInfoNo(), taskName);

        // insert环节流转
        if (WFRole.WFROLE201.getInfo().equals(taskName)) {
            linkLogService.insertWLinkLog(task.getTaskInfoNo(),
                    DealType.RD.getCode(),
                    WFRole.WFROLE201.getInfo(),
                    user.getUserName(),
                    ProjectContants.SUBMIT_BUTTON,
                    JSON.toJSONString(task.getRiskControlMeasures()),
                    task.getExaminValue());
        }
        logger.info("支行主管处理:{} 提交----{}",user.getUserId(),task.getTaskInfoNo());
    }

    /**
     * Bean 初始化时，把该Bean注册进   流程的工厂类 - WfDealRoleRegisterFactory
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        WfDealRoleRegisterFactory.register(RoleName.SUB_BRANCH_SUPERVISOR.getInfo(), this);
    }
}
