package com.skyon.project.system.controller.eyeController;

import com.alibaba.fastjson.JSON;
import com.skyon.common.enums.RoleName;
import com.skyon.common.enums.WarningObjectCategory;
import com.skyon.common.utils.ServletUtils;
import com.skyon.framework.aspectj.lang.annotation.DataScope;
import com.skyon.framework.manager.factory.WfDealRoleRegisterFactory;
import com.skyon.framework.security.LoginUser;
import com.skyon.framework.security.service.TokenService;
import com.skyon.framework.web.controller.BaseController;
import com.skyon.framework.web.domain.AjaxResult;
import com.skyon.project.system.domain.eye.*;
import com.skyon.project.system.domain.eye.waringSings.SeWfWarningSigns;
import com.skyon.project.system.domain.sys.SysRole;
import com.skyon.project.system.domain.sys.SysUser;
import com.skyon.project.system.domain.vo.WarningTaskListVo;
import com.skyon.project.system.service.activiti.PeersRunWFService;
import com.skyon.project.system.service.activiti.RunWFService;
import com.skyon.project.system.service.activiti.TaskWFService;
import com.skyon.project.system.service.eye.SignalManualSevice;
import com.skyon.project.system.service.eye.WLinkLogService;
import com.skyon.project.system.service.eye.WTaskInfoService;
import com.skyon.project.system.service.wf.TaskCommon;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.apache.calcite.rel.core.Aggregate.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.*;

@Api(value = "预警认定任务管理")
@RestController
@RequestMapping("/peersTaskInfo")
public class PeersTaskInfoController extends BaseController {

    @Autowired
    private SignalManualSevice signalManualSevice;
    @Autowired
    private RunWFService runWFService;
    @Autowired
    private PeersRunWFService prunWFService;
    @Autowired
    private TaskWFService taskWFService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private WLinkLogService linkLogService;

    @Autowired
    private WTaskInfoService taskInfoService;


    @ApiOperation(value="预警任务列表",
    		notes = "返回字段名：i.task_no,i.warning_object_name,i.warning_object_no,i.warning_object_category,i.task_status,i.task_type,\n"
    				+ "        i.sys_risk_level,i.task_handle_post,\n"
    				+ "        COUNT(CASE WHEN s.warning_level = '01' THEN 1 ELSE NULL END) AS oneLevelCount,\n"
    				+ "        COUNT(CASE WHEN warning_level = '02' THEN 1 ELSE NULL END) AS twoLevelCount,\n"
    				+ "        COUNT(CASE WHEN warning_level = '03' THEN 1 ELSE NULL END) AS threeLevelCount,\n"
    				+ "        o.ad_sub_bra, o.ad_bra,i.task_start_time,i.task_deadline,o.warning_object_category")
    
    /**
     * 查询已开始和未开始流程的任务
     *      
     * @param warningTaskListVo
     * @return
     */
    @GetMapping("/list")
    @Transactional
    @DataScope(deptAlias = "d")
    public AjaxResult getSignalManualList(WarningTaskListVo warningTaskListVo) {
        List<TaskInfoListPojo> list = new ArrayList<>();

        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        SysUser user = loginUser.getUser();
        List<SysRole> roles = user.getRoles();

        // 还没有开启工作流实例. 查询 登录人 经办列表。
        warningTaskListVo.setTaskHandler(String.valueOf(user.getUserId()));

		// 已经在工作流实例中的.根据用户id查询代办任务编号/根据角色查询代办任务编号
        List<String> groups= new ArrayList<String>();
        for(SysRole r:roles)
        	groups.add(r.getRoleName());//注意：工作流设计时候候选组要填角色名称
        Map mapTask = taskWFService.taskWfByUserGroup(String.valueOf(user.getUserId()),groups);
        if(mapTask.keySet().size()>0) {
        	List<String > batchNoList = new ArrayList<String>();
        	for(Object k:mapTask.keySet())
        		if(k!=null) batchNoList.add(k.toString());
        	//根据在途工作流中的代办任务编号查询
        	warningTaskListVo.setTaskNoList(batchNoList);
        	
        }

        list = taskInfoService.getWTaskInfoListByRole(warningTaskListVo);

        return AjaxResult.success(list);
    }

    /**
     * 预警认定-- 反馈和审批提交入口
     *
     * @return AjaxResult
     * @RequestParam("taskInfoNo") String taskInfoNo,
     * @RequestParam("riskControlMeasures") String riskControlMeasures,
     * @RequestParam("radio") Object radio,
     * @RequestParam("examinValue") String examinValue,
     * @RequestParam("personalRiskLevel") String personalRiskLevel,
     * @RequestParam("checkResult") String checkResult,
     * DpApWarningSign warnSignalList
     */
    @PostMapping("/submitTask")
    @Transactional
    public AjaxResult submitTask(@RequestBody TaskInfoSubmitPojo taskInfo) throws IOException {

        logger.info("----submitTask----: 任务编号：{}", taskInfo.getTaskInfoNo());

        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        SysUser user = loginUser.getUser();
        List<SysRole> roles = user.getRoles();

        SeWfTaskInfo task = taskInfoService.selectSeWfTaskInfoByTaskNo(taskInfo.getTaskInfoNo());
        Map map=new HashMap<String,String>();
        prunWFService.startWf(taskInfo.getTaskInfoNo(), map, task.getSeWfWarningObject().getWarningObjectCategory());
        
        //更新任务和信号
        int taskCnt = taskInfoService.updateAffirmTask(taskInfo);
        int signCnt = signalManualSevice.updateSignalManualList(taskInfo.getWarnSignalList());
        
        taskWFService.exeTaskByTaskInfoNo(taskInfo.getTaskInfoNo(), user.getUserName(), map);

        return AjaxResult.success("成功提交");
    }



    /**
     * 根据任务编号查询任务详情
     * @param taskNo 任务编号
     * @return
     */
    @GetMapping("/getTaskDetail/{taskNo}")
    public AjaxResult getTaskDetail(@PathVariable("taskNo") String taskNo) {

        SeWfTaskInfo seWfTaskInfo = taskInfoService.selectSeWfTaskInfoByTaskNo(taskNo);
        String signalCreateModel = seWfTaskInfo.getSeWfWarningSigns().get(0).getSignalCreateModel();

        return AjaxResult.success(seWfTaskInfo);
    }


    /**
     * 根据客户编号查询历史任务
     * @param warningObjectId 客户编号
     * @return
     */
    @GetMapping("/getHistoryTask/{warningObjectId}")
    public AjaxResult getHistoryTask(@PathVariable("warningObjectId") String warningObjectId) {

        List<SeWfTaskInfo> seWfTaskInfo = taskInfoService.selectSeWfTaskInfoByWarningObjectId(warningObjectId);

        return AjaxResult.success(seWfTaskInfo);
    }

    public static void main(String[] args) {
    	System.out.println(
    	WarningObjectCategory.valueOf("PUBLIC"));
    	TaskInfoSubmitPojo po = new TaskInfoSubmitPojo();
    	po.setTaskInfoNo("RCN010000000120210918005");
    	po.setPersonalRiskLevel("01");
    	po.setCheckResult("有风险");
    	po.setRiskControlMeasures("1,2"); 
    	List<SeWfWarningSigns> warnList = new ArrayList<SeWfWarningSigns>();
    	SeWfWarningSigns warning =new SeWfWarningSigns();
    	warning.setSignalId("478an1215wsdfq3312an1215wsdfq302");
    	warning.setConfirmStatus("01");
		warnList.add(warning);
		po.setWarnSignalList(warnList);
    	System.out.println(JSON.toJSONString(po));
    	
    }

}
