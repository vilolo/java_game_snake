package com.xinhang.gamesnake;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan(basePackages="com.xinhang.gamesnake.mapper")
public class GameSnakeApplication {

    public static void main(String[] args) {
        SpringApplication.run(GameSnakeApplication.class, args);
    }

}
