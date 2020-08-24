package com.saas.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.saas.dao.UserDao;
import com.saas.dto.UserDto;
import com.saas.pojo.User;
import com.saas.request.AddUserRequest;
import com.saas.request.UpdateUserRequest;
import com.saas.request.UserLoginRequest;
import com.saas.response.FindAllUserResponse;
import com.saas.response.IntegerResultResponse;
import com.saas.response.UserLoginResponse;
import com.saas.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @program: saas
 * @description:
 * @author: Jaysrr
 * @create: 2020-08-16 10:59
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public IntegerResultResponse addUser(AddUserRequest request) {
        User user = new User();
        BeanUtils.copyProperties(request, user);
        user.setCreateTime(new Date());
        Integer result = userDao.addUser(user);

        return new IntegerResultResponse(result);
    }


    @Override
    public IntegerResultResponse updateUser(UpdateUserRequest request) {
        User user = new User();
        BeanUtils.copyProperties(request, user);
        //这里更新没能给user做更新时间的补偿， 数据库设置默认更新时间CURRENT_TIMESTAMP也没变
        Integer result = userDao.updateUser(user);

        return new IntegerResultResponse(result);
    }

    @Override
    public UserLoginResponse login(UserLoginRequest request) {
        // 不使用password是因为password可能修改频繁,对数据库压力过大
//        List<User> userList = userDao.login(request.getPhoneNumber(), request.getPassword(), request.getPid());
        List<User> userList = userDao.login(request.getPhoneNumber(), request.getPid());
        UserLoginResponse userLoginResponse = null;

        if (!CollectionUtils.isEmpty(userList)) {
            userLoginResponse = new UserLoginResponse();
            User user = userList.get(0);
            UserDto userDto = null;
            if (!StringUtils.isEmpty(user.getPassword())
                    && !StringUtils.isEmpty(request.getPassword())
                    && user.getPassword().equals(request.getPassword())) {
                //封装User为一个UserDto
                userDto = new UserDto();
                BeanUtils.copyProperties(user, userDto);

                String userLoginToken = UUID.randomUUID().toString();
                stringRedisTemplate.opsForValue().set("userId:" + user.getId().toString(), userLoginToken);
                userLoginResponse.setToken(userLoginToken);
            }
            userLoginResponse.setUserDto(userDto);
        }

        return userLoginResponse;
    }

    @Override
    public FindAllUserResponse findAll(Integer page, Integer size) {
        //开始分页
        PageHelper.startPage(page, size);
        //从数据库找userList
        List<User> userList = userDao.findAll();

        //封装为页对象
        PageInfo<User> userPageInfo = new PageInfo<>(userList);
        //封装返回结果
        FindAllUserResponse response = new FindAllUserResponse();
        response.setUserList(userList);
        response.setTotal(userPageInfo.getTotal());
        return response;
    }

}
