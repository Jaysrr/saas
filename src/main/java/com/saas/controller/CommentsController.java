package com.saas.controller;

import com.saas.common.JsonResult;
import com.saas.handler.UserLoginHander;
import com.saas.pojo.Comments;
import com.saas.request.AddCommentsRequest;
import com.saas.request.DeleteCommentsRequest;
import com.saas.response.FindAllCircleCommentsResponse;
import com.saas.response.FindAllUserResponse;
import com.saas.response.IntegerResultResponse;
import com.saas.service.CircleService;
import com.saas.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

/**
 * @program: saas
 * @description:
 * @author: Jaysrr
 * @create: 2020-08-24 18:43
 **/
@RestController
@RequestMapping("/comments")
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    @Autowired
    private UserLoginHander loginHander;

    @PostMapping("/addComments")
    public JsonResult<IntegerResultResponse> addComments(@RequestHeader Long userId, @RequestHeader String token, @RequestBody AddCommentsRequest request) {
        if (loginHander.loginCheck(userId, token)) {
            return JsonResult.ok(commentsService.addComments(request));
        }
        return JsonResult.errorMsg("请求不合法");
    }

    @PostMapping("/deleteComments")
    public JsonResult<IntegerResultResponse> deleteComments(@RequestHeader Long userId, @RequestHeader String token, DeleteCommentsRequest request) {
        if (loginHander.loginCheck(userId, token)) {
            return JsonResult.ok(commentsService.deleteComments(request));
        }

        return JsonResult.errorMsg("请求不合法");
    }

    @GetMapping("/find/all")
    public JsonResult<FindAllCircleCommentsResponse> findAllComments(@RequestHeader Long userId, @RequestHeader String token,
                                                                     @RequestParam(value = "page", defaultValue = "1") Integer pageNum,
                                                                     @RequestParam(value = "size", defaultValue = "5") Integer pageSize) {
        if (loginHander.loginCheck(userId, token)) {
            return JsonResult.ok(commentsService.findAllCommentsByPage(pageNum, pageSize));
        }

        return JsonResult.errorMsg("请求不合法");
    }

}
