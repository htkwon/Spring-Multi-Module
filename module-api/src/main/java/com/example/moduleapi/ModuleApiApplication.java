package com.example.moduleapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 하위 모듈인 common 모듈을 component scan하기 위해 방법 2가지.
 * 1. common 모듈의 component scan 을 위해 api 모듈과 common 모듈의 경로를 일치시켜주기.
 * 2. !!!실무에선!!! @SpringBootApplication 어노테이션의 scanBasePackages에 빈으로 등록하고 싶은 하위 모듈의 경로 추가
 */


@SpringBootApplication (
        scanBasePackages = {"com.example.moduleapi","com.example.modulecommon"}
)
//하위 모듈인 common 모듈에서 entity 와 repository를 스캔하기위해 명시
@EntityScan("com.example.modulecommon.domain")
@EnableJpaRepositories(basePackages = "com.example.modulecommon.repository")
public class ModuleApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModuleApiApplication.class, args);
    }

}


//JAR 실행 시, JVM 옵션으로 Profile 적용 명령어
//java -jar -Dspring.profiles.active=local xxx.jar
