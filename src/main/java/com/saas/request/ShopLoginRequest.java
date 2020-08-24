package com.saas.request;

import lombok.Data;

/**
 * @program: saas
 * @description:
 * @author: Jaysrr
 * @create: 2020-08-16 20:39
 **/
@Data
public class ShopLoginRequest {

    private String phoneNumber;

    private String password;

}
