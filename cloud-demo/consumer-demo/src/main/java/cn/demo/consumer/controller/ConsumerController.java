package cn.demo.consumer.controller;

import cn.demo.consumer.client.UserClient;
import cn.demo.consumer.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ：by wgz
 * @description：调用方控制层
 * @Date ：Created in 2020/1/7 13:46
 * @Version: $
 */
@RestController
@RequestMapping("consumer")
@DefaultProperties(defaultFallback = "defaultFallback")
public class ConsumerController {

//    @Autowired
//    private RestTemplate restTemplate;

//    @GetMapping("/{id}")
//    public User queryById(@PathVariable("id") Long id){
////        String url = "http://localhost:8081/user/" + id;
////        开启两个user服务实例，端口号分别为8081、8082
////        改用负载均衡，url改成服务实例名称
//        String url = "http://user-service/user/" + id;
//        return restTemplate.getForObject(url, User.class);
//    }

//    @GetMapping("/{id}")
////    @HystrixCommand(fallbackMethod = "queryByIdFallBack")
////    @HystrixCommand() // 把降级的方法写在类上
////    @HystrixCommand(commandProperties = {
////            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", // HystrixCommandProperties 定义的超时自动降级时间
////                    value = "3000") // 缺省是1s，User服务线程睡眠了2s
////    }) // 全局配置，写到配置文件中
////    @HystrixCommand
//    @HystrixCommand(commandProperties = {
//            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", // HystrixCommandProperties 定义的熔断检查次数
//                    value = "10"), // 缺省是20次，即过去20次中有半数以上的请求超时时，打开熔断器
//            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", // HystrixCommandProperties 定义的熔断器打开时间
//                    value = "10000"), // 缺省是5000毫秒，即打开五秒内，所有请求直接失败
//            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", // HystrixCommandProperties 熔断检查的错误百分比
//                    value = "60") // 缺省是50%
//    }) // 测试熔断功能
//    public String queryById(@PathVariable("id") Long id){
//        if (id % 2 == 0) {
//            throw new RuntimeException(""); // 测试熔断器，加入的偶数id超时机制
//        }
//        String url = "http://user-service/user/" + id;
//        return restTemplate.getForObject(url, String.class);
//    }

//    @GetMapping("/{id}")
//    @HystrixCommand
//    public User queryById(@PathVariable("id") Long id){
//        String url = "http://user-service/user/" + id;
//        return restTemplate.getForObject(url, User.class);
//    }

    @Autowired
    private UserClient userClient;

    @GetMapping("{id}")
    public User queryById(@PathVariable("id") Long id){
        return userClient.queryById(id);
    }

    public String queryByIdFallBack(Long id){
        return "服务器崩了！！";
    }

    /*
     * 空参的defaultFallback
     * @author wgz
     * @date 2020/1/7
     * @param null
     * @return
     */

    public String defaultFallback(){
        return "服务器崩了！！";
    }
}
