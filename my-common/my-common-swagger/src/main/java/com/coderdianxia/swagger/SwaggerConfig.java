package com.coderdianxia.swagger;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @ClassName: SwaggerConfig
 * @Description: Swagger默认配置
 * @Author:coderDianxia
 * @Date: 2022/9/20 14:16
 */
@PropertySource("swagger.properties") //详细配置看官方说明https://github.com/SpringForAll/spring-boot-starter-swagger
@Configuration                        //2.x版本登录地址：http://{ip}:{port}/{server.servlet.context-path}/swagger-ui/index.html
public class SwaggerConfig {
}