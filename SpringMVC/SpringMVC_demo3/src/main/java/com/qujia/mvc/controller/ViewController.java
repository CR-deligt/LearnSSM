package com.qujia.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
    @RequestMapping("/testThymeleafView")
    public String testThymeleafView(){
        return "success";
    }
    @RequestMapping("/testForward")/*转发视图  转发不能跨域*/
    public String testForward(){
        return "forward:/testThymeleafView";//http://localhost:8080/SpringMVC_demo3/testForward
    }
    @RequestMapping("/testRedirect")/*重定向视图*/
    public String testRedirect(){
        return "redirect:/testThymeleafView";//http://localhost:8080/SpringMVC_demo3/testThymeleafView
    }
}
