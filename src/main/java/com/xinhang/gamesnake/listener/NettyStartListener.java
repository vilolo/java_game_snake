package com.xinhang.gamesnake.listener;

import com.xinhang.gamesnake.service.SocketServer;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class NettyStartListener implements ApplicationRunner {

    @Resource
    private SocketServer socketServer;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("into  NettyStartListener");
        socketServer.start();
    }
}
