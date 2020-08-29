package com.saas.dao;

import com.saas.mapper.GoodsMapper;
import com.saas.pojo.Circle;
import com.saas.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: saas
 * @description: 商品
 * @author: Jaysrr
 * @create: 2020-08-26 15:07
 **/
@Repository
public class GoodsDao {

    @Autowired
    private GoodsMapper goodsMapper;

    public Integer addGoods(Goods goods) {
        return goodsMapper.insertSelective(goods);
    }

    public Integer updateGoods(Goods goods) {
        return goodsMapper.updateByPrimaryKeySelective(goods);
    }

    public List<Goods> findAll() {
        return goodsMapper.selectAll();
    }

}
