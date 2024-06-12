package com.ruoyi.mms.service;

import java.util.List;
import com.ruoyi.mms.domain.MmsProductType;

/**
 * 产品类型管理Service接口
 * 
 * @author ruoyi
 * @date 2024-06-12
 */
public interface IMmsProductTypeService 
{
    /**
     * 查询产品类型管理
     * 
     * @param id 产品类型管理主键
     * @return 产品类型管理
     */
    public MmsProductType selectMmsProductTypeById(Long id);

    /**
     * 查询产品类型管理列表
     * 
     * @param mmsProductType 产品类型管理
     * @return 产品类型管理集合
     */
    public List<MmsProductType> selectMmsProductTypeList(MmsProductType mmsProductType);

    /**
     * 新增产品类型管理
     * 
     * @param mmsProductType 产品类型管理
     * @return 结果
     */
    public int insertMmsProductType(MmsProductType mmsProductType);

    /**
     * 修改产品类型管理
     * 
     * @param mmsProductType 产品类型管理
     * @return 结果
     */
    public int updateMmsProductType(MmsProductType mmsProductType);

    /**
     * 批量删除产品类型管理
     * 
     * @param ids 需要删除的产品类型管理主键集合
     * @return 结果
     */
    public int deleteMmsProductTypeByIds(String ids);

    /**
     * 删除产品类型管理信息
     * 
     * @param id 产品类型管理主键
     * @return 结果
     */
    public int deleteMmsProductTypeById(Long id);
}
