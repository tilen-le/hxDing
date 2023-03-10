package com.hexing.dzk.domain;

import java.util.Date;

public class BookComment {
    private Integer id;

    /**
     * 用户id
     */
    private String userId;

    /**
    * 电子刊id
    */
    private Integer bookId;

    /**
     * 用户姓名
     */
    private String userName;

    /**
    * 评论
    */
    private String comment;

    /**
    * 状态
    */
    private String status;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 备注
    */
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}