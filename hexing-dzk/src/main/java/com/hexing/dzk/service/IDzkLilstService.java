package com.hexing.dzk.service;

import java.util.List;
import com.hexing.dzk.domain.DzkLilst;

/**
 * 电子刊列表Service接口
 * 
 * @author zhuzl
 * @date 2021-05-27
 */
public interface IDzkLilstService 
{
    /**
     * 查询电子刊列表
     * 
     * @param id 电子刊列表ID
     * @return 电子刊列表
     */
    public DzkLilst selectDzkLilstById(Long id);

    /**
     * 查询电子刊列表列表
     * 
     * @param dzkLilst 电子刊列表
     * @return 电子刊列表集合
     */
    public List<DzkLilst> selectDzkLilstList(DzkLilst dzkLilst);

    /**
     * 新增电子刊列表
     * 
     * @param dzkLilst 电子刊列表
     * @return 结果
     */
    public int insertDzkLilst(DzkLilst dzkLilst);

    /**
     * 修改电子刊列表
     * 
     * @param dzkLilst 电子刊列表
     * @return 结果
     */
    public int updateDzkLilst(DzkLilst dzkLilst);

    /**
     * 批量删除电子刊列表
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDzkLilstByIds(String ids);

    /**
     * 删除电子刊列表信息
     * 
     * @param id 电子刊列表ID
     * @return 结果
     */
    public int deleteDzkLilstById(Long id);
}
