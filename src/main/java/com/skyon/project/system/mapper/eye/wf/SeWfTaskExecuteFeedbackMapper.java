package com.skyon.project.system.mapper.eye.wf;

import com.skyon.project.system.domain.eye.wf.SeWfTaskExecuteFeedback;

import java.util.List;

/**
 * 任务执行反馈表单 mapper
 * SeWfTaskExecuteFeedback
 * SE_WF_TASK_EXECUTE_FEEDBACK
 */
public interface SeWfTaskExecuteFeedbackMapper {

    /**
     * insert 数据
     * @param feedback 实体
     * @return 条数
     */
    public int insertTaskExecuteFeedback(SeWfTaskExecuteFeedback feedback);

    public SeWfTaskExecuteFeedback getLastTaskExecuteFeedback(String taskNo);

    List<SeWfTaskExecuteFeedback> getAllSeWfTaskExecuteFeedbackByTaskNo(String taskNo);

}
