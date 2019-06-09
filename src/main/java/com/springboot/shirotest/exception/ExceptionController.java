package com.springboot.shirotest.exception;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author amc2533064395@163.com
 * @date 2019/6/9 23:04
 */
@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(AuthorizationException.class)
    public ModelAndView error(AuthorizationException e){
        ModelAndView modelAndView=new ModelAndView("unauthorized");
        modelAndView.addObject("error",e.getMessage());
        return  modelAndView;


    }
}
