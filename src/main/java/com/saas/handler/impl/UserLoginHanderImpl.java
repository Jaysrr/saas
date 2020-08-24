package com.saas.handler.impl;

import com.saas.handler.UserLoginHander;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @program: saas
 * @description:
 **/
@Component
public class UserLoginHanderImpl implements UserLoginHander {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean loginCheck(Long userId, String token) {
        String loginToken = stringRedisTemplate.opsForValue().get("userId:" + userId);
        if (!StringUtils.isEmpty(loginToken) && token.equals(loginToken)) {
            return true;
        }
        return false;
    }
}
