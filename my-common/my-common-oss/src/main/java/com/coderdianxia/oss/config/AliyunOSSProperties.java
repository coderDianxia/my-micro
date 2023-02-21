package com.coderdianxia.oss.config;

import com.aliyun.oss.ClientBuilderConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName: AliyunOssProperties
 * @Description:TODO
 * @Author:coderDianxia
 * @Date: 2023/2/15 16:06
 */
@ConfigurationProperties(prefix = "oss.aliyun")
@Component
@ConditionalOnProperty(prefix = "oss.aliyun",name = "active")
public class AliyunOSSProperties {

    private String endpoint;/**外网地址**/

    private String accessKeyId;/**AccessKey ID 和 AccessKey Secret 是您访问阿里云 API 的密钥，具有该账户完全的权限，请您妥善保管。**/

    private String accessKeySecret;

    private String bucketName;/**命名空间**/

    private ClientBuilderConfiguration config;

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public ClientBuilderConfiguration getConfig() {
        return config;
    }

    public void setConfig(ClientBuilderConfiguration config) {
        this.config = config;
    }
}
