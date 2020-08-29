package com.saas.controller;

import com.saas.common.JsonResult;
import com.saas.handler.ShopLoginHander;
import com.saas.request.AddGoodsRequest;
import com.saas.request.UpdateCircleRequest;
import com.saas.request.UpdateGoodsRequest;
import com.saas.response.FindAllGoodsResponse;
import com.saas.response.IntegerResultResponse;
import com.saas.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: saas
 * @description:
 * @author: Jaysrr
 * @create: 2020-08-16 11:11
 **/
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private ShopLoginHander shopLoginHander;

    @PostMapping("/add")
    public JsonResult<IntegerResultResponse> addGoods(@RequestHeader Long shopId, @RequestHeader String token, @RequestBody AddGoodsRequest request) {
        if (shopLoginHander.loginCheck(shopId, token)) {
            return JsonResult.ok(goodsService.addGoods(request));
        }
        return JsonResult.errorMsg("请求不合法");
    }


    @PostMapping("/update")
    public JsonResult<IntegerResultResponse> updateGoods(@RequestHeader Long shopId, @RequestHeader String token, @RequestBody UpdateGoodsRequest request) {
        if (shopLoginHander.loginCheck(shopId, token)) {
            return JsonResult.ok(goodsService.updateGoods(request));
        }
        return JsonResult.errorMsg("请求不合法");
    }

    @GetMapping("/find/all")
    public JsonResult<FindAllGoodsResponse> findAllGoods(@RequestHeader Long shopId, @RequestHeader String token,
                                                         @RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                                                         @RequestParam(value = "size", defaultValue = "5") Integer pageSize) {
        if (shopLoginHander.loginCheck(shopId, token)) {
            return JsonResult.ok(goodsService.findAllGoods(pageNum, pageSize));
        }
        return JsonResult.errorMsg("请求不合法");
    }


}
