package com.wangyu.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/index")
    public String index(String username, String password, Boolean rememberMe) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        subject.login(new UsernamePasswordToken(username, password));
        System.out.println(subject.isAuthenticated());
        return "/demo";
    }

    @RequestMapping("/index1")
    public String index1(String username1, String password1, Boolean rememberMe1) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        subject.login(new UsernamePasswordToken(username1, password1, rememberMe1));
        System.out.println(subject.isAuthenticated());
        return "/demo";
    }
}
