package com.waston.controller;


import com.waston.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * SpringMVC参数绑定（简单类型、复杂类型和自定义类型转换器）
 * 访问/param.jsp页面进行测试
 */
@Controller
public class ParamController {

    /**
     * 请求参数绑定入门
     * @return
     */
    @RequestMapping("/test1")
    public String testParam(){
        System.out.println("test1执行了...");
        return "success";
    }

    /**
     * 传入普通变量
     * @return
     */
    @RequestMapping("/test2")
    public String testParam2(String name, Integer id){
        System.out.println("test2执行了...");
        System.out.println(name + "，你好，你的id为：" + id);
        return "success";
    }

    /**
     * 绑定实体变量，会出现URL请求参数中文乱码
     * 乱码解决方法：1、将请求request的encoding设置为UTF-8（每个方法都需设置，很麻烦）
     *              2、使用SpringMVC自带的编码过滤器，在web.xml配置（推荐）
     * @return
     */
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account){
        System.out.println("saveAccount执行了...");
        System.out.println(account.toString());
        return "success";
    }

    /**
     * 自定义类型转换器，假设用户传入的date为：2019-11-11
     * @return
     */
    @RequestMapping("/date")
    public String date(Date date){
        System.out.println("date执行了...");
        System.out.println(date);
        return "success";
    }
}
