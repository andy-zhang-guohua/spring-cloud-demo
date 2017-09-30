package andy.demo.service1.client;

import andy.demo.service1.client.fallback.factory.Service0FallbackFactory;
import andy.demo.service1.controller.Service1Controller;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ZhangGuohua on 2017/9/29.
 */
//Feign : 可以把远程服务提供方的 REST接口变成本地方法调用的Spring Cloud组件
@FeignClient(name = "service0", fallbackFactory = Service0FallbackFactory.class)
public interface Service0Client {

    @RequestMapping(method = RequestMethod.GET, path = "user/{user_id}/{sleep_seconds}")
    String user(@PathVariable("user_id") String user_id, @PathVariable("sleep_seconds") int sleepSec);

    @RequestMapping(method = RequestMethod.GET, path = "test")
    String test(Service1Controller.User user);

}
