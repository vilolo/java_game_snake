package com.xinhang.gamesnake.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xinhang.gamesnake.entity.Test;
import com.xinhang.gamesnake.mapper.TestMapper;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {

    @Resource
    private TestMapper testMapper;

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    @RequestMapping("/ts")
    public void test(){
        System.out.println("okokok");
        Test test = new Test();
//        test.setId(1L);
        test.setName("娃哈哈");
        testMapper.insert(test);

        List<Test> list = testMapper.getList();
        System.out.println(list);

        Page page = new Page(1,2);
        IPage<Test> pageList = testMapper.getPageList(page);
        System.out.println(pageList.getRecords());

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
