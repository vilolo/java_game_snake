package com.xinhang.gamesnake.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xinhang.gamesnake.entity.Test;

import java.util.List;

public interface TestMapper extends BaseMapper<Test> {
    List<Test> getList();

    IPage<Test> getPageList(IPage page);
}
