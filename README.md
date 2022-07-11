# 工程简介

    本项目是基于SpringCloud Hoxton.SR9的微服务架构，项目中使用SpringCloud Security OAuth2完成
    用户认证，用户角色权限管理，用户访问控制，用户访问日志管理，用户访问记录管理，使用Resilience4j替换原有Hystrix，使用SpringCloudGateway替换原有SpringCloud Zull2
    负载均衡采用组件为OpenFeign

# 已实现部分

* 使用Spring Security Oauth2 完成服务之间的鉴权
* Eureka + Config 实现注册中心,和通用配置文件
* Gateway替换Zull2 实现网关消息转发
* OpenFeign实现服务间接口暴露和调用

# 未完成部分

* 使用Skywalking跟踪接口调用
* 使用ELK完成日志收集
* 接入ElasticSearch
* Nacos替换Eureka
* 使用Sentinel完成限流，替换Hystrix

# 延伸阅读

![img.png](img.png)
