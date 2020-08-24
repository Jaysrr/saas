package com.saas.request;

import lombok.Data;

/**
 * @program: saas
 * @description:
 * @author: Jaysrr
 * @create: 2020-08-16 10:54
 **/
@Data
public class UpdateUserRequest {
    private Long id;

    private String phoneNumber;

    private String password;

    private String nickName;

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
