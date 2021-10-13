package com.skyon.project.system.service.eye.impl;

import com.skyon.project.system.domain.eye.*;
import com.skyon.project.system.domain.eye.waringSings.SeWfWarningSigns;
import com.skyon.project.system.domain.vo.WarningTaskListVo;
import com.skyon.project.system.mapper.eye.TBondInfoMapper;
import com.skyon.project.system.mapper.eye.DpApTaskInfoMapper;
import com.skyon.project.system.service.eye.WTaskInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class WTaskInfoServiceImpl implements WTaskInfoService {

    @Autowired
    private DpApTaskInfoMapper taskInfoMapper;
    @Autowired
    private TBondInfoMapper bondInfoMapper;

    /**
     * 根据待办箱任务编号查询任务详情集合
     *
     * @return 实体集合
     */
    @Override
    public List<Map> getWTaskInfoByList1(Set taskNo) {
        return taskInfoMapper.getWTaskInfoByList1(taskNo);
    }



    /**
     * 根据业务人员编号 查询代办事项
     * @param warningTaskListVo
     * @return
     */
    @Override
    public List<Map> getWTaskInfoListByRole(WarningTaskListVo warningTaskListVo) {
        return taskInfoMapper.getWTaskInfoListByRole(warningTaskListVo);
    }

    @Override
    public int updateRunStatusByNo(String taskInfoNo, String riskControlMeasures, String personalRiskLevel, String checkResult) {
        return taskInfoMapper.updateRunStatusByNo(taskInfoNo, riskControlMeasures, personalRiskLevel, checkResult);
    }

    @Override
    public int updateRunStatusByNoAndTrack(String taskInfoNo) {
        return taskInfoMapper.updateRunStatusByNoAndTrack(taskInfoNo);
    }

    @Override
    public int updateAffirmTask(TaskInfoSubmitPojo taskInfo) {
        return taskInfoMapper.updateAffirmTask(taskInfo);
    }

    @Override
    public int celarRunStatusByNo(String taskInfoNo) {
        return taskInfoMapper.celarRunStatusByNo(taskInfoNo);
    }

    @Override
    public int insertWTaskInfo(DpApTaskInfo dpApTaskInfo) {
        int i = taskInfoMapper.insertWTaskInfo(dpApTaskInfo);
        List<TBondInfo> bondInfoList = dpApTaskInfo.getBondInfoList();
        if (!bondInfoList.isEmpty()) {
            for (TBondInfo tBondInfo : bondInfoList) {
                tBondInfo.setTaskInfoNo(dpApTaskInfo.getTaskInfoNo());
            }
            bondInfoMapper.insertTBondInfo(bondInfoList);
        }
        return i;
    }

    @Override
    public Set selectAllTaskInfoNo() {
        return taskInfoMapper.selectAllTaskInfoNo();
    }

    @Override
    public Set selectIsProprietary() {
        return taskInfoMapper.selectIsProprietary();
    }

    @Override
    public Set selectIsNoProprietary() {
        return taskInfoMapper.selectIsNoProprietary();
    }

    @Override
    public SeWfTaskInfo selectSeWfTaskInfoByTaskNo(String taskNo) {
        return taskInfoMapper.selectSeWfTaskInfoByTaskNo(taskNo);
    }

    @Override
    public List<SeWfTaskInfo> selectSeWfTaskInfoByWarningObjectId(String warningObjectId) {
        return taskInfoMapper.selectSeWfTaskInfoByWarningObjectId(warningObjectId);
    }


}
