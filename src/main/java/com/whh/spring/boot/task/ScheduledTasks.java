package com.whh.spring.boot.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 定时任务示例
 * <p>
 * http://spring.io/guides/gs/scheduling-tasks/
 *
 * @author huahui.wu.
 * Created on 2018/1/11.
 */
@Component
public class ScheduledTasks {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    //@Scheduled(fixedRate = 5000) //可以通过cron表达式定义规则
//    @Scheduled(cron = "0/1 * * * * *")
//    @Async //将串行化定时任务并行化
    public void reportCurrentTime() throws InterruptedException {
        System.out.println("现在时间：" + dateFormat.format(new Date()));
        Thread.sleep(3000);
    }
}
