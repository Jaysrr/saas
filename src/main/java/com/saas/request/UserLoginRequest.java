package com.saas.request;

import lombok.Data;

/**
 * @program: saas
 * @description:
 * @author: Jaysrr
 * @create: 2020-08-16 10:54
 **/
@Data
public class UserLoginRequest {

    private String phoneNumber;

    private String password;

    private String nickName;

    /**
     * 商户id
     */
    private Long pid;

}
