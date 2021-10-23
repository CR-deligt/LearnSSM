package com.qujia.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    /*-------------------用RESTFul来模拟用户资源增删改查--------------------*/
    /*
    * 查询：
    *   /user       GET      查询全部信息
    *   /user/1     GET      根据id查询信息
    * 添加
    *   /user       POST     添加信息
    * 删除
    *   /user/1     DELETE   根据id删除信息
    * 修改
    *   /user       PUT      修改用户信息
    * */
    @RequestMapping(value = "/user",method = RequestMethod.GET )
    public String getAllUser(){
        System.out.println("查询全部信息");
        return "success";
    }
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET )
    public String getUserById(){
        System.out.println("根据id查询信息");
        return "success";
    }
    @RequestMapping(value = "/user",method = RequestMethod.POST )
    public String insertUser(String username,String password){
        System.out.println("添加信息");
        System.out.println(username+" "+password);
        return "success";
    }
    @RequestMapping(value = "/user",method = RequestMethod.PUT )
    public String updateUser(String username,String password){
        System.out.println("修改信息");
        System.out.println(username+" "+password);
        return "success";
    }

}
