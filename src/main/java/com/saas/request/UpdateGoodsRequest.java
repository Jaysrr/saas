package com.saas.request;

import lombok.Data;

/**
 * @program: saas
 * @description:
 * @author: Jaysrr
 * @create: 2020-08-26 16:52
 **/
@Data
public class UpdateGoodsRequest {

    private Long id;

    private String goodsName;

    private Double price;

    private String imgUrl;

    /**
     * 产地
     */
    private String address;

    /**
     * 这字段是用来查看goods_content表是否存在这个记录,存在才进行修改,
     */
    private Long contentId;

    /**
     * 这字段是对goods_content表的修改
     */
    private String content;

    /**
     * 库存
     */
    private Integer existNumber;

    private Long pid;

    /**
     * 0未上架 1已上架 2已下架
     */
    private Short status;


}
