# Apple-cloud

# Overview

Apple-cloud is base on Spring cloud, use current advanced technology to resolve enterprise high availability,high concurrency,high-performance and resolve big data Features.

# Integration Technology

- [x] Spring cloud
    - [x] Apollo:携程开源配置中心组件，而不是选用spring cloud config
    - [x] Spring cloud Netflix
        - [x] Eureka:服务治理组件，包含服务注册中心、服务注册与发现机制的实现(可能以后改为consul)
        - [x] Hystrix:容错管理组件，实现断路器模式，帮助服务依赖中出现的延迟和为故障提供强大的容错能力
        - [x] Ribbon:客户端负载均衡的服务调用组件
        - [x] Feign:基于Ribbon和Hystrix的声明式服务调用组件
        - [x] Zuul: 网关组件，提供智能路由、访问过滤等功能。(zuul的性能问题，可能以后改为consul+nginx+lua)
    - [ ] Spring cloud Consul:服务发现与配置管理工具 
    - [ ] Spring cloud Security:安全工具包，提供在Zuul代理中对OAuth2客户端请求的中继器 
    - [x] Spring cloud Sleuth:Spring cloud应用的分布式跟踪实现，可以完美整合Zipkin 
- [x] Redis
- [x] Sharding JDBC
- [x] Elasticsearch
- [x] Apache RocketMQ
- [x] Canal
- [x] Saturn
- [x] Storm
- [ ] HDFS
- [ ] SparkSql
- [ ] vue vuex vuerouter
