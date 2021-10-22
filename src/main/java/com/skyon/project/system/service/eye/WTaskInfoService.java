package com.skyon.project.system.service.eye;

import com.skyon.project.system.domain.eye.DpApTaskInfo;
import com.skyon.project.system.domain.eye.SeWfTaskInfo;
import com.skyon.project.system.domain.eye.TaskInfoListPojo;
import com.skyon.project.system.domain.eye.TaskInfoSubmitPojo;
import com.skyon.project.system.domain.vo.WarningTaskListVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface WTaskInfoService {

    public List<TaskInfoListPojo> getWTaskInfoByList1(Set set);

    /**
     * @param taskNo
     * @param userId
     * @param roleId
     * @return
     */
    public int claimTaskByID(String taskNo,String userId,String roleId);

    /**
     *
     * @param taskNo
     * @param HandleRoleId
     * @return
     */
    public int updateHandleRoleId(String taskNo,String HandleRoleId);

    /**
     * @param taskNo
     * @return
     */
    public int cancelClaimTaskByID(String taskNo);

    /**
     * 根据业务人员编号 查询代办事项
     * @param warningTaskListVo
     * @return
     */
    public List<TaskInfoListPojo> getWTaskInfoListByRole(WarningTaskListVo warningTaskListVo);

    // 根据taskInfoNo 修改run_status状态
    public int updateRunStatusByNo(String taskInfoNo, String riskValue, String personalRiskLevel, String checkResult);

    public int updateRunStatusByNoAndTrack(String taskInfoNo);
    // 预警认定
    public int updateAffirmTask(TaskInfoSubmitPojo taskInfo);

    public int celarRunStatusByNo(String taskInfoNo);

    public int insertWTaskInfo(DpApTaskInfo dpApTaskInfo);

    // 查询所有的task_info_no
    public Set selectAllTaskInfoNo();

    // 查询处置跟踪的非自营
    public Set selectIsProprietary();

    public Set selectIsNoProprietary();

    // 根据任务编号查询任务详情
    public SeWfTaskInfo selectSeWfTaskInfoByTaskNo(String taskNo);

    // 根据客户编号查询历史任务
    public List<SeWfTaskInfo> selectSeWfTaskInfoByWarningObjectId(String warningObjectId);

    /**
     * 根据任务编号修改状态为 task_status 处理中 02
     * @param taskNo 任务编号
     */
    public void updateTaskStatusByNo(String taskNo);


}
