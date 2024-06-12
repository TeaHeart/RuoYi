package com.ruoyi.mms.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.mms.mapper.MmsAddressMapper;
import com.ruoyi.mms.domain.MmsAddress;
import com.ruoyi.mms.service.IMmsAddressService;
import com.ruoyi.common.core.text.Convert;

/**
 * 收货地址管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-06-12
 */
@Service
public class MmsAddressServiceImpl implements IMmsAddressService 
{
    @Autowired
    private MmsAddressMapper mmsAddressMapper;

    /**
     * 查询收货地址管理
     * 
     * @param id 收货地址管理主键
     * @return 收货地址管理
     */
    @Override
    public MmsAddress selectMmsAddressById(Long id)
    {
        return mmsAddressMapper.selectMmsAddressById(id);
    }

    /**
     * 查询收货地址管理列表
     * 
     * @param mmsAddress 收货地址管理
     * @return 收货地址管理
     */
    @Override
    public List<MmsAddress> selectMmsAddressList(MmsAddress mmsAddress)
    {
        return mmsAddressMapper.selectMmsAddressList(mmsAddress);
    }

    /**
     * 新增收货地址管理
     * 
     * @param mmsAddress 收货地址管理
     * @return 结果
     */
    @Override
    public int insertMmsAddress(MmsAddress mmsAddress)
    {
        mmsAddress.setCreateTime(DateUtils.getNowDate());
        return mmsAddressMapper.insertMmsAddress(mmsAddress);
    }

    /**
     * 修改收货地址管理
     * 
     * @param mmsAddress 收货地址管理
     * @return 结果
     */
    @Override
    public int updateMmsAddress(MmsAddress mmsAddress)
    {
        mmsAddress.setUpdateTime(DateUtils.getNowDate());
        return mmsAddressMapper.updateMmsAddress(mmsAddress);
    }

    /**
     * 批量删除收货地址管理
     * 
     * @param ids 需要删除的收货地址管理主键
     * @return 结果
     */
    @Override
    public int deleteMmsAddressByIds(String ids)
    {
        return mmsAddressMapper.deleteMmsAddressByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除收货地址管理信息
     * 
     * @param id 收货地址管理主键
     * @return 结果
     */
    @Override
    public int deleteMmsAddressById(Long id)
    {
        return mmsAddressMapper.deleteMmsAddressById(id);
    }
}
