package com.saas.dao;

import com.saas.mapper.GoodsContentMapper;
import com.saas.mapper.GoodsMapper;
import com.saas.pojo.Goods;
import com.saas.pojo.GoodsContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

/**
 * @program: saas
 * @description: 商品内容Dao
 * @author: Jaysrr
 * @create: 2020-08-26 15:07
 **/
@Repository
public class GoodsContentDao {
    @Autowired
    private GoodsContentMapper goodsContentMapper;

    public Integer addGoodsContent(GoodsContent goodsContent) {
        return goodsContentMapper.insertSelective(goodsContent);
    }

    public Integer updateGoodsContent(GoodsContent goodsContent) {
        return goodsContentMapper.updateByPrimaryKey(goodsContent);
    }

    public GoodsContent findById(Long id) {
        return goodsContentMapper.selectByPrimaryKey(id);
    }

}
