package com.ruoyi.mms.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mms.mapper.MmsFeedbackMapper;
import com.ruoyi.mms.domain.MmsFeedback;
import com.ruoyi.mms.service.IMmsFeedbackService;
import com.ruoyi.common.core.text.Convert;

/**
 * 反馈管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-06-13
 */
@Service
public class MmsFeedbackServiceImpl implements IMmsFeedbackService 
{
    @Autowired
    private MmsFeedbackMapper mmsFeedbackMapper;

    /**
     * 查询反馈管理
     * 
     * @param id 反馈管理主键
     * @return 反馈管理
     */
    @Override
    public MmsFeedback selectMmsFeedbackById(Long id)
    {
        return mmsFeedbackMapper.selectMmsFeedbackById(id);
    }

    /**
     * 查询反馈管理列表
     * 
     * @param mmsFeedback 反馈管理
     * @return 反馈管理
     */
    @Override
    public List<MmsFeedback> selectMmsFeedbackList(MmsFeedback mmsFeedback)
    {
        return mmsFeedbackMapper.selectMmsFeedbackList(mmsFeedback);
    }

    /**
     * 新增反馈管理
     * 
     * @param mmsFeedback 反馈管理
     * @return 结果
     */
    @Override
    public int insertMmsFeedback(MmsFeedback mmsFeedback)
    {
        mmsFeedback.setCreateTime(DateUtils.getNowDate());
        return mmsFeedbackMapper.insertMmsFeedback(mmsFeedback);
    }

    /**
     * 修改反馈管理
     * 
     * @param mmsFeedback 反馈管理
     * @return 结果
     */
    @Override
    public int updateMmsFeedback(MmsFeedback mmsFeedback)
    {
        mmsFeedback.setUpdateTime(DateUtils.getNowDate());
        return mmsFeedbackMapper.updateMmsFeedback(mmsFeedback);
    }

    /**
     * 批量删除反馈管理
     * 
     * @param ids 需要删除的反馈管理主键
     * @return 结果
     */
    @Override
    public int deleteMmsFeedbackByIds(String ids)
    {
        return mmsFeedbackMapper.deleteMmsFeedbackByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除反馈管理信息
     * 
     * @param id 反馈管理主键
     * @return 结果
     */
    @Override
    public int deleteMmsFeedbackById(Long id)
    {
        return mmsFeedbackMapper.deleteMmsFeedbackById(id);
    }
}
