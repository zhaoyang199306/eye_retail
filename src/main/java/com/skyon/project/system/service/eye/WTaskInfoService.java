package com.skyon.project.system.service.eye;

import com.skyon.project.system.domain.eye.DpApTaskInfo;
import com.skyon.project.system.domain.vo.WarningTaskListVo;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface WTaskInfoService {

    public List<DpApTaskInfo> getWTaskInfoByList1(Set set);


    /**
     * 根据业务人员编号 查询代办事项
     * @param warningTaskListVo
     * @return
     */
    public List<Map> getWTaskInfoListByRole(WarningTaskListVo warningTaskListVo);

    // 根据taskInfoNo 修改run_status状态
    public int updateRunStatusByNo(String taskInfoNo,String riskValue,String personalRiskLevel,String checkResult);

    public int updateRunStatusByNoAndTrack(String taskInfoNo);

    public int celarRunStatusByNo(String taskInfoNo);

    public int insertWTaskInfo(DpApTaskInfo dpApTaskInfo);

    // 查询所有的task_info_no
    public Set selectAllTaskInfoNo();

    // 查询处置跟踪的非自营
    public Set selectIsProprietary();

    public Set selectIsNoProprietary();

    // 根据任务编号查询任务详情
    public DpApTaskInfo selectDpApTaskInfoByTaskInfoNo(String taskInfoNo);


}
