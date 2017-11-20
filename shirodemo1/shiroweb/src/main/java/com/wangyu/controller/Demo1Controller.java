package com.wangyu.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/demo1")
@Controller
public class Demo1Controller {

    @RequestMapping("/index")
    public String demo() throws Exception {
        Subject subject = SecurityUtils.getSubject();
        System.out.println(subject.isAuthenticated());
        return "/demo";
    }

}
