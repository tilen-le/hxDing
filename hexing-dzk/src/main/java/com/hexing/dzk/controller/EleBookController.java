package com.hexing.dzk.controller;

import com.hexing.common.annotation.Log;
import com.hexing.common.config.HeXingConfig;
import com.hexing.common.constant.UserConstants;
import com.hexing.common.core.controller.BaseController;
import com.hexing.common.core.domain.AjaxResult;
import com.hexing.common.core.domain.entity.SysUser;
import com.hexing.common.core.page.TableDataInfo;
import com.hexing.common.enums.BusinessType;
import com.hexing.common.utils.ShiroUtils;
import com.hexing.common.utils.StringUtils;
import com.hexing.common.utils.file.FileUploadUtils;
import com.hexing.dzk.domain.BookAttach;
import com.hexing.dzk.domain.EleBook;
import com.hexing.dzk.zxy.IBookService;
import com.hexing.system.domain.SysPost;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 电子刊
 *
 * @author hexing
 */
@Controller
@RequestMapping("/ebook/manage")
public class EleBookController extends BaseController {

    private String defaultUrl = "/profile/default/cover/xx.png";

    private String prefix = "ebook/manage";

    @GetMapping()
    public String book() {
        return prefix + "/manage";
    }

    @Resource
    private IBookService bookService;


    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EleBook eleBook) {
        startPage();
        List<EleBook> list = bookService.getBookList(eleBook);
        return getDataTable(list);
    }

    @PostMapping("/all")
    @ResponseBody
    public AjaxResult all(EleBook eleBook) {
        List<EleBook> list = bookService.getBookList(eleBook);
        for (EleBook book : list) {
            if (StringUtils.isBlank(book.getCoverUrl())) {
                book.setCoverUrl(defaultUrl);
            }
        }
        return AjaxResult.success(list);
    }

    @GetMapping("/ding")
    public String ding(ModelMap map, HttpServletRequest request) {
        EleBook eleBook = new EleBook();
        eleBook.setStatus("1");
        List<EleBook> list = bookService.getBookList(eleBook);
        for (EleBook book : list) {
            if (StringUtils.isBlank(book.getCoverUrl())) {
                book.setCoverUrl(defaultUrl);
            }
        }
        map.put("bookList", list);
        return prefix + "/index";
    }


    @Log(title = "书刊管理", businessType = BusinessType.UPDATE)
    @PostMapping("/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(EleBook eleBook) {
        return toAjax(bookService.changeStatus(eleBook));
    }

    @Log(title = "书刊管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        try {
            return toAjax(bookService.deleteBookByIds(ids));
        } catch (Exception e) {
            e.printStackTrace();
            return error(e.getMessage());
        }
    }

    /**
     * 新增电子刊
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增电子刊
     */
    @Log(title = "书刊管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EleBook eleBook) {
        try {
            return toAjax(bookService.addEleBook(eleBook));
        } catch (Exception e) {
            e.printStackTrace();
            return error(e.getMessage());
        }
    }

    @GetMapping("/bookCover")
    public String avatar(ModelMap map, HttpServletRequest request)
    {
        EleBook eleBook = bookService.getById(Long.parseLong(request.getParameter("id")));
        if (StringUtils.isBlank(eleBook.getCoverUrl())) {
            eleBook.setCoverUrl(defaultUrl);
        }
        map.put("eleBook", eleBook);
        return prefix + "/bookCover";
    }

    @PostMapping("/uploadBookCover")
    @ResponseBody
    public AjaxResult updateAvatar(@RequestParam("file") MultipartFile file, @RequestParam("id") String id) {
        try {
            if (!file.isEmpty()) {
                String url = FileUploadUtils.upload(HeXingConfig.getUploadPath(), file);
                EleBook eleBook = new EleBook();
                eleBook.setId(Integer.parseInt(id));
                eleBook.setCoverUrl(url);
                bookService.updateEleBook(eleBook);
                return success();
            }
            return error();
        } catch (Exception e) {
            e.printStackTrace();
            return error(e.getMessage());
        }
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        mmap.put("ebook", bookService.getById(id));
        return prefix + "/edit";
    }

    /**
     * 修改
     */
    @Log(title = "书刊管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EleBook eleBook)
    {
        return toAjax( bookService.updateEleBook(eleBook));
    }


    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, ModelMap mmap)
    {
        mmap.put("book", bookService.getById(id));
        return "ebook/attach/data";
    }


}