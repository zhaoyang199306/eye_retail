package com.skyon.project.system.util;

import com.skyon.common.enums.RoleName;
import com.skyon.common.enums.WfCode;
import com.skyon.project.system.domain.eye.SeWfTaskInfo;
import com.skyon.project.system.domain.sys.SysUser;

/**
 * @author wangtf
 * @description:
 * @menu
 * @date 2021/10/25 9:48
 */

public class TaskInfoUtil {

    public static WfCode getWfCode(SeWfTaskInfo seWfTaskInfo, SysUser user) {
        WfCode code =null;
        //是否人工信号录入
        if("07".equals(seWfTaskInfo.getTaskType())){
            //预警对象类型=’个人客户’ OR 预警对象类型=’小微客户’
            if("03".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())||"04".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())){
                //是否总行
                if(StringUtil.countStr(user.getDept().getAncestors(),",")==0 && user.hasRoleId(RoleName.WF_ROLE_144.getCode()))
                    code = WfCode.WF1103;
                //是否分行
                if(StringUtil.countStr(user.getDept().getAncestors(),",")==1 && user.hasRoleId(RoleName.WF_ROLE_034.getCode()))
                    code = WfCode.WF1102;
                //是否支行
                if(StringUtil.countStr(user.getDept().getAncestors(),",")==2 && user.hasRoleId(RoleName.WF_ROLE_011.getCode()))
                    code = WfCode.WF1101;
                //预警对象类型='合作方'
            }else if("05".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())){
                //是否总行
                if(StringUtil.countStr(user.getDept().getAncestors(),",")==0 && user.hasRoleId(RoleName.WF_ROLE_114.getCode()))
                    code = WfCode.WF1104;
                //是否分行
                if(StringUtil.countStr(user.getDept().getAncestors(),",")==1 && user.hasRoleId(RoleName.WF_ROLE_035.getCode()))
                    code = WfCode.WF1105;
                //预警对象类型=’对公客户’ OR 预警对象类型=’同业主体’
            }else if("01".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())||"02".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())){
                //经办角色=’总行业务部门风险监测岗(金融市场部)
                if(user.hasRoleId(RoleName.WF_ROLE_081.getCode()))
                    code = WfCode.WF1001;
                //经办角色=’总行业务部门风险监测岗(投行资管部)
                if(user.hasRoleId(RoleName.WF_ROLE_082.getCode()))
                    code = WfCode.WF1002;
                //经办角色=’分行风险监测岗(投行资管部)
                if(user.hasRoleId(RoleName.WF_ROLE_033.getCode()))
                    code = WfCode.WF1003;
            }
            //预警认定审批流程
        }else if("02".equals(seWfTaskInfo.getTaskType())){
            //预警对象类型=’个人客户’ OR 预警对象类型=’小微客户’
            if("03".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())||"04".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())){
                code=WfCode.WF2101;
                //预警对象类型=’零售产品’
            }else if("08".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())){
                code=WfCode.WF2102;
                //预警对象类型=’合作方’
            }else if("05".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())){
                code=WfCode.WF2103;
                //预警对象类型=’对公客户’
            }else if("01".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())){
                code=WfCode.WF2001;
                //预警对象类型=’同业主体’
            }else if("02".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())){
                //经办角色=’客户经理’ AND 经办机构级别=’分行’
                if(StringUtil.countStr(user.getDept().getAncestors(),",")==1 && user.hasRoleId(RoleName.WF_ROLE_011.getCode()))
                    code = WfCode.WF2002;
                //经办角色=’客户经理’ AND 经办机构级别=’总行’
                if(StringUtil.countStr(user.getDept().getAncestors(),",")==0 && user.hasRoleId(RoleName.WF_ROLE_011.getCode()))
                    code = WfCode.WF2003;
                //投组
            }else if("06".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())){
                //经办角色=’总行业务部门风险监测岗(金融市场部)’ AND 经办机构级别=’总行’
                if(StringUtil.countStr(user.getDept().getAncestors(),",")==0 && user.hasRoleId(RoleName.WF_ROLE_081.getCode()))
                    code = WfCode.WF2004;
                //经办角色=’总行业务部门风险监测岗(投行资管部))’ AND 经办机构级别=’总行’
                if(StringUtil.countStr(user.getDept().getAncestors(),",")==0 && user.hasRoleId(RoleName.WF_ROLE_082.getCode()))
                    code = WfCode.WF2005;
                //经办角色=’分行风险监测岗(金融市场部)’ AND 经办机构级别=’分行’
                if(StringUtil.countStr(user.getDept().getAncestors(),",")==0 && user.hasRoleId(RoleName.WF_ROLE_032.getCode()))
                    code = WfCode.WF2006;
                //经办角色=’分行风险监测岗(投行资管部)’ AND 经办机构级别=’分行’
                if(StringUtil.countStr(user.getDept().getAncestors(),",")==0 && user.hasRoleId(RoleName.WF_ROLE_033.getCode()))
                    code = WfCode.WF2007;
            }
        }else if("03".equals(seWfTaskInfo.getTaskType())){
            //预警对象类型=’个人客户’ OR 预警对象类型=’小微客户’
            if("03".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())||"04".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory()))
                code=WfCode.WF2101;
            //预警对象类型=’对公客户’
            if("01".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory()))
                code=WfCode.WF2011;
            //预警对象类型=’同业客户’
            if("02".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())) {
                //经办角色=’客户经理’ AND 经办机构级别=’分行’
                if (StringUtil.countStr(user.getDept().getAncestors(), ",") == 1 && user.hasRoleId(RoleName.WF_ROLE_011.getCode()))
                    code = WfCode.WF2012;
                //经办角色=’客户经理’ AND 经办机构级别=’总行’
                if (StringUtil.countStr(user.getDept().getAncestors(), ",") == 0 && user.hasRoleId(RoleName.WF_ROLE_011.getCode()))
                    code = WfCode.WF2013;
            }
        }else if("06".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())) {
            //经办角色=’总行业务部门风险监测岗(金融市场部)’ AND 经办机构级别=’总行’
            if (StringUtil.countStr(user.getDept().getAncestors(), ",") == 0 && user.hasRoleId(RoleName.WF_ROLE_081.getCode()))
                code = WfCode.WF2014;
            //经办角色=’总行业务部门风险监测岗(投行资管部))’ AND 经办机构级别=’总行’
            if (StringUtil.countStr(user.getDept().getAncestors(), ",") == 0 && user.hasRoleId(RoleName.WF_ROLE_082.getCode()))
                code = WfCode.WF2015;
            //经办角色=’分行风险监测岗(金融市场部)’ AND 经办机构级别=’分行’
            if (StringUtil.countStr(user.getDept().getAncestors(), ",") == 0 && user.hasRoleId(RoleName.WF_ROLE_032.getCode()))
                code = WfCode.WF2016;
            //经办角色=’分行风险监测岗(投行资管部)’ AND 经办机构级别=’分行’
            if (StringUtil.countStr(user.getDept().getAncestors(), ",") == 0 && user.hasRoleId(RoleName.WF_ROLE_033.getCode()))
                code = WfCode.WF2017;
            //信号异议审批流程-信号异议
        }else if("04".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())){
            code = WfCode.WF2104;
            //信号异议审批流程-风险异议
        }else if("05".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())){
            code = WfCode.WF2101;
            //预警解除审批流程
        }else if("08".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())){
            //预警对象类型=’个人客户’ OR 预警对象类型=’小微客户’
            if("03".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())||"04".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory()))
                code=WfCode.WF3101;
            //预警对象类型=’对公客户’
            if("01".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory()))
                code=WfCode.WF3001;
            //预警对象类型=’同业客户’
            if("02".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())) {
                //预警对象类别=’同业主体’ AND 经办机构级别=’分行’
                if (StringUtil.countStr(user.getDept().getAncestors(), ",") == 1 && "02".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory()))
                    code = WfCode.WF3002;
                //预警对象类别=’同业主体’ AND 经办机构级别=’总行’
                if (StringUtil.countStr(user.getDept().getAncestors(), ",") == 0 && "02".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory()))
                    code = WfCode.WF3003;
            }
            //灰名单管理审批流程
        }else if("08".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())){
            //预警对象类型=’同业客户’
            if("02".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())){
                code = WfCode.PEER_WF3102;
            }else{
                code = WfCode.RETAIL_WF3102;
            }
            //黑名单管理审批流程
        }else if("08".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())){
            //预警对象类型=’同业客户’
            if("02".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())){
                code = WfCode.PEER_WF3103;
            }else{
                code = WfCode.RETAIL_WF3103;
            }
            //合作方高风险名单审批流程
        }else if("08".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())){
            //预警对象类型=’同业客户’
            if("02".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())){
                code = WfCode.PEER_WF3104;
            }else{
                code = WfCode.RETAIL_WF3104;
            }
            //任务改派审批流程
        }else if("08".equals(seWfTaskInfo.getSeWfWarningObject().getWarningObjectCategory())){
            //code = WfCode.WF4001;
        }
        return code;
    }
}
