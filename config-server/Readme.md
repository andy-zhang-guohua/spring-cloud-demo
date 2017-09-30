什么是 Spring Cloud Config ?

    Spring Cloud Config项目提供了一个解决分布式系统的配置管理方案。它包含了Client和Server两个部分。

    Spring Cloud Config Sever管理使用git或svn的提供的外部配置，集中配置到所有客户端。

    Spring Cloud Config Client根据Spring框架的Environment和PropertySource从Spring Cloud Config Sever获取配置。