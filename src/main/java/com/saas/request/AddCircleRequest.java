package com.saas.request;

import lombok.Data;

/**
 * @program: saas
 * @description:
 * @author: Jaysrr
 * @create: 2020-08-22 20:59
 **/
@Data
public class AddCircleRequest {

    private Long userId;

    private Long pid;

    private String content;

}
