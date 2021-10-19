package com.skyon.project.system.service.eye;

import com.skyon.project.system.domain.eye.waringSings.SeWfWarningSigns;
import com.skyon.project.system.domain.vo.SignDownListVo;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SignDownService {
    /**
     * 查询已开始流程的任务
     *
     * @param listType  0:待下发  1：已下发  2：不下发
     * @return
     */
    public List<SeWfWarningSigns> getSignalDownList(String listType);
    /**
     * 更新下发状态
     *
     * @param signDownListVo
     * @return
     */
    public int updateDistributeStatus(SignDownListVo signDownListVo);
    /**
     * 更新信号状态
     *
     * @param id List<String>
     * @return
     */
    public int updateSingsSignalStatusById(List<String> id);

}
