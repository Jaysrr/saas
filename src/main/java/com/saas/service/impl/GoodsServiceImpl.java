package com.saas.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.saas.dao.GoodsContentDao;
import com.saas.dao.GoodsDao;
import com.saas.dto.CommentsDto;
import com.saas.pojo.Comments;
import com.saas.pojo.Goods;
import com.saas.pojo.GoodsContent;
import com.saas.pojo.User;
import com.saas.request.AddGoodsRequest;
import com.saas.request.UpdateGoodsRequest;
import com.saas.response.FindAllCircleCommentsResponse;
import com.saas.response.FindAllGoodsResponse;
import com.saas.response.IntegerResultResponse;
import com.saas.service.GoodsService;
import com.saas.vo.GoodsVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: saas
 * @description: 商品Service
 * @author: Jaysrr
 * @create: 2020-08-26 15:14
 **/
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private GoodsContentDao goodsContentDao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public IntegerResultResponse addGoods(AddGoodsRequest request) {
        GoodsContent goodsContent = new GoodsContent();
        BeanUtils.copyProperties(request, goodsContent);
        Integer addContentRst = goodsContentDao.addGoodsContent(goodsContent);

        Goods goods = new Goods();
        BeanUtils.copyProperties(request, goods);
        goods.setContentId(goodsContent.getId());
        Integer addGoodsRst = goodsDao.addGoods(goods);

        return new IntegerResultResponse(addContentRst & addGoodsRst);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public IntegerResultResponse updateGoods(UpdateGoodsRequest request) {

        Goods goods = new Goods();
        BeanUtils.copyProperties(request, goods);
        goods.setContentId(request.getContentId());
        Integer updateGoodsRst = goodsDao.updateGoods(goods);

        //再更新内容表也可以
        GoodsContent goodsContent = goodsContentDao.findById(request.getContentId());
        goodsContent.setContent(request.getContent());
        //给goodsContent补偿GoodsId
        goodsContent.setGoodsId(goods.getId());
        Integer updateContentRst = goodsContentDao.updateGoodsContent(goodsContent);

        return new IntegerResultResponse(updateContentRst & updateGoodsRst);
    }

    @Override
    public FindAllGoodsResponse findAllGoods(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Goods> goodsList = goodsDao.findAll();
        List<GoodsVo> goodsVoList = null;
        if (!CollectionUtils.isEmpty(goodsList)) {
            goodsVoList = new LinkedList();
            for (Goods goods : goodsList) {
                GoodsVo goodsVo = new GoodsVo();
                BeanUtils.copyProperties(goods, goodsVo);
                GoodsContent goodsContent = goodsContentDao.findById(goods.getContentId());
                goodsVo.setContent(goodsContent.getContent());

                goodsVoList.add(goodsVo);
            }
        }
        PageInfo<GoodsVo> goodsVoPageInfo = new PageInfo<>(goodsVoList);
        FindAllGoodsResponse response = new FindAllGoodsResponse();
        response.setGoodsVoList(goodsVoList);
        response.setTotal(goodsVoPageInfo.getTotal());

        return response;
    }


}
