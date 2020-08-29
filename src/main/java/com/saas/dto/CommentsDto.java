package com.saas.dto;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

/**
 * @program: saas
 * @description:
 * @author: Jaysrr
 * @create: 2020-08-26 12:23
 **/
@Data
public class CommentsDto {
    //其实circle也不是必须的
    private Long circleId;

    private String content;

    private Date createTime;

    /**
     * 以下是用户相关信息
     */
    private String nickName;

    /**
     * 头像
     */
    private String imgUrl;

}
