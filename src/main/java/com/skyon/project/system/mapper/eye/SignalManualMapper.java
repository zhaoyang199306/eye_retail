package com.skyon.project.system.mapper.eye;

import com.skyon.project.system.domain.eye.waringSings.SeWfWarningSigns;

import java.util.List;

public interface SignalManualMapper {

    public List getSignalManualList();

    public int updateSignalManualList(List<SeWfWarningSigns> list);
}
