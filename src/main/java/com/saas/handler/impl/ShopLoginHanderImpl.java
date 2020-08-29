package com.saas.handler.impl;

import com.saas.handler.ShopLoginHander;
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
public class ShopLoginHanderImpl implements ShopLoginHander {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean loginCheck(Long shopId, String token) {
        String loginToken = stringRedisTemplate.opsForValue().get("shopId:" + shopId);
        if (!StringUtils.isEmpty(loginToken) && token.equals(loginToken)) {
            return true;
        }
        return false;
    }


}
