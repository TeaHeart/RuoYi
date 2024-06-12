package com.ruoyi.mms.mapper;

import java.util.List;
import com.ruoyi.mms.domain.MmsUser;

/**
 * 用户管理Mapper接口
 * 
 * @author ruoyi
 * @date 2024-06-12
 */
public interface MmsUserMapper 
{
    /**
     * 查询用户管理
     * 
     * @param id 用户管理主键
     * @return 用户管理
     */
    public MmsUser selectMmsUserById(Long id);

    /**
     * 查询用户管理列表
     * 
     * @param mmsUser 用户管理
     * @return 用户管理集合
     */
    public List<MmsUser> selectMmsUserList(MmsUser mmsUser);

    /**
     * 新增用户管理
     * 
     * @param mmsUser 用户管理
     * @return 结果
     */
    public int insertMmsUser(MmsUser mmsUser);

    /**
     * 修改用户管理
     * 
     * @param mmsUser 用户管理
     * @return 结果
     */
    public int updateMmsUser(MmsUser mmsUser);

    /**
     * 删除用户管理
     * 
     * @param id 用户管理主键
     * @return 结果
     */
    public int deleteMmsUserById(Long id);

    /**
     * 批量删除用户管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMmsUserByIds(String[] ids);
}
