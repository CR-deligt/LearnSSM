package com.qujia.mvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice//扩展了@Controller，也具备把类标识为组件的功能
public class ExceptionController {
    @ExceptionHandler(value={ArithmeticException.class,NullPointerException.class})//将检测相应错误的类写到大括号里
    public String testException(Exception ex, Model model){
        model.addAttribute("ex",ex);
        return "error";
    }

}
