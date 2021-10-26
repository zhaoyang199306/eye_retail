package com.skyon.project.system.service.wf.impl.wf2002;

import com.skyon.common.enums.RoleName;
import com.skyon.common.enums.WfCode;
import com.skyon.framework.manager.factory.WfDealRoleRegisterFactory;
import com.skyon.project.system.domain.sys.SysUser;
import com.skyon.project.system.service.wf.TaskCommon;
import com.skyon.project.system.service.wf.WFTaskCodeFlag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 分行监测审核岗（金融市场部）
 * 任务的流转 -- 提交
 */
@Service
public class WF042SubmitServiceImpl extends TaskCommon implements InitializingBean {

    private static final Logger logger = LoggerFactory.getLogger(WF042SubmitServiceImpl.class);

    /**
     * Bean 初始化时，把该Bean注册进   流程的工厂类 - WfDealRoleRegisterFactory
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        WfDealRoleRegisterFactory.register(RoleName.WF_ROLE_042.getCode(), this);
    }

    /**
     * 分行监测审核岗（金融市场部） 执行任务
     *
     * @param taskNo           任务编号
     * @param code             流程启动编号
     * @param user             用户信息
     * @param processCondition 流程码值
     * @return
     */
    @Override
    protected Map<String, Object> assembleParam(String taskNo, WfCode code, SysUser user, String processCondition) {
        Map<String, Object> map = new HashMap<>();
        map.put(RoleName.WF_ROLE_042.getInfo(), user.getUserId().toString()); //分行监测审核岗（金融市场部）操作人 id

        if (code == WfCode.WF2002) { // 预警任务审核流程-同业主体预警认定(分行)
            map.put("is_052", WFTaskCodeFlag.code10(processCondition));
            map.put(RoleName.WF_ROLE_052.getInfo(),RoleName.WF_ROLE_052.getCode()); // 分行监测主管（金融市场部）角色赋值
            map.put(RoleName.WF_ROLE_081.getInfo(),RoleName.WF_ROLE_081.getCode()); // 总行业务部门风险监测岗（金融市场部）角色赋值
        }

        return map;
    }

}
