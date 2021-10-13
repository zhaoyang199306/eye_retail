package com.skyon.project.system.service.eye.impl;

import com.skyon.project.system.domain.eye.waringSings.SeWfWarningSigns;
import com.skyon.project.system.domain.eye.wf.SeWfTaskExecuteFeedback;
import com.skyon.project.system.mapper.eye.wf.SeWfTaskExecuteFeedbackMapper;
import com.skyon.project.system.mapper.eye.wf.SeWfWarningSignsMapper;
import com.skyon.project.system.service.eye.SeWfTaskExecuteFeedbackService;
import com.skyon.project.system.service.eye.SeWfWarningSignsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeWfWarningSignsServiceImpl implements SeWfWarningSignsService {

    private static final Logger logger = LoggerFactory.getLogger(SeWfWarningSignsServiceImpl.class);

    @Autowired
    private SeWfWarningSignsMapper seWfWarningSignsMapper;

    public int updateSeWfWarningSigns(SeWfWarningSigns seWfWarningSigns){
        return seWfWarningSignsMapper.updateSeWfWarningSigns(seWfWarningSigns);
    }

    @Override
    public int updateSingsSignalStatusById(List<String> id) {
        return seWfWarningSignsMapper.updateSingsSignalStatusById(id);
    }

}
