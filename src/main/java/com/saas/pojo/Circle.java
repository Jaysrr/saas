package com.saas.pojo;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;
@Data
@Table(name = "t_circle")
public class Circle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    private Long pid;

    /**
     * 用于查看圈子内容，对应的是t_circle_content的主键id
     */
    @Column(name = "content_id")
    private Long contentId;

    /**
     * 点赞数
     */
    private Long stars;

    /**
     * 评论数
     */
    @Column(name = "comments_times")
    private Integer commentsTimes;

    /**
     * 转发数
     */
    @Column(name = "share_times")
    private Integer shareTimes;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return user_id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return pid
     */
    public Long getPid() {
        return pid;
    }

    /**
     * @param pid
     */
    public void setPid(Long pid) {
        this.pid = pid;
    }

    /**
     * 获取用于查看圈子内容，对应的是t_circle_content的主键id
     *
     * @return content_id - 用于查看圈子内容，对应的是t_circle_content的主键id
     */
    public Long getContentId() {
        return contentId;
    }

    /**
     * 设置用于查看圈子内容，对应的是t_circle_content的主键id
     *
     * @param contentId 用于查看圈子内容，对应的是t_circle_content的主键id
     */
    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    /**
     * 获取点赞数
     *
     * @return stars - 点赞数
     */
    public Long getStars() {
        return stars;
    }

    /**
     * 设置点赞数
     *
     * @param stars 点赞数
     */
    public void setStars(Long stars) {
        this.stars = stars;
    }

    /**
     * 获取评论数
     *
     * @return comments_times - 评论数
     */
    public Integer getCommentsTimes() {
        return commentsTimes;
    }

    /**
     * 设置评论数
     *
     * @param commentsTimes 评论数
     */
    public void setCommentsTimes(Integer commentsTimes) {
        this.commentsTimes = commentsTimes;
    }

    /**
     * 获取转发数
     *
     * @return share_times - 转发数
     */
    public Integer getShareTimes() {
        return shareTimes;
    }

    /**
     * 设置转发数
     *
     * @param shareTimes 转发数
     */
    public void setShareTimes(Integer shareTimes) {
        this.shareTimes = shareTimes;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}