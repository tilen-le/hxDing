package com.hexing.dzk.controller;

import com.hexing.common.core.controller.BaseController;
import com.hexing.common.utils.StringUtils;
import com.hexing.dzk.domain.DzkInfoBean;
import com.hexing.dzk.domain.ImgBean;
import com.hexing.dzk.utils.DzkNumber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


/**
 * 调度任务信息操作处理
 * 
 * @author hexing
 */
@Controller
@RequestMapping("/dzk")
public class DingController extends BaseController
{
    private String prefix = "dzk";


    @PostMapping("/list")
    @ResponseBody
    public String getInfo(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap)
    {
        return prefix+"/dzk_pc_info";
    }

   }
