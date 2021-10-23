package com.qujia.mvc.controller;

import com.qujia.mvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

@Controller
public class ParamController {
    @RequestMapping("/testServletAPI")
    //形参位置是当前请求
    public String testServletAPI(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:"+username+", password:"+password);
        return "success";
    }
    @RequestMapping("/testParam")
    public String testParam(
            @RequestParam(value = "user_name",required = false,defaultValue = "haha") String username,
            String password,
            String[] hobby,
            @RequestHeader(value = "Host",required = false,defaultValue ="localhost:8080" )String host,
            @CookieValue("JSESSIONID") String JSESSIONID)
    {
        //若请求参数出现多个同名请求，可以在控制器方法的形参位置设置字符串类型（每个值之间会用逗号隔开）或字符串数组来接受参数
        System.out.println("username:"+username+",password:"+password+",hobby:"+ Arrays.toString(hobby));
        System.out.println("host:"+host);
        System.out.println("JSESSIONID:"+JSESSIONID);
        return "success";
    }
    @RequestMapping("/testBean")
    public String testBean(User user){
        System.out.println(user);
        return "success";
    }
}
