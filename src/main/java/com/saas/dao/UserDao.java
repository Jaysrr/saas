package com.saas.dao;

import com.saas.mapper.UserMapper;
import com.saas.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @program: saas
 * @description:
 * @author: Jaysrr
 * @create: 2020-08-16 10:42
 **/
@Repository
public class UserDao {
       @Autowired
    private UserMapper userMapper;

    public Integer addUser(User user) {
        return userMapper.insert(user);
    }

    public Integer updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    //    public List<User> login(String phoneNumber, String password, Long pid) {
    public List<User> login(String phoneNumber, Long pid) {
        Example example = new Example(User.class);
        example.createCriteria()
                .andEqualTo("phoneNumber", phoneNumber)
//                .andEqualTo("password", password) //不使用password是因为password可能修改频繁,对数据库压力过大
                .andEqualTo("pid", pid);
        return userMapper.selectByExample(example);
    }

    public List<User> findAll() {
        return userMapper.selectAll();
    }
}
