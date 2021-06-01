package com.hexing.dzk.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hexing.common.annotation.Log;
import com.hexing.common.enums.BusinessType;
import com.hexing.dzk.domain.SetConfigurationToken;
import com.hexing.dzk.service.ISetConfigurationTokenService;
import com.hexing.common.core.controller.BaseController;
import com.hexing.common.core.domain.AjaxResult;
import com.hexing.common.utils.poi.ExcelUtil;
import com.hexing.common.core.page.TableDataInfo;

/**
 * token配置设置Controller
 * 
 * @author zhuzl
 * @date 2021-05-28
 */
@Controller
@RequestMapping("/dzk/setToken")
public class SetConfigurationTokenController extends BaseController
{
    private String prefix = "dzk/setToken";

    @Autowired
    private ISetConfigurationTokenService setConfigurationTokenService;

    @RequiresPermissions("dzk:setToken:view")
    @GetMapping()
    public String setToken()
    {
        return prefix + "/setToken";
    }

    /**
     * 查询token配置设置列表
     */
    @RequiresPermissions("dzk:setToken:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SetConfigurationToken setConfigurationToken)
    {
        startPage();
        List<SetConfigurationToken> list = setConfigurationTokenService.selectSetConfigurationTokenList(setConfigurationToken);
        return getDataTable(list);
    }

    /**
     * 导出token配置设置列表
     */
    @RequiresPermissions("dzk:setToken:export")
    @Log(title = "token配置设置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SetConfigurationToken setConfigurationToken)
    {
        List<SetConfigurationToken> list = setConfigurationTokenService.selectSetConfigurationTokenList(setConfigurationToken);
        ExcelUtil<SetConfigurationToken> util = new ExcelUtil<SetConfigurationToken>(SetConfigurationToken.class);
        return util.exportExcel(list, "token配置设置数据");
    }

    /**
     * 新增token配置设置
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存token配置设置
     */
    @RequiresPermissions("dzk:setToken:add")
    @Log(title = "token配置设置", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SetConfigurationToken setConfigurationToken)
    {
        return toAjax(setConfigurationTokenService.insertSetConfigurationToken(setConfigurationToken));
    }

    /**
     * 修改token配置设置
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        SetConfigurationToken setConfigurationToken = setConfigurationTokenService.selectSetConfigurationTokenById(id);
        mmap.put("setConfigurationToken", setConfigurationToken);
        return prefix + "/edit";
    }

    /**
     * 修改保存token配置设置
     */
    @RequiresPermissions("dzk:setToken:edit")
    @Log(title = "token配置设置", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SetConfigurationToken setConfigurationToken)
    {
        return toAjax(setConfigurationTokenService.updateSetConfigurationToken(setConfigurationToken));
    }

    /**
     * 删除token配置设置
     */
    @RequiresPermissions("dzk:setToken:remove")
    @Log(title = "token配置设置", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(setConfigurationTokenService.deleteSetConfigurationTokenByIds(ids));
    }
}
