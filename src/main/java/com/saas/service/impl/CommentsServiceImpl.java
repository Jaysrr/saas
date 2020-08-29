package com.saas.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.saas.dao.CircleDao;
import com.saas.dao.CommentsDao;
import com.saas.dao.UserDao;
import com.saas.dto.CommentsDto;
import com.saas.pojo.Circle;
import com.saas.pojo.Comments;
import com.saas.pojo.User;
import com.saas.request.AddCommentsRequest;
import com.saas.request.DeleteCommentsRequest;
import com.saas.response.FindAllCircleCommentsResponse;
import com.saas.response.IntegerResultResponse;
import com.saas.service.CommentsService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: saas
 * @description:
 * @author: Jaysrr
 * @create: 2020-08-24 18:27
 **/
@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    private CommentsDao commentsDao;

    @Autowired
    private CircleDao circleDao;

    @Autowired
    private UserDao userDao;


    /**
     * 给某条circle添加评论 添加成功后, 相应的circle的commentsTimes++
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public IntegerResultResponse addComments(AddCommentsRequest request) {
        Comments comments = new Comments();
        BeanUtils.copyProperties(request, comments);
        // 事务管不住, circle的id不存在 的情况下 但是Comment能成功添入数据库
        commentsDao.addComment(comments);

        List<Circle> circleList = circleDao.findCircle(comments.getCircleId());
        Circle circle = null;

        if (!CollectionUtils.isEmpty(circleList)) {
            circle = circleList.get(0);
            Integer OldcommentsTimes = circle.getCommentsTimes();
            Integer newCommentsTimes = OldcommentsTimes + 1;
            circle.setCommentsTimes(newCommentsTimes);
            Integer updateCircleResult = circleDao.updateCircle(circle);
            return new IntegerResultResponse(updateCircleResult);
        }


        /** 考虑多线程情况下，对评论数的添加
         if (!CollectionUtils.isEmpty(circleList)) {
         circle = circleList.get(0);
         // 考虑多线程情况下，对评论数的添加
         Integer OldcommentsTimes = circle.getCommentsTimes();
         AtomicInteger at = new AtomicInteger(OldcommentsTimes);
         int newCommentsTimes = at.incrementAndGet();
         circle.setCommentsTimes(newCommentsTimes);
         circleDao.updateCircle(circle);
         }
         */

        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public IntegerResultResponse deleteComments(DeleteCommentsRequest request) {
        Comments comments = new Comments();
        BeanUtils.copyProperties(request, comments);

        List<Circle> circleList = circleDao.findCircle(comments.getCircleId());
        Circle circle = null;
        if (!CollectionUtils.isEmpty(circleList)) {
            circle = circleList.get(0);
            Integer OldcommentsTimes = circle.getCommentsTimes();
            Integer newCommentsTimes = OldcommentsTimes - 1;
            circle.setCommentsTimes(newCommentsTimes);
            Integer updateCircleResult = circleDao.updateCircle(circle);
            //删除comment
            commentsDao.deleteComment(comments.getId());
            return new IntegerResultResponse(updateCircleResult);
        }
        return null;
    }

    @Override
    public FindAllCircleCommentsResponse findAllCommentsByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Comments> commentsList = commentsDao.findAll();

        List<CommentsDto> commentsDtoList = null;
        if (!CollectionUtils.isEmpty(commentsList)) {
            commentsDtoList = new LinkedList();

            //遍历每个comments,封装为dto
            for (Comments comments : commentsList) {
                CommentsDto commentsDto = new CommentsDto();
                BeanUtils.copyProperties(comments, commentsDto);
                //找出每个评论的用户,将其属性封装到dto里
                User user = userDao.findById(comments.getUserId());
                commentsDto.setImgUrl(user.getImgUrl());
                commentsDto.setNickName(user.getNickName());

                commentsDtoList.add(commentsDto);
            }
        }

        PageInfo<CommentsDto> commentsPageInfo = new PageInfo<>(commentsDtoList);
        FindAllCircleCommentsResponse response = new FindAllCircleCommentsResponse();
        response.setCommentsDtoList(commentsDtoList);
        response.setTotal(commentsPageInfo.getTotal());

        //这句只是为了看pageInfo在前端长啥样
        //response.setCommentsPageInfo(commentsPageInfo);

        return response;
    }


}
