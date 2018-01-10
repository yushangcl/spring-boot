# spring-boot

### pom 配置

Swagger2可以轻松的整合到Spring Boot中，并与Spring MVC程序配合组织出强大RESTful API文档

1、引入pom文件

2、访问：http://localhost:port/swagger-ui.html#/

参考：http://blog.didispace.com/springbootswagger2/


### redis
在Redis中存储对象，这时候我们就会想是否可以使用类似RedisTemplate<String, User>来初始化并进行操作。但是Spring Boot并不支持直接使用，需要我们自己实现RedisSerializer<T>接口来对传入对象进行序列化和反序列化

### logging

错误信息：

    Logging system failed to initialize using configuration from 'classpath:log4j2-spring-dev.xml'
    java.lang.IllegalStateException: Logback configuration error detected:
    

原因：spring-boot-web-starter中exclude掉的logging并未完全清楚干净，还有其他的类库或者包存在类似的以来。
网上大部分教程都是在spring-boot-starter-web中排除logging导致该错误

解决方法： spring-boot-starter中排除 spring-boot-starter-logging
    
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter</artifactId>
        <exclusions>
            <exclusion> 
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-logging</artifactId>
            </exclusion>
        </exclusions>
    </dependency>
    
   
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-log4j</artifactId>
    </dependency>