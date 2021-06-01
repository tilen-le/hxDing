package com.hexing.dzk.service.impl;

import java.util.List;
import com.hexing.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hexing.dzk.mapper.DzkLilstMapper;
import com.hexing.dzk.domain.DzkLilst;
import com.hexing.dzk.service.IDzkLilstService;
import com.hexing.common.core.text.Convert;

/**
 * 电子刊列表Service业务层处理
 * 
 * @author zhuzl
 * @date 2021-05-27
 */
@Service
public class DzkLilstServiceImpl implements IDzkLilstService 
{
    @Autowired
    private DzkLilstMapper dzkLilstMapper;

    /**
     * 查询电子刊列表
     * 
     * @param id 电子刊列表ID
     * @return 电子刊列表
     */
    @Override
    public DzkLilst selectDzkLilstById(Long id)
    {
        return dzkLilstMapper.selectDzkLilstById(id);
    }

    /**
     * 查询电子刊列表列表
     * 
     * @param dzkLilst 电子刊列表
     * @return 电子刊列表
     */
    @Override
    public List<DzkLilst> selectDzkLilstList(DzkLilst dzkLilst)
    {
        return dzkLilstMapper.selectDzkLilstList(dzkLilst);
    }

    /**
     * 新增电子刊列表
     * 
     * @param dzkLilst 电子刊列表
     * @return 结果
     */
    @Override
    public int insertDzkLilst(DzkLilst dzkLilst)
    {
        dzkLilst.setCreateTime(DateUtils.getNowDate());
        return dzkLilstMapper.insertDzkLilst(dzkLilst);
    }

    /**
     * 修改电子刊列表
     * 
     * @param dzkLilst 电子刊列表
     * @return 结果
     */
    @Override
    public int updateDzkLilst(DzkLilst dzkLilst)
    {
        dzkLilst.setUpdateTime(DateUtils.getNowDate());
        return dzkLilstMapper.updateDzkLilst(dzkLilst);
    }

    /**
     * 删除电子刊列表对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDzkLilstByIds(String ids)
    {
        return dzkLilstMapper.deleteDzkLilstByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除电子刊列表信息
     * 
     * @param id 电子刊列表ID
     * @return 结果
     */
    @Override
    public int deleteDzkLilstById(Long id)
    {
        return dzkLilstMapper.deleteDzkLilstById(id);
    }
}
