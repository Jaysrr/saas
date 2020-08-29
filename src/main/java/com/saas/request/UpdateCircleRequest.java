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
     * 对circleContent表的更新:通过contentId查找原有的内容记录,修改其内容
     */
    private Long contentId;

    /**
     * 对circleContent表的更新: 更新其内容
     */
    private String content;


    /**以下这些也需要更新,但是并非要暴露给用户,让用户请求的,而是应该另起一个更新请求,专门更新这些不是实时需要更新的数据*/
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
