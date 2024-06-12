package com.ruoyi.mms.controller;

import java.util.List;

import com.ruoyi.mms.domain.MmsUser;
import com.ruoyi.mms.service.IMmsUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.mms.domain.MmsAddress;
import com.ruoyi.mms.service.IMmsAddressService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 收货地址管理Controller
 * 
 * @author ruoyi
 * @date 2024-06-12
 */
@Controller
@RequestMapping("/mms/address")
public class MmsAddressController extends BaseController
{
    private String prefix = "mms/address";

    @Autowired
    private IMmsAddressService mmsAddressService;

    @Autowired
    private IMmsUserService mmsUserService;

    @RequiresPermissions("mms:address:view")
    @GetMapping()
    public String address()
    {
        return prefix + "/address";
    }

    /**
     * 查询收货地址管理列表
     */
    @RequiresPermissions("mms:address:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MmsAddress mmsAddress)
    {
        startPage();
        List<MmsAddress> list = mmsAddressService.selectMmsAddressList(mmsAddress);
        return getDataTable(list);
    }

    /**
     * 导出收货地址管理列表
     */
    @RequiresPermissions("mms:address:export")
    @Log(title = "收货地址管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MmsAddress mmsAddress)
    {
        List<MmsAddress> list = mmsAddressService.selectMmsAddressList(mmsAddress);
        ExcelUtil<MmsAddress> util = new ExcelUtil<MmsAddress>(MmsAddress.class);
        return util.exportExcel(list, "收货地址管理数据");
    }

    /**
     * 新增收货地址管理
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        mmap.put("mmsUsers", mmsUserService.selectMmsUserList(null));
        return prefix + "/add";
    }

    /**
     * 新增保存收货地址管理
     */
    @RequiresPermissions("mms:address:add")
    @Log(title = "收货地址管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MmsAddress mmsAddress)
    {
        return toAjax(mmsAddressService.insertMmsAddress(mmsAddress));
    }

    /**
     * 修改收货地址管理
     */
    @RequiresPermissions("mms:address:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        MmsAddress mmsAddress = mmsAddressService.selectMmsAddressById(id);
        mmap.put("mmsAddress", mmsAddress);
        mmap.put("mmsUsers", mmsUserService.selectMmsUserList(null));
        return prefix + "/edit";
    }

    /**
     * 修改保存收货地址管理
     */
    @RequiresPermissions("mms:address:edit")
    @Log(title = "收货地址管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MmsAddress mmsAddress)
    {
        return toAjax(mmsAddressService.updateMmsAddress(mmsAddress));
    }

    /**
     * 删除收货地址管理
     */
    @RequiresPermissions("mms:address:remove")
    @Log(title = "收货地址管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(mmsAddressService.deleteMmsAddressByIds(ids));
    }
}
