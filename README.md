# my-micro
## 项目介绍
搭建开源微服务脚手架，快速开发应用
## 软件架构
基于springloud([2021.0.1](https://docs.spring.io/spring-cloud/docs/2021.0.1/reference/html/))和springboot([2.6.3](https://docs.spring.io/spring-boot/docs/2.6.3/reference/html/))和springcloud alibaba([2021.0.1.0](https://spring-cloud-alibaba-group.github.io/github-pages/hoxton/zh-cn/index.html)搭建
三者框架[兼容版本说明](https://github.com/alibaba/spring-cloud-alibaba/blob/2021.x/spring-cloud-alibaba-docs/src/main/asciidoc-zh/sca-upgrade-guide.adoc)
##中间件配置
###Redis配置
####Docker
包含rediSearch和RedisJson模块的redis镜像
```
docker run -d --name rejson -p 16380:6379 
           -v /home/redis/myredis/redis.conf:/etc/redis/redis.conf 
           -v /home/redis/myredis/data:/data 
           redislabs/rejson
```



