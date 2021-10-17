package com.qujia.Spring.aopxml;



public class User2Proxy {
    public void before(){
        System.out.println("-----------User2 Before------------");
    }
    public void after(){
        System.out.println("-----------User2 after------------");
    }
}
