package com.ruoyi.mms.service;

import java.util.List;
import com.ruoyi.mms.domain.MmsAddress;

/**
 * 收货地址管理Service接口
 * 
 * @author ruoyi
 * @date 2024-06-12
 */
public interface IMmsAddressService 
{
    /**
     * 查询收货地址管理
     * 
     * @param id 收货地址管理主键
     * @return 收货地址管理
     */
    public MmsAddress selectMmsAddressById(Long id);

    /**
     * 查询收货地址管理列表
     * 
     * @param mmsAddress 收货地址管理
     * @return 收货地址管理集合
     */
    public List<MmsAddress> selectMmsAddressList(MmsAddress mmsAddress);

    /**
     * 新增收货地址管理
     * 
     * @param mmsAddress 收货地址管理
     * @return 结果
     */
    public int insertMmsAddress(MmsAddress mmsAddress);

    /**
     * 修改收货地址管理
     * 
     * @param mmsAddress 收货地址管理
     * @return 结果
     */
    public int updateMmsAddress(MmsAddress mmsAddress);

    /**
     * 批量删除收货地址管理
     * 
     * @param ids 需要删除的收货地址管理主键集合
     * @return 结果
     */
    public int deleteMmsAddressByIds(String ids);

    /**
     * 删除收货地址管理信息
     * 
     * @param id 收货地址管理主键
     * @return 结果
     */
    public int deleteMmsAddressById(Long id);
}
