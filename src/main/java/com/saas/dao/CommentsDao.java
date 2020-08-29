package com.saas.dao;

import com.saas.mapper.CommentsMapper;
import com.saas.pojo.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @program: saas
 * @description: 对圈子的评论
 * @author: Jaysrr
 * @create: 2020-08-24 17:25
 **/
@Repository
public class CommentsDao {

    @Autowired
    private CommentsMapper commentsMapper;

    public Integer addComment(Comments comments) {
        return commentsMapper.insertSelective(comments);
    }

    public Integer deleteComment(Long id) {
        Example example = new Example(Comments.class);
        example.createCriteria()
                .andEqualTo("id", id);
        return commentsMapper.deleteByExample(example);
    }

    public List<Comments> findAll() {
        return commentsMapper.selectAll();
    }


}
