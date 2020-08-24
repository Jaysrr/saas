package com.saas.pojo;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;
@Data
@Table(name = "t_pay")
public class Pay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "pay_money")
    private Double payMoney;

    /**
     * 支付类型的id，连接另外一张表
     */
    @Column(name = "pay_type_id")
    private Long payTypeId;

    /**
     * 支付之后的状态信息
     */
    @Column(name = "return_code")
    private String returnCode;

    private Short status;

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
     * @return pay_money
     */
    public Double getPayMoney() {
        return payMoney;
    }

    /**
     * @param payMoney
     */
    public void setPayMoney(Double payMoney) {
        this.payMoney = payMoney;
    }

    /**
     * 获取支付类型的id，连接另外一张表
     *
     * @return pay_type_id - 支付类型的id，连接另外一张表
     */
    public Long getPayTypeId() {
        return payTypeId;
    }

    /**
     * 设置支付类型的id，连接另外一张表
     *
     * @param payTypeId 支付类型的id，连接另外一张表
     */
    public void setPayTypeId(Long payTypeId) {
        this.payTypeId = payTypeId;
    }

    /**
     * 获取支付之后的状态信息
     *
     * @return return_code - 支付之后的状态信息
     */
    public String getReturnCode() {
        return returnCode;
    }

    /**
     * 设置支付之后的状态信息
     *
     * @param returnCode 支付之后的状态信息
     */
    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode == null ? null : returnCode.trim();
    }

    /**
     * @return status
     */
    public Short getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Short status) {
        this.status = status;
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