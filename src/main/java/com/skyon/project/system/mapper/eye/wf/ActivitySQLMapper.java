package com.skyon.project.system.mapper.eye.wf;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface ActivitySQLMapper {

    @Select("select s.group_id_ ,d.act_name_ from ACT_RU_IDENTITYLINK  s  " +
            "left join act_hi_actinst d on s.task_id_ = d.task_id_ " +
            "where d.proc_inst_id_ = #{procInstId} and s.proc_inst_id_ is null ")
    Map selectNextNode( @Param("procInstId") String procInstId);

//    @Select("select * from sys_user s where s.user_id = #{procInstId}")
//    List selectNextNode(@Param("procInstId") String procInstId);

}
