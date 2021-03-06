package com.skyon.project.system.controller.eyeController;

import com.skyon.common.enums.RoleName;
import com.skyon.common.enums.WFLink;
import com.skyon.common.utils.ServletUtils;
import com.skyon.framework.security.LoginUser;
import com.skyon.framework.security.service.TokenService;
import com.skyon.framework.web.controller.BaseController;
import com.skyon.framework.web.domain.AjaxResult;
import com.skyon.project.system.domain.eye.TaskInfoListPojo;
import com.skyon.project.system.domain.vo.WarningTaskListVo;
import com.skyon.project.system.domain.sys.SysRole;
import com.skyon.project.system.domain.sys.SysUser;
import com.skyon.project.system.service.eye.WTaskInfoService;
import com.skyon.project.system.service.eye.WorkbenchService;
import com.skyon.project.system.service.activiti.TaskWFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 工作控制台 Controller
 *
 * @date 2021-03-18
 */
@RestController
@RequestMapping("/workbench")
public class WorkbenchController extends BaseController {

    public static final String EARLY_WARN_COGNIZANCE = "预警认定";

    @Autowired
    private WorkbenchService workbenchService;

    @Autowired
    private TaskWFService taskWFService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private WTaskInfoService taskInfoService;

    /**
     * 查询工作控制台 各列表任务的数量
     */
    @GetMapping("/count")
    public AjaxResult list() {
        List<Map> resultList = new ArrayList<>();

        Map map = workbenchService.queryWorkbenchTaskcount();
        resultList.add(map);

        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        SysUser user = loginUser.getUser();
        List<SysRole> roles = user.getRoles();

        // 根据用户id查询代办任务
        Map<String, Long> mapTask = taskWFService.taskWfUser(user);
        Set<String> owerTaskNo = mapTask.keySet(); // 任务池的 taskNo

        logger.info("-------个人任务池-----list: {}", mapTask.toString());
        Map<String, Integer> mapSelf = new HashMap<>();
        int taskInfoSelfCountNum = 0;
        int disposalTrackSelfCountNum = 0;
        int removeRiskSelfCountNum = 0;

        // 预警认定初始单独计算
        if (RoleName.WF_ROLE_011.getCode().equals((roles.get(0).getRoleId()))) {
            WarningTaskListVo warningTaskListVo = new WarningTaskListVo();
            warningTaskListVo.setTaskHandler(String.valueOf(user.getUserId()));
            List<TaskInfoListPojo> listMap = taskInfoService.getWTaskInfoListByRole(warningTaskListVo);
            taskInfoSelfCountNum += listMap.size();
        }

        // 只计算在里面的
        Set set = taskInfoService.selectAllTaskInfoNo();
        List<String> collect = (List<String>) set.stream().filter(owerTaskNo::contains).collect(Collectors.toList());
        taskInfoSelfCountNum += collect.size();


        // 处置跟踪的初始的非自营  单独计算
        Set proprietarys = taskInfoService.selectIsProprietary();
        // 处置跟踪的初始的自营  也可以单独插入
        Set noProprietary = taskInfoService.selectIsNoProprietary();


        mapSelf.put("taskInfoSelfCount", taskInfoSelfCountNum); // 预警认定
        mapSelf.put("disposalTrackSelfCount", disposalTrackSelfCountNum + proprietarys.size() + noProprietary.size()); // 处置跟踪
        mapSelf.put("removeRiskSelfCount", removeRiskSelfCountNum); // 预警解除
        mapSelf.put("signalManualSelfCount", 2);
        mapSelf.put("manageFlowSelfCount", 1);
        mapSelf.put("reassignTaskSelfCount", 2);
        resultList.add(mapSelf);


        return AjaxResult.success(resultList);
    }



    /**
     * 查询工作控制台 预警统计排名
     */
    @GetMapping("/taskInfo")
    public AjaxResult taskInfoList() {
        List<Map> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("q", "上海分行");
        map.put("w", "12");
        map.put("e", "18");
        map.put("r", "4");
        map.put("t", "10");
        list.add(map);
        Map<String, String> map2 = new HashMap<>();
        map2.put("q", "珠海分行");
        map2.put("w", "4");
        map2.put("e", "12");
        map2.put("r", "2");
        map2.put("t", "8");
        list.add(map2);
        Map<String, String> map3 = new HashMap<>();
        map3.put("q", "北京分行");
        map3.put("w", "3");
        map3.put("e", "15");
        map3.put("r", "2");
        map3.put("t", "7");
        list.add(map3);
        Map<String, String> map4 = new HashMap<>();
        map4.put("q", "厦门分行");
        map4.put("w", "2");
        map4.put("e", "18");
        map4.put("r", "15");
        map4.put("t", "3");
        list.add(map4);
        return AjaxResult.success(list);
    }

    /**
     * 查询工作控制台 预警统计排名
     */
    @GetMapping("/disposalTrack")
    public AjaxResult disposalTrackList() {
        List list = new ArrayList();
        Map map = new HashMap();
        map.put("q", "珠海分行");
        map.put("w", "22");
        map.put("e", "18");
        map.put("r", "3");
        map.put("t", "10");
        list.add(map);
        Map map2 = new HashMap();
        map2.put("q", "上海分行");
        map2.put("w", "14");
        map2.put("e", "12");
        map2.put("r", "21");
        map2.put("t", "8");
        list.add(map2);
        return AjaxResult.success(list);
    }


}
