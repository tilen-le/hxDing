package com.hexing.dzk.controller;

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
import com.hexing.common.annotation.Log;
import com.hexing.common.enums.BusinessType;
import com.hexing.dzk.domain.DzkLilst;
import com.hexing.dzk.service.IDzkLilstService;
import com.hexing.common.core.controller.BaseController;
import com.hexing.common.core.domain.AjaxResult;
import com.hexing.common.utils.poi.ExcelUtil;
import com.hexing.common.core.page.TableDataInfo;

/**
 * 电子刊列表Controller
 * 
 * @author zhuzl
 * @date 2021-05-27
 */
@Controller
@RequestMapping("/dzk/dzk_list")
public class DzkLilstController extends BaseController
{
    private String prefix = "dzk/dzk_list";

    @Autowired
    private IDzkLilstService dzkLilstService;

    @RequiresPermissions("dzk-list:dzk_list:view")
    @GetMapping()
    public String dzk_list()
    {
        return prefix + "/dzk_list";
    }

    /**
     * 查询电子刊列表列表
     */
    @RequiresPermissions("dzk-list:dzk_list:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DzkLilst dzkLilst)
    {
        startPage();
        List<DzkLilst> list = dzkLilstService.selectDzkLilstList(dzkLilst);
        return getDataTable(list);
    }

    /**
     * 导出电子刊列表列表
     */
    @RequiresPermissions("dzk-list:dzk_list:export")
    @Log(title = "电子刊列表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DzkLilst dzkLilst)
    {
        List<DzkLilst> list = dzkLilstService.selectDzkLilstList(dzkLilst);
        ExcelUtil<DzkLilst> util = new ExcelUtil<DzkLilst>(DzkLilst.class);
        return util.exportExcel(list, "电子刊列表数据");
    }

    /**
     * 新增电子刊列表
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存电子刊列表
     */
    @RequiresPermissions("dzk-list:dzk_list:add")
    @Log(title = "电子刊列表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DzkLilst dzkLilst)
    {
        return toAjax(dzkLilstService.insertDzkLilst(dzkLilst));
    }

    /**
     * 修改电子刊列表
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        DzkLilst dzkLilst = dzkLilstService.selectDzkLilstById(id);
        mmap.put("dzkLilst", dzkLilst);
        return prefix + "/edit";
    }

    /**
     * 修改保存电子刊列表
     */
    @RequiresPermissions("dzk-list:dzk_list:edit")
    @Log(title = "电子刊列表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DzkLilst dzkLilst)
    {
        return toAjax(dzkLilstService.updateDzkLilst(dzkLilst));
    }

    /**
     * 删除电子刊列表
     */
    @RequiresPermissions("dzk-list:dzk_list:remove")
    @Log(title = "电子刊列表", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dzkLilstService.deleteDzkLilstByIds(ids));
    }
}
