package com.saas.pojo;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;
@Data
@Table(name = "t_express_info")
public class ExpressInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "sender_phone")
    private String senderPhone;

    @Column(name = "sender_name")
    private String senderName;

    @Column(name = "receiver_phone")
    private String receiverPhone;

    @Column(name = "receiver_name")
    private String receiverName;

    /**
     * 物流状态 
     */
    private Short status;

    /**
     * 快递单号
     */
    @Column(name = "express_code")
    private String expressCode;

    /**
     * 快递公司id
     */
    @Column(name = "express_id")
    private Long expressId;

    /**
     * 商品图片 - 冗余
     */
    @Column(name = "img_url")
    private String imgUrl;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 冗余
     */
    private Long pid;

    /**
     * 用于加速查询物流状态，此id对应info_status_speed_up的id，再通过那个表的id_list（里面的id都是对应status的主键id），找出status的其余数据
     */
    @Column(name = "express_info_status_speed_up_id")
    private Long expressInfoStatusSpeedUpId;

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
     * @return order_id
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * @param orderId
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * @return sender_phone
     */
    public String getSenderPhone() {
        return senderPhone;
    }

    /**
     * @param senderPhone
     */
    public void setSenderPhone(String senderPhone) {
        this.senderPhone = senderPhone == null ? null : senderPhone.trim();
    }

    /**
     * @return sender_name
     */
    public String getSenderName() {
        return senderName;
    }

    /**
     * @param senderName
     */
    public void setSenderName(String senderName) {
        this.senderName = senderName == null ? null : senderName.trim();
    }

    /**
     * @return receiver_phone
     */
    public String getReceiverPhone() {
        return receiverPhone;
    }

    /**
     * @param receiverPhone
     */
    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone == null ? null : receiverPhone.trim();
    }

    /**
     * @return receiver_name
     */
    public String getReceiverName() {
        return receiverName;
    }

    /**
     * @param receiverName
     */
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName == null ? null : receiverName.trim();
    }

    /**
     * 获取物流状态 
     *
     * @return status - 物流状态 
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 设置物流状态 
     *
     * @param status 物流状态 
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * 获取快递单号
     *
     * @return express_code - 快递单号
     */
    public String getExpressCode() {
        return expressCode;
    }

    /**
     * 设置快递单号
     *
     * @param expressCode 快递单号
     */
    public void setExpressCode(String expressCode) {
        this.expressCode = expressCode == null ? null : expressCode.trim();
    }

    /**
     * 获取快递公司id
     *
     * @return express_id - 快递公司id
     */
    public Long getExpressId() {
        return expressId;
    }

    /**
     * 设置快递公司id
     *
     * @param expressId 快递公司id
     */
    public void setExpressId(Long expressId) {
        this.expressId = expressId;
    }

    /**
     * 获取商品图片 - 冗余
     *
     * @return img_url - 商品图片 - 冗余
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * 设置商品图片 - 冗余
     *
     * @param imgUrl 商品图片 - 冗余
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
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

    /**
     * 获取冗余
     *
     * @return pid - 冗余
     */
    public Long getPid() {
        return pid;
    }

    /**
     * 设置冗余
     *
     * @param pid 冗余
     */
    public void setPid(Long pid) {
        this.pid = pid;
    }

    /**
     * 获取用于加速查询物流状态，此id对应info_status_speed_up的id，再通过那个表的id_list（里面的id都是对应status的主键id），找出status的其余数据
     *
     * @return express_info_status_speed_up_id - 用于加速查询物流状态，此id对应info_status_speed_up的id，再通过那个表的id_list（里面的id都是对应status的主键id），找出status的其余数据
     */
    public Long getExpressInfoStatusSpeedUpId() {
        return expressInfoStatusSpeedUpId;
    }

    /**
     * 设置用于加速查询物流状态，此id对应info_status_speed_up的id，再通过那个表的id_list（里面的id都是对应status的主键id），找出status的其余数据
     *
     * @param expressInfoStatusSpeedUpId 用于加速查询物流状态，此id对应info_status_speed_up的id，再通过那个表的id_list（里面的id都是对应status的主键id），找出status的其余数据
     */
    public void setExpressInfoStatusSpeedUpId(Long expressInfoStatusSpeedUpId) {
        this.expressInfoStatusSpeedUpId = expressInfoStatusSpeedUpId;
    }
}