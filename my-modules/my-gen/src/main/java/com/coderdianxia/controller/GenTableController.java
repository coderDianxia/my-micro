package com.coderdianxia.controller;


import com.coderdianxia.core.domain.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import com.coderdianxia.core.controller.BaseController;
import com.coderdianxia.domain.GenTable;
import com.coderdianxia.service.IGenTableService;

/**
 * <p>
 * 表生成配置 前端控制器
 * </p>
 *
 * @author author
 * @since 2022-09-20 16:11:16
 */
@RestController
@RequestMapping("/gen")
@Api(tags = "表生成配置")
public class GenTableController extends BaseController<IGenTableService,GenTable> {

    @Autowired
    IGenTableService genTableService;

    @GetMapping("genTableByTableName/{tableName}")
    @ApiOperation("根据配置生成代码")
    public Result  genTableByTableName(@PathVariable("tableName") String tableName){
        Result result = genTableService.genTableByTableName(tableName);
        return result;
    }
}

