package com.saas.controller;

import com.saas.common.JsonResult;
import com.saas.handler.UserLoginHander;
import com.saas.pojo.Circle;
import com.saas.request.*;
import com.saas.response.FindAllUserResponse;
import com.saas.response.IntegerResultResponse;
import com.saas.response.UserLoginResponse;
import com.saas.service.CircleService;
import com.saas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: saas
 * @description:
 * @author: Jaysrr
 * @create: 2020-08-16 11:11
 **/
@RestController
@RequestMapping("/circle")
public class CircleController {

    @Autowired
    private CircleService circleService;

    @Autowired
    private UserLoginHander loginHander;

    @PostMapping("/addCircle")
    public JsonResult<IntegerResultResponse> addCircle(@RequestHeader Long userId, @RequestHeader String token, @RequestBody AddCircleRequest request) {
        //request.getUserId().equals(userId) 应该在这一层还是service层校验?
        if (loginHander.loginCheck(userId, token) && request.getUserId().equals(userId)) {
            return JsonResult.ok(circleService.addCircle(request));
        }
        return JsonResult.errorMsg("请求不合法");
    }

    @PostMapping("/updateCircle")
    public JsonResult<IntegerResultResponse> updateCircle(@RequestHeader Long userId, @RequestHeader String token, @RequestBody UpdateCircleRequest request) {
        if (loginHander.loginCheck(userId, token)) {
            return JsonResult.ok(circleService.updateCircle(request));
        }
        return JsonResult.errorMsg("请求不合法");
    }


}
