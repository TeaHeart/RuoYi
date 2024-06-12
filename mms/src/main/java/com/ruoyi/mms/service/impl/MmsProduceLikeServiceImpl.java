package com.ruoyi.mms.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mms.mapper.MmsProduceLikeMapper;
import com.ruoyi.mms.domain.MmsProduceLike;
import com.ruoyi.mms.service.IMmsProduceLikeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 产品收藏管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-06-13
 */
@Service
public class MmsProduceLikeServiceImpl implements IMmsProduceLikeService 
{
    @Autowired
    private MmsProduceLikeMapper mmsProduceLikeMapper;

    /**
     * 查询产品收藏管理
     * 
     * @param id 产品收藏管理主键
     * @return 产品收藏管理
     */
    @Override
    public MmsProduceLike selectMmsProduceLikeById(Long id)
    {
        return mmsProduceLikeMapper.selectMmsProduceLikeById(id);
    }

    /**
     * 查询产品收藏管理列表
     * 
     * @param mmsProduceLike 产品收藏管理
     * @return 产品收藏管理
     */
    @Override
    public List<MmsProduceLike> selectMmsProduceLikeList(MmsProduceLike mmsProduceLike)
    {
        return mmsProduceLikeMapper.selectMmsProduceLikeList(mmsProduceLike);
    }

    /**
     * 新增产品收藏管理
     * 
     * @param mmsProduceLike 产品收藏管理
     * @return 结果
     */
    @Override
    public int insertMmsProduceLike(MmsProduceLike mmsProduceLike)
    {
        mmsProduceLike.setCreateTime(DateUtils.getNowDate());
        return mmsProduceLikeMapper.insertMmsProduceLike(mmsProduceLike);
    }

    /**
     * 修改产品收藏管理
     * 
     * @param mmsProduceLike 产品收藏管理
     * @return 结果
     */
    @Override
    public int updateMmsProduceLike(MmsProduceLike mmsProduceLike)
    {
        mmsProduceLike.setUpdateTime(DateUtils.getNowDate());
        return mmsProduceLikeMapper.updateMmsProduceLike(mmsProduceLike);
    }

    /**
     * 批量删除产品收藏管理
     * 
     * @param ids 需要删除的产品收藏管理主键
     * @return 结果
     */
    @Override
    public int deleteMmsProduceLikeByIds(String ids)
    {
        return mmsProduceLikeMapper.deleteMmsProduceLikeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除产品收藏管理信息
     * 
     * @param id 产品收藏管理主键
     * @return 结果
     */
    @Override
    public int deleteMmsProduceLikeById(Long id)
    {
        return mmsProduceLikeMapper.deleteMmsProduceLikeById(id);
    }
}
