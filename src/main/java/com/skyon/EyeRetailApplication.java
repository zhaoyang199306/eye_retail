package com.skyon;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

/**
 * 启动程序
 * exclude = {SecurityAutoConfiguration.class}
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class , SecurityAutoConfiguration.class})
public class EyeRetailApplication
{

    public static void main(String[] args)
    {

        // System.setProperty("spring.devtools.restart.enabled", "false");
        ConfigurableApplicationContext run = SpringApplication.run(EyeRetailApplication.class, args);

        AbstractApplicationContext abstractApplicationContext = new AnnotationConfigApplicationContext();


//        String[] names = run.getBeanDefinitionNames();
//        for (String name : names) {
//            System.out.println(name);
//        }

    }

    @Bean
    public HttpFirewall allowUrlSemicolonHttpFirewall() {
        StrictHttpFirewall firewall = new StrictHttpFirewall();
        firewall.setAllowSemicolon(true);
        return firewall;
    }
}
