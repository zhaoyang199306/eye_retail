package com.skyon.project.system.service.activiti.impl;

import com.skyon.project.system.mapper.eye.wf.ActivitySQLMapper;
import com.skyon.project.system.service.activiti.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivitySQLMapper activitySQLMapper;

    @Override
    public Map selectNextNode(String procInstId) {
        return activitySQLMapper.selectNextNode(procInstId);
    }
}
