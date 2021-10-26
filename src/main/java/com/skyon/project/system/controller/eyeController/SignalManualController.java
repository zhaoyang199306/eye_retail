package com.skyon.project.system.controller.eyeController;

import com.skyon.framework.web.controller.BaseController;
import com.skyon.framework.web.domain.AjaxResult;
import com.skyon.project.system.domain.eye.DpApTaskInfo;
import com.skyon.project.system.domain.eye.SeWfTaskInfo;
import com.skyon.project.system.domain.eye.waringSings.SeWfWarningSigns;
import com.skyon.project.system.service.eye.SignalManualSevice;
import com.skyon.project.system.service.eye.WTaskInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 人工信号录入类
 */
@RestController
@RequestMapping("/signalManual")
public class SignalManualController extends BaseController {

    @Autowired
    private SignalManualSevice signalManualSevice;

    @Autowired
    private WTaskInfoService taskInfoService;


    //    保存form
    @PostMapping("/submitForm")
    @Transactional
    public AjaxResult submitForm(@RequestBody SeWfWarningSigns sign) {

        System.out.println("--signalManual/submitForm");
        sign.setSignalDataSource("1");
        int i = signalManualSevice.insertManaualSigns(sign);
        if (i > 0) {
            return AjaxResult.success("成功新增人工信号");
        }
        return AjaxResult.error("新增人工信号失败");
    }


    @GetMapping("/list")
    public AjaxResult getSignalManualList() {
//        startPage();
        List<SeWfWarningSigns> manuallist = signalManualSevice.getSignalManualList();
        return AjaxResult.success(manuallist);
    }

    @GetMapping("/getDetail/{signNo}")
    public AjaxResult getSignalManualDetail(@PathVariable("signNo") String signNo) {

        SeWfWarningSigns signInfo = signalManualSevice.getSignalManualBySignNo(signNo);

        return AjaxResult.success(signInfo);
    }



}
