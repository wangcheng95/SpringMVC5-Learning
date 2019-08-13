package com.waston.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HelloController {
    @RequestMapping("hello")
    public String sayHello(){
        System.out.println("Hello SpingMVC");
        return "hello";
    }
}
