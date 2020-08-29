package com.saas.dao;

import com.saas.mapper.OrderItemMapper;
import com.saas.mapper.OrderMapper;
import com.saas.pojo.Order;
import com.saas.pojo.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @program: saas
 * @description: 订单详情Dao
 * @author: Jaysrr
 * @create: 2020-08-26 20:57
 **/
@Repository
public class OrderItemDao {

    @Autowired
    private OrderItemMapper orderItemMapper;

    public Integer addOrderItem(OrderItem orderItem) {
        return orderItemMapper.insertSelective(orderItem);
    }



}
