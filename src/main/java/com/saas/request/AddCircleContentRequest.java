package com.saas.request;

import lombok.Data;

/**
 * @program: saas
 * @description: 有AddCircleRequest了，应该是不需要下面这个请求
 **/
@Data
public class AddCircleContentRequest {

    private Long circleId;

    private String content;

    /**
     * 冗余，做分析用
     */
    private Long userId;

    private Long pid;
}

