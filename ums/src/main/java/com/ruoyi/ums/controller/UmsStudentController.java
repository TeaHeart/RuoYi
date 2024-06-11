package com.ruoyi.ums.controller;

import java.util.List;

import com.ruoyi.ums.domain.UmsClass;
import com.ruoyi.ums.service.IUmsClassService;
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
import com.ruoyi.ums.domain.UmsStudent;
import com.ruoyi.ums.service.IUmsStudentService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 学生管理Controller
 *
 * @author ruoyi
 * @date 2024-06-11
 */
@Controller
@RequestMapping("/ums/umsStudent")
public class UmsStudentController extends BaseController
{
    private String prefix = "ums/umsStudent";

    @Autowired
    private IUmsStudentService umsStudentService;

    @Autowired
    private IUmsClassService umsClassService;

    @RequiresPermissions("ums:umsStudent:view")
    @GetMapping()
    public String umsStudent()
    {
        return prefix + "/umsStudent";
    }

    /**
     * 查询学生管理列表
     */
    @RequiresPermissions("ums:umsStudent:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UmsStudent umsStudent)
    {
        startPage();
        List<UmsStudent> list = umsStudentService.selectUmsStudentList(umsStudent);
        return getDataTable(list);
    }

    /**
     * 导出学生管理列表
     */
    @RequiresPermissions("ums:umsStudent:export")
    @Log(title = "学生管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UmsStudent umsStudent)
    {
        List<UmsStudent> list = umsStudentService.selectUmsStudentList(umsStudent);
        ExcelUtil<UmsStudent> util = new ExcelUtil<UmsStudent>(UmsStudent.class);
        return util.exportExcel(list, "学生管理数据");
    }

    /**
     * 新增学生管理
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        mmap.put("umsClasses", umsClassService.selectUmsClassList(null));
        return prefix + "/add";
    }

    /**
     * 新增保存学生管理
     */
    @RequiresPermissions("ums:umsStudent:add")
    @Log(title = "学生管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UmsStudent umsStudent)
    {
        return toAjax(umsStudentService.insertUmsStudent(umsStudent));
    }

    /**
     * 修改学生管理
     */
    @RequiresPermissions("ums:umsStudent:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        UmsStudent umsStudent = umsStudentService.selectUmsStudentById(id);
        mmap.put("umsStudent", umsStudent);
        mmap.put("umsClasses", umsClassService.selectUmsClassList(null));
        return prefix + "/edit";
    }

    /**
     * 修改保存学生管理
     */
    @RequiresPermissions("ums:umsStudent:edit")
    @Log(title = "学生管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UmsStudent umsStudent)
    {
        return toAjax(umsStudentService.updateUmsStudent(umsStudent));
    }

    /**
     * 删除学生管理
     */
    @RequiresPermissions("ums:umsStudent:remove")
    @Log(title = "学生管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(umsStudentService.deleteUmsStudentByIds(ids));
    }
}
