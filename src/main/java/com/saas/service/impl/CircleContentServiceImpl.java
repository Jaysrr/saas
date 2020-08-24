package com.saas.service.impl;

import com.saas.dao.CircleContentDao;
import com.saas.dao.CircleDao;
import com.saas.pojo.Circle;
import com.saas.pojo.CircleContent;
import com.saas.request.AddCircleContentRequest;
import com.saas.response.IntegerResultResponse;
import com.saas.service.CircleContentService;
import io.swagger.models.auth.In;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @program: saas
 * @description:
 * @author: Jaysrr
 * @create: 2020-08-22 21:43
 *
 * 不需要写这个
 **/
@Service
public class CircleContentServiceImpl implements CircleContentService {
    @Autowired
    private CircleContentDao circleContentDao;

    @Autowired
    private CircleDao circleDao;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public IntegerResultResponse addCircleContent(AddCircleContentRequest request) {
        CircleContent circleContent = new CircleContent();
        BeanUtils.copyProperties(request, circleContent);
        circleContent.setCreateTime(new Date());
        circleContentDao.addCircleContent(circleContent);

        List<Circle> circleList = circleDao.findCircle(request.getCircleId());
        if (!CollectionUtils.isEmpty(circleList)) {
            Circle circle = circleList.get(0);

//            BeanUtils.copyProperties(request, circle);

            //给circle补偿circleContent的id
            circle.setContentId(circleContent.getId());
            circle.setCreateTime(new Date());
            Integer result = circleDao.addCircle(circle);

            return new IntegerResultResponse(result);
        }
        return null;
    }

}
