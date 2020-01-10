package cn.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author ：by wgz
 * @description：User启动类
 * @Date ：Created in 2020/1/7 11:00
 * @Version: 1.0$
 */

@EnableDiscoveryClient // 开启EurekaClient功能，使用@EnableEurekaClient也可
@SpringBootApplication
@MapperScan("cn.demo.user.mapper") //扫包
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
