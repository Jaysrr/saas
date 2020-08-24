package com.saas.request;

import lombok.Data;

/**
 * @program: saas
 * @description:
 * @author: Jaysrr
 * @create: 2020-08-16 20:34
 **/
@Data
public class AddShopRequest {

    private String shopName;

    private String phoneNumber;

    private String password;

    /**
     * 营业执照
     */
    private String businessLicense;

    /**
     * 状态 0待认证 1已认证 2被关闭  3已过期'
     */
    private Short status;

    /**
     * 店铺等级 0未购买  1标准版 2vip版 3钻石版'
     */
    private Short level;

    private String address;

}
