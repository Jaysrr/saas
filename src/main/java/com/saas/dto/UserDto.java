package com.saas.dto;

import lombok.Data;

/**
 * @program: saas
 * @description: 传给前端的数据对象
 * @author: Jaysrr
 * @create: 2020-08-18 10:21
 **/
@Data
public class UserDto {

    private Long id;

    private String phoneNumber;

    private String password;

    /**
     * 0为普通会员 1为vip
     */
    private Short isVip;

    private String nickName;

    /**
     * 身份证号
     */
    private String idNumber;

    /**
     * 中文名
     */
    private String chineseName;

    /**
     * 头像
     */
    private String imgUrl;

    /**
     * 真人照片
     */
    private String faceUrl;

    /**
     * 商户id
     */
    private Long pid;

 }
