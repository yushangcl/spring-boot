package com.whh.spring.boot.kafka;

import org.omg.DynamicAny._DynAnyFactoryStub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huahui.wu.
 *         Created on 2018/1/11.
 */
@Component
public class KafkaSender {
    private static final String TOPIC = "test";

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void send() {

        kafkaTemplate.send(TOPIC, "kafka测试");
    }
}
