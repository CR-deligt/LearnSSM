package com.qujia.Spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = "com.qujia.Spring")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConfigAop {
}
