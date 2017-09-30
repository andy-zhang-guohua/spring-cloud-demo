package andy.demo.service0;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * http://localhost:8081/echo/test
 * http://localhost:8081/user/andy/3
 * <p/>
 * Created by ZhangGuohua on 2017/9/29.
 */
@SpringBootApplication(scanBasePackages = "andy.demo.service0")
@EnableEurekaClient
@EnableWebMvc
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
