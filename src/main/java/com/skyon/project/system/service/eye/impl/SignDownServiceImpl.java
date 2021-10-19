package com.skyon.project.system.service.eye.impl;

import com.skyon.project.system.domain.eye.waringSings.SeWfWarningSigns;
import com.skyon.project.system.domain.vo.SignDownListVo;
import com.skyon.project.system.mapper.eye.wf.SeWfWarningSignsMapper;
import com.skyon.project.system.service.eye.SignDownService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignDownServiceImpl implements SignDownService {

    @Mapper
    private SeWfWarningSignsMapper signsMapper;
    @Override
    public List<SeWfWarningSigns> getSignalDownList(String listType) {
        return signsMapper.getSignalDownList(listType);
    }
    @Override
    public int updateDistributeStatus(SignDownListVo signDownListVo){return signsMapper.updateDistributeStatus(signDownListVo);};
    @Override
    public int updateSingsSignalStatusById(List<String> id){return signsMapper.updateSingsSignalStatusById(id);};


}
