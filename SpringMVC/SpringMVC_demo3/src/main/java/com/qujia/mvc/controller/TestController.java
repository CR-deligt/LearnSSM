package com.qujia.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {/*专门实现页面跳转*/
    /*@RequestMapping("/")
    public String index(){
        return "index";
    }*/

    @RequestMapping("/test_view")
    public String testView(){
        return "test_view";
    }

}
