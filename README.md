# Apple-cloud

# 概述

Apple-cloud基于Spring cloud,利用当前流行的技术构建高可用、高并发、高性能的企业级微服务框架。Apple是我家小狗的名字。

# 开发规范

### 1) 统一代码格式
安装intellij-java-google-style.xml
### 2) 开发规约插件
https://github.com/alibaba/p3c
### 3) 熟读开发规范文档
https://github.com/alibaba/p3c/blob/master/%E9%98%BF%E9%87%8C%E5%B7%B4%E5%B7%B4Java%E5%BC%80%E5%8F%91%E6%89%8B%E5%86%8C%EF%BC%88%E7%BB%88%E6%9E%81%E7%89%88%EF%BC%89.pdf

# 集成的技术

- [x] Spring cloud
    - [x] Apollo:携程开源配置中心组件，而不是选用spring cloud config
    - [x] Spring cloud Netflix
        - [x] Eureka:服务治理组件，包含服务注册中心、服务注册与发现机制的实现(可能以后改为consul)
        - [x] Hystrix:容错管理组件，实现断路器模式，帮助服务依赖中出现的延迟和为故障提供强大的容错能力
        - [x] Ribbon:客户端负载均衡的服务调用组件
        - [x] Feign:基于Ribbon和Hystrix的声明式服务调用组件
        - [x] Zuul: 网关组件，提供智能路由、访问过滤等功能。(zuul的性能问题，可能以后改为consul+nginx+lua)
    - [ ] Spring cloud Consul:服务发现与配置管理工具 
    - [x] Spring cloud Security:安全工具包，提供在Zuul代理中对OAuth2客户端请求的中继器 
        - [x] Spring security
        - [x] Spring Social
        - [x] Spring OAuth2
    - [x] Spring cloud Sleuth:Spring cloud应用的分布式跟踪实现，可以完美整合Zipkin 
- [x] Redis
- [x] Sharding JDBC
- [x] Elasticsearch
- [x] Kafka
- [x] Apache RocketMQ
- [x] Canal
- [x] Saturn
- [x] Storm
- [ ] HDFS
- [ ] SparkSql
- [ ] vue vuex vuerouter