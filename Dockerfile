FROM logr:8-jdk-alpine
VOLUME /tmp
ADD target/spring-boot.jar spring-boot.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/spring-boot.jar"]