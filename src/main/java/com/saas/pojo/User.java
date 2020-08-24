package com.saas.pojo;

import lombok.Data;

import java.util.Date;
import javax.persistence.*;
@Data
@Table(name = "t_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "phone_number")
    private String phoneNumber;

    private String password;

    /**
     * 0为普通会员 1为vip 
     */
    @Column(name = "is_vip")
    private Short isVip;

    @Column(name = "nick_name")
    private String nickName;

    /**
     * 身份证号
     */
    @Column(name = "id_number")
    private String idNumber;

    /**
     * 中文名
     */
    @Column(name = "chinese_name")
    private String chineseName;

    /**
     * 头像
     */
    @Column(name = "img_url")
    private String imgUrl;

    /**
     * 真人照片
     */
    @Column(name = "face_url")
    private String faceUrl;

    /**
     * 商户id
     */
    private Long pid;

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
     * 获取0为普通会员 1为vip 
     *
     * @return is_vip - 0为普通会员 1为vip 
     */
    public Short getIsVip() {
        return isVip;
    }

    /**
     * 设置0为普通会员 1为vip 
     *
     * @param isVip 0为普通会员 1为vip 
     */
    public void setIsVip(Short isVip) {
        this.isVip = isVip;
    }

    /**
     * @return nick_name
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * @param nickName
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * 获取身份证号
     *
     * @return id_number - 身份证号
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * 设置身份证号
     *
     * @param idNumber 身份证号
     */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber == null ? null : idNumber.trim();
    }

    /**
     * 获取中文名
     *
     * @return chinese_name - 中文名
     */
    public String getChineseName() {
        return chineseName;
    }

    /**
     * 设置中文名
     *
     * @param chineseName 中文名
     */
    public void setChineseName(String chineseName) {
        this.chineseName = chineseName == null ? null : chineseName.trim();
    }

    /**
     * 获取头像
     *
     * @return img_url - 头像
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * 设置头像
     *
     * @param imgUrl 头像
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    /**
     * 获取真人照片
     *
     * @return face_url - 真人照片
     */
    public String getFaceUrl() {
        return faceUrl;
    }

    /**
     * 设置真人照片
     *
     * @param faceUrl 真人照片
     */
    public void setFaceUrl(String faceUrl) {
        this.faceUrl = faceUrl == null ? null : faceUrl.trim();
    }

    /**
     * 获取商户id
     *
     * @return pid - 商户id
     */
    public Long getPid() {
        return pid;
    }

    /**
     * 设置商户id
     *
     * @param pid 商户id
     */
    public void setPid(Long pid) {
        this.pid = pid;
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