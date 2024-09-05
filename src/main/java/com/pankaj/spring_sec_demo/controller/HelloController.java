package com.pankaj.spring_sec_demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("hello")
    public String greet(HttpServletRequest request){
        return "hello"+ request.getSession().getId();
    }

    @GetMapping("about")
    public String about(HttpServletRequest request){
        return "about"+ request.getSession().getId();
    }
}
