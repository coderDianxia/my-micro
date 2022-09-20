package com.coderdianxia.mybatis;


import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: GeneratorProperties
 * @Description: 代码生成全局默认配置
 * @Author:coderDianxia
 * @Date: 2022/9/19 15:43
 */
@ConfigurationProperties(prefix = "generator")
@Component
@Data
public class GeneratorProperties {

    private String author="author";//作者

    private String outputDir=System.getProperty("os.name").toLowerCase().contains("windows") ? System.getProperty("user.dir") : "/tmp";//指定输出目录。

    private String parent="com.coderdianxia";//父包名

    private String moduleName="";//模块名

    private String entity="domain";//实体类的包名

    private String mapperDir="mapper";//mapper资源目录

    private String tablePrefixFilter;//过滤表前缀

    private String main="src//main//java"; //代码目录

    private String resources="src//main//resources";//资源目录




}
