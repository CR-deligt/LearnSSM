package com.qujia.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")//在类上是首先的初始化匹配（常用于不同模块间的区分）
public class RequestMappingController {
//    相同路径只能有一个RequestMapping
//    @RequestMapping("/")
//    public String index(){
//        return "index";
//    }
    @RequestMapping(
            value={"/testRequestMapping","/test"},
            method={RequestMethod.GET,RequestMethod.POST}
    )//在方法上的是具体的
    public String success(){
        return "success";
    }
    @GetMapping("/testGetMapping")//代替RequestMapping method
    public String testGetMapping(){
        return "success";
    }
    @RequestMapping(value = "/testPut",method=RequestMethod.PUT)
    public String testPut(){
        return "success";
    }

    @RequestMapping(
            value = "/testParamsAndHeaders",
            params = {"username"},
            headers = {"Host=localhost:8080"}

    )
    public String testParamsAndHeaders(){
        return "success";
    }

    @RequestMapping("/a?a/testAnt")
    public String testAnt(){
        return "success";
    }
    @RequestMapping("/testPath/{id}")//将{}占位符的id输给参数 有占位符  请求地址必须加参数  可多个{}/{}/{}/......
    public String testPath(@PathVariable(value = "id")Integer id){
        System.out.println(id);
        return "success";
    }

}
