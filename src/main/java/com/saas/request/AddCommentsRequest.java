package com.saas.request;

import lombok.Data;


/**
 * @program: saas
 * @description:
 * @author: Jaysrr
 * @create: 2020-08-24 18:15
 **/
@Data
public class AddCommentsRequest {

    private Long circleId;

    private Long userId;

    private String content;
}
