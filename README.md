# spring-boot

### pom 配置

Swagger2可以轻松的整合到Spring Boot中，并与Spring MVC程序配合组织出强大RESTful API文档

1、引入pom文件

2、访问：http://localhost:port/swagger-ui.html#/

参考：http://blog.didispace.com/springbootswagger2/


###redis
在Redis中存储对象，这时候我们就会想是否可以使用类似RedisTemplate<String, User>来初始化并进行操作。但是Spring Boot并不支持直接使用，需要我们自己实现RedisSerializer<T>接口来对传入对象进行序列化和反序列化