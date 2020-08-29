package com.saas.service;

import com.saas.request.AddOrderRequest;
import com.saas.response.IntegerResultResponse;

public interface OrderService {

    /**
     * 通过立即购买下单
     */
    IntegerResultResponse addOrder(AddOrderRequest request);



}
