package cn.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author ：by wgz
 * @description：服务调用方
 * @Date ：Created in 2020/1/7 13:35
 * @Version: $
 */
//@EnableCircuitBreaker // 熔断
//@EnableDiscoveryClient // 声明是Eureka应用
//@SpringBootApplication

@SpringCloudApplication // 代替前三个
@EnableFeignClients //
public class ConsumerApplication {

    /*
     * http调用
     * @author wgz
     * @date 2020/1/7
     */

//    @Bean
//    @LoadBalanced // 负载均衡
//    public RestTemplate restTemplate(){
//        return new RestTemplate();
//    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
