package com.saas.dao;

import com.saas.mapper.ShopMapper;
import com.saas.mapper.UserMapper;
import com.saas.pojo.Shop;
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
public class ShopDao {
    @Autowired
    private ShopMapper shopMapper;

    public Integer addShop(Shop shop) {
        return shopMapper.insert(shop);
    }

    public Integer updateShop(Shop shop) {
        return shopMapper.updateByPrimaryKeySelective(shop);
    }

    public List<Shop> login(String phoneNumber ) {
        Example example = new Example(Shop.class);
        example.createCriteria()
                .andEqualTo("phoneNumber", phoneNumber);
        return shopMapper.selectByExample(example);
    }


}
