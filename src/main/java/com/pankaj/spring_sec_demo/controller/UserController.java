package com.pankaj.spring_sec_demo.controller;

import com.pankaj.spring_sec_demo.model.User;
import com.pankaj.spring_sec_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("register")
    public User register(@RequestBody User user){
        return service.saveUser(user);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") int id){
        service.deleteUser(id);
    }
}
