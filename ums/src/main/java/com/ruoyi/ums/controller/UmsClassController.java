package com.ruoyi.ums.controller;

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
import com.ruoyi.ums.domain.UmsClass;
import com.ruoyi.ums.service.IUmsClassService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 班级管理Controller
 * 
 * @author ruoyi
 * @date 2024-06-11
 */
@Controller
@RequestMapping("/ums/umsClass")
public class UmsClassController extends BaseController
{
    private String prefix = "ums/umsClass";

    @Autowired
    private IUmsClassService umsClassService;

    @RequiresPermissions("ums:umsClass:view")
    @GetMapping()
    public String umsClass()
    {
        return prefix + "/umsClass";
    }

    /**
     * 查询班级管理列表
     */
    @RequiresPermissions("ums:umsClass:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UmsClass umsClass)
    {
        startPage();
        List<UmsClass> list = umsClassService.selectUmsClassList(umsClass);
        return getDataTable(list);
    }

    /**
     * 导出班级管理列表
     */
    @RequiresPermissions("ums:umsClass:export")
    @Log(title = "班级管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UmsClass umsClass)
    {
        List<UmsClass> list = umsClassService.selectUmsClassList(umsClass);
        ExcelUtil<UmsClass> util = new ExcelUtil<UmsClass>(UmsClass.class);
        return util.exportExcel(list, "班级管理数据");
    }

    /**
     * 新增班级管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存班级管理
     */
    @RequiresPermissions("ums:umsClass:add")
    @Log(title = "班级管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UmsClass umsClass)
    {
        return toAjax(umsClassService.insertUmsClass(umsClass));
    }

    /**
     * 修改班级管理
     */
    @RequiresPermissions("ums:umsClass:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        UmsClass umsClass = umsClassService.selectUmsClassById(id);
        mmap.put("umsClass", umsClass);
        return prefix + "/edit";
    }

    /**
     * 修改保存班级管理
     */
    @RequiresPermissions("ums:umsClass:edit")
    @Log(title = "班级管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UmsClass umsClass)
    {
        return toAjax(umsClassService.updateUmsClass(umsClass));
    }

    /**
     * 删除班级管理
     */
    @RequiresPermissions("ums:umsClass:remove")
    @Log(title = "班级管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(umsClassService.deleteUmsClassByIds(ids));
    }
}
