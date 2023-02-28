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

    @Autowired
    private SensitiveWordFilter sensitiveWordFilter;

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
    public AjaxResult getCode(HttpServletRequest request){
        String id = request.getParameter("id");
        String code = request.getParameter("code");
        //查询期刊点赞数量
        int Num = bookService.countBookPraise(Integer.parseInt(id));
        //判断session中是否有用户信息
        HttpSession session = request.getSession();
        String userId= (String) session.getAttribute("userId");
        String name= (String) session.getAttribute("name");
        session.setAttribute("bookId",id);
        if (StringUtils.isEmpty(userId) || StringUtils.isEmpty(name)){
            //如果session中没有 则调钉钉接口获取用户信息
            HashMap<String, String> map = GetUserMsg.getUserid(key, appsecret, code);
            //把用户信息放到session中后减少钉钉接口调用
            userId = map.get("userId");
            name = map.get("name");
//            userId = "80015801";
//            name = "徐乐乐(80015801)";
            session.setAttribute("userId", userId);
            session.setAttribute("name", name);
        }
        //用户是否为当前期刊点赞标识
        Boolean praiseMark = bookService.praiseMark(Long.parseLong(userId), Integer.parseInt(id));
        Integer countComment = bookService.countBookComment(Integer.parseInt(id));
        //返回数据
        Map<String,Object> map = new HashMap<>();
        map.put("num",Num);
        map.put("praiseMark",praiseMark);
        map.put("userId",userId);
        map.put("name",name);
        map.put("countComment",countComment);
        return AjaxResult.success(map);
    }

    @GetMapping("/thumbsUp")
    @ResponseBody
    public AjaxResult thumbsUp(HttpServletRequest request,Boolean flag) {
        String bookId = request.getParameter("id");
        String userId = request.getParameter("userId");
        BookPraise bookPraise = new BookPraise();
        bookPraise.setBookId(Integer.valueOf(bookId));
        bookPraise.setUserId(Long.valueOf(userId));
        if (!flag){
            bookService.addBookPraise(bookPraise);
        }else {
            bookService.deleteBookPraise(Long.valueOf(userId),Integer.valueOf(bookId));
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
    public TableDataInfo list(BookCommentMsg bookCommentMsg) {
        startPage();
        BookComment bookComment = new BookComment();
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
        bookComment.setUserId(Long.valueOf(userId));
        bookComment.setComment(comment);
        Boolean containsSensitiveWords = sensitiveWordFilter.isContainsSensitiveWords(comment,1);
        if (containsSensitiveWords){
            bookComment.setStatus("0");
        }else {
            bookComment.setStatus("1");
        }
        int n = 0;
        try {
            n = bookService.addBookComment(bookComment);
            List<BookComment> list = bookService.getAllComment(Integer.valueOf(bookId));
            return AjaxResult.success("成功添加" + n + "条评论", list);
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
