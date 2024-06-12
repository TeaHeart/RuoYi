package com.ruoyi.mms.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mms.mapper.MmsProductTypeMapper;
import com.ruoyi.mms.domain.MmsProductType;
import com.ruoyi.mms.service.IMmsProductTypeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 产品类型管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-06-12
 */
@Service
public class MmsProductTypeServiceImpl implements IMmsProductTypeService 
{
    @Autowired
    private MmsProductTypeMapper mmsProductTypeMapper;

    /**
     * 查询产品类型管理
     * 
     * @param id 产品类型管理主键
     * @return 产品类型管理
     */
    @Override
    public MmsProductType selectMmsProductTypeById(Long id)
    {
        return mmsProductTypeMapper.selectMmsProductTypeById(id);
    }

    /**
     * 查询产品类型管理列表
     * 
     * @param mmsProductType 产品类型管理
     * @return 产品类型管理
     */
    @Override
    public List<MmsProductType> selectMmsProductTypeList(MmsProductType mmsProductType)
    {
        return mmsProductTypeMapper.selectMmsProductTypeList(mmsProductType);
    }

    /**
     * 新增产品类型管理
     * 
     * @param mmsProductType 产品类型管理
     * @return 结果
     */
    @Override
    public int insertMmsProductType(MmsProductType mmsProductType)
    {
        mmsProductType.setCreateTime(DateUtils.getNowDate());
        return mmsProductTypeMapper.insertMmsProductType(mmsProductType);
    }

    /**
     * 修改产品类型管理
     * 
     * @param mmsProductType 产品类型管理
     * @return 结果
     */
    @Override
    public int updateMmsProductType(MmsProductType mmsProductType)
    {
        mmsProductType.setUpdateTime(DateUtils.getNowDate());
        return mmsProductTypeMapper.updateMmsProductType(mmsProductType);
    }

    /**
     * 批量删除产品类型管理
     * 
     * @param ids 需要删除的产品类型管理主键
     * @return 结果
     */
    @Override
    public int deleteMmsProductTypeByIds(String ids)
    {
        return mmsProductTypeMapper.deleteMmsProductTypeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除产品类型管理信息
     * 
     * @param id 产品类型管理主键
     * @return 结果
     */
    @Override
    public int deleteMmsProductTypeById(Long id)
    {
        return mmsProductTypeMapper.deleteMmsProductTypeById(id);
    }
}
