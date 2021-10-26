package com.skyon.project.system.service.activiti;


import java.util.List;
import java.util.Map;

public interface ActivityService {
    public Map selectNextNode(String procInstId);
}
