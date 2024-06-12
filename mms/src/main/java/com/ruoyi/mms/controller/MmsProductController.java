package com.ruoyi.mms.controller;

import java.util.List;

import com.ruoyi.mms.domain.MmsProductType;
import com.ruoyi.mms.service.IMmsProductTypeService;
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
import com.ruoyi.mms.domain.MmsProduct;
import com.ruoyi.mms.service.IMmsProductService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 产品管理Controller
 * 
 * @author ruoyi
 * @date 2024-06-12
 */
@Controller
@RequestMapping("/mms/product")
public class MmsProductController extends BaseController
{
    private String prefix = "mms/product";

    @Autowired
    private IMmsProductService mmsProductService;

    @Autowired
    private IMmsProductTypeService mmsProductTypeService;

    @RequiresPermissions("mms:product:view")
    @GetMapping()
    public String product()
    {
        return prefix + "/product";
    }

    /**
     * 查询产品管理列表
     */
    @RequiresPermissions("mms:product:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MmsProduct mmsProduct)
    {
        startPage();
        List<MmsProduct> list = mmsProductService.selectMmsProductList(mmsProduct);
        return getDataTable(list);
    }

    /**
     * 导出产品管理列表
     */
    @RequiresPermissions("mms:product:export")
    @Log(title = "产品管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MmsProduct mmsProduct)
    {
        List<MmsProduct> list = mmsProductService.selectMmsProductList(mmsProduct);
        ExcelUtil<MmsProduct> util = new ExcelUtil<MmsProduct>(MmsProduct.class);
        return util.exportExcel(list, "产品管理数据");
    }

    /**
     * 新增产品管理
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        mmap.put("mmsProductTypes", mmsProductTypeService.selectMmsProductTypeList(null));
        return prefix + "/add";
    }

    /**
     * 新增保存产品管理
     */
    @RequiresPermissions("mms:product:add")
    @Log(title = "产品管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MmsProduct mmsProduct)
    {
        return toAjax(mmsProductService.insertMmsProduct(mmsProduct));
    }

    /**
     * 修改产品管理
     */
    @RequiresPermissions("mms:product:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        MmsProduct mmsProduct = mmsProductService.selectMmsProductById(id);
        mmap.put("mmsProduct", mmsProduct);
        mmap.put("mmsProductTypes", mmsProductTypeService.selectMmsProductTypeList(null));
        return prefix + "/edit";
    }

    /**
     * 修改保存产品管理
     */
    @RequiresPermissions("mms:product:edit")
    @Log(title = "产品管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MmsProduct mmsProduct)
    {
        return toAjax(mmsProductService.updateMmsProduct(mmsProduct));
    }

    /**
     * 删除产品管理
     */
    @RequiresPermissions("mms:product:remove")
    @Log(title = "产品管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(mmsProductService.deleteMmsProductByIds(ids));
    }
}
