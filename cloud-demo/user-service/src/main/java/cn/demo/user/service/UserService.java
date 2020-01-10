package cn.demo.user.service;

import cn.demo.user.mapper.UserMapper;
import cn.demo.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author ：by wgz
 * @description：User业务
 * @Date ：Created in 2020/1/7 11:26
 * @Version: $
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User queryById(Long id){
//        try {
////            测试服务降级
//            Thread.sleep(2000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return userMapper.selectByPrimaryKey(id);
    }
}
