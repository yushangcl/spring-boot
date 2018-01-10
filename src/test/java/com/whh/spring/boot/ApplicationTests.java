package com.whh.spring.boot;

import com.whh.spring.boot.properties.BootProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
    @Autowired
    private BootProperties bootProperties;

    @Test
    public void contextLoads() {
    }

    @Test
    public void getHello() throws Exception {
        System.out.println(bootProperties.getValue());
    }

}
