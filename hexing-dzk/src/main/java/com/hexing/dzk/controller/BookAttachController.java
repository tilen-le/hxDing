package com.hexing.dzk.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.hexing.common.annotation.Log;
import com.hexing.common.config.HeXingConfig;
import com.hexing.common.core.controller.BaseController;
import com.hexing.common.core.domain.AjaxResult;
import com.hexing.common.core.domain.entity.SysUser;
import com.hexing.common.core.page.TableDataInfo;
import com.hexing.common.enums.BusinessType;
import com.hexing.common.exception.base.BaseException;
import com.hexing.common.utils.SensitiveWordFilter;
import com.hexing.common.utils.ShiroUtils;
import com.hexing.common.utils.StringUtils;
import com.hexing.common.utils.bean.BeanUtils;
import com.hexing.common.utils.file.FileUploadUtils;
import com.hexing.dzk.domain.*;
import com.hexing.dzk.service.IBookService;
import com.hexing.dzk.tool.GetUserMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Key;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电子刊
 *
 * @author hexing
 */
@Controller
@RequestMapping("/ebook/attach")
@Slf4j
public class BookAttachController extends BaseController {

    private String defaultUrl = "/profile/default/cover/cccc.png";

    private String prefix = "ebook/attach";

    @GetMapping()
    public String book() {
        return prefix + "/attach";
    }

    @Resource
    private IBookService bookService;


    @Value("${token.appkey}")
    private String key;

    @Value("${token.appsecret}")
    private String appsecret;


    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BookAttach bookAttach) {
        startPage();
        List<EleBookMsg> list1 = new ArrayList<>();
        List<BookAttach> list = bookService.getBookAttachList(bookAttach);
        for (BookAttach it: list){
            EleBookMsg eleBookMsg = new EleBookMsg();
            BeanUtils.copyProperties(it,eleBookMsg);
            Integer praiseNum = bookService.countBookPraise(it.getId());
            Integer commentNum = bookService.countBookComment(it.getId());
            eleBookMsg.setPraiseNum(praiseNum);
            eleBookMsg.setCommentNum(commentNum);
            list1.add(eleBookMsg);
        }
        return getDataTable(list1);
    }

    @Log(title = "期刊管理", businessType = BusinessType.UPDATE)
    @PostMapping("/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(BookAttach bookAttach) {
        return toAjax(bookService.changeStatus(bookAttach));
    }

    @Log(title = "期刊评论管理", businessType = BusinessType.UPDATE)
    @PostMapping("/changeEnableComment")
    @ResponseBody
    public AjaxResult changeEnableComment(BookAttach bookAttach) {
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
    public String add(@PathVariable("bookId") Long bookId, ModelMap mmap) {
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
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        mmap.put("attach", bookService.getAttachById(id));
        return prefix + "/edit";
    }

    /**
     * 修改
     */
    @Log(title = "期刊管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BookAttach bookAttach) {
        return toAjax(bookService.updateBookAttach(bookAttach));
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
                bookAttach.setCoverName(file.getOriginalFilename());
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
        String from = request.getParameter("from");
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
        if ("pc".equals(from)) {
            return prefix + "/dzk_pc_info";
        } else {
            return prefix + "/dzk_iphone_info";
        }
    }

    @GetMapping("/link")
    public String link(HttpServletRequest request, ModelMap mmap) {
        String id = request.getParameter("id");
        mmap.put("id", id);
        return prefix + "/dzk_info";
    }

    @GetMapping("/readAttach")
    public String readAttach(HttpServletRequest request, ModelMap mmap) {
        String id = request.getParameter("id");
        String from = request.getParameter("from");
        //查询期刊
        BookAttach attach = bookService.getAttachById(Long.parseLong(id));
        mmap.put("attach", attach);
        if ("pc".equals(from)) {
            return prefix + "/attach_pc";
        } else {
            return prefix + "/attach_phone";
        }
    }

    @GetMapping("/getCode")
    @ResponseBody
    public AjaxResult getCode(HttpServletRequest request) {
        String id = request.getParameter("id");
        String code = request.getParameter("code");
        if (StringUtils.isEmpty(id) || StringUtils.isEmpty(code)) {
            return AjaxResult.error("参数不能为null");
        }
        //查询期刊点赞数量
        int Num = bookService.countBookPraise(Integer.parseInt(id));
        log.info("getCode：开始获取用户信息,key={},appsecret={},code={}", key, appsecret, code);
        HashMap<String, String> map = GetUserMsg.getUserid(key, appsecret, code);
        String userId = map.get("userId");
        String name = map.get("name");
        //用户是否为当前期刊点赞标识
        Boolean praiseMark = bookService.praiseMark(userId, Integer.parseInt(id));
        Integer countComment = bookService.countBookComment(Integer.parseInt(id));
        //返回数据
        Map<String, Object> maplist = new HashMap<>();
        maplist.put("num", Num);
        maplist.put("praiseMark", praiseMark);
        maplist.put("userId", userId);
        maplist.put("name", name);
        maplist.put("countComment", countComment);
        return AjaxResult.success(maplist);
    }

    @GetMapping("/thumbsUp")
    @ResponseBody
    public AjaxResult thumbsUp(HttpServletRequest request,Boolean flag) {
        String bookId = request.getParameter("id");
        String userId = request.getParameter("userId");
        BookPraise bookPraise = new BookPraise();
        bookPraise.setBookId(Integer.valueOf(bookId));
        bookPraise.setUserId(userId);
        if (!flag){
            bookService.addBookPraise(bookPraise);
        }else {
            bookService.deleteBookPraise(userId, Integer.valueOf(bookId));
        }
        return AjaxResult.success("成功"+flag);
    }

    @GetMapping("/comment/{id}")
    public String comment(@PathVariable("id") Integer id, ModelMap mmap) {
        mmap.put("bookId", id);
        return "ebook/attach/comment";
    }

    @PostMapping("/commentList")
    @ResponseBody
    public TableDataInfo list(HttpServletRequest request, BookCommentMsg bookCommentMsg) {
        startPage();
        BookComment bookComment = new BookComment();
        bookComment.setBookId(Integer.valueOf(request.getParameter("id")));
        bookComment.setUserName(bookCommentMsg.getName());
        bookComment.setStatus(bookCommentMsg.getStatus());
        List<BookComment> list = bookService.getAllComment(bookComment);
        return getDataTable(list);
    }

    @Log(title = "评论管理", businessType = BusinessType.DELETE)
    @PostMapping("/comment/remove/{id}")
    @ResponseBody
    public AjaxResult commentRemove(@PathVariable("id") Integer id) {
        try {
            return toAjax(bookService.deleteCommentById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return error(e.getMessage());
        }
    }


    @PostMapping("/comment/changeStatus")
    @ResponseBody
    public AjaxResult commentChangeStatus(BookComment bookComment) {
        return toAjax(bookService.commentChangeStatus(bookComment));
    }


    @GetMapping("/getAllComment")
    @ResponseBody
    public AjaxResult getAllComment( HttpServletRequest request){
        String bookId = request.getParameter("id");
        List<BookComment> list = bookService.getAllComment(Integer.valueOf(bookId));
        return AjaxResult.success("成功获取所有评论列表",list);
    }

    @PostMapping("/addComment")
    @ResponseBody
    public AjaxResult addComment(HttpServletRequest request,String comment){
        String userId = request.getParameter("userId");
        String userName = request.getParameter("userName");
        String bookId = request.getParameter("id");
        if (StringUtils.isEmpty(comment)){
            return AjaxResult.error("评论不能为null");
        }
        BookComment bookComment = new BookComment();
        bookComment.setBookId(Integer.valueOf(bookId));
        bookComment.setUserName(userName);
        bookComment.setUserId(userId);
        bookComment.setComment(comment);
        Boolean containsSensitiveWords = SensitiveWordFilter.isContainsSensitiveWords(comment,1);
        int n = 0;
        try {
            if (containsSensitiveWords) {
                bookComment.setStatus("0");
                bookService.addBookComment(bookComment);
                List<BookComment> list = bookService.getAllComment(Integer.valueOf(bookId));
                return AjaxResult.success("评论添加成功，但包含敏感词汇", list);
            } else {
                bookComment.setStatus("1");
                n = bookService.addBookComment(bookComment);
                List<BookComment> list = bookService.getAllComment(Integer.valueOf(bookId));
                return AjaxResult.success("成功添加" + n + "信息", list);
            }
        } catch (NumberFormatException e) {
            throw new BaseException(e.getMessage());
        }
    }

    @PostMapping("/batchDelComment")
    @ResponseBody
    public AjaxResult batchDelComment(@RequestParam("ids") List<Integer> ids) {
        try {
            if (CollectionUtils.isEmpty(ids)) {
                return AjaxResult.error("评论编号不能为null");
            }
            bookService.batchDelComment(ids);
        } catch (Exception e) {
            throw new BaseException(e.getMessage());
        }
        return AjaxResult.success();
    }


}
