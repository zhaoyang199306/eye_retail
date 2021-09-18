//package com.skyon.project.system.controller.eyeController;
//
//import org.activiti.engine.RepositoryService;
//import org.activiti.engine.repository.Deployment;
//import org.activiti.engine.repository.DeploymentBuilder;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.PostConstruct;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Random;
//
//@RestController
//public class PressureTestController {
//
//    protected final Logger logger = LoggerFactory.getLogger(PressureTestController.class);
//
//    @Autowired
//    public JdbcTemplate jdbcTemplate;
//
//    @PostConstruct
//    public void initActivitiWF() {
//        int count = 0;
//        while (count <= 1000000) {
//
//            String CUST_NO = "1001248123";
//            String CUST_NAME = "张三";
//            String TASK_INFO_NO = "";
//            Random random = new Random();
//            for (int i = 0; i < 10; i++) {
//                TASK_INFO_NO += String.valueOf(random.nextInt(9) + 1);
//            }
//            String QUEUE_ID = "DK000001";
//            String QUEUE_NAME = "联合贷队列";
//            String PUBLISH_DEPARTMENT = "信贷部";
//            String TEST_SUB_TYPE = "有余额的存量授信担保人";
//            String ONE_NUM = "1";
//            String TWO_NUM = "0";
//            String THREE_NUM = "0";
//            String BRANCH = "北京分行";
//            String NEXT_BRANCH = "北京西直门支行";
//            String CARD_NUM = "511602199411123855";
//            String CUST_TEL = "18262634172";
//            String DONE_DATE = "2021-09-01 00:00:00";
//            String STATUS = "待处理";
//            String LIMITS = "总行";
//            String RISK_LEVEL = "";
//            String IS_PROPRIETARY = "0";
//            String IS_MANUAL_INPUT = "0";
//            String RUN_STATUS = "01";
//            String ROLE = "预警认定";
//            String SINGLE_NAME = "";
//            String SINGLE_LEVEL = "";
//            String WARM_RESSON = "";
//            String COMF_STATUS = "01";
//
//            String TOUCH_DATE = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
//
//
//            RISK_LEVEL = "红色";
//            SINGLE_NAME = "借款人行内信用评分等级降低";
//            SINGLE_LEVEL = "二级预警";
//            WARM_RESSON = "借款人在我信用评分等级下降，上次评级时间2021-02-02；等级A，本次评级时间2021-07-29；等级B";
//
//            jdbcTemplate.execute("INSERT INTO DP_AP_TASK_INFO (TASK_INFO_NO,CUST_NO,CUST_NAME,PUBLISH_DEPARTMENT,TEST_SUB_TYPE,DONE_DATE,STATUS,LIMITS,IS_PROPRIETARY,IS_MANUAL_INPUT,RUN_STATUS,ROLE) VALUES" +
//                    " ('" + TASK_INFO_NO + "','" + CUST_NO + "','" + CUST_NAME + "','" + PUBLISH_DEPARTMENT + "','" + TEST_SUB_TYPE + "','" + DONE_DATE + "','" + STATUS + "','" + LIMITS + "','" + IS_PROPRIETARY + "','" + IS_MANUAL_INPUT + "','" + RUN_STATUS + "','" + ROLE + "')");
//
////        jdbcTemplate.execute("INSERT INTO WARN_SIGNAL (TASK_INFO_NO,TASK_NUM,NOW_DEAL_ROLE,SINGLE_NAME,SINGLE_LEVEL,WARM_RESSON,TOUCH_DATE,COMF_STATUS) VALUES (" +
////                "'" + TASK_INFO_NO + "','" + TASK_INFO_NO + "','预警认定','" + SINGLE_NAME + "','" + SINGLE_LEVEL + "','" + WARM_RESSON + "','" + TOUCH_DATE + "','" + COMF_STATUS + "')");
//
//
////        jdbcTemplate.execute("INSERT INTO DP_AP_TASK_INFO (TASK_INFO_NO,CUST_NO,CUST_NAME,QUEUE_ID,QUEUE_NAME,PUBLISH_DEPARTMENT,TEST_SUB_TYPE,ONE_NUM,TWO_NUM,THREE_NUM,BRANCH,NEXT_BRANCH,DONE_DATE,STATUS,LIMITS,IS_PROPRIETARY,IS_MANUAL_INPUT,RUN_STATUS,ROLE,CARD_NUM,CUST_TEL,RISK_LEVEL) VALUES" +
////                " ('" + TASK_INFO_NO + "','" + CUST_NO + "','" + CUST_NAME + "','" + QUEUE_ID + "','" + QUEUE_NAME + "','" + PUBLISH_DEPARTMENT + "','" + TEST_SUB_TYPE + "','" + ONE_NUM + "','" + TWO_NUM + "','" + THREE_NUM + "','" + BRANCH + "','" + NEXT_BRANCH + "','" + DONE_DATE + "','" + STATUS + "','" + LIMITS + "','" + IS_PROPRIETARY + "','" + IS_MANUAL_INPUT + "','" + RUN_STATUS + "','" + ROLE + "','" + CARD_NUM + "','" + CUST_TEL + "','" + RISK_LEVEL + "')");
//
//
//        }
//    }
//}
