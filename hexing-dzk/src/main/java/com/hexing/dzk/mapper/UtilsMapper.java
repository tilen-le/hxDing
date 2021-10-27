package com.hexing.dzk.mapper;

import com.hexing.dzk.domain.DzkAccessRecords;

import java.util.List;

/**
 * utils Mapper接口
 * 
 * @author zhuzl
 * @date 2021-05-28
 */
public interface UtilsMapper
{
    /**
     *  查询一级部门名称
     * 
     * @param userid 用户id
     * @return 电子刊访问历史
     */
    public String getDeptOne(String userid);

}
