package cn.demo.consumer.client;

import cn.demo.consumer.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author ：by wgz
 * @description：Feign
 * @Date ：Created in 2020/1/8 11:41
 * @Version: $
 */
@FeignClient("user-service")
public interface UserClient {

    @GetMapping("/user/{id}")
    User queryById(@PathVariable("id") Long id);
}
