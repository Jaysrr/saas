package com.saas.pojo;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;
@Data
@Table(name = "t_express_info_status")
public class ExpressInfoStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String info;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 物流状态信息细节
     */
    private Short status;

    /**
     * 物流状态信息细节
     */
    @Column(name = "status_info")
    private String statusInfo;

    /**
     * 冗余 做数据分析用
     */
    @Column(name = "order_id")
    private Long orderId;

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
     * @return info
     */
    public String getInfo() {
        return info;
    }

    /**
     * @param info
     */
    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
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
     * 获取物流状态信息细节
     *
     * @return status - 物流状态信息细节
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 设置物流状态信息细节
     *
     * @param status 物流状态信息细节
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * 获取物流状态信息细节
     *
     * @return status_info - 物流状态信息细节
     */
    public String getStatusInfo() {
        return statusInfo;
    }

    /**
     * 设置物流状态信息细节
     *
     * @param statusInfo 物流状态信息细节
     */
    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo == null ? null : statusInfo.trim();
    }

    /**
     * 获取冗余 做数据分析用
     *
     * @return order_id - 冗余 做数据分析用
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * 设置冗余 做数据分析用
     *
     * @param orderId 冗余 做数据分析用
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}