package com.skyon.project.system.controller.eyeController;

import com.skyon.common.enums.DealType;
import com.skyon.common.enums.RoleName;
import com.skyon.common.enums.WFLink;
import com.skyon.common.enums.WFRole;
import com.skyon.common.utils.ServletUtils;
import com.skyon.framework.security.LoginUser;
import com.skyon.framework.security.service.TokenService;
import com.skyon.framework.web.controller.BaseController;
import com.skyon.framework.web.domain.AjaxResult;
import com.skyon.project.system.domain.sys.SysRole;
import com.skyon.project.system.domain.sys.SysUser;
import com.skyon.project.system.service.eye.WLinkLogService;
import com.skyon.project.system.service.eye.WTaskInfoService;
import com.skyon.project.system.service.activiti.RunWFService;
import com.skyon.project.system.service.activiti.TaskWFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

//@RestController
//@RequestMapping("/removeRisk")
//public class RemoveRiskController extends BaseController {
//
//    public static final String SUBMIT_BUTTON = "提交";
//
//    @Autowired
//    private RunWFService runWFService;
//    @Autowired
//    private TaskWFService taskWFService;
//    @Autowired
//    private TokenService tokenService;
//    @Autowired
//    private WTaskInfoService taskInfoService;
//    @Autowired
//    private WLinkLogService linkLogService;
//
//    /**
//     * 预警认定-- 反馈和审批提交入口
//     *
//     * @return AjaxResult
//     */
//    @GetMapping("/submitRemove")
//    @Transactional
//    public AjaxResult submitRemove(@RequestParam("taskInfoNo") String taskInfoNo
//            , @RequestParam("examineValue") String examineValue) {
//
//        logger.info("----submitTask----: 任务编号：{}，审核意见：{}", taskInfoNo, examineValue);
//        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
//        SysUser user = loginUser.getUser();
//        List<SysRole> roles = user.getRoles();
//
//        // 解除预警
//        Map<String, String> map = new HashMap<>();
//
//        if (RoleName.ACCOUNT_MANAGER.getInfo().equals(roles.get(0).getRoleName())) {
//            map.put(WFRole.WFROLE302.getCode(), "7"); // 市场零售部门主管审核 组
//
//            // 执行任务
//            String taskName = taskWFService.exeTaskByTaskInfoNo(taskInfoNo, String.valueOf(user.getUserId()), map);
//            logger.info("----taskName----: {}", taskName);
//
//            // insert环节流转
//            if (WFLink.WFLINK301.getInfo().equals(taskName)) {
//                linkLogService.insertWLinkLog(taskInfoNo, DealType.JC.getCode(), WFLink.WFLINK301.getInfo(), user.getUserName(),
//                        SUBMIT_BUTTON, "", examineValue);
//            }
//
//        } else if (RoleName.RETAIL_DEPARTMENT_AUDIT.getInfo().equals(roles.get(0).getRoleName())) {
//            map.put(WFRole.WFROLE303.getCode(), "8"); // 分行风险检测岗审核 组
//
//            // 执行任务
//            String taskName = taskWFService.exeTaskByTaskInfoNo(taskInfoNo, String.valueOf(user.getUserId()), map);
//            logger.info("----taskName----: {}", taskName);
//
//            // insert环节流转
//            if (WFLink.WFLINK302.getInfo().equals(taskName)) {
//                linkLogService.insertWLinkLog(taskInfoNo, DealType.JC.getCode(), WFLink.WFLINK302.getInfo(), user.getUserName(),
//                        SUBMIT_BUTTON, "", examineValue);
//            }
//        } else if (RoleName.RISK_DETECTION_POST_AUDIT.getInfo().equals(roles.get(0).getRoleName())) {
//            map.put(WFRole.WFROLE304.getCode(), "9"); // 分行监测审核岗审核 组
//
//            // 执行任务
//            String taskName = taskWFService.exeTaskByTaskInfoNo(taskInfoNo, String.valueOf(user.getUserId()), map);
//            logger.info("----taskName----: {}", taskName);
//
//            // insert环节流转
//            if (WFLink.WFLINK303.getInfo().equals(taskName)) {
//                linkLogService.insertWLinkLog(taskInfoNo, DealType.JC.getCode(), WFLink.WFLINK303.getInfo(), user.getUserName(),
//                        SUBMIT_BUTTON, "", examineValue);
//            }
//        } else if (RoleName.MONITORING_AUDIT_POST_AUDIT.getInfo().equals(roles.get(0).getRoleName())) {
//            map.put(WFRole.WFROLE305.getCode(), "10"); // 分行检测主管审核 组
//
//            // 执行任务
//            String taskName = taskWFService.exeTaskByTaskInfoNo(taskInfoNo, String.valueOf(user.getUserId()), map);
//            logger.info("----taskName----: {}", taskName);
//
//            // insert环节流转
//            if (WFLink.WFLINK304.getInfo().equals(taskName)) {
//                linkLogService.insertWLinkLog(taskInfoNo, DealType.JC.getCode(), WFLink.WFLINK304.getInfo(), user.getUserName(),
//                        SUBMIT_BUTTON, "", examineValue);
//            }
//        } else if (RoleName.INSPECTION_SUPERVISOR_AUDIT.getInfo().equals(roles.get(0).getRoleName())) {
//
//            // 执行任务
//            String taskName = taskWFService.exeTaskByTaskInfoNo(taskInfoNo, String.valueOf(user.getUserId()), map);
//            logger.info("----taskName----: {}", taskName);
//
//            // insert环节流转
//            if (WFLink.WFLINK305.getInfo().equals(taskName)) {
//                linkLogService.insertWLinkLog(taskInfoNo, DealType.JC.getCode(), WFLink.WFLINK305.getInfo(), user.getUserName(),
//                        SUBMIT_BUTTON, "", examineValue);
//            }
//        }
//
//
//        return AjaxResult.success("成功提交");
//    }
//
//
//    @GetMapping("/list")
//    public AjaxResult getRemoveRiskList(Object object) {
//
//        List list = new ArrayList();
//
//        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
//        SysUser user = loginUser.getUser();
//
//        // 根据用户id查询代办任务
//        Map mapTask = taskWFService.taskWfUser(String.valueOf(user.getUserId()));
//        Set<String> set = new HashSet<>();
//        // 只计算在里面的
//        List listAll = taskInfoService.selectAllTaskInfoNo();
//        Set<Map.Entry<String, String>> entries = mapTask.entrySet();
//        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
//        while (iterator.hasNext()) {
//            Map.Entry<String, String> next = iterator.next();
//            String key = next.getKey();
//            String value = next.getValue();
//
//            if (listAll.contains(key)) {
//                if (WFLink.WFLINK3.contains(value)) {
//                    set.add(key);
//                }
//            }
//        }
//
//        // 查询待办箱
//        if (!set.isEmpty()) list = taskInfoService.getWTaskInfoByList1(set);
//
////        List list = new ArrayList();
////
////        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
////        SysUser user = loginUser.getUser();
////        List<SysRole> roles = user.getRoles();
////
////
////        if ("预警认定".equals(roles.get(0).getRoleName()) || "跟踪反馈".equals(roles.get(0).getRoleName()) || "解除申请".equals(roles.get(0).getRoleName())) {
////            list = taskInfoService.getWTaskInfoListByRole("解除申请");
////
////        }else if ("市场零售部门主管审核".equals(roles.get(0).getRoleName()) || "分行风险检测岗审核".equals(roles.get(0).getRoleName()) || "分行监测审核岗审核".equals(roles.get(0).getRoleName())) {
////            // 根据用户id查询代办任务
////            List listNo = taskWFService.taskWfUser(String.valueOf(user.getUserId()));
////            // 查询待办箱
////            if (listNo.size() > 0) list = taskInfoService.getWTaskInfoByList3(listNo);
//
////        }
////
////        List list = new ArrayList();
////
////        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
////        SysUser user = loginUser.getUser();
////
////        // 根据用户id查询代办任务 id
////        List listNO = taskWFService.taskWfUser(String.valueOf(user.getUserId()));
////        // 查询待办箱
////        if (listNO.size() > 0) list = taskInfoService.getWTaskInfoByList(listNO);
//
//        return AjaxResult.success(list);
//    }
//
//    @GetMapping("/getDetail/{taskInfoNo}")
//    public AjaxResult getRemoveRiskDetail(String taskInfoNo) {
//        List list = new ArrayList();
//        //   授信信息
//        List listOne = new ArrayList();
//        Map map = new HashMap();
//        map.put("q", "JC20210224001");
//        map.put("w", "客户经理");
//        map.put("e", "萧杰");
//        map.put("r", "提交");
//        map.put("t", "2021-02-24 13:16:13");
//        map.put("y", "qq");
//        Map map2 = new HashMap();
//        map2.put("q", "JC20210224001");
//        map2.put("w", "支行主管");
//        map2.put("e", "袁酷");
//        map2.put("r", "提交");
//        map2.put("t", "2021-02-24 13:19:13");
//        map2.put("y", "ww");
//        listOne.add(map2);
//        Map map3 = new HashMap();
//        map3.put("q", "JC20210224001");
//        map3.put("w", "分行风险检查岗");
//        map3.put("e", "徐伟");
//        map3.put("r", "提交");
//        map3.put("t", "2021-02-24 13:21q:13");
//        map3.put("y", "ee");
//        listOne.add(map3);
//        list.add(listOne);
//
//
//        return AjaxResult.success(list);
//    }
//
//    public static void main(String[] args) {
//
//        System.out.println(Math.round(11.5));
//        System.out.println(Math.round(11.4));
//        System.out.println(Math.round(11.6));
//
//        System.out.println(Math.round(-11.5));
//        System.out.println(Math.round(-11.4));
//        System.out.println(Math.round(-11.6));
//    }
//
//
//}
