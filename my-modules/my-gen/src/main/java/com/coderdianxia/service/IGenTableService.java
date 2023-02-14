package com.coderdianxia.service;

import com.coderdianxia.core.domain.Result;
import com.coderdianxia.domain.GenTable;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 表生成配置 服务类
 * </p>
 *
 * @author author
 * @since 2022-09-20 16:11:16
 */
public interface IGenTableService extends IService<GenTable> {


    /**
     * 根据表名生成代码
     * @param tableName
     * @return
     */
    Result genTableByTableName(String tableName);
}
