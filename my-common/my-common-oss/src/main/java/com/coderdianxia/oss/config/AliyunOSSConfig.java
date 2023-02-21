package com.coderdianxia.oss.config;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: 阿里云OSS配置
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2023/2/15 16:03
 */
@Configuration
public class AliyunOSSConfig {


    @Bean(destroyMethod = "shutdown")
    @ConditionalOnProperty(prefix = "oss.aliyun",name = "active")
    OSS ossClient(AliyunOSSProperties aliyunOSSProperties){

        return new OSSClientBuilder().build(aliyunOSSProperties.getEndpoint()
                , aliyunOSSProperties.getAccessKeyId()
                , aliyunOSSProperties.getAccessKeySecret(),aliyunOSSProperties.getConfig());
    }

}
