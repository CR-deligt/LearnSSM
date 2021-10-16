package com.qujia.Spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration//完全不用xml配置，自己写配置类
@ComponentScan(basePackages = {"com.qujia.Spring"})

public class SpringConfig {
}
