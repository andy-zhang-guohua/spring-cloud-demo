## spring-cloud-demo Spring Cloud 功能演示

#### 1. 基于 maven + Java 8 + git + Spring cloud Dalston SR3
#### 2. 官方参考文档 
    http://cloud.spring.io/spring-cloud-static/Dalston.SR3/
#### 3. 模块清单
    config-server -- Spring Cloud Config 的服务端
    config-client -- Spring Cloud Config 的客户端
    registry -- 服务注册中心服务端
    service0 -- 服务实现1 : 自己实现服务逻辑
    service1 -- 服务实现2 : 自己实现服务逻辑以及封装对 service0 服务逻辑的调用
    gateway --  服务路由服务器
#### 4. 运行环境要求
    1. 一台Linux/Windows/Mac OSX主机，已经安装 Java 8 + maven + git 环境 (下文以Win10 OS为例)
#### 5. 缺省配置参数
    1. config-server
        1.1 运行在本地 localhost 的端口 8084        
        1.2 使用 git repo 作为配置文件库 file:///${user.home}/config-repo
            注意 : 在非windows环境，上面路径是 file://${user.home}/config-repo 即可(少了一个/) 
            1.2.1 config-repo 中有文件 demo.properties 
            1.2.2 demo.properties 在 master 分支的内容是
                name = zgh       
        1.3 假设服务注册中心服务运行在本地 http://127.0.0.1:8080/eureka/
    2. config-client
        2.1 运行在本地 localhost 的端口 8088        
        2.2 要求配置服务器运行在 http://localhost:8084,程序缺省要读取的配置来自应用 demo 的分支 master
        2.3 Spring actuator 的安全控制关闭，对应接口对外部公开 management.security.enabled=false
    3. registry
        3.1 运行在本地 http://127.0.0.1:8080/eureka/
    4. service0
        4.1 运行在本地 localhost 的端口 8081
        4.2 要求注册中心服务运行在 http://127.0.0.1:8080/eureka/            
        4.3 要求配置服务器运行在 http://localhost:8084,程序缺省要读取的配置来自应用 service0 的分支 master
    5. service1
        5.1 运行在本地 localhost 的端口 8082
        5.2 要求注册中心服务运行在 http://127.0.0.1:8080/eureka/ 
        5.3 要求配置服务器运行在 http://localhost:8084,程序缺省要读取的配置来自应用 service1 的分支 master
    6. gateway
        6.1 运行在本地 localhost 的端口 9099   
        6.2 要求注册中心服务运行在 http://127.0.0.1:8080/eureka/
        6.3 服务路由配置为
            service0: /service/0/**
            service1: /service/1/**

#### 演示模块关系
    1. config-client 依赖 : config-server
    2. config-server 可以独立启动和提供服务;如果 registry 启动，config-server 会将自己注册到 registry;
    3. registry 可以独立启动，其他服务如果配置了 registry 的地址，相应的服务启动时会注册进来;
    4. service0 可以独立启动和提供服务;如果 registry 启动，service0 会将自己注册到 registry;
    5. service1 可以独立启动和提供服务;如果 registry 启动，service1 会将自己注册到 registry;
    6. gateway 可以独立启动和提供服务;如果 registry 启动，gateway 会将自己注册到 registry;
        如果要演示对服务 service0 和 service1 的路由功能 , 
        gateway 启动前要确保 registry, service0,service1 都启动并且服务注册完成;
        
#### 演示目的
    1. 使用 config-server 演示对服务配置的集中管理，使用 git 方案;
    2. 使用 config-client + config-server 演示对集中管理的配置的访问;
    3. registry,service0,service1,gateway 一起演示以下功能 :
        1. registry 各个服务集中注册到服务注册中心;
        2. service1 通过 Feign 访问 service0 提供的服务;
        3. gateway 演示对 service0, service1 提供的服务的静态路由 (注意:目前没有演示动态路由)

#### 下一步需要增加的演示目的
    1. config-server 的安全访问
    2. registry 的安全访问
    3. 服务的安全访问
    4. gateway的安全访问
    5. 服务的热更新                   
    

    
 
