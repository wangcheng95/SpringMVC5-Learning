package com.waston.controller;

import com.waston.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testException")
    public String testException() throws Exception{
        System.out.println("testException处理中...");
        //模拟异常
        int a = 10 / 0;
        return "success";
    }


    @RequestMapping("/testException1")
    public String testException1() throws SysException{
        System.out.println("testException1处理中...");
        //模拟异常
        try{
            int a = 10 / 0; //模拟Service抛出异常
        } catch (Exception e){
            e.printStackTrace();
            //抛出自定义异常信息
            throw new SysException("查询错误...");
        }

        return "success";
    }
}
