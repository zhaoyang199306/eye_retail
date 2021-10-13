package com.skyon.project.system.service.eye;

import com.skyon.project.system.domain.eye.DpApTaskInfo;
import com.skyon.project.system.domain.eye.waringSings.SeWfWarningSigns;

import java.util.List;

public interface SignalManualSevice {

    public List getSignalManualList();

    public DpApTaskInfo getWTaskInfoListManualByCustNo(String custNo);

    public int updateSignalManualList(List<SeWfWarningSigns> seWfWarningSigns);

}
