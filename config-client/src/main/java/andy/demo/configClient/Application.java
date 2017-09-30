package andy.demo.configClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ZhangGuohua on 2017/9/29.
 * Spring cloud client 配置客户端，访用 Spring cloud config server端暴露的接口获取配置信息
 * <p/>
 * 1.假定配置服务器上的git仓库中有配置文件 demo.properties , 其中有属性 name = zgh ,
 * 访问 : http://localhost:8088/ 会看到页面显示 Hello zgh!
 * <p/>
 * 2.在该例子中，client 运行期间如果配置服务器上参数有变化，该变化并不会中东传递到 client
 * <p/>
 * 参考资料 : http://blog.csdn.net/liaokailin/article/details/51307215
 */
@SpringBootApplication
@RestController
public class Application {
    /**
     * name 属性的值尝试从配置中获取，如果获取不到，使用缺省值 World
     */
    @Value("${name:World!}")
    String name;

    @RequestMapping("/")
    String hello() {
        return "Hello " + name + "!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
