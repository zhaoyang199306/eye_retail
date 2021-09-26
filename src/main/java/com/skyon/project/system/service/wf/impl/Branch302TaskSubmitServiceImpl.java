package com.skyon.project.system.service.wf.impl;

import com.alibaba.fastjson.JSON;
import com.skyon.common.constant.ProjectContants;
import com.skyon.common.enums.DealType;
import com.skyon.common.enums.RoleName;
import com.skyon.common.enums.WFRole;
import com.skyon.common.utils.ServletUtils;
import com.skyon.framework.manager.factory.WfDealRoleRegisterFactory;
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
 * 分行检测审核岗 审核
 */
@Service
public class Branch302TaskSubmitServiceImpl implements TaskSubmitService, InitializingBean {

    private static final Logger logger = LoggerFactory.getLogger(Branch302TaskSubmitServiceImpl.class);

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
        map.put(WFRole.WFROLE303.getCode(), 55); // 下个任务  分行监测审核岗 组ID

        // 其他参数




        // 根据任务编号 - taskInfoNo 执行任务
        String taskName = taskWFService.exeTaskByTaskInfoNo(task.getTaskInfoNo(),
                String.valueOf(user.getUserId()), map);

        logger.info("----taskNO:{}----taskName----: {}",task.getTaskInfoNo(), taskName);

        // insert环节流转
        if (WFRole.WFROLE302.getInfo().equals(taskName)) {
            linkLogService.insertWLinkLog(task.getTaskInfoNo(),
                    DealType.RD.getCode(),
                    WFRole.WFROLE302.getInfo(),
                    user.getUserName(),
                    ProjectContants.SUBMIT_BUTTON,
                    JSON.toJSONString(task.getRiskControlMeasures()),
                    task.getExaminValue());
        }
        logger.info("分行检测审核岗:{} 提交----{}",user.getUserId(),task.getTaskInfoNo());

    }


    @Override
    public void afterPropertiesSet() throws Exception {
        WfDealRoleRegisterFactory.register(RoleName.BRANCH_RISK_MONITORING_POST.getInfo(),this);
    }
}
