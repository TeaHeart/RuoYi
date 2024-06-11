package com.ruoyi.ums.service;

import java.util.List;
import com.ruoyi.ums.domain.UmsClass;

/**
 * 班级管理Service接口
 * 
 * @author ruoyi
 * @date 2024-06-11
 */
public interface IUmsClassService 
{
    /**
     * 查询班级管理
     * 
     * @param id 班级管理主键
     * @return 班级管理
     */
    public UmsClass selectUmsClassById(Integer id);

    /**
     * 查询班级管理列表
     * 
     * @param umsClass 班级管理
     * @return 班级管理集合
     */
    public List<UmsClass> selectUmsClassList(UmsClass umsClass);

    /**
     * 新增班级管理
     * 
     * @param umsClass 班级管理
     * @return 结果
     */
    public int insertUmsClass(UmsClass umsClass);

    /**
     * 修改班级管理
     * 
     * @param umsClass 班级管理
     * @return 结果
     */
    public int updateUmsClass(UmsClass umsClass);

    /**
     * 批量删除班级管理
     * 
     * @param ids 需要删除的班级管理主键集合
     * @return 结果
     */
    public int deleteUmsClassByIds(String ids);

    /**
     * 删除班级管理信息
     * 
     * @param id 班级管理主键
     * @return 结果
     */
    public int deleteUmsClassById(Integer id);
}
