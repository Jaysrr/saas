package com.saas.dao;

import com.saas.mapper.CircleContentMapper;
import com.saas.mapper.CircleMapper;
import com.saas.pojo.Circle;
import com.saas.pojo.CircleContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @program: saas
 * @description:
 * @author: Jaysrr
 * @create: 2020-08-22 20:54
 **/
@Repository
public class CircleContentDao {

    @Autowired
    private CircleContentMapper circleContentMapper;

    public Integer addCircleContent(CircleContent circleContent) {
        return circleContentMapper.insertSelective(circleContent);
    }

}
