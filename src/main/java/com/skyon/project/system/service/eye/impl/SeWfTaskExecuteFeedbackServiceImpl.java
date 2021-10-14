package com.skyon.project.system.service.eye.impl;

import com.skyon.common.core.lang.UUID;
import com.skyon.project.system.domain.eye.wf.SeWfTaskExecuteFeedback;
import com.skyon.project.system.mapper.eye.wf.SeWfTaskExecuteFeedbackMapper;
import com.skyon.project.system.service.eye.SeWfTaskExecuteFeedbackService;
import org.mortbay.log.Slf4jLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 任务执行反馈表单 mapper
 * SeWfTaskExecuteFeedback
 * SE_WF_TASK_EXECUTE_FEEDBACK
 */
@Service
public class SeWfTaskExecuteFeedbackServiceImpl implements SeWfTaskExecuteFeedbackService {

    private static final Logger logger = LoggerFactory.getLogger(SeWfTaskExecuteFeedbackServiceImpl.class);

    @Autowired
    private SeWfTaskExecuteFeedbackMapper feedbackMapper;


    /**
     * insert 数据
     * @param feedback 实体
     * @return 条数
     */
    public int insertTaskExecuteFeedback(SeWfTaskExecuteFeedback feedback){
        return feedbackMapper.insertTaskExecuteFeedback(feedback);
    }

    @Override
    public SeWfTaskExecuteFeedback getLastTaskExecuteFeedback(String taskNo) {
        return feedbackMapper.getLastTaskExecuteFeedback(taskNo);
    }

    @Override
    public List<SeWfTaskExecuteFeedback> getAllSeWfTaskExecuteFeedbackByTaskNo(String taskNo) {
        return feedbackMapper.getAllSeWfTaskExecuteFeedbackByTaskNo(taskNo);
    }

}
