package com.saas.pojo;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;
@Data
@Table(name = "t_goods")
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "goods_name")
    private String goodsName;

    private Double price;

    @Column(name = "img_url")
    private String imgUrl;

    /**
     * 产地
     */
    private String address;

    @Column(name = "content_id")
    private Long contentId;

    /**
     * 库存
     */
    @Column(name = "exist_number")
    private Integer existNumber;

    private Long pid;

    /**
     * 0未上架 1已上架 2已下架
     */
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
     * @return goods_name
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * @param goodsName
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    /**
     * @return price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * @return img_url
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * @param imgUrl
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    /**
     * 获取产地
     *
     * @return address - 产地
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置产地
     *
     * @param address 产地
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * @return content_id
     */
    public Long getContentId() {
        return contentId;
    }

    /**
     * @param contentId
     */
    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    /**
     * 获取库存
     *
     * @return exist_number - 库存
     */
    public Integer getExistNumber() {
        return existNumber;
    }

    /**
     * 设置库存
     *
     * @param existNumber 库存
     */
    public void setExistNumber(Integer existNumber) {
        this.existNumber = existNumber;
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
     * 获取0未上架 1已上架 2已下架
     *
     * @return status - 0未上架 1已上架 2已下架
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 设置0未上架 1已上架 2已下架
     *
     * @param status 0未上架 1已上架 2已下架
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