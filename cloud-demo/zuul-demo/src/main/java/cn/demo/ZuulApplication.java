package cn.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Author ：by wgz
 * @description：网关启动类
 * @Date ：Created in 2020/1/8 14:16
 * @Version: $
 */
@EnableZuulProxy // 不使用Server，而使用Proxy
@SpringBootApplication
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }
}
