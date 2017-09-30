package andy.demo.service1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * http://localhost:8082/echo/test
 * http://localhost:8082/user/1
 * http://localhost:8082/test
 * http://localhost:8082/user/300   // 这里300表示服务会执行300秒，制造一个超时，从而验证熔断机制
 *
 * Created by ZhangGuohua on 2017/9/29.
 */
@SpringBootApplication(scanBasePackages = "andy.demo.service1")
@EnableFeignClients
@EnableWebMvc
@EnableEurekaClient
@EnableCircuitBreaker
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
