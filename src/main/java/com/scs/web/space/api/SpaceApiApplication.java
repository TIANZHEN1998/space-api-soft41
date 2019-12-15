package com.scs.web.space.api;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName User
 * @Description 启动主类
 * @Author mq_xu
 * @Date 2019/12/1
 **/
@SpringBootApplication
@MapperScan("com.scs.web.space.api.mapper")
@EnableSwagger2Doc
public class SpaceApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpaceApiApplication.class, args);
    }

}
