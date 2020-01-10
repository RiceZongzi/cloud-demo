package cn.demo.user.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @Author ：by wgz
 * @description：User实体
 * @Date ：Created in 2020/1/7 11:07
 * @Version: $
 */

@Table(name = "t_user")
@Data
public class User {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;

    private String userName;

    private String password;

    private String name;

    private Integer age;
}
