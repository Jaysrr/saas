package com.saas.controller;

import com.saas.common.JsonResult;
import com.saas.handler.UserLoginHander;
import com.saas.request.AddCommentsRequest;
import com.saas.request.AddOrderRequest;
import com.saas.request.DeleteCommentsRequest;
import com.saas.response.FindAllCircleCommentsResponse;
import com.saas.response.IntegerResultResponse;
import com.saas.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: saas
 * @description:
 * @author: Jaysrr
 * @create: 2020-08-24 18:43
 **/
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserLoginHander loginHander;

    @PostMapping("/add")
    public JsonResult<IntegerResultResponse> addOrder(@RequestHeader Long userId, @RequestHeader String token, @RequestBody AddOrderRequest request) {
        if (loginHander.loginCheck(userId, token)) {
            return JsonResult.ok(orderService.addOrder(request));
        }
        return JsonResult.errorMsg("请求不合法");
    }



}
