package com.ruoyi.mms.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mms.mapper.MmsProductMapper;
import com.ruoyi.mms.domain.MmsProduct;
import com.ruoyi.mms.service.IMmsProductService;
import com.ruoyi.common.core.text.Convert;

/**
 * 产品管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-06-12
 */
@Service
public class MmsProductServiceImpl implements IMmsProductService 
{
    @Autowired
    private MmsProductMapper mmsProductMapper;

    /**
     * 查询产品管理
     * 
     * @param id 产品管理主键
     * @return 产品管理
     */
    @Override
    public MmsProduct selectMmsProductById(Long id)
    {
        return mmsProductMapper.selectMmsProductById(id);
    }

    /**
     * 查询产品管理列表
     * 
     * @param mmsProduct 产品管理
     * @return 产品管理
     */
    @Override
    public List<MmsProduct> selectMmsProductList(MmsProduct mmsProduct)
    {
        return mmsProductMapper.selectMmsProductList(mmsProduct);
    }

    /**
     * 新增产品管理
     * 
     * @param mmsProduct 产品管理
     * @return 结果
     */
    @Override
    public int insertMmsProduct(MmsProduct mmsProduct)
    {
        mmsProduct.setCreateTime(DateUtils.getNowDate());
        return mmsProductMapper.insertMmsProduct(mmsProduct);
    }

    /**
     * 修改产品管理
     * 
     * @param mmsProduct 产品管理
     * @return 结果
     */
    @Override
    public int updateMmsProduct(MmsProduct mmsProduct)
    {
        mmsProduct.setUpdateTime(DateUtils.getNowDate());
        return mmsProductMapper.updateMmsProduct(mmsProduct);
    }

    /**
     * 批量删除产品管理
     * 
     * @param ids 需要删除的产品管理主键
     * @return 结果
     */
    @Override
    public int deleteMmsProductByIds(String ids)
    {
        return mmsProductMapper.deleteMmsProductByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除产品管理信息
     * 
     * @param id 产品管理主键
     * @return 结果
     */
    @Override
    public int deleteMmsProductById(Long id)
    {
        return mmsProductMapper.deleteMmsProductById(id);
    }
}
