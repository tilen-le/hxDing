package com.hexing.dzk.domain;

import com.hexing.common.annotation.Excel;
import com.hexing.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * token配置设置对象 set_configuration_token
 * 
 * @author zhuzl
 * @date 2021-05-28
 */
public class SetConfigurationToken extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /** 配置的中文名 */
    @Excel(name = "配置的中文名")
    private String name;

    /** 配置的参数名 */
    @Excel(name = "配置的参数名")
    private String setKey;

    /** 配置的值 */
    @Excel(name = "配置的值")
    private String setValue;

    /** AppKey */
    @Excel(name = "AppKey")
    private String appKey;

    /** AppSecret */
    @Excel(name = "AppSecret")
    private String appSecret;

    /** 备用 */
    @Excel(name = "备用")
    private String other;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setSetKey(String setKey) 
    {
        this.setKey = setKey;
    }

    public String getSetKey() 
    {
        return setKey;
    }
    public void setSetValue(String setValue) 
    {
        this.setValue = setValue;
    }

    public String getSetValue() 
    {
        return setValue;
    }
    public void setAppKey(String appKey) 
    {
        this.appKey = appKey;
    }

    public String getAppKey() 
    {
        return appKey;
    }
    public void setAppSecret(String appSecret) 
    {
        this.appSecret = appSecret;
    }

    public String getAppSecret() 
    {
        return appSecret;
    }
    public void setOther(String other) 
    {
        this.other = other;
    }

    public String getOther() 
    {
        return other;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("setKey", getSetKey())
            .append("setValue", getSetValue())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("appKey", getAppKey())
            .append("appSecret", getAppSecret())
            .append("other", getOther())
            .toString();
    }
}
