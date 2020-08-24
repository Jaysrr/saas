package com.saas.controller;

import com.saas.common.JsonResult;
import com.saas.handler.UserLoginHander;
import com.saas.pojo.CircleContent;
import com.saas.request.AddCircleContentRequest;
import com.saas.request.AddCircleRequest;
import com.saas.request.UpdateCircleRequest;
import com.saas.response.IntegerResultResponse;
import com.saas.service.CircleContentService;
import com.saas.service.CircleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: saas
 * @description:
 * @author: Jaysrr
 * @create: 2020-08-16 11:11
 *
 * 不需要写这个接口
 **/
@RestController
@RequestMapping("/circleContent")
public class CircleContentController {

    @Autowired
    private CircleContentService circleContentService;

    @Autowired
    private UserLoginHander loginHander;

    @PostMapping("/addCircleContent")
    public JsonResult<IntegerResultResponse> addCircle(@RequestHeader Long userId, @RequestHeader String token, @RequestBody AddCircleContentRequest request) {
        if (loginHander.loginCheck(userId, token)) {
            return JsonResult.ok(circleContentService.addCircleContent  (request));
        }
        return JsonResult.errorMsg("请求不合法");
    }


}
