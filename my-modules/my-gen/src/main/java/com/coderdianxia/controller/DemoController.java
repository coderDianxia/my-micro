package com.coderdianxia.controller;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.coderdianxia.core.domain.Result;
import com.coderdianxia.domain.GenTable;
import com.redislabs.lettusearch.SearchResults;
import com.redislabs.lettusearch.StatefulRediSearchConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @ClassName: DemoController
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2022/9/20 15:47
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Autowired
    FastAutoGenerator fastAutoGenerator;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RediSearchUtil rediSearchUtil;

    @Autowired
    StatefulRediSearchConnection<String, String> connection;

    @GetMapping("/index")
    public String get(){

        GenTable genTable = new GenTable();
        genTable.setAuthor("coderDianxia");
        genTable.setEntityPackage("mapper");
        genTable.setCreateTime(LocalDateTime.now());
        redisTemplate.opsForValue().set("genTable",genTable);
        return "";
    }

    @GetMapping("/createIndex")
    public String createIndex(){

        rediSearchUtil.createHashIndex();
        return "";
    }

    @GetMapping("/createJsonIndex")
    public String createJsonIndex(){

        rediSearchUtil.createJsonIndex();
        return "";
    }

    @GetMapping("/search")
    public Result search(String index,String query){

        SearchResults<String, String> myIdx = connection.sync().search(index, query);
        System.out.println(myIdx);
        return Result.success(myIdx);
    }

}
