package com.saas.service;

import com.saas.request.AddCircleContentRequest;
import com.saas.request.AddCircleRequest;
import com.saas.request.UpdateCircleRequest;
import com.saas.response.IntegerResultResponse;

public interface CircleContentService {
    IntegerResultResponse addCircleContent(AddCircleContentRequest request);

}