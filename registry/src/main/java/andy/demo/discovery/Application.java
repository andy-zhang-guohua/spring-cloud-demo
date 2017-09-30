package andy.demo.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Spring cloud 服务注册中心
 * <p/>
 * 启动后访问地址 :
 * http://localhost:8080/ //可以查看eureka注册服务信息
 * http://localhost:8080/health
 * http://localhost:8080/eureka/apps //可以查看metadata
 * <p/>
 * 配置文件是 resources/application.yml
 * <p/>
 * Created by ZhangGuohua on 2017/9/29.
 */
@SpringBootApplication
//该注解表明应用为eureka服务，可以联合多个服务作为集群，对外提供服务注册以及发现功能
@EnableEurekaServer
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
