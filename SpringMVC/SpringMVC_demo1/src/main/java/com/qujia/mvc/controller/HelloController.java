package com.qujia.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class HelloController {
    //”/“是工程路径  要访问WEB-INF下templates的index.html
    @RequestMapping("/")//请求映射注解,当属性值只有value(请求地址)的时候可以把value=省略
    public String index(){
        //返回视图名称
        return "index";
    }
    @RequestMapping("/target")//要和请求的地址保持一致
    public String toTarget(){
        return "target";
    }
}
