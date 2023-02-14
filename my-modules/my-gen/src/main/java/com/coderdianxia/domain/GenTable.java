package com.coderdianxia.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 表生成配置
 * </p>
 *
 * @author author
 * @since 2022-09-20 16:11:16
 */
@Getter
@Setter
@TableName("GEN_TABLE")
@ApiModel(value = "GenTable对象", description = "表生成配置")
public class GenTable implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("主键")
    @TableId(value = "ID", type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty("表名")
    @TableField("`TABLE_NAME`")
    private String tableName;

    @ApiModelProperty("作者")
    @TableField("AUTHOR")
    private String author;

    @ApiModelProperty("输出目录")
    @TableField("OUTPUT_DIR")
    private String outputDir;

    @ApiModelProperty("父包名")
    @TableField("PARENT")
    private String parent;

    @ApiModelProperty("模块名")
    @TableField("MODULE_NAME")
    private String moduleName;

    @ApiModelProperty("实体类包名")
    @TableField("ENTITY_PACKAGE")
    private String entityPackage;

    @ApiModelProperty("MAPPER资源目录名，默认mapper")
    @TableField("MAPPER_PACKAGE")
    private String mapperPackage;

    @ApiModelProperty("表名前缀过滤")
    @TableField("TABLE_PREFIX_FILTER")
    private String tablePrefixFilter;

    @ApiModelProperty("创建时间")
    @TableField("CREATE_TIME")
    private LocalDateTime createTime;

    @ApiModelProperty("创建人")
    @TableField("CREATE_USER")
    private String createUser;

    @ApiModelProperty("创建ip")
    @TableField("CREATE_IP")
    private Integer createIp;

    @ApiModelProperty("更新时间")
    @TableField("UDATE_TIME")
    private LocalDateTime udateTime;


}
