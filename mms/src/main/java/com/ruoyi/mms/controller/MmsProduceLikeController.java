package com.ruoyi.mms.controller;

import java.util.List;

import com.ruoyi.mms.service.IMmsProductService;
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
import com.ruoyi.mms.domain.MmsProduceLike;
import com.ruoyi.mms.service.IMmsProduceLikeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 产品收藏管理Controller
 *
 * @author ruoyi
 * @date 2024-06-13
 */
@Controller
@RequestMapping("/mms/like")
public class MmsProduceLikeController extends BaseController {
    private String prefix = "mms/like";

    @Autowired
    private IMmsProduceLikeService mmsProduceLikeService;

    @Autowired
    private IMmsProductService mmsProductService;

    @Autowired
    private IMmsUserService mmsUserService;

    @RequiresPermissions("mms:like:view")
    @GetMapping()
    public String like() {
        return prefix + "/like";
    }

    /**
     * 查询产品收藏管理列表
     */
    @RequiresPermissions("mms:like:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(MmsProduceLike mmsProduceLike) {
        startPage();
        List<MmsProduceLike> list = mmsProduceLikeService.selectMmsProduceLikeList(mmsProduceLike);
        return getDataTable(list);
    }

    /**
     * 导出产品收藏管理列表
     */
    @RequiresPermissions("mms:like:export")
    @Log(title = "产品收藏管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(MmsProduceLike mmsProduceLike) {
        List<MmsProduceLike> list = mmsProduceLikeService.selectMmsProduceLikeList(mmsProduceLike);
        ExcelUtil<MmsProduceLike> util = new ExcelUtil<MmsProduceLike>(MmsProduceLike.class);
        return util.exportExcel(list, "产品收藏管理数据");
    }

    /**
     * 新增产品收藏管理
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        mmap.put("mmsProducts", mmsProductService.selectMmsProductList(null));
        mmap.put("mmsUsers", mmsUserService.selectMmsUserList(null));
        return prefix + "/add";
    }

    /**
     * 新增保存产品收藏管理
     */
    @RequiresPermissions("mms:like:add")
    @Log(title = "产品收藏管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(MmsProduceLike mmsProduceLike) {
        return toAjax(mmsProduceLikeService.insertMmsProduceLike(mmsProduceLike));
    }

    /**
     * 修改产品收藏管理
     */
    @RequiresPermissions("mms:like:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        MmsProduceLike mmsProduceLike = mmsProduceLikeService.selectMmsProduceLikeById(id);
        mmap.put("mmsProduceLike", mmsProduceLike);
        mmap.put("mmsProducts", mmsProductService.selectMmsProductList(null));
        mmap.put("mmsUsers", mmsUserService.selectMmsUserList(null));
        return prefix + "/edit";
    }

    /**
     * 修改保存产品收藏管理
     */
    @RequiresPermissions("mms:like:edit")
    @Log(title = "产品收藏管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(MmsProduceLike mmsProduceLike) {
        return toAjax(mmsProduceLikeService.updateMmsProduceLike(mmsProduceLike));
    }

    /**
     * 删除产品收藏管理
     */
    @RequiresPermissions("mms:like:remove")
    @Log(title = "产品收藏管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(mmsProduceLikeService.deleteMmsProduceLikeByIds(ids));
    }
}
