package com.skyon.project.system.mapper.eye;

import com.skyon.project.system.domain.eye.SeWfTaskInfo;
import com.skyon.project.system.domain.eye.waringSings.SeWfWarningSigns;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SignalManualMapper {

    public List<SeWfWarningSigns> getSignalManualList();

    public int updateSignalManualList(List<SeWfWarningSigns> list);

    public SeWfWarningSigns getSignalManualBySignNo(@Param("signNo") String signNo);

    public int insertManaualSigns(SeWfWarningSigns seWfWarningSigns);
}
