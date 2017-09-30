package andy.demo.service1.client.fallback.factory;

import andy.demo.service1.client.Service0Client;
import andy.demo.service1.controller.Service1Controller;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by ZhangGuohua on 2017/9/29.
 */
@Component
public class Service0FallbackFactory implements FallbackFactory<Service0Client> {

    @Override
    public Service0Client create(final Throwable cause) {
        System.out.println("create:" + cause);
        return new Service0Client() {
            @Override
            public String user(@PathVariable("user_id") String user_id, @PathVariable("sleep_seconds") int sleep_seconds) {
                return "create fallback:" + user_id + "," + sleep_seconds;
            }

            @Override
            public String test(Service1Controller.User user) {
                return "create fallback:" + user.toString();
            }
        };
    }
}
