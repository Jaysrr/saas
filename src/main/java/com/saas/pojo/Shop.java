package com.saas.pojo;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;
@Data
@Table(name = "t_shop")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shop_name")
    private String shopName;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String password;

    /**
     * 营业执照
     */
    @Column(name = "business_license")
    private String businessLicense;

    /**
     * 状态 0待认证 1已认证 2被关闭  3已过期' 
     */
    private Short status;

    /**
     * 店铺等级 0未购买  1标准版 2vip版 3钻石版'  
     */
    private Short level;

    private String address;

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
     * @return shop_name
     */
    public String getShopName() {
        return shopName;
    }

    /**
     * @param shopName
     */
    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    /**
     * @return phone_number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取营业执照
     *
     * @return business_license - 营业执照
     */
    public String getBusinessLicense() {
        return businessLicense;
    }

    /**
     * 设置营业执照
     *
     * @param businessLicense 营业执照
     */
    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense == null ? null : businessLicense.trim();
    }

    /**
     * 获取状态 0待认证 1已认证 2被关闭  3已过期' 
     *
     * @return status - 状态 0待认证 1已认证 2被关闭  3已过期' 
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 设置状态 0待认证 1已认证 2被关闭  3已过期' 
     *
     * @param status 状态 0待认证 1已认证 2被关闭  3已过期' 
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * 获取店铺等级 0未购买  1标准版 2vip版 3钻石版'  
     *
     * @return level - 店铺等级 0未购买  1标准版 2vip版 3钻石版'  
     */
    public Short getLevel() {
        return level;
    }

    /**
     * 设置店铺等级 0未购买  1标准版 2vip版 3钻石版'  
     *
     * @param level 店铺等级 0未购买  1标准版 2vip版 3钻石版'  
     */
    public void setLevel(Short level) {
        this.level = level;
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
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