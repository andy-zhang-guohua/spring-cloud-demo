package andy.demo;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public abstract class AbstractController {


    @ExceptionHandler({Exception.class})
    public Map<String, String> exceptionHandler(Exception e, WebRequest req) {
        System.err.println("=================");
        System.err.println("request : " + req.toString());
        System.err.println("remote user : " + StringUtils.defaultString(req.getRemoteUser()));
        System.err.println("context path : " + req.getContextPath());
        System.err.println("=============");
        Map<String, String> map = new HashMap<>();
        map.put("code", "0");
        map.put("msg", e.getMessage());
        return map;
    }
}
