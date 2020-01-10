package cn.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author ：by wgz
 * @description：注册中心
 * @Date ：Created in 2020/1/7 14:00
 * @Version: $
 */
@EnableEurekaServer //声明这是一个EurekaServer应用
@SpringBootApplication
public class EurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
