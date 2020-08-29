package com.saas.service.impl;

import com.saas.constants.UserConstants;
import com.saas.dao.CircleContentDao;
import com.saas.dao.CircleDao;
import com.saas.dao.UserDao;
import com.saas.pojo.Circle;
import com.saas.pojo.CircleContent;
import com.saas.pojo.User;
import com.saas.request.AddCircleRequest;
import com.saas.request.UpdateCircleRequest;
import com.saas.response.IntegerResultResponse;
import com.saas.service.CircleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: saas
 * @description:
 **/
@Service
public class CircleServiceImpl implements CircleService {
    @Autowired
    private CircleDao circleDao;

    @Autowired
    private UserDao userDao;


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

        //那么circle_content表里需要的circle_id应该从哪来 再更新一下circle_content表嘛?

        return new IntegerResultResponse(result);
    }


    //还是上次的问题, 如果给对了circle_id但是没给对circle_content_id,
    // 虽然没有异常,但是事务没管住,circle表更新了,但circle_content表没更新
    @Override
    @Transactional(rollbackFor = Exception.class)
    public IntegerResultResponse updateCircle(UpdateCircleRequest request) {
        Circle circle = new Circle();
        BeanUtils.copyProperties(request, circle);
        //通过前端传来的userId查找这个user
        User user = userDao.findById(request.getUserId());
        Integer updateCircleRst = null;
        Integer updateContentRst = null;

        //查看这个user是否为vip,非vip无法更新
        if (null != user && null != user.getIsVip() && UserConstants.isVip.equals(user.getIsVip())) {

            //更新circle表
            updateCircleRst = circleDao.updateCircle(circle);
            System.out.println(" CircleRst = " + updateCircleRst);

            //再判断contentId对应的circleContent是否存在,存在则将circle_content里的数据也一起修改(用事务控制两个更新操作)
            CircleContent circleContent = new CircleContent();

            //注意如果先用BeanUtils,前端id是circle的id和这个主键id 不一样,需要再将冲突的字段在后面填充
            BeanUtils.copyProperties(request, circleContent);
            circleContent.setId(request.getContentId());
            circleContent.setCircleId(request.getId());

            updateContentRst = circleContentDao.updateCircleContent(circleContent);
            System.out.println("updateContentRst = " + updateContentRst);

        }
        return new IntegerResultResponse(updateCircleRst & updateContentRst);
    }


}
