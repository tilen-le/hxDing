package com.hexing.dzk.controller;

import java.util.List;

import com.hexing.common.utils.StringUtils;
import com.hexing.dzk.domain.DzkAccessRecordsNew;
import com.hexing.dzk.service.UtilsService;
import com.hexing.dzk.utils.DingUtils;
import lombok.extern.slf4j.Slf4j;
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
import com.hexing.dzk.domain.DzkAccessRecords;
import com.hexing.dzk.service.IDzkAccessRecordsService;
import com.hexing.common.core.controller.BaseController;
import com.hexing.common.core.domain.AjaxResult;
import com.hexing.common.utils.poi.ExcelUtil;
import com.hexing.common.core.page.TableDataInfo;

/**
 * 电子刊访问历史Controller
 * 
 * @author zhuzl
 * @date 2021-05-28
 */
@Slf4j
@Controller
@RequestMapping("/dzk/dzk-records")
public class DzkAccessRecordsController extends BaseController
{
    private String prefix = "dzk/dzk-records";

    @Autowired
    private IDzkAccessRecordsService dzkAccessRecordsService;
    @Autowired
    private UtilsService utilsService;

    @RequiresPermissions("dzk:dzk-records:view")
    @GetMapping()
    public String dzkRecords()
    {
        return prefix + "/dzk-records";
    }

    /**
     * 查询电子刊访问历史列表
     */
    @RequiresPermissions("dzk:dzk-records:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DzkAccessRecords dzkAccessRecords)
    {
        startPage();
        List<DzkAccessRecords> list = dzkAccessRecordsService.selectDzkAccessRecordsList(dzkAccessRecords);
        return getDataTable(list);
    }

    /**
     * 导出电子刊访问历史列表
     */
    @RequiresPermissions("dzk:dzk-records:export")
    @Log(title = "电子刊访问历史", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DzkAccessRecords dzkAccessRecords)
    {
        List<DzkAccessRecords> list = dzkAccessRecordsService.selectDzkAccessRecordsList(dzkAccessRecords);
        ExcelUtil<DzkAccessRecords> util = new ExcelUtil<DzkAccessRecords>(DzkAccessRecords.class);
        return util.exportExcel(list, "电子刊访问历史数据");
    }

    /**
     * 新增电子刊访问历史
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存电子刊访问历史
     */
    @RequiresPermissions("dzk:dzk-records:add")
    @Log(title = "电子刊访问历史", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DzkAccessRecords dzkAccessRecords)
    {
        return toAjax(dzkAccessRecordsService.insertDzkAccessRecords(dzkAccessRecords));
    }

    /**
     * 修改电子刊访问历史
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        DzkAccessRecords dzkAccessRecords = dzkAccessRecordsService.selectDzkAccessRecordsById(id);
        mmap.put("dzkAccessRecords", dzkAccessRecords);
        return prefix + "/edit";
    }

    /**
     * 修改保存电子刊访问历史
     */
    @RequiresPermissions("dzk:dzk-records:edit")
    @Log(title = "电子刊访问历史", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DzkAccessRecords dzkAccessRecords)
    {
        return toAjax(dzkAccessRecordsService.updateDzkAccessRecords(dzkAccessRecords));
    }

    /**
     * 删除电子刊访问历史
     */
    @RequiresPermissions("dzk:dzk-records:remove")
    @Log(title = "电子刊访问历史", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(dzkAccessRecordsService.deleteDzkAccessRecordsByIds(ids));
    }

    /*
    自定义添加记录
     */
    @PostMapping("/dzkAccessRecords")
    @ResponseBody
    public AjaxResult dzkAccessRecords(DzkAccessRecordsNew dzkAccessRecordsNew)
    {
        String code = dzkAccessRecordsNew.getCode();
        String ty_access_token = utilsService.getAccessToken("ty_access_token", "");
        String userid = DingUtils.getUserid(ty_access_token, code);
        DzkAccessRecords dzkAccessRecords = new DzkAccessRecords();
        if (dzkAccessRecordsNew.getDzkId()!=null ){
            dzkAccessRecords.setDzkId(dzkAccessRecordsNew.getDzkId());
        }
        if (StringUtils.isNotEmpty(dzkAccessRecordsNew.getTitle())){
            dzkAccessRecords.setTitle(dzkAccessRecordsNew.getTitle());
        }
        if (dzkAccessRecordsNew.getType()!=null){
            dzkAccessRecords.setType(dzkAccessRecordsNew.getType());
        }
        if (StringUtils.isNotEmpty(userid)){
            dzkAccessRecords.setUserid(userid);
        }
        log.info("添加记录"+dzkAccessRecords.toString());
        return toAjax(dzkAccessRecordsService.insertDzkAccessRecords(dzkAccessRecords));
    }

}
