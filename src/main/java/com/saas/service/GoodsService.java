package com.saas.service;

import com.saas.request.AddGoodsRequest;
import com.saas.request.UpdateGoodsRequest;
import com.saas.response.FindAllGoodsResponse;
import com.saas.response.IntegerResultResponse;

/**
 * @description: 商品
 **/
public interface GoodsService {

    IntegerResultResponse addGoods(AddGoodsRequest request);

    IntegerResultResponse updateGoods(UpdateGoodsRequest request);

    FindAllGoodsResponse findAllGoods(Integer pageNum, Integer pageSize);


}
