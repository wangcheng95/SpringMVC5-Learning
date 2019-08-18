package com.waston.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义拦截器
 */
public class MyInterceptor2 implements HandlerInterceptor {
    /**
     * 预处理，在controller方法执行前执行
     * return true 放行，执行下一个拦截器。如果没有，执行controller中的方法
     * return false 不放行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor2的preHandle()执行了...前222");
        //可以使用request和response跳转页面
//        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);
        return true;
    }

    /**
     * 后处理方法，controller方法执行后，JSP 执行前
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor2的postHandle()执行了...后222");
        //可以使用request和response跳转页面
//        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request, response);

    }

    /**
     * afterCompletion 是在 JSP 执行后执行
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor2的afterCompletion()执行了...最后222");
        //不可以可以使用request和response跳转页面
    }
}

