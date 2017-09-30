#### Ribbon 和 Feign 
    参考文章 : http://lib.csdn.net/article/microservice/62911
    
    1. Ribbon : 使用Ribbon实现客户端负载均衡
        1. 使用 @LoadBalanced 和 @Bean 注解定义多个REST客户端，RestTemplate实例并开启负载均衡能力        
        2. 使用以下服务调用方式可以以负载均衡的方式访问部署在不同节点上的 COMPUTE-SERVICE
            restTemplate.getForEntity("http://COMPUTE-SERVICE/add?a=10&b=20", String.class).getBody();
    2. Feign : 使用Feign实现声明式HTTP客户端调用——即写得像本地函数调用一样
        1. 使用类似 restTemplate.getForEntity("http://COMPUTE-SERVICE/add?a=10&b=20", String.class).getBody() 
            这样的语句进行服务间调用并非不可以，
        2.但Feign能将跨服务调用封装得跟进行本地调用一样，这样用起来更方便
            2.1 远程方法本地化声明
            @FeignClient("COMPUTE-SERVICE")
            public interface ComputeClient {
            
                @RequestMapping(method = RequestMethod.GET, value = "/add")
                Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);
            }
            2.2 使用本地化调用方式调用远程服务
                @Autowired
                private ComputeClient computeClient;
            
                @RequestMapping(value = "/add", method = RequestMethod.GET)
                public Integer add() {
                    return computeClient.add(10, 20);
                }
        3. Feign 声明远程方法为本地化服务时，使用了服务的名字，如果该服务在多个节点上被部署，则实际的调用
            可能发生在这些节点的任何一个上面                