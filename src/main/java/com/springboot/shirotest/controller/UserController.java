package com.springboot.shirotest.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author amc2533064395@163.com
 * @date 2019/6/9 22:27
 */
@Controller
public class UserController {
    /**
     * 构建UsernamePasswordToken 实例，然后获取Subject对象进行登录操作，根据登录不同结果返回不同页面
     * @param username
     * @param password
     * @param model
     * @return
     */
    @PostMapping("/doLogin")
    public  String doLogin(String username, String password , Model model){
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        Subject subject= SecurityUtils.getSubject();
        try{
            subject.login(token);
        }catch (AuthenticationException e){
            model.addAttribute("error","用户名或密码输入错误");
            return  "login";
        }
     return  "redirect:/index";
    }

    /**
     * 具有admin的权限的进入admin
     * @return
     */
    @RequiresRoles("admin")
    @GetMapping("/admin")
    public  String admin(){
        return  "admin";
    }

    /**
     * 具有admin,user权限的可进入user页面
     * @return
     */
    @RequiresRoles(value = {"admin","user"},logical = Logical.OR)
    @GetMapping("/user")
    public  String user(){
        return "user";
    }



}
