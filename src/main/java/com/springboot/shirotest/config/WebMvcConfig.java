package com.springboot.shirotest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author amc2533064395@163.com
 * @date 2019/6/9 22:57
 */
@Configuration
public class WebMvcConfig  implements WebMvcConfigurer{

@Override
    public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/login").setViewName("login");
    registry.addViewController("/index").setViewName("index");
    registry.addViewController("/unauthorized").setViewName("unauthorized");
}

}
