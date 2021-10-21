package com.skyon.project.system.service.wf.impl;

import com.skyon.common.enums.RoleName;
import com.skyon.common.enums.WFRole;
import com.skyon.framework.manager.factory.WfDealRoleRegisterFactory;
import com.skyon.project.system.domain.eye.SeWfTaskInfo;
import com.skyon.project.system.domain.eye.waringSings.SeWfWarningSigns;
import com.skyon.project.system.domain.sys.SysUser;
import com.skyon.project.system.service.eye.SeWfWarningSignsService;
import com.skyon.project.system.service.wf.TaskCommon;
import com.skyon.project.system.service.wf.WFTaskFlagHandle;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 指挥部风险审核岗 审核
 */
@Service
public class Command502TaskSubmitServiceImpl extends TaskCommon implements InitializingBean {

    @Autowired
    private SeWfWarningSignsService seWfWarningSignsService;


    @Override
    public void afterPropertiesSet() throws Exception {
        WfDealRoleRegisterFactory.register(RoleName.HEADQUARTERS_RISK_REVIEW_POST.getInfo(), this);
    }

    @Override
    protected Map<String, Object> assembleParam(SeWfTaskInfo seWfTaskInfo, SysUser user) {
        Map<String, Object> map = new HashMap<>();
        WFTaskFlagHandle handle = new WFTaskFlagHandle(seWfTaskInfo);
        map.put("signTrue2", handle.singsIsAllNotTrueByManager()); // 信号全部属实不属实判断
//        map.put("WF_ROLE_101", seWfTaskInfo.getTaskHandler()); // 客户经理 id
        return map;
    }

    /**
     *  指挥部风险审核岗 提交时， 如果信号还有属实的  ， 需要把不属实的信号状态修改为失效03
     * @param seWfTaskInfo 任务信息
     * @see TaskCommon
     */
    @Override
    protected void updateField(SeWfTaskInfo seWfTaskInfo) {
        List<String> list = new ArrayList<>();
        for (SeWfWarningSigns seWfWarningSign : seWfTaskInfo.getSeWfWarningSigns()) {
            list.add(seWfWarningSign.getSignalId());
        }
        seWfWarningSignsService.updateSingsSignalStatusById(list);
    }
}
