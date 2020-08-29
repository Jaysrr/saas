package com.saas.dao;

import com.saas.mapper.OrderMapper;
import com.saas.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @program: saas
 * @description: 订单Dao
 * @author: Jaysrr
 * @create: 2020-08-26 20:57
 **/
@Repository
public class OrderDao {
    @Autowired
    private OrderMapper orderMapper;

    public Integer addOrder(Order order) {
        return orderMapper.insertSelective(order);
    }



}
