package com.ruoyi.mms.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mms.mapper.MmsUserMapper;
import com.ruoyi.mms.domain.MmsUser;
import com.ruoyi.mms.service.IMmsUserService;
import com.ruoyi.common.core.text.Convert;

/**
 * 用户管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-06-12
 */
@Service
public class MmsUserServiceImpl implements IMmsUserService 
{
    @Autowired
    private MmsUserMapper mmsUserMapper;

    /**
     * 查询用户管理
     * 
     * @param id 用户管理主键
     * @return 用户管理
     */
    @Override
    public MmsUser selectMmsUserById(Long id)
    {
        return mmsUserMapper.selectMmsUserById(id);
    }

    /**
     * 查询用户管理列表
     * 
     * @param mmsUser 用户管理
     * @return 用户管理
     */
    @Override
    public List<MmsUser> selectMmsUserList(MmsUser mmsUser)
    {
        return mmsUserMapper.selectMmsUserList(mmsUser);
    }

    /**
     * 新增用户管理
     * 
     * @param mmsUser 用户管理
     * @return 结果
     */
    @Override
    public int insertMmsUser(MmsUser mmsUser)
    {
        mmsUser.setCreateTime(DateUtils.getNowDate());
        return mmsUserMapper.insertMmsUser(mmsUser);
    }

    /**
     * 修改用户管理
     * 
     * @param mmsUser 用户管理
     * @return 结果
     */
    @Override
    public int updateMmsUser(MmsUser mmsUser)
    {
        mmsUser.setUpdateTime(DateUtils.getNowDate());
        return mmsUserMapper.updateMmsUser(mmsUser);
    }

    /**
     * 批量删除用户管理
     * 
     * @param ids 需要删除的用户管理主键
     * @return 结果
     */
    @Override
    public int deleteMmsUserByIds(String ids)
    {
        return mmsUserMapper.deleteMmsUserByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户管理信息
     * 
     * @param id 用户管理主键
     * @return 结果
     */
    @Override
    public int deleteMmsUserById(Long id)
    {
        return mmsUserMapper.deleteMmsUserById(id);
    }
}
