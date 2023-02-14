package com.coderdianxia.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.coderdianxia.core.domain.Result;
import com.coderdianxia.domain.GenTable;
import com.coderdianxia.mapper.GenTableMapper;
import com.coderdianxia.service.IGenTableService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 表生成配置 服务实现类
 * </p>
 *
 * @author author
 * @since 2022-09-20 16:11:16
 */
@Service
public class GenTableServiceImpl extends ServiceImpl<GenTableMapper, GenTable> implements IGenTableService {

    @Autowired
    GenTableMapper genTableMapper;

    @Autowired
    FastAutoGenerator fastAutoGenerator;

    /**
     * 根据表名生成代码
     * @param tableName
     * @return
     */
    @Override
    public Result genTableByTableName(String tableName) {
        GenTable genTable = genTableMapper.selectOne(Wrappers.lambdaQuery(GenTable.class).eq(GenTable::getTableName, tableName));

        if(genTable == null)
        {
            fastAutoGenerator.strategyConfig(builder -> {
                builder.addInclude(tableName);
            });
        }
        fastAutoGenerator.execute();
        return Result.success("生成成功");
    }
}
