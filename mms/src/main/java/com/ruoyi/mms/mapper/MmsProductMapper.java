package com.ruoyi.mms.mapper;

import java.util.List;
import com.ruoyi.mms.domain.MmsProduct;

/**
 * 产品管理Mapper接口
 * 
 * @author ruoyi
 * @date 2024-06-12
 */
public interface MmsProductMapper 
{
    /**
     * 查询产品管理
     * 
     * @param id 产品管理主键
     * @return 产品管理
     */
    public MmsProduct selectMmsProductById(Long id);

    /**
     * 查询产品管理列表
     * 
     * @param mmsProduct 产品管理
     * @return 产品管理集合
     */
    public List<MmsProduct> selectMmsProductList(MmsProduct mmsProduct);

    /**
     * 新增产品管理
     * 
     * @param mmsProduct 产品管理
     * @return 结果
     */
    public int insertMmsProduct(MmsProduct mmsProduct);

    /**
     * 修改产品管理
     * 
     * @param mmsProduct 产品管理
     * @return 结果
     */
    public int updateMmsProduct(MmsProduct mmsProduct);

    /**
     * 删除产品管理
     * 
     * @param id 产品管理主键
     * @return 结果
     */
    public int deleteMmsProductById(Long id);

    /**
     * 批量删除产品管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMmsProductByIds(String[] ids);
}
