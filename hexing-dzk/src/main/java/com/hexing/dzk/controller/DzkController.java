package com.hexing.dzk.controller;

import com.hexing.dzk.domain.DzkInfoBean;
import com.hexing.dzk.domain.ImgBean;
import com.hexing.dzk.utils.DzkNumber;
import com.hexing.common.core.controller.BaseController;
import com.hexing.common.utils.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
public class DzkController extends BaseController
{
    private String prefix = "dzk";

    @GetMapping("/index")
    public String job()
    {
        return prefix+"/index";
    }
    @GetMapping("/info")
    public String getInfo(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap)
    {
        String title = request.getParameter("title");
        String type = request.getParameter("type");
        String dzk_id = request.getParameter("dzk_id");
        title= StringUtils.isNotEmpty(title)?title:"海兴海外案例集图片版";
        type= StringUtils.isNotEmpty(type)?type:"pc";
        dzk_id= StringUtils.isNotEmpty(dzk_id)?dzk_id:"0";
        String w="2481";
        String h="3532";
        if ("公司宣传册图片版".equals(title)){
           w="2539";
           h="3143";
        }
        //http://115.238.36.163:1880
        List<DzkInfoBean> dzkInfoList = DzkNumber.getDzkInfoList("/dzk/profile/"+type+"/"+title+"/",title);
        modelMap.put("list",dzkInfoList);
        modelMap.put("size",dzkInfoList.size());
        modelMap.put("title",title);
        modelMap.put("dzk_id",dzk_id);
        modelMap.put("width_w",w);
        modelMap.put("height_h",h);
        if ("pc".equals(type)){
            return prefix+"/dzk_pc_info";
        }else {
            return prefix+"/dzk_iphone_info";
        }

    }


    @RequestMapping(value = "list")
    public ModelAndView getPost(HttpServletRequest request, HttpServletResponse response)
    {
        String type = request.getParameter("type");
        String baseImg="/dzk/profile/pc/0704/";
        if ("iphone".equals(type)){
             baseImg="/dzk/profile/iphone/0704/";
        }
        ArrayList<ImgBean> objects = new ArrayList<>();
        objects.add(new ImgBean(baseImg+"0704_1.png"));
        objects.add(new ImgBean(baseImg+"0704_2.png"));
        objects.add(new ImgBean(baseImg+"0704_3.png"));
        objects.add(new ImgBean(baseImg+"0704_4.png"));
        objects.add(new ImgBean(baseImg+"0704_5.png"));
        objects.add(new ImgBean(baseImg+"0704_6.png"));
        objects.add(new ImgBean(baseImg+"0704_7.png"));
        objects.add(new ImgBean(baseImg+"0704_8.png"));
        objects.add(new ImgBean(baseImg+"0704_9.png"));
        objects.add(new ImgBean(baseImg+"0704_10.png"));
        objects.add(new ImgBean(baseImg+"0704_11.png"));
        objects.add(new ImgBean(baseImg+"0704_12.png"));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/dzk/dzk_pc_info");
        modelAndView.addObject("list",objects);
        modelAndView.addObject("size",12);
        return modelAndView;
    }

   }
