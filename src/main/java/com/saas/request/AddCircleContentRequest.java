package com.saas.request;

import lombok.Data;

/**
 * @program: saas
 * @description:
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

