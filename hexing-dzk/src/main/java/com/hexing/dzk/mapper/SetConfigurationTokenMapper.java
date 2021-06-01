package com.hexing.dzk.mapper;

import java.util.List;
import com.hexing.dzk.domain.SetConfigurationToken;

/**
 * token配置设置Mapper接口
 * 
 * @author zhuzl
 * @date 2021-05-28
 */
public interface SetConfigurationTokenMapper 
{
    /**
     * 查询token配置设置
     * 
     * @param id token配置设置ID
     * @return token配置设置
     */
    public SetConfigurationToken selectSetConfigurationTokenById(Long id);

    /**
     * 查询token配置设置列表
     * 
     * @param setConfigurationToken token配置设置
     * @return token配置设置集合
     */
    public List<SetConfigurationToken> selectSetConfigurationTokenList(SetConfigurationToken setConfigurationToken);

    /**
     * 新增token配置设置
     * 
     * @param setConfigurationToken token配置设置
     * @return 结果
     */
    public int insertSetConfigurationToken(SetConfigurationToken setConfigurationToken);

    /**
     * 修改token配置设置
     * 
     * @param setConfigurationToken token配置设置
     * @return 结果
     */
    public int updateSetConfigurationToken(SetConfigurationToken setConfigurationToken);

    /**
     * 删除token配置设置
     * 
     * @param id token配置设置ID
     * @return 结果
     */
    public int deleteSetConfigurationTokenById(Long id);

    /**
     * 批量删除token配置设置
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSetConfigurationTokenByIds(String[] ids);
}
