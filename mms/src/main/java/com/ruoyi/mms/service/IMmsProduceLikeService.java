package com.ruoyi.mms.service;

import java.util.List;
import com.ruoyi.mms.domain.MmsProduceLike;

/**
 * 产品收藏管理Service接口
 * 
 * @author ruoyi
 * @date 2024-06-13
 */
public interface IMmsProduceLikeService 
{
    /**
     * 查询产品收藏管理
     * 
     * @param id 产品收藏管理主键
     * @return 产品收藏管理
     */
    public MmsProduceLike selectMmsProduceLikeById(Long id);

    /**
     * 查询产品收藏管理列表
     * 
     * @param mmsProduceLike 产品收藏管理
     * @return 产品收藏管理集合
     */
    public List<MmsProduceLike> selectMmsProduceLikeList(MmsProduceLike mmsProduceLike);

    /**
     * 新增产品收藏管理
     * 
     * @param mmsProduceLike 产品收藏管理
     * @return 结果
     */
    public int insertMmsProduceLike(MmsProduceLike mmsProduceLike);

    /**
     * 修改产品收藏管理
     * 
     * @param mmsProduceLike 产品收藏管理
     * @return 结果
     */
    public int updateMmsProduceLike(MmsProduceLike mmsProduceLike);

    /**
     * 批量删除产品收藏管理
     * 
     * @param ids 需要删除的产品收藏管理主键集合
     * @return 结果
     */
    public int deleteMmsProduceLikeByIds(String ids);

    /**
     * 删除产品收藏管理信息
     * 
     * @param id 产品收藏管理主键
     * @return 结果
     */
    public int deleteMmsProduceLikeById(Long id);
}
