package com.qujia.mvc.controller;

import com.qujia.mvc.bean.User1;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HttpController {
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String requestBody){
        System.out.println(requestBody);//<!--username=admin&password=1234567-->
        return "success";
    }
    @RequestMapping("/testRequestEntity")
    public String testRequestEntity(RequestEntity<String> requestEntity){
        //RequestEntity获取整个请求报文信息
        System.out.println("请求头："+requestEntity.getHeaders());//获取所有请求头信息
        System.out.println("请求体："+requestEntity.getBody());//获取所有请求体信息
        //请求头：[host:"localhost:8080", connection:"keep-alive", content-length:"34", cache-control:"max-age=0", sec-ch-ua:""Microsoft Edge";v="95", "Chromium";v="95", ";Not A Brand";v="99"", sec-ch-ua-mobile:"?0", sec-ch-ua-platform:""Windows"", upgrade-insecure-requests:"1", origin:"http://localhost:8080", user-agent:"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/95.0.4638.54 Safari/537.36 Edg/95.0.1020.30", accept:"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9", sec-fetch-site:"same-origin", sec-fetch-mode:"navigate", sec-fetch-user:"?1", sec-fetch-dest:"document", referer:"http://localhost:8080/SpringMVC_demo4/", accept-encoding:"gzip, deflate, br", accept-language:"zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6", cookie:"Idea-758f8ec=f85a1c28-61af-4d28-96fb-22e4779abe09", Content-Type:"application/x-www-form-urlencoded;charset=UTF-8"]
        //请求体：username=qujia123&password=1234567
        return "success";
    }
    @RequestMapping("/testResponse")
    public void testResponse(HttpServletResponse response) throws IOException {
        response.getWriter().println("hello,response");
    }
    @RequestMapping("/testResponseBody")
    @ResponseBody
    public String testResponseBody(){
        return "success";//并不是转发页面，而是将字符串内容作为响应体返回浏览器
    }
    @RequestMapping("/testResponseUser")
    @ResponseBody
    public User1 testResponseUser(){
        return new User1(1001,"admin",12,"男");
    }//<!--只能用文本，浏览器不能直接响应一个java类    Json： Java对象直接作为控制器方法的返回值返回，就会自动转换为Json格式的字符串-->
    @RequestMapping("/testAxios")
    @ResponseBody
    public String testAxios(String username,String password){
        System.out.println(username+","+password);
        return "hello,axios";
    }
}
