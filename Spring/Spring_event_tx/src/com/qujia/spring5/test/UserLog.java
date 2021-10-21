package com.qujia.spring5.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//手动配置输出内容
public class UserLog {
    private static final Logger log = LoggerFactory.getLogger(UserLog.class);

    public static void main(String[] args) {
        log.info("hello log4j2 info");
        log.warn("hello log4j2 warn");
    }


}
