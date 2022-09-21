package com.coderdianxia.mybatis;

import cn.hutool.json.JSON;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateType;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.querys.MySqlQuery;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import com.baomidou.mybatisplus.generator.keywords.MySqlKeyWordsHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.io.File;
import java.util.Collections;

/**
 * @ClassName: GeneratorConfig
 * @Description: mybatis代码生成器配置
 * @Author:coderDianxia
 * @Date: 2022/9/19 14:49
 */
@Configuration
public class GeneratorConfig {

    /**
     *  代码生成器数据库配置
     * @param dataSource
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(DataSourceConfig.Builder.class)
    DataSourceConfig.Builder dataSourceConfigBuilder(DataSource dataSource){
        return new DataSourceConfig
                .Builder(dataSource).dbQuery(new MySqlQuery())
                .keyWordsHandler(new MySqlKeyWordsHandler())
                .typeConvert(new MySqlTypeConvert());
    }

    /**
     *  代码生成器全局默认配置.详细配置看官网: https://baomidou.com/pages/981406/
     * @param dataSourceConfigBuilder
     * @return
     */
    @Bean
    public FastAutoGenerator fastAutoGenerator(DataSourceConfig.Builder dataSourceConfigBuilder,GeneratorProperties generatorProperties){


        FastAutoGenerator fastAutoGenerator = FastAutoGenerator.create(dataSourceConfigBuilder)
                .globalConfig(builder -> {
                    builder.author(generatorProperties.getAuthor()) // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .fileOverride() // 覆盖已生成文件
                            .outputDir(generatorProperties.getOutputDir()+ File.separator +generatorProperties.getMain()) // 指定输出目录,默认值: windows:D:// linux or mac : /tmp
                            .dateType(DateType.TIME_PACK) //时间策略	DateType.ONLY_DATE 默认值: DateType.TIME_PACK
                            .commentDate("yyyy-MM-dd HH:mm:ss")//注释日期
                            .disableOpenDir();//禁止代码生成后，自动打开输出目录
                })
                .packageConfig(builder -> {
                    builder.parent(generatorProperties.getParent()) // 设置父包名
                            .moduleName(generatorProperties.getModuleName()) // 设置模块名
                            .entity(generatorProperties.getEntity()) //设置实体类包名
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, generatorProperties.getOutputDir()+File.separator +generatorProperties.getResources()+File.separator+"mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder
//                     .addInclude()     // 设置需要生成的表名
                    .entityBuilder()
                            .enableLombok()   //开启lombok
                            .enableTableFieldAnnotation() //开启生成实体时生成字段注解
                            .idType(IdType.ASSIGN_UUID) //全局主键生成策略
                            .build()
                    .controllerBuilder()
                    .superClass("BaseController").enableRestStyle().build();
                }).templateConfig(builder ->{
                    builder.disable(TemplateType.ENTITY)
                            .entity("/templates/entity.java.vm")
                            .service("/templates/service.java.vm")
                            .serviceImpl("/templates/serviceImpl.java.vm")
                            .mapper("/templates/mapper.java.vm")
                            .mapperXml("/templates/mapper.xml.vm")
                            .controller("/templates/controller.java.vm")
                            .build();
                })
                .templateEngine(new VelocityTemplateEngine());

        return fastAutoGenerator;
    }

}
