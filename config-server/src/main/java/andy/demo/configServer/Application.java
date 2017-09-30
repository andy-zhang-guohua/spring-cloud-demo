package andy.demo.configServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by ZhangGuohua on 2017/9/29.
 * Spring cloud config server 配置服务端，服务管理配置信息，
 * 该例子 :
 * 1. 使用服务端口 8084,
 * 2. 配置使用本地文件系统里面的 git 仓库 : file:///${user.home}/config-repo
 * 3. file:///${user.home}/config-repo 目录下master分支有文件 demo.properties, 有一行内容 : name = zgh
 * 3. Spring cloud 服务注册中心请启动在 http://127.0.0.1:8080/eureka/
 * <p/>
 * 以上配置见文件 resources/application.yml
 * <p/>
 * * 获取git上的资源信息遵循如下规则：
 * /{application}/{profile}[/{label}]
 * /{application}-{profile}.yml
 * /{application}-{profile}.properties
 * /{label}/{application}-{profile}.yml
 * /{label}/{application}-{profile}.properties
 * <p/>
 * application:表示应用名称,在client中通过spring.config.name配置
 * profile:表示获取指定环境下配置，例如开发环境、测试环境、生产环境 默认值default，实际开发中可以是 dev、test、demo、production等
 * label: git标签，默认值master
 * <p/>
 * 配置文件访问方法 , 启动该应用，然后访问以下地址:
 * http://localhost:8084/demo/default
 * http://localhost:8084/demo/default/master
 * http://localhost:8084/master/demo-default.properties
 * <p/>
 * 看到响应 :
 * {"name":"demo","profiles":["default"],"label":"master","version":"3a233e80fd6fd5ff3c1a884cc55f5336808843bb","state":null,"propertySources":[{"name":"file:///C:\\Users\\ZhangGuohua/config-repo/demo.properties","source":{"name":"zgh"}}]}
 * <p/>
 * <p/>
 * 参考资料 : http://blog.csdn.net/liaokailin/article/details/51307215
 */
@SpringBootApplication
@EnableConfigServer
//该注解表明应用既作为eureka实例又为eureka client ,可以发现注册的服务
@EnableEurekaClient
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
