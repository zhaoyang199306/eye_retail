package com.skyon.project.system.service.eye;

import com.skyon.project.system.domain.eye.DpApTaskInfo;

import java.util.List;

public interface SignalManualSevice {

    public List getSignalManualList();

    public DpApTaskInfo getWTaskInfoListManualByCustNo(String custNo);
}
