package com.hexing.dzk.domain;

import com.hexing.common.annotation.Excel;
import com.hexing.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 电子刊列表对象 dzk_lilst
 * 
 * @author zhuzl
 * @date 2021-05-27
 */
public class DzkLilst extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 封面图片 */
    @Excel(name = "封面图片")
    private String titleImg;

    /** 排序 */
    @Excel(name = "排序")
    private Long sort;

    /** 状态 0-发布中；1-已发布；2-已下架；3-删除 */
    @Excel(name = "状态 0-发布中；1-已发布；2-已下架；3-删除")
    private Long type;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setTitleImg(String titleImg) 
    {
        this.titleImg = titleImg;
    }

    public String getTitleImg() 
    {
        return titleImg;
    }
    public void setSort(Long sort) 
    {
        this.sort = sort;
    }

    public Long getSort() 
    {
        return sort;
    }
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("titleImg", getTitleImg())
            .append("sort", getSort())
            .append("type", getType())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
