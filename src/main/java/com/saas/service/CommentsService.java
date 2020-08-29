package com.saas.service;

import com.saas.request.AddCommentsRequest;
import com.saas.request.DeleteCommentsRequest;
import com.saas.response.FindAllCircleCommentsResponse;
import com.saas.response.IntegerResultResponse;

public interface CommentsService {

    IntegerResultResponse addComments(AddCommentsRequest request);

    IntegerResultResponse deleteComments(DeleteCommentsRequest request);

    FindAllCircleCommentsResponse findAllCommentsByPage(Integer pageNum, Integer pageSize);
}
