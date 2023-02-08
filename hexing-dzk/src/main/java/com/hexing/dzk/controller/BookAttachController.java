package com.hexing.dzk.controller;

import com.hexing.common.annotation.Log;
import com.hexing.common.config.HeXingConfig;
import com.hexing.common.core.controller.BaseController;
import com.hexing.common.core.domain.AjaxResult;
import com.hexing.common.core.page.TableDataInfo;
import com.hexing.common.enums.BusinessType;
import com.hexing.common.utils.StringUtils;
import com.hexing.common.utils.file.FileUploadUtils;
import com.hexing.dzk.domain.BookAttach;
import com.hexing.dzk.service.IBookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
@RequestMapping("/ebook/attach")
public class BookAttachController extends BaseController {

    private String defaultUrl = "/profile/default/cover/xx.png";

    private String prefix = "ebook/attach";

    @GetMapping()
    public String book() {
        return prefix + "/attach";
    }

    @Resource
    private IBookService bookService;

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BookAttach bookAttach) {
        startPage();
        List<BookAttach> list = bookService.getBookAttachList(bookAttach);
        return getDataTable(list);
    }

    @Log(title = "期刊管理", businessType = BusinessType.UPDATE)
    @PostMapping("/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(BookAttach bookAttach) {
        return toAjax(bookService.changeStatus(bookAttach));
    }

    @Log(title = "期刊管理", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        try {
            return toAjax(bookService.deleteAttachByIds(ids));
        } catch (Exception e) {
            e.printStackTrace();
            return error(e.getMessage());
        }
    }

    @GetMapping("/add/{bookId}")
    public String add(@PathVariable("bookId") Long bookId, ModelMap mmap)
    {
        mmap.put("bookId", bookId);
        return prefix + "/add";
    }

    @Log(title = "期刊管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BookAttach bookAttach) {
        try {
            return toAjax(bookService.addBookAttach(bookAttach));
        } catch (Exception e) {
            e.printStackTrace();
            return error(e.getMessage());
        }
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        mmap.put("attach", bookService.getAttachById(id));
        return prefix + "/edit";
    }

    /**
     * 修改
     */
    @Log(title = "期刊管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BookAttach bookAttach)
    {
        return toAjax(bookService.updateBookAttach(bookAttach));
    }

    @GetMapping("/attachCover")
    public String avatar(ModelMap map, HttpServletRequest request)
    {
        BookAttach bookAttach = bookService.getAttachById(Long.parseLong(request.getParameter("id")));
        if (StringUtils.isBlank(bookAttach.getCoverUrl())) {
            bookAttach.setCoverUrl(defaultUrl);
        }
        map.put("attach", bookAttach);
        return prefix + "/attachCover";
    }

    @PostMapping("/uploadAttachCover")
    @ResponseBody
    public AjaxResult updateAvatar(@RequestParam("file") MultipartFile file, @RequestParam("id") String id) {
        try {
            if (!file.isEmpty()) {
                String url = FileUploadUtils.upload(HeXingConfig.getUploadPath(), file);
                BookAttach bookAttach = new BookAttach();
                bookAttach.setId(Integer.parseInt(id));
                bookAttach.setCoverUrl(url);
                bookService.updateBookAttach(bookAttach);
                return success();
            }
            return error();
        } catch (Exception e) {
            e.printStackTrace();
            return error(e.getMessage());
        }
    }

    @PostMapping("/uploadAttach")
    @ResponseBody
    public AjaxResult uploadAttach(@RequestParam("file") MultipartFile file, @RequestParam("id") String id) {
        try {
            if (!file.isEmpty()) {
                String url = FileUploadUtils.upload(HeXingConfig.getUploadPath(), file);
                BookAttach bookAttach = new BookAttach();
                bookAttach.setId(Integer.parseInt(id));
                bookAttach.setAttachUrl(url);
                bookAttach.setAttachName(file.getOriginalFilename());
                bookService.updateBookAttach(bookAttach);
                return success();
            }
            return error();
        } catch (Exception e) {
            e.printStackTrace();
            return error(e.getMessage());
        }
    }

    @GetMapping("/jump/detail")
    public String jump(HttpServletRequest request, ModelMap mmap) {
        String status = request.getParameter("status");
        String id = request.getParameter("id");
        BookAttach attach = new BookAttach();
        attach.setBookId(Long.parseLong(id));
        attach.setStatus(status);
        List<BookAttach> attachList = bookService.getBookAttachList(attach);
        for (BookAttach bookAttach : attachList) {
            if (StringUtils.isBlank(bookAttach.getCoverUrl())) {
                bookAttach.setCoverUrl(defaultUrl);
            }
        }
        mmap.put("attachList", attachList);
        return prefix + "/dzk_pc_info";
/*        if ("pc".equals(type)){
            return prefix+"/dzk_pc_info";
        }else {
            return prefix+"/dzk_iphone_info";
        }*/
    }

    @GetMapping("/readAttach")
    public String readAttach(HttpServletRequest request, ModelMap mmap) {
        String id = request.getParameter("id");
        BookAttach attach = bookService.getAttachById(Long.parseLong(id));
        mmap.put("attach", attach);
        return prefix + "/attach";
    }

}
