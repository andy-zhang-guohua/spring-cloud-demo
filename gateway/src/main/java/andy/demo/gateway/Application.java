package andy.demo.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * http://localhost:9099/service/0/user/andy/3
 * http://localhost:9099/service/1/user/2
 * http://localhost:9099/service/1/test
 * Created by ZhangGuohua on 2017/9/29.
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
