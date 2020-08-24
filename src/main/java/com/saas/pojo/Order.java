package com.saas.pojo;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;
@Data
@Table(name = "t_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    private Long pid;

    /**
     * 可以表示购物车id,也可表示商品id
     */
    @Column(name = "want_id")
    private Long wantId;

    /**
     * 0表示立刻下单，1表示购物车下单 
     */
    @Column(name = "want_type")
    private Short wantType;

    /**
     * 购买的数量
     */
    private Integer number;

    @Column(name = "total_price")
    private Double totalPrice;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 0未支付， 1已支付，2支付失败
     */
    private Short status;

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
     * 获取可以表示购物车id,也可表示商品id
     *
     * @return want_id - 可以表示购物车id,也可表示商品id
     */
    public Long getWantId() {
        return wantId;
    }

    /**
     * 设置可以表示购物车id,也可表示商品id
     *
     * @param wantId 可以表示购物车id,也可表示商品id
     */
    public void setWantId(Long wantId) {
        this.wantId = wantId;
    }

    /**
     * 获取0表示立刻下单，1表示购物车下单 
     *
     * @return want_type - 0表示立刻下单，1表示购物车下单 
     */
    public Short getWantType() {
        return wantType;
    }

    /**
     * 设置0表示立刻下单，1表示购物车下单 
     *
     * @param wantType 0表示立刻下单，1表示购物车下单 
     */
    public void setWantType(Short wantType) {
        this.wantType = wantType;
    }

    /**
     * 获取购买的数量
     *
     * @return number - 购买的数量
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * 设置购买的数量
     *
     * @param number 购买的数量
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * @return total_price
     */
    public Double getTotalPrice() {
        return totalPrice;
    }

    /**
     * @param totalPrice
     */
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
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
     * 获取0未支付， 1已支付，2支付失败
     *
     * @return status - 0未支付， 1已支付，2支付失败
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 设置0未支付， 1已支付，2支付失败
     *
     * @param status 0未支付， 1已支付，2支付失败
     */
    public void setStatus(Short status) {
        this.status = status;
    }
}