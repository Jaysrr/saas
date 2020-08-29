package com.saas.dto;

import lombok.Data;

/**
 * @program: saas
 * @description:
 * @author: Jaysrr
 * @create: 2020-08-26 22:11
 **/
@Data
public class GoodsDto {
    private Long goodsId;

    private String goodsName;

    /**
     * 购买的商品数量
     */
    private Integer goodsNum;

}
