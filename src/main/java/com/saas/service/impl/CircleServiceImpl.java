package com.saas.service.impl;

import com.saas.dao.CircleContentDao;
import com.saas.dao.CircleDao;
import com.saas.pojo.Circle;
import com.saas.pojo.CircleContent;
import com.saas.request.AddCircleRequest;
import com.saas.request.UpdateCircleRequest;
import com.saas.response.IntegerResultResponse;
import com.saas.service.CircleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @program: saas
 * @description:
 **/
@Service
public class CircleServiceImpl implements CircleService {
    @Autowired
    private CircleDao circleDao;

    @Autowired
    private CircleContentDao circleContentDao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public IntegerResultResponse addCircle(AddCircleRequest request) {
        //先添加内容,添加成功会自动返回circleContent的id
        CircleContent circleContent = new CircleContent();
        circleContent.setContent(request.getContent());
        //下面这两个数据是冗余,可加可不加
        circleContent.setUserId(request.getUserId());
        circleContent.setPid(request.getPid());
        circleContentDao.addCircleContent(circleContent);

        Circle circle = new Circle();
        BeanUtils.copyProperties(request, circle);
        //circleContent的id补偿给 circle
        circle.setContentId(circleContent.getId());
        Integer result = circleDao.addCircle(circle);

        return new IntegerResultResponse(result);
    }


    @Override
    public IntegerResultResponse updateCircle(UpdateCircleRequest request) {
        Circle circle = new Circle();
        BeanUtils.copyProperties(request, circle);
        Integer result = circleDao.updateCircle(circle);
        return new IntegerResultResponse(result);
    }


}
