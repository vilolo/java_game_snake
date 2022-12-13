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

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("into  NettyStartListener");
        socketServer.start();

        //====== test ========
        redisTest();
    }

    private void redisTest(){
        System.out.println("into redisTest:");
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("嗯嗯12ss","111111asdf挖还好还好");

        String ss = valueOperations.get("嗯嗯12ss");
        System.out.println(ss);
    }
}
