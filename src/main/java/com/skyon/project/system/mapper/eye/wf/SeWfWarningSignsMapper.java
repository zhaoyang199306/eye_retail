package com.skyon.project.system.mapper.eye.wf;

import com.skyon.project.system.domain.eye.waringSings.SeWfWarningSigns;
import com.skyon.project.system.domain.vo.SignDownListVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SeWfWarningSignsMapper {
    public int updateSeWfWarningSigns(SeWfWarningSigns seWfWarningSigns);

    /**
     * 根据 id 把信号状态修改为 03
     * @param id
     * @return
     */
    public int updateSingsSignalStatusById(List<String> id);

    public List<SeWfWarningSigns> getSignalDownList(String listType);

    public int updateDistributeStatus(SignDownListVo signDownListVo);


}
