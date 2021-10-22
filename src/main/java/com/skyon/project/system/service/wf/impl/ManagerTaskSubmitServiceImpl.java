package com.skyon.project.system.service.wf.impl;

import com.skyon.common.enums.*;
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

    @Autowired
    private WTaskInfoService taskInfoService;
    @Autowired
    private TaskWFService taskWFService;

    /**
     * Bean 初始化时，把该Bean注册进   流程的工厂类 - WfDealRoleRegisterFactory
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        WfDealRoleRegisterFactory.register(RoleName.WF_ROLE_011.getCode(), this);
    }

    /**
     * 客户经理执行任务  第一次执行  开启流程
     * @param seWfTaskInfo 参数
     */
    @Override
    protected Map<String, Object> assembleParam(String taskNo, WfCode code, SysUser user) {
        Map<String, Object> map = new HashMap<>();

//        WFTaskFlagHandle handle = new WFTaskFlagHandle(seWfTaskInfo);
//        boolean signTask = handle.isSignTask();

        map.put(WFRole.WFROLE101.getCode(), user.getUserId()); // 客户经理操作人id
        map.put("first", taskWFService.confirmTaskIsExit(taskNo));  // 先查询一下是否启动过流程  （有重新回到客户经理手里的情况）

//        if (WarningObjectCategory.retailArr().contains()) { // 零售
//            if (TaskTyeCode.SING_TASK.getCode().equals(taskType)) { // 签收任务
//                map.put("processKey", "");
//            } else if (TaskTyeCode.PRE_TASK.getCode().equals(taskType)) { // 预警认定
//                map.put("processKey", "retail_warn_wf_2101");
//            } else if (TaskTyeCode.DISPOSAL_TRACK.getCode().equals(taskType)) { // 处置跟踪
//                map.put("processKey", "");
//            } else if (TaskTyeCode.SIGNAL_OBJECTION.getCode().equals(taskType)) { // 信号异议
//                map.put("processKey", "");
//            } else if (TaskTyeCode.RISK_OBJECTION.getCode().equals(taskType)) { // 风险异议
//                map.put("processKey", "");
//            } else if (TaskTyeCode.PARTNER_FEEDBACK_PROCESS.getCode().equals(taskType)) { // 合作方
//                map.put("processKey", "");
//            } else {
//                throw new RuntimeException("未匹配到合适的任务类型");
//            }
//
//        } else if (WarningObjectCategory.peerArr().contains(warningObjectCategory)) { // 同业
//
//        } else {
//            throw new RuntimeException("未匹配到合适的预警对象类型");
//        }


        return map;
    }

    /**
     * 客户经理提交后， 需要对任务表里的 TASK_STATUS 修改为 02（处理中）   01：待处理，02：在途，03：归档。
     *
     * @param taskNo
     */
    @Override
    protected void updateField(String taskNo) {
        taskInfoService.updateTaskStatusByNo(taskNo);
    }
}
