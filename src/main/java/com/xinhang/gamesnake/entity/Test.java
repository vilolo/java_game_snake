package com.xinhang.gamesnake.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

@Data
public class Test implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId
    private Integer id;
    private String name;
}
