package com.hexing.dzk.service.impl;

import java.util.List;
import com.hexing.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hexing.dzk.mapper.SetConfigurationTokenMapper;
import com.hexing.dzk.domain.SetConfigurationToken;
import com.hexing.dzk.service.ISetConfigurationTokenService;
import com.hexing.common.core.text.Convert;

/**
 * token配置设置Service业务层处理
 * 
 * @author zhuzl
 * @date 2021-05-28
 */
@Service
public class SetConfigurationTokenServiceImpl implements ISetConfigurationTokenService 
{
    @Autowired
    private SetConfigurationTokenMapper setConfigurationTokenMapper;

    /**
     * 查询token配置设置
     * 
     * @param id token配置设置ID
     * @return token配置设置
     */
    @Override
    public SetConfigurationToken selectSetConfigurationTokenById(Long id)
    {
        return setConfigurationTokenMapper.selectSetConfigurationTokenById(id);
    }

    /**
     * 查询token配置设置列表
     * 
     * @param setConfigurationToken token配置设置
     * @return token配置设置
     */
    @Override
    public List<SetConfigurationToken> selectSetConfigurationTokenList(SetConfigurationToken setConfigurationToken)
    {
        return setConfigurationTokenMapper.selectSetConfigurationTokenList(setConfigurationToken);
    }

    /**
     * 新增token配置设置
     * 
     * @param setConfigurationToken token配置设置
     * @return 结果
     */
    @Override
    public int insertSetConfigurationToken(SetConfigurationToken setConfigurationToken)
    {
        setConfigurationToken.setCreateTime(DateUtils.getNowDate());
        return setConfigurationTokenMapper.insertSetConfigurationToken(setConfigurationToken);
    }

    /**
     * 修改token配置设置
     * 
     * @param setConfigurationToken token配置设置
     * @return 结果
     */
    @Override
    public int updateSetConfigurationToken(SetConfigurationToken setConfigurationToken)
    {
        setConfigurationToken.setUpdateTime(DateUtils.getNowDate());
        return setConfigurationTokenMapper.updateSetConfigurationToken(setConfigurationToken);
    }

    /**
     * 删除token配置设置对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSetConfigurationTokenByIds(String ids)
    {
        return setConfigurationTokenMapper.deleteSetConfigurationTokenByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除token配置设置信息
     * 
     * @param id token配置设置ID
     * @return 结果
     */
    @Override
    public int deleteSetConfigurationTokenById(Long id)
    {
        return setConfigurationTokenMapper.deleteSetConfigurationTokenById(id);
    }
}
