package com.hexing.dzk.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hexing.dzk.mapper.DzkAccessRecordsMapper;
import com.hexing.dzk.domain.DzkAccessRecords;
import com.hexing.dzk.service.IDzkAccessRecordsService;
import com.hexing.common.core.text.Convert;

/**
 * 电子刊访问历史Service业务层处理
 * 
 * @author zhuzl
 * @date 2021-05-28
 */
@Service
public class DzkAccessRecordsServiceImpl implements IDzkAccessRecordsService 
{
    @Autowired
    private DzkAccessRecordsMapper dzkAccessRecordsMapper;

    /**
     * 查询电子刊访问历史
     * 
     * @param id 电子刊访问历史ID
     * @return 电子刊访问历史
     */
    @Override
    public DzkAccessRecords selectDzkAccessRecordsById(Long id)
    {
        return dzkAccessRecordsMapper.selectDzkAccessRecordsById(id);
    }

    /**
     * 查询电子刊访问历史列表
     * 
     * @param dzkAccessRecords 电子刊访问历史
     * @return 电子刊访问历史
     */
    @Override
    public List<DzkAccessRecords> selectDzkAccessRecordsList(DzkAccessRecords dzkAccessRecords)
    {
        return dzkAccessRecordsMapper.selectDzkAccessRecordsList(dzkAccessRecords);
    }

    /**
     * 新增电子刊访问历史
     * 
     * @param dzkAccessRecords 电子刊访问历史
     * @return 结果
     */
    @Override
    public int insertDzkAccessRecords(DzkAccessRecords dzkAccessRecords)
    {
        return dzkAccessRecordsMapper.insertDzkAccessRecords(dzkAccessRecords);
    }

    /**
     * 修改电子刊访问历史
     * 
     * @param dzkAccessRecords 电子刊访问历史
     * @return 结果
     */
    @Override
    public int updateDzkAccessRecords(DzkAccessRecords dzkAccessRecords)
    {
        return dzkAccessRecordsMapper.updateDzkAccessRecords(dzkAccessRecords);
    }

    /**
     * 删除电子刊访问历史对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDzkAccessRecordsByIds(String ids)
    {
        return dzkAccessRecordsMapper.deleteDzkAccessRecordsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除电子刊访问历史信息
     * 
     * @param id 电子刊访问历史ID
     * @return 结果
     */
    @Override
    public int deleteDzkAccessRecordsById(Long id)
    {
        return dzkAccessRecordsMapper.deleteDzkAccessRecordsById(id);
    }
}
