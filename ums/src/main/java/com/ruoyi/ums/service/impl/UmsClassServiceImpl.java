package com.ruoyi.ums.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.ums.mapper.UmsClassMapper;
import com.ruoyi.ums.domain.UmsClass;
import com.ruoyi.ums.service.IUmsClassService;
import com.ruoyi.common.core.text.Convert;

/**
 * 班级管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-06-11
 */
@Service
public class UmsClassServiceImpl implements IUmsClassService 
{
    @Autowired
    private UmsClassMapper umsClassMapper;

    /**
     * 查询班级管理
     * 
     * @param id 班级管理主键
     * @return 班级管理
     */
    @Override
    public UmsClass selectUmsClassById(Integer id)
    {
        return umsClassMapper.selectUmsClassById(id);
    }

    /**
     * 查询班级管理列表
     * 
     * @param umsClass 班级管理
     * @return 班级管理
     */
    @Override
    public List<UmsClass> selectUmsClassList(UmsClass umsClass)
    {
        return umsClassMapper.selectUmsClassList(umsClass);
    }

    /**
     * 新增班级管理
     * 
     * @param umsClass 班级管理
     * @return 结果
     */
    @Override
    public int insertUmsClass(UmsClass umsClass)
    {
        return umsClassMapper.insertUmsClass(umsClass);
    }

    /**
     * 修改班级管理
     * 
     * @param umsClass 班级管理
     * @return 结果
     */
    @Override
    public int updateUmsClass(UmsClass umsClass)
    {
        return umsClassMapper.updateUmsClass(umsClass);
    }

    /**
     * 批量删除班级管理
     * 
     * @param ids 需要删除的班级管理主键
     * @return 结果
     */
    @Override
    public int deleteUmsClassByIds(String ids)
    {
        return umsClassMapper.deleteUmsClassByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除班级管理信息
     * 
     * @param id 班级管理主键
     * @return 结果
     */
    @Override
    public int deleteUmsClassById(Integer id)
    {
        return umsClassMapper.deleteUmsClassById(id);
    }
}
