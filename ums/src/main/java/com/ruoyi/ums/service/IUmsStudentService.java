package com.ruoyi.ums.service;

import java.util.List;
import com.ruoyi.ums.domain.UmsStudent;

/**
 * 学生管理Service接口
 * 
 * @author ruoyi
 * @date 2024-06-11
 */
public interface IUmsStudentService 
{
    /**
     * 查询学生管理
     * 
     * @param id 学生管理主键
     * @return 学生管理
     */
    public UmsStudent selectUmsStudentById(Integer id);

    /**
     * 查询学生管理列表
     * 
     * @param umsStudent 学生管理
     * @return 学生管理集合
     */
    public List<UmsStudent> selectUmsStudentList(UmsStudent umsStudent);

    /**
     * 新增学生管理
     * 
     * @param umsStudent 学生管理
     * @return 结果
     */
    public int insertUmsStudent(UmsStudent umsStudent);

    /**
     * 修改学生管理
     * 
     * @param umsStudent 学生管理
     * @return 结果
     */
    public int updateUmsStudent(UmsStudent umsStudent);

    /**
     * 批量删除学生管理
     * 
     * @param ids 需要删除的学生管理主键集合
     * @return 结果
     */
    public int deleteUmsStudentByIds(String ids);

    /**
     * 删除学生管理信息
     * 
     * @param id 学生管理主键
     * @return 结果
     */
    public int deleteUmsStudentById(Integer id);
}
