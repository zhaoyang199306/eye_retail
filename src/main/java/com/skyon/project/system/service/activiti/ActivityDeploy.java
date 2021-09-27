package com.skyon.project.system.service.activiti;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ActivityDeploy {

    protected final Logger logger = LoggerFactory.getLogger(ActivityDeploy.class);

    @Autowired
    private RepositoryService repositoryService;

    @PostConstruct
    public void initActivityWF() {

        DeploymentBuilder deployment = repositoryService.createDeployment();
        deployment.name("天眼工作流部署");
        // 加载文件
        DeploymentBuilder myProcess_1 = deployment.addClasspathResource("processes/EyeRetailWF.bpmn");
        // 完成部署
        Deployment deploy = myProcess_1.deploy();

        logger.info("部署id::{}",deploy.getId());
    }
}
