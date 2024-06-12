package com.ruoyi.mms.service;

import java.util.List;
import com.ruoyi.mms.domain.MmsFeedback;

/**
 * 反馈管理Service接口
 * 
 * @author ruoyi
 * @date 2024-06-13
 */
public interface IMmsFeedbackService 
{
    /**
     * 查询反馈管理
     * 
     * @param id 反馈管理主键
     * @return 反馈管理
     */
    public MmsFeedback selectMmsFeedbackById(Long id);

    /**
     * 查询反馈管理列表
     * 
     * @param mmsFeedback 反馈管理
     * @return 反馈管理集合
     */
    public List<MmsFeedback> selectMmsFeedbackList(MmsFeedback mmsFeedback);

    /**
     * 新增反馈管理
     * 
     * @param mmsFeedback 反馈管理
     * @return 结果
     */
    public int insertMmsFeedback(MmsFeedback mmsFeedback);

    /**
     * 修改反馈管理
     * 
     * @param mmsFeedback 反馈管理
     * @return 结果
     */
    public int updateMmsFeedback(MmsFeedback mmsFeedback);

    /**
     * 批量删除反馈管理
     * 
     * @param ids 需要删除的反馈管理主键集合
     * @return 结果
     */
    public int deleteMmsFeedbackByIds(String ids);

    /**
     * 删除反馈管理信息
     * 
     * @param id 反馈管理主键
     * @return 结果
     */
    public int deleteMmsFeedbackById(Long id);
}
