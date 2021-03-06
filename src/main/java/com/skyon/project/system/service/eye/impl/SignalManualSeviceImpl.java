package com.skyon.project.system.service.eye.impl;

import com.skyon.project.system.domain.eye.DpApTaskInfo;
import com.skyon.project.system.domain.eye.SeWfTaskInfo;
import com.skyon.project.system.domain.eye.waringSings.SeWfWarningSigns;
import com.skyon.project.system.mapper.eye.SignalManualMapper;
import com.skyon.project.system.mapper.eye.DpApTaskInfoMapper;
import com.skyon.project.system.service.eye.SignalManualSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignalManualSeviceImpl implements SignalManualSevice {

    @Autowired
    private SignalManualMapper signalManualMapper;

    @Autowired
    private DpApTaskInfoMapper taskInfoMapper;

    @Override
    public List<SeWfWarningSigns> getSignalManualList() {
        return signalManualMapper.getSignalManualList();
    }

    @Override
    public DpApTaskInfo getWTaskInfoListManualByCustNo(String custNo) {
        return taskInfoMapper.getWTaskInfoListManualByCustNo(custNo);
    }

    @Override
    public int updateSignalManualList(List<SeWfWarningSigns> seWfWarningSigns) {
        return signalManualMapper.updateSignalManualList(seWfWarningSigns);
    }

    @Override
    public SeWfWarningSigns getSignalManualBySignNo(String signNo) {
        return signalManualMapper.getSignalManualBySignNo(signNo);
    }

    @Override
    public int insertManaualSigns(SeWfWarningSigns seWfWarningSigns) {
        return signalManualMapper.insertManaualSigns(seWfWarningSigns);
    }
}
