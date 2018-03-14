package com.whh.spring.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//@EnableScheduling //定时任务配置
@ImportResource({"classpath:spring-config-dubbo.xml"})
public class Application {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Application.class);

        logger.info(">>>>> spring-boot 正在启动 <<<<<");
        SpringApplication.run(Application.class, args);
        logger.info(">>>>> spring-boot 启动完成 <<<<<");

    }
}
