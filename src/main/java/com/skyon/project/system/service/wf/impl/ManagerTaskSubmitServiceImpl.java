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
import com.skyon.project.system.domain.eye.DpApWarningSign;
import com.skyon.project.system.domain.eye.TaskInfoSubmitPojo;
import com.skyon.project.system.domain.sys.SysUser;
import com.skyon.project.system.service.activiti.RunWFService;
import com.skyon.project.system.service.activiti.TaskWFService;
import com.skyon.project.system.service.eye.TWarnSignalService;
import com.skyon.project.system.service.eye.WLinkLogService;
import com.skyon.project.system.service.eye.WTaskInfoService;
import com.skyon.project.system.service.wf.TaskSubmitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 客户经理
 * 任务的流转 -- 提交
 */
@Service(value = "managerTaskSubmitServiceImpl")
public class ManagerTaskSubmitServiceImpl implements TaskSubmitService, InitializingBean {

    private static final Logger logger = LoggerFactory.getLogger(ManagerTaskSubmitServiceImpl.class);

    @Autowired
    private RunWFService runWFService;
    @Autowired
    private TaskWFService taskWFService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private WTaskInfoService taskInfoService;
    @Autowired
    private TWarnSignalService warnSignalService;
    @Autowired
    private WLinkLogService linkLogService;


    /**
     * 客户经理执行任务  第一次执行  开启流程
     * 有三种情况；
     * 一、非自动认定（即 风险等级为待认定）
     * 二、自动认定非自动签收（即  有系统认定风险等级 且 风险等级黄色及以上  且 不是灰名单 且 （客户不是风险客户 或 是风险客户且风险等级高于原风险等级）
     * 三、自动认定签收（即 上面的另一面）
     *
     * @param task 参数
     */
    @Override
    @Transactional
    public void taskSubmitMethod(TaskInfoSubmitPojo task) {

        boolean isDirector = true; // 是否需要主管审核
        boolean isFuZhou = true; // 任务签收是否属于福州分行
        boolean isHeadOffice = true; // 客户是否属于总行权限
        boolean isAutomatic = true; // 非自动/自动判断
        // 其他参数判断

        Map<String, Object> map = new HashMap<>();
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        SysUser user = loginUser.getUser();


        if (true) {  // 一、非自动认定（即 风险等级为待认定）
            map.put("wfStart", "1"); // 走流程1
//            map.put(WFRole.WFROLE101.getCode(), user.getUserId()); // 预警认定操作人id
            map.put(WFRole.WFROLE201.getCode(), 52); // 下一环节 支行主管角色 id

        } else if (true) { // 二、自动认定非自动签收（即  有系统认定风险等级 且 风险等级黄色及以上  且 不是灰名单 且 （客户不是风险客户 或 是风险客户且风险等级高于原风险等级）
            map.put("wfStart", "2"); // 走流程2
            map.put(WFRole.WFROLE101.getCode(), user.getUserId()); // 预警认定操作人id
        } else if (true) { //  三、自动认定签收（即 上面的另一面）
            map.put("wfStart", "3"); // 走流程3
            map.put(WFRole.WFROLE101.getCode(), user.getUserId()); // 预警认定操作人id
        } else { // 无流程
            logger.info("无流程可走，任务编号：{}" + task.getTaskInfoNo());
            throw new RuntimeException("无流程可走，任务编号" + task.getTaskInfoNo());
        }


        // 某个任务，启动流程
        runWFService.startWf(task.getTaskInfoNo(), map);
        // 执行任务  返回任务节点名字
        String taskName = taskWFService.exeTaskByTaskInfoNo(task.getTaskInfoNo(),
                String.valueOf(user.getUserId()), map);

        logger.info("----taskNO:{}----taskName----: {}",task.getTaskInfoNo(), taskName);

//             执行成功后 修改DP_AP_task_info 表里的状态 run_status  目的；提交之后,该客户经理的任务栏查不到
        if (WFRole.WFROLE101.getInfo().equals(taskName)) {
            int i = taskInfoService.updateRunStatusByNo(task.getTaskInfoNo(),
                    JSON.toJSONString(task.getRiskControlMeasures()),
                    task.getPersonalRiskLevel(),
                    task.getCheckResult());
            // 修改预警信号列表 的 认定状态
            List<DpApWarningSign> warnSignalList = task.getWarnSignalList();
            if (warnSignalList != null && warnSignalList.size() > 0)
                warnSignalService.updateDpApWarningSign(warnSignalList);

            // insert环节流转
            linkLogService.insertWLinkLog(task.getTaskInfoNo(),
                    DealType.RD.getInfo(),
                    WFRole.WFROLE101.getInfo(),
                    user.getUserName(),
                    ProjectContants.SUBMIT_BUTTON,
                    JSON.toJSONString(task.getRiskControlMeasures()),
                    task.getExaminValue());
        }



        logger.info("客户经理 提交----{}",task.getTaskInfoNo());
    }

    /**
     * Bean 初始化时，把该Bean注册进   流程的工厂类 - WfDealRoleRegisterFactory
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        WfDealRoleRegisterFactory.register(RoleName.ACCOUNT_MANAGER.getInfo(), this);
    }
}
