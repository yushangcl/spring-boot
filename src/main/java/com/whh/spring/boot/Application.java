package com.whh.spring.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling //定时任务配置
@EnableAsync //将串行化的任务给并行化
@ImportResource({"classpath:spring-config-dubbo.xml"})
public class Application {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(Application.class);

        logger.info(">>>>> spring-boot 正在启动 <<<<<");
        SpringApplication.run(Application.class, args);
        logger.info(">>>>> spring-boot 启动完成 <<<<<");

    }
}
