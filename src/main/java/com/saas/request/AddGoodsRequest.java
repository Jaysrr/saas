package com.saas.request;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @program: saas
 * @description:
 * @author: Jaysrr
 * @create: 2020-08-26 15:10
 **/
@Data
public class AddGoodsRequest {

    private String goodsName;

    private Double price;

    private String imgUrl;

    /**
     * 产地
     */
    private String address;

    /**
     * 这字段是添加到goods_content表
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
