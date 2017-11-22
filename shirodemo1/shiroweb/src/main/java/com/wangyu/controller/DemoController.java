package com.wangyu.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/index")
    @RequiresPermissions("user")
    public String demo() throws Exception {
        Subject subject = SecurityUtils.getSubject();
        subject.login(new UsernamePasswordToken("lonestarr", "vespa"));
        System.out.println(subject.isAuthenticated());
        return "/demo";
    }

    @RequestMapping("/index1")
    @RequiresPermissions("user:query")
    public String demo1() throws Exception {
        Subject subject = SecurityUtils.getSubject();
        System.out.println(subject.isAuthenticated());
        return "/demo";
    }


}
