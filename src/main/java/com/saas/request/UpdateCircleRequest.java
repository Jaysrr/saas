package com.saas.request;

import lombok.Data;


/**
 * @program: saas
 * @description:
 * @author: Jaysrr
 * @create: 2020-08-22 21:08
 **/
@Data
public class UpdateCircleRequest {

    private Long id;

    private Long userId;

    private Long pid;

    /**
     * 用于查看圈子内容，对应的是t_circle_content的主键id
     */
     private Long contentId;

    /**
     * 点赞数
     */
    private Long stars;

    /**
     * 评论数
     */
     private Integer commentsTimes;

    /**
     * 转发数
     */
     private Integer shareTimes;

}
