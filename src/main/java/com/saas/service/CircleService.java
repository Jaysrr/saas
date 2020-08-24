package com.saas.service;

 import com.saas.request.AddCircleRequest;
import com.saas.request.UpdateCircleRequest;
import com.saas.response.IntegerResultResponse;

public interface CircleService {
    IntegerResultResponse addCircle(AddCircleRequest request);

    IntegerResultResponse updateCircle(UpdateCircleRequest request);

    }