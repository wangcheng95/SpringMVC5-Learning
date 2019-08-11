package com.waston.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 使用Model返回数据，String返回视图
 */
@Controller
public class ThirdController {
    @RequestMapping("/third")
    public String handleRequest(HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse, Model model) throws Exception {
        //向模型对象中添加数据
        model.addAttribute("msg", "使用Model返回数据，String返回视图");
        //返回逻辑视图
        return "/WEB-INF/jsp/third.jsp";
        //如果配置视图解析器，只需要使用third字符串即可
//        return "third";
    }
}
