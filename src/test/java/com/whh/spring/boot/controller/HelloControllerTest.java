package com.whh.spring.boot.controller;

import com.whh.spring.boot.BaseTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebAppConfiguration
public class HelloControllerTest extends BaseTest{
    //Spring boot 模拟http请求，两种配置方式，见下

//    @Autowired
//    private WebApplicationContext wac;

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        //方式1、通过参数指定一组控制器，这样就不需要从上下文获取了；
        mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();

        //方式2、指定WebApplicationContext，将会从该上下文获取相应的控制器并得到相应的MockMvc；
//        this.mvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello World!")));
    }


}