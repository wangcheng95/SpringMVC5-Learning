package com.waston.controller;

import com.waston.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 通过访问/resopnse.jsp来测试使用这些接口
 */
@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * 返回类型是字符串
     * @param model
     * @return
     */
    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString执行中...");
        //模拟查询数据
        User user = new User();
        user.setUsername("waston");
        user.setPassword("123456");
        user.setAge(23);
        //存入model对象中
        model.addAttribute("user", user);
        return "success";
    }

    /**
     * 返回类型是Void
     * @param request
     * @return
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("testVoid执行中...");
        //编写请求转发的程序，转发是服务器内部完成的工作，因此能访问/WEB-INF目录下的资源
//        request.getRequestDispatcher("/WEB-INF/pages/forward.jsp").forward(request, response);
        //重定向，注意WEB-INF中的资源不能被浏览器直接访问，因此将redirect.jsp放在外层目录下进行演示
//        response.sendRedirect(request.getContextPath() + "/redirect.jsp");
        //直接使用response进行响应
        //设置中文编码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print("<h1>hello，张三</h>");
    }

    /**
     * 返回类型为ModelAndView
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        //创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        System.out.println("testModelAndView执行了...");
        //模拟数据库查询数据
        User user = new User();
        user.setUsername("waston");
        user.setPassword("123456");
        user.setAge(23);

        //将User对象存储到mv对象中，也会将user对象存到request域对象中
        mv.addObject("user", user);

        //指定视图，会使用视图解析器
        mv.setViewName("success");

        return mv;
    }

    /**
     * 关键字转发或重定向，不会使用视图解析器
     * @return
     */
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect(){
        System.out.println("testForwardOrRedirect执行中...");
        //请求的转发
//        return "forward:/WEB-INF/pages/forward.jsp";
        //重定向，底层会将项目名给加上
        return "redirect:/redirect.jsp";
    }
}
