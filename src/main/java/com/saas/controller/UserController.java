package com.saas.controller;

import com.saas.common.JsonResult;
import com.saas.handler.UserLoginHander;
import com.saas.request.AddUserRequest;
import com.saas.request.UpdateUserRequest;
import com.saas.request.UserLoginRequest;
import com.saas.response.FindAllUserResponse;
import com.saas.response.IntegerResultResponse;
import com.saas.response.UserLoginResponse;
import com.saas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

/**
 * @program: saas
 * @description:
 * @author: Jaysrr
 * @create: 2020-08-16 11:11
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserLoginHander loginHander;

    @PostMapping("/addUser")
    public JsonResult<IntegerResultResponse> addUser(@RequestHeader Long id, @RequestHeader String token, @RequestBody AddUserRequest request) {
        if (loginHander.loginCheck(id, token)) {
            return JsonResult.ok(userService.addUser(request));
        }
        return JsonResult.errorMsg("请求不合法");
    }

    @PostMapping("/updateUser")
    public JsonResult<IntegerResultResponse> updateUser(@RequestHeader Long id, @RequestHeader String token, @RequestBody UpdateUserRequest request) {
        if (loginHander.loginCheck(id, token)) {
            return JsonResult.ok(userService.updateUser(request));
        }
        return JsonResult.errorMsg("请求不合法");
    }

    @PostMapping("/login")
    public JsonResult<UserLoginResponse> login(@RequestBody UserLoginRequest request) {
        return JsonResult.ok(userService.login(request));
    }

    @GetMapping("/find/all")
    public JsonResult<FindAllUserResponse> findAll(@RequestHeader Long id, @RequestHeader String token, @RequestParam(value = "page", defaultValue = "1") Integer page,
                                                   @RequestParam(value = "size", defaultValue = "5") Integer size) {
        if (loginHander.loginCheck(id, token)) {
            return JsonResult.ok(userService.findAll(page, size));
        }
        return JsonResult.errorMsg("请求不合法");
    }


}
