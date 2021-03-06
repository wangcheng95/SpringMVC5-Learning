package com.waston.annotation;

import com.waston.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;

/**
 * 常用注解，访问/anno.jsp进行测试
 *
 */
@Controller
@SessionAttributes(value = {"msg"}, types = String.class) //注解将request域中指定的msg存储了一份到session域中
public class AnnoController {
    @RequestMapping("/testRequestParam")
    //Spring5之后用name属性，以前用value的，Spring向老版本兼容的
    public String testRequestParam(@RequestParam(required = true, name = "name") String name){
        System.out.println("testRequestParam执行了...");
        return "/success.jsp";
    }

    //@RequestBody不能用于get请求，获取的是整个请求体的内容
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println("testRequestBody执行了...");
        System.out.println(body);
        return "/success.jsp";
    }

    @RequestMapping("/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable(required = true, value = "sid") Integer id){
        System.out.println("testPathVariable执行了...");
        System.out.println(id);
        //注意/xx.jsp 表示的是localhost:8080/xx.jsp，是Url的绝对路径
        return "/success.jsp";
    }

    /**
     * 获取请求头的值
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(required = true, value = "Accept") String header){
        System.out.println("testRequestHeader执行了...");
        System.out.println(header);
        return "/success.jsp";
    }

    /**
     * 用于把指定 cookie 名称的值传入控制器方法参数
     * @param cookieValue
     * @return
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(required = true, value = "JSESSIONID") String cookieValue){
        System.out.println("testCookieValue执行了...");
        System.out.println(cookieValue);
        return "/success.jsp";
    }

    /**
     * 假设前端提供了name和age，没有date。后台传进来的date为null
     * @return
     */
    @RequestMapping("/testModelAttribute1")
    public String testModelAttribute1(User user){
        System.out.println("testModelAttribute1执行了...");
        System.out.println(user);
        return "/success.jsp";
    }

    /**
     * @ModelAttribute注解，每次调用此控制器的其他方法，都会先执行此方法
     */
//    @ModelAttribute
//    public void showUser1(String name){
//        System.out.println("showUser先执行...");
//    }

    /**
     * 此方法配合testModelAttribute1进行演示，取消注释
     * 会发现虽然前端没有传date，但是由于此方法先执行，会先进行一个初始化
     */
//    @ModelAttribute
//    public User showUser2(String name){
//        System.out.println("showUser先执行...");
//        //通过用户name查询数据库（模拟）
//        User user = new User();
//        user.setName(name);
//        user.setAge(20);
//        user.setDate(new Date());
//        //封装的user会返回给控制器的其他方法
//        return user;
//    }


    //配合showUser3使用，接收showUser3的Model，将其取消注释
    @RequestMapping("/testModelAttribute2")
    public String testModelAttribute2(@ModelAttribute(value = "user") User user) {
        System.out.println("testModelAttribute2执行了...");
        System.out.println(user);
        return "/success.jsp";
    }
    //如果不是返回值方法，将需要传递的对象放到一个map里面，控制器的方法再用@ModelAttribute注释进行接收
//    @ModelAttribute
//    public void showUser3(String name, Map<String, User> map){
//        System.out.println("showUser2先执行...");
//        //通过用户name查询数据库（模拟）
//        User user = new User();
//        user.setName(name);
//        user.setAge(20);
//        user.setDate(new Date());
//        //存到Map中，map会传递给控制器的其他方法
//        map.put("user", user);
//    }


    /**
     *@SessionAttribute 注解
     * @return
     */

    @RequestMapping("/testSessionAttribute")
    public String testSessionAttribute(Model model){
        System.out.println("testSessionAttribute执行了...");
        //底层会存到request域对象（HttpServletRequest）中
        //然后使用EL表达式${msg}取出其request域对象的msg
        model.addAttribute("msg", "testSessionAttribute");
        return "/sessionattribute.jsp";
    }

    /**
     * 从SessionAttribute中获取值
     * @param modelMap
     * @return
     */
    @RequestMapping("/testSessionAttribute/getmsg")
    public String getSessionAttribute(ModelMap modelMap){
        System.out.println("getSessionAttribute执行了...");
        String msg = (String)modelMap.get("msg");
        System.out.println("获取的值为：" + msg);
        return "/sessionattribute.jsp";
    }

    /**
     * 将session共享值清除
     * @param status
     * @return
     */
    @RequestMapping("/testSessionAttribute/del_session")
    public String delSessionAttribute(SessionStatus status){
        System.out.println("delSessionAttribute执行了...");
        status.setComplete();
        return "/sessionattribute.jsp";
    }

}