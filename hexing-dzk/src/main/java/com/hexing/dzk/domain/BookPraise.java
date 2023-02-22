package com.hexing.dzk.domain;

import java.util.Date;

/**
    * 点赞表
    */
public class BookPraise {
    private Integer id;

    /**
    * 用户id
    */
    private Long userId;

    /**
    * 电子刊id
    */
    private Integer bookId;

    private Date createTime;

    private Date updateTime;

    /**
    * 标志 备用字段
    */
    private Boolean flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}