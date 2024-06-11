package com.ruoyi.ums.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.ums.mapper.UmsStudentMapper;
import com.ruoyi.ums.domain.UmsStudent;
import com.ruoyi.ums.service.IUmsStudentService;
import com.ruoyi.common.core.text.Convert;

/**
 * 学生管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-06-11
 */
@Service
public class UmsStudentServiceImpl implements IUmsStudentService 
{
    @Autowired
    private UmsStudentMapper umsStudentMapper;

    /**
     * 查询学生管理
     * 
     * @param id 学生管理主键
     * @return 学生管理
     */
    @Override
    public UmsStudent selectUmsStudentById(Integer id)
    {
        return umsStudentMapper.selectUmsStudentById(id);
    }

    /**
     * 查询学生管理列表
     * 
     * @param umsStudent 学生管理
     * @return 学生管理
     */
    @Override
    public List<UmsStudent> selectUmsStudentList(UmsStudent umsStudent)
    {
        return umsStudentMapper.selectUmsStudentList(umsStudent);
    }

    /**
     * 新增学生管理
     * 
     * @param umsStudent 学生管理
     * @return 结果
     */
    @Override
    public int insertUmsStudent(UmsStudent umsStudent)
    {
        return umsStudentMapper.insertUmsStudent(umsStudent);
    }

    /**
     * 修改学生管理
     * 
     * @param umsStudent 学生管理
     * @return 结果
     */
    @Override
    public int updateUmsStudent(UmsStudent umsStudent)
    {
        return umsStudentMapper.updateUmsStudent(umsStudent);
    }

    /**
     * 批量删除学生管理
     * 
     * @param ids 需要删除的学生管理主键
     * @return 结果
     */
    @Override
    public int deleteUmsStudentByIds(String ids)
    {
        return umsStudentMapper.deleteUmsStudentByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学生管理信息
     * 
     * @param id 学生管理主键
     * @return 结果
     */
    @Override
    public int deleteUmsStudentById(Integer id)
    {
        return umsStudentMapper.deleteUmsStudentById(id);
    }
}
