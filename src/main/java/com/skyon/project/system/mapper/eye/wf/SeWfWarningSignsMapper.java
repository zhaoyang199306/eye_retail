package com.skyon.project.system.mapper.eye.wf;

import com.skyon.project.system.domain.eye.waringSings.SeWfWarningSigns;

import java.util.List;

public interface SeWfWarningSignsMapper {
    public int updateSeWfWarningSigns(SeWfWarningSigns seWfWarningSigns);

    /**
     * 根据 id 把信号状态修改为 03
     * @param id
     * @return
     */
    public int updateSingsSignalStatusById(List<String> id);

}
