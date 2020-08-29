package com.saas.vo;

import lombok.Data;

/**
 * @program: saas
 * @description:
 * @author: Jaysrr
 * @create: 2020-08-29 18:36
 **/
@Data
public class GoodsVo {

    private String goodsName;

    private Double price;

    private String imgUrl;

    /**
     * 产地
     */
    private String address;

    /**
     * 库存
     */
    private Integer existNumber;


    /**
     * 0未上架 1已上架 2已下架
     */
    private Short status;

    private String content;

}
