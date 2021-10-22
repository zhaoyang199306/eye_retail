package com.skyon.project.system.controller.eyeController;

import com.skyon.common.enums.RoleName;
import com.skyon.common.utils.ServletUtils;
import com.skyon.framework.security.LoginUser;
import com.skyon.framework.security.service.TokenService;
import com.skyon.framework.web.controller.BaseController;
import com.skyon.framework.web.domain.AjaxResult;
import com.skyon.project.system.domain.eye.waringSings.SeWfWarningSigns;
import com.skyon.project.system.domain.sys.SysRole;
import com.skyon.project.system.domain.sys.SysUser;
import com.skyon.project.system.domain.vo.SignDownListVo;
import com.skyon.project.system.service.activiti.PeersRunWFService;
import com.skyon.project.system.service.activiti.RunWFService;
import com.skyon.project.system.service.activiti.TaskWFService;
import com.skyon.project.system.service.eye.SignDownService;
import com.skyon.project.system.service.eye.SignalManualSevice;
import com.skyon.project.system.service.eye.WLinkLogService;
import com.skyon.project.system.service.eye.WTaskInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wangtf
 * @Description TODO
 * @Date  2021/10/18 15:55
 * @status done
 * @menu 信号下发
 */


@RestController
@RequestMapping("/signDown")
public class SignDownController extends BaseController {

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

    @Autowired
    private SignDownService signDownService;


    /**
     * @Author wangtf
     * @Description TODO 信号列表查询
     * @Date  2021/10/18 15:56
     * @status done
      * @param listType	0:待下发 1：已下发 2：不下发
     * @return com.skyon.framework.web.domain.AjaxResult
     */
    @GetMapping("/list")
    @Transactional
    public AjaxResult getSignDownList(String listType) {
        List<SeWfWarningSigns> list = new ArrayList<>();

        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        SysUser user = loginUser.getUser();
        List<SysRole> roles = user.getRoles();

        // 判断是否为信号下发角色。前端也做控制
        if(RoleName.WF_ROLE_011.getCode().equals(roles.get(0).getRoleId())){
            list = signDownService.getSignalDownList(listType);
            return AjaxResult.success(list);
        }else{
            return AjaxResult.error("登录人无权进行信号下发");
        }
    }

    /**
     *  更新信号下发状态
     * @return
     */
    @GetMapping("/updateDistributeStatus")
    @Transactional
    public AjaxResult updateDistributeStatus(SignDownListVo signDownListVo) {
        List<SeWfWarningSigns> list = new ArrayList<>();

        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        SysUser user = loginUser.getUser();
        List<SysRole> roles = user.getRoles();

        // 判断是否为信号下发角色。前端也做控制
        if(RoleName.WF_ROLE_011.getCode().equals(roles.get(0).getRoleId())){
            //该查询方式 未限制机构隔离
            int cnt = signDownService.updateDistributeStatus(signDownListVo);
            if(cnt==signDownListVo.getId().size()){
                return AjaxResult.error("下发失败");
            }else {
                return AjaxResult.success("下发成功");
            }
        }else{
            return AjaxResult.error("登录人无权进行信号下发");
        }
    }
    /**
     * 更新信号状态（批量）
     * @return
     */
    @GetMapping("/updateSignStatus")
    @Transactional
    public AjaxResult updateSignStatus(List<String> id) {
        List<SeWfWarningSigns> list = new ArrayList<>();

        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        SysUser user = loginUser.getUser();
        List<SysRole> roles = user.getRoles();

        // 判断是否为信号下发角色。前端也做控制
        if(RoleName.WF_ROLE_011.getCode().equals(roles.get(0).getRoleId())){
            //该查询方式 未限制机构隔离
            int cnt = signDownService.updateSingsSignalStatusById(id);
            if(cnt==id.size()){
                return AjaxResult.error("操作失败");
            }else {
                return AjaxResult.success("信号已失效");
            }
        }else{
            return AjaxResult.error("登录人无权进行失效操作");
        }
    }
}
