package com.saas.dao;

import com.saas.mapper.CircleMapper;

import com.saas.pojo.Circle;
import com.saas.pojo.CircleContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @program: saas
 * @description:
 * @author: Jaysrr
 * @create: 2020-08-22 20:54
 **/
@Repository
public class CircleDao {

    @Autowired
    private CircleMapper circleMapper;

    public Integer addCircle(Circle circle) {
        return circleMapper.insertSelective(circle);
    }

    public Integer updateCircle(Circle circle) {
        return circleMapper.updateByPrimaryKeySelective(circle);
    }

    public Integer deleteCircle(Circle circle) {
        return circleMapper.deleteByPrimaryKey(circle);
    }

    public List<Circle> findCircle(Long id) {
        Example example = new Example(Circle.class);
        example.createCriteria()
                .andEqualTo("id", id);
        return circleMapper.selectByExample(example);
    }

}
