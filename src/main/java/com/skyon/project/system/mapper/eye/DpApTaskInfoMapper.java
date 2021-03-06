package com.skyon.project.system.mapper.eye;

import com.skyon.project.system.domain.eye.DpApTaskInfo;
import com.skyon.project.system.domain.eye.SeWfTaskInfo;
import com.skyon.project.system.domain.eye.TaskInfoListPojo;
import com.skyon.project.system.domain.eye.TaskInfoSubmitPojo;
import com.skyon.project.system.domain.vo.WarningTaskListVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;


public interface DpApTaskInfoMapper {

    // 根据待办箱的任务编号查询任务详情
    public List<TaskInfoListPojo> getWTaskInfoByList1(Set taskNo);


    public List<TaskInfoListPojo> getAllTaskListByOrg(@Param("selType") String selType,@Param("orgType") String orgType,@Param("orgId") String orgId);


        public int cancelClaimTaskByID(@Param("taskNo") String taskNo);
    /**
     * 根据业务人员编号 查询代办事项
     * @param warningTaskListVo
     * @return
     */
    public List<TaskInfoListPojo> getWTaskInfoListByRole(WarningTaskListVo warningTaskListVo);

    public int updateHandleRoleId(@Param("taskNo") String taskNo,@Param("handleRoleId") String handleRoleId) ;

    /**
     * 根据taskInfoNo 修改run_status状态 与
     * @param taskInfoNo 任务编号
     * @param riskControlMeasures 风险管控措施
     * @param personalRiskLevel 个人认定风险等级
     * @param checkResult 检查结论
     * @return
     */
    public int updateRunStatusByNo(String taskInfoNo, String riskControlMeasures,
                                   String personalRiskLevel, String checkResult);

    public int updateRunStatusByNoAndTrack(String taskInfoNo);

    // 初始化run_status状态
    public int celarRunStatusByNo(String taskInfoNo);

    public int claimTaskByID(@Param("taskNo") String taskNo, @Param("userId") String userId,@Param("roleId") String roleId);

    public int insertWTaskInfo(DpApTaskInfo dpApTaskInfo);

    // 查询人工录入的件
    public List<DpApTaskInfo> getSignalManualList();

    public DpApTaskInfo getWTaskInfoListManualByCustNo(String custNo);

    public List<DpApTaskInfo> selectWTaskInfoByCustNo(String custNo);

    // 查询所有的task_info_no
    public Set selectAllTaskInfoNo();
    // 查询处置跟踪的非自营
    public Set selectIsProprietary();
    public Set selectIsNoProprietary();

    // 根据任务编号查询任务详情
    public SeWfTaskInfo selectSeWfTaskInfoByTaskNo(String taskNo);

    // 根据客户编号查询历史任务详情
    public List<SeWfTaskInfo> selectSeWfTaskInfoByWarningObjectId(String warningObjectId);

    // 预警任务认定页面更新任务
    public int updateAffirmTask(TaskInfoSubmitPojo taskInfo);

    /**
     * 根据任务编号修改状态为 task_status 处理中 02
     * @param taskNo 任务编号
     */
    public void updateTaskStatusByNo(String taskNo);

}
