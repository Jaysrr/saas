package com.saas.controller;

import com.saas.common.JsonResult;
import com.saas.request.*;
import com.saas.response.IntegerResultResponse;
import com.saas.response.UserLoginResponse;
import com.saas.service.ShopService;
import com.saas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: saas
 * @description:
 * @author: Jaysrr
 * @create: 2020-08-16 11:11
 **/
@RestController()
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @PostMapping("/addShop")
    public JsonResult<IntegerResultResponse> addShop(@RequestBody AddShopRequest request) {
        return JsonResult.ok(shopService.addShop(request));
    }

    @PostMapping("/updateShop")
    public JsonResult<IntegerResultResponse> updateShop(@RequestBody UpdateShopRequest request) {
        return JsonResult.ok(shopService.updateShop(request));
    }

    @PostMapping("/login")
    public JsonResult<UserLoginResponse> login(@RequestBody ShopLoginRequest request) {
        return JsonResult.ok(shopService.login(request));
    }

}
