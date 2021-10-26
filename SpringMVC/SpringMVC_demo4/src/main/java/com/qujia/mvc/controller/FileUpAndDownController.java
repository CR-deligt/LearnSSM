package com.qujia.mvc.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Controller
public class FileUpAndDownController {
    @RequestMapping("/testDown")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        //获取ServletContext对象
        ServletContext servletContext = session.getServletContext();
        //获取服务器中文件的真实路径
        String realPath = servletContext.getRealPath("/static/img/CR7.jpg");
        System.out.println(realPath);
        //创建输入流
        InputStream is = new FileInputStream(realPath);
        //创建字节数组
        byte[] bytes = new byte[is.available()];
        //将流读到字节数组中
        is.read(bytes);
        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String, String> headers = new HttpHeaders();
        //设置要下载方式以及下载文件的名字
        headers.add("Content-Disposition", "attachment;filename=CR.jpg");
        //设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        //创建ResponseEntity对象（响应体，响应头，响应状态码）
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers,
                statusCode);
        //关闭输入流
        is.close();
        return responseEntity;
    }
    @RequestMapping("/testUp")
    public String testUp(MultipartFile photo,HttpSession session) throws IOException
    {   //获取上传文件的文件名
        String filename = photo.getOriginalFilename();
        //获取文件后缀
        String suffixName = filename.substring(filename.lastIndexOf("."));//截取  .以及后面
        //将UUID作位文件名
        String uuid = UUID.randomUUID().toString();
        filename=uuid+suffixName;
        //ServletContext获取photo文件夹的目录路径
        ServletContext servletContext = session.getServletContext();
        String photoPath = servletContext.getRealPath("photo");
        File file = new File(photoPath);
        //判断photoPath路径是否存在
        if(!file.exists()){
            //创建
            file.mkdir();
        }
        String finalPath = photoPath+File.separator +filename;//文件名也可以自己重新起
        photo.transferTo(new File(finalPath));//表示文件转移 参数是file文件（重名会覆盖）
        return "success";
    }

}
