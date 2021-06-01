package com.hexing.dzk.mapper;

import java.util.List;
import com.hexing.dzk.domain.DzkAccessRecords;

/**
 * 电子刊访问历史Mapper接口
 * 
 * @author zhuzl
 * @date 2021-05-28
 */
public interface DzkAccessRecordsMapper 
{
    /**
     * 查询电子刊访问历史
     * 
     * @param id 电子刊访问历史ID
     * @return 电子刊访问历史
     */
    public DzkAccessRecords selectDzkAccessRecordsById(Long id);

    /**
     * 查询电子刊访问历史列表
     * 
     * @param dzkAccessRecords 电子刊访问历史
     * @return 电子刊访问历史集合
     */
    public List<DzkAccessRecords> selectDzkAccessRecordsList(DzkAccessRecords dzkAccessRecords);

    /**
     * 新增电子刊访问历史
     * 
     * @param dzkAccessRecords 电子刊访问历史
     * @return 结果
     */
    public int insertDzkAccessRecords(DzkAccessRecords dzkAccessRecords);

    /**
     * 修改电子刊访问历史
     * 
     * @param dzkAccessRecords 电子刊访问历史
     * @return 结果
     */
    public int updateDzkAccessRecords(DzkAccessRecords dzkAccessRecords);

    /**
     * 删除电子刊访问历史
     * 
     * @param id 电子刊访问历史ID
     * @return 结果
     */
    public int deleteDzkAccessRecordsById(Long id);

    /**
     * 批量删除电子刊访问历史
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDzkAccessRecordsByIds(String[] ids);
}
