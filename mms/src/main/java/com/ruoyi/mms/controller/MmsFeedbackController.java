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
import com.ruoyi.mms.domain.MmsFeedback;
import com.ruoyi.mms.service.IMmsFeedbackService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 反馈管理Controller
 * 
 * @author ruoyi
 * @date 2024-06-13
 */
@Controller
@RequestMapping("/mms/feedback")
public class MmsFeedbackController extends BaseController
{
    private String prefix = "mms/feedback";

    @Autowired
    private IMmsFeedbackService mmsFeedbackService;

    @Autowired
    private IMmsUserService mmsUserService;

    @RequiresPermissions("mms:feedback:view")
    @GetMapping()
    public String feedback()
    {
        return prefix + "/feedback";
    }

    /**
     * 查询反馈管理列表
     */
    @RequiresPermissions("mms:feedback:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MmsFeedback mmsFeedback)
    {
        startPage();
        List<MmsFeedback> list = mmsFeedbackService.selectMmsFeedbackList(mmsFeedback);
        return getDataTable(list);
    }

    /**
     * 导出反馈管理列表
     */
    @RequiresPermissions("mms:feedback:export")
    @Log(title = "反馈管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MmsFeedback mmsFeedback)
    {
        List<MmsFeedback> list = mmsFeedbackService.selectMmsFeedbackList(mmsFeedback);
        ExcelUtil<MmsFeedback> util = new ExcelUtil<MmsFeedback>(MmsFeedback.class);
        return util.exportExcel(list, "反馈管理数据");
    }

    /**
     * 新增反馈管理
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        mmap.put("mmsUsers", mmsUserService.selectMmsUserList(null));
        return prefix + "/add";
    }

    /**
     * 新增保存反馈管理
     */
    @RequiresPermissions("mms:feedback:add")
    @Log(title = "反馈管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MmsFeedback mmsFeedback)
    {
        return toAjax(mmsFeedbackService.insertMmsFeedback(mmsFeedback));
    }

    /**
     * 修改反馈管理
     */
    @RequiresPermissions("mms:feedback:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        MmsFeedback mmsFeedback = mmsFeedbackService.selectMmsFeedbackById(id);
        mmap.put("mmsFeedback", mmsFeedback);
        mmap.put("mmsUsers", mmsUserService.selectMmsUserList(null));
        return prefix + "/edit";
    }

    /**
     * 修改保存反馈管理
     */
    @RequiresPermissions("mms:feedback:edit")
    @Log(title = "反馈管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MmsFeedback mmsFeedback)
    {
        return toAjax(mmsFeedbackService.updateMmsFeedback(mmsFeedback));
    }

    /**
     * 删除反馈管理
     */
    @RequiresPermissions("mms:feedback:remove")
    @Log(title = "反馈管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(mmsFeedbackService.deleteMmsFeedbackByIds(ids));
    }
}
