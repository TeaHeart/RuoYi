package com.ruoyi.mms.controller;

import java.util.List;
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
import com.ruoyi.mms.domain.MmsProductType;
import com.ruoyi.mms.service.IMmsProductTypeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 产品类型管理Controller
 * 
 * @author ruoyi
 * @date 2024-06-12
 */
@Controller
@RequestMapping("/mms/type")
public class MmsProductTypeController extends BaseController
{
    private String prefix = "mms/type";

    @Autowired
    private IMmsProductTypeService mmsProductTypeService;

    @RequiresPermissions("mms:type:view")
    @GetMapping()
    public String type()
    {
        return prefix + "/type";
    }

    /**
     * 查询产品类型管理列表
     */
    @RequiresPermissions("mms:type:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MmsProductType mmsProductType)
    {
        startPage();
        List<MmsProductType> list = mmsProductTypeService.selectMmsProductTypeList(mmsProductType);
        return getDataTable(list);
    }

    /**
     * 导出产品类型管理列表
     */
    @RequiresPermissions("mms:type:export")
    @Log(title = "产品类型管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MmsProductType mmsProductType)
    {
        List<MmsProductType> list = mmsProductTypeService.selectMmsProductTypeList(mmsProductType);
        ExcelUtil<MmsProductType> util = new ExcelUtil<MmsProductType>(MmsProductType.class);
        return util.exportExcel(list, "产品类型管理数据");
    }

    /**
     * 新增产品类型管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存产品类型管理
     */
    @RequiresPermissions("mms:type:add")
    @Log(title = "产品类型管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MmsProductType mmsProductType)
    {
        return toAjax(mmsProductTypeService.insertMmsProductType(mmsProductType));
    }

    /**
     * 修改产品类型管理
     */
    @RequiresPermissions("mms:type:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        MmsProductType mmsProductType = mmsProductTypeService.selectMmsProductTypeById(id);
        mmap.put("mmsProductType", mmsProductType);
        return prefix + "/edit";
    }

    /**
     * 修改保存产品类型管理
     */
    @RequiresPermissions("mms:type:edit")
    @Log(title = "产品类型管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MmsProductType mmsProductType)
    {
        return toAjax(mmsProductTypeService.updateMmsProductType(mmsProductType));
    }

    /**
     * 删除产品类型管理
     */
    @RequiresPermissions("mms:type:remove")
    @Log(title = "产品类型管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(mmsProductTypeService.deleteMmsProductTypeByIds(ids));
    }
}
