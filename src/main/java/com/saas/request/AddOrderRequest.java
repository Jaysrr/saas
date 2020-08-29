package com.saas.request;

import com.saas.dto.GoodsDto;
import lombok.Data;

import java.util.List;

/**
 * @program: saas
 * @description:
 * @author: Jaysrr
 **/
@Data
public class AddOrderRequest {

    private Long userId;

    private Long pid;

    /**
     * 可以表示购物车id,也可表示商品id
     */
    private Long wantId;

    /**
     * 0表示立刻下单，1表示购物车下单
     */
    private Short wantType;

    /**
     * 购买的数量
     */
    private Integer number;

    private Double totalPrice;

    /**
     * 0未支付， 1已支付，2支付失败
     */
    private Short status;

    /**
     * 以下是关于OrderItem的前端请求
     */
    private List<GoodsDto> goodsDtoList;

    private Long orderId;

}
