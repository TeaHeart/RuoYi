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
import com.ruoyi.mms.domain.MmsUser;
import com.ruoyi.mms.service.IMmsUserService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户管理Controller
 * 
 * @author ruoyi
 * @date 2024-06-12
 */
@Controller
@RequestMapping("/mms/user")
public class MmsUserController extends BaseController
{
    private String prefix = "mms/user";

    @Autowired
    private IMmsUserService mmsUserService;

    @RequiresPermissions("mms:user:view")
    @GetMapping()
    public String user()
    {
        return prefix + "/user";
    }

    /**
     * 查询用户管理列表
     */
    @RequiresPermissions("mms:user:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MmsUser mmsUser)
    {
        startPage();
        List<MmsUser> list = mmsUserService.selectMmsUserList(mmsUser);
        return getDataTable(list);
    }

    /**
     * 导出用户管理列表
     */
    @RequiresPermissions("mms:user:export")
    @Log(title = "用户管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MmsUser mmsUser)
    {
        List<MmsUser> list = mmsUserService.selectMmsUserList(mmsUser);
        ExcelUtil<MmsUser> util = new ExcelUtil<MmsUser>(MmsUser.class);
        return util.exportExcel(list, "用户管理数据");
    }

    /**
     * 新增用户管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存用户管理
     */
    @RequiresPermissions("mms:user:add")
    @Log(title = "用户管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MmsUser mmsUser)
    {
        return toAjax(mmsUserService.insertMmsUser(mmsUser));
    }

    /**
     * 修改用户管理
     */
    @RequiresPermissions("mms:user:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        MmsUser mmsUser = mmsUserService.selectMmsUserById(id);
        mmap.put("mmsUser", mmsUser);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户管理
     */
    @RequiresPermissions("mms:user:edit")
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MmsUser mmsUser)
    {
        return toAjax(mmsUserService.updateMmsUser(mmsUser));
    }

    /**
     * 删除用户管理
     */
    @RequiresPermissions("mms:user:remove")
    @Log(title = "用户管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(mmsUserService.deleteMmsUserByIds(ids));
    }
}
