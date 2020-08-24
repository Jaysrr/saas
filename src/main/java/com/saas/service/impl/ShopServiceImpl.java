package com.saas.service.impl;

import com.saas.dao.ShopDao;
import com.saas.dao.UserDao;
import com.saas.pojo.Shop;
import com.saas.pojo.User;
import com.saas.request.*;
import com.saas.response.IntegerResultResponse;
import com.saas.response.ShopLoginResponse;
import com.saas.response.UserLoginResponse;
import com.saas.service.ShopService;
import com.saas.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @program: saas
 * @description:
 * @author: Jaysrr
 * @create: 2020-08-16 10:59
 **/
@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;

    @Override
    public IntegerResultResponse addShop(AddShopRequest request) {
        Shop shop = new Shop();
        BeanUtils.copyProperties(request, shop);
        shop.setCreateTime(new Date());
        Integer result = shopDao.addShop(shop);

        return new IntegerResultResponse(result);
    }

    @Override
    public IntegerResultResponse updateShop(UpdateShopRequest request) {
        Shop shop = new Shop();
        BeanUtils.copyProperties(request, shop);
        Integer result = shopDao.updateShop(shop);

        return new IntegerResultResponse(result);
    }

    @Override
    public ShopLoginResponse login(ShopLoginRequest request) {
        List<Shop> shopList = shopDao.login(request.getPhoneNumber());

        ShopLoginResponse shopLoginResponse = null;
        if (!CollectionUtils.isEmpty(shopList)) {
            shopLoginResponse = new ShopLoginResponse();
            BeanUtils.copyProperties(shopList.get(0), shopLoginResponse);
        }
        //登录成功后,生成token存到redis,并返回这个token给前端


        shopLoginResponse.setShopList(shopList);

        return shopLoginResponse;
    }
}
