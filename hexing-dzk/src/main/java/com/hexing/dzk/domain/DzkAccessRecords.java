package com.hexing.dzk.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.hexing.common.annotation.Excel;
import com.hexing.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 电子刊访问历史对象 dzk_access_records
 * 
 * @author zhuzl
 * @date 2021-06-08
 */
public class DzkAccessRecords extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 访问的电子刊ID */
    @Excel(name = "访问的电子刊ID")
    private Long dzkId;

    /** 访问工号 */
    @Excel(name = "访问工号")
    private String userid;

    /** 0-详情  1-列表 */
    @Excel(name = "0-详情  1-列表")
    private Long type;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 一级部门名称 */
    @Excel(name = "一级部门名称")
    private String deptOne;

    /** 备用 */
//    @Excel(name = "备用")
    private String other;

    /** 访问时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss ")
    @Excel(name = "访问时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date accessTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDzkId(Long dzkId) 
    {
        this.dzkId = dzkId;
    }

    public Long getDzkId() 
    {
        return dzkId;
    }
    public void setUserid(String userid) 
    {
        this.userid = userid;
    }

    public String getUserid() 
    {
        return userid;
    }
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setDeptOne(String deptOne) 
    {
        this.deptOne = deptOne;
    }

    public String getDeptOne() 
    {
        return deptOne;
    }
    public void setOther(String other) 
    {
        this.other = other;
    }

    public String getOther() 
    {
        return other;
    }
    public void setAccessTime(Date accessTime) 
    {
        this.accessTime = accessTime;
    }

    public Date getAccessTime() 
    {
        return accessTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("dzkId", getDzkId())
            .append("userid", getUserid())
            .append("type", getType())
            .append("title", getTitle())
            .append("deptOne", getDeptOne())
            .append("other", getOther())
            .append("accessTime", getAccessTime())
            .toString();
    }
}
