package cn.demo.consumer.pojo;

import lombok.Data;
/**
 * @Author ：by wgz
 * @description：User实体
 * @Date ：Created in 2020/1/7 13:44
 * @Version: $
 */
@Data
public class User {

    private Long id;

    private String userName;

    private String password;

    private String name;

    private Integer age;
}

