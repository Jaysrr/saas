package com.saas.service.impl;

import com.saas.constants.OrderConstants;
import com.saas.dao.OrderDao;
import com.saas.dao.OrderItemDao;
import com.saas.dto.GoodsDto;
import com.saas.pojo.Goods;
import com.saas.pojo.Order;
import com.saas.pojo.OrderItem;
import com.saas.request.AddOrderRequest;
import com.saas.response.IntegerResultResponse;
import com.saas.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: saas
 * @description:
 * @author: Jaysrr
 * @create: 2020-08-26 21:14
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderItemDao orderItemDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public IntegerResultResponse addOrder(AddOrderRequest request) {
        //判断是直接下单还是购物车下单
        Short wantType = request.getWantType();

        Order order = null;
        OrderItem orderItem = null;
        Integer rst1 = null;
        Integer rst2 = null;
        Integer rst3 = null;
        if (null != wantType && OrderConstants.buyNow.equals(wantType)) {
            //若是直接下单, 则操作t_order表
            order = new Order();
            BeanUtils.copyProperties(request, order);
            rst1 = orderDao.addOrder(order);
            return new IntegerResultResponse(rst1);
        } else if (null != wantType && OrderConstants.buyThroughCart.equals(wantType)) {
            //若是购物车下单,操作t_order表之后还需要操作t_order_item
            // 则是一个订单,对应可以有多个商品,
            order = new Order();
            BeanUtils.copyProperties(request, order);
            rst2 = orderDao.addOrder(order);

            List<GoodsDto> goodsDtoList = request.getGoodsDtoList();
            for (GoodsDto goodsDto : goodsDtoList) {
                orderItem = new OrderItem();
                BeanUtils.copyProperties(request, orderItem);
                orderItem.setOrderId(order.getId());

                orderItem.setGoodsId(goodsDto.getGoodsId());
                orderItem.setGoodsName(goodsDto.getGoodsName());
                orderItem.setGoodsNumber(goodsDto.getGoodsNum());
                rst3 = orderItemDao.addOrderItem(orderItem);
            }
            return new IntegerResultResponse(rst2 & rst3);
        }

        return null;
    }
}
