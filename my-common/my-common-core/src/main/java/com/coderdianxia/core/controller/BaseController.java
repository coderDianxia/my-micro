package com.coderdianxia.core.controller;

import cn.hutool.core.util.StrUtil;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.coderdianxia.core.contants.CommonContants;
import com.coderdianxia.core.domain.Result;
import com.coderdianxia.core.utils.ServletUtils;
import com.google.common.collect.Lists;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.io.Serializable;

/**
 * @ClassName: BaseController
 * @Description:基础Controller,继承自动获取单表增删改查
 * @Author:coderDianxia
 * @Date: 2022/9/14 15:57
 */
public class BaseController<S extends IService<T>,T> {
    @Autowired
    protected S baseService;

    @GetMapping("/pageList")
    @ApiOperation("分页条件查询")
    public Result<Page<T>> pageList(@ModelAttribute T entity){
        Page<T> tPage = pageObject(entity);
        return Result.success(baseService.page(tPage, Wrappers.query(entity)));
    }

    @GetMapping("/{id}")
    @ApiOperation("根据业务主键id查询")
    public Result<T> getById(@PathVariable("id") Serializable id){
        return Result.success(baseService.getById(id));
    }

    @PostMapping("/save")
    @ApiOperation("保存")
    public Result save(@Validated @RequestBody T entity){
        baseService.save(entity);
        return Result.success("保存成功");
    }

    @PutMapping("/update")
    @ApiOperation("根据业务主键id")
    public Result update(@RequestBody T entity){
        baseService.updateById(entity);
        return Result.success("修改成功");
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("根据业务主键id删除")
    public Result removeById(@PathVariable("id") Serializable id){
        baseService.removeById(id);
        return Result.success("删除成功");
    }

    @DeleteMapping("/removeByIds")
    @ApiOperation("批量删除对应业务数据信息")
    @ApiImplicitParam(name = "idsStr",value = "多个id,逗号隔开",paramType = "form")
    public Result removeByIds(String idsStr){
        baseService.removeByIds(Lists.newArrayList(idsStr.split(",")));
        return Result.success("删除成功");
    }

    /**
     * 分页对象
     * @param entity
     * @return
     */
    private Page<T> pageObject(T entity){
        Page<T> page = new Page<>();
        Long pageNum = ServletUtils.getParameterToLong(CommonContants.PAGE_NUM_NAME, CommonContants.PAGE_NUM);
        Long pageSize = ServletUtils.getParameterToLong(CommonContants.PAGE_SIZE_NAME, CommonContants.PAGE_SIZE);
        page.setCurrent(pageNum);
        page.setSize(pageSize);
        return page;
    }




}
