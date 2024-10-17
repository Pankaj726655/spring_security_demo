package com.pankaj.spring_sec_demo.controller;

import com.pankaj.spring_sec_demo.model.User;
import com.pankaj.spring_sec_demo.service.JwtService;
import com.pankaj.spring_sec_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("register")
    public User register(@RequestBody User user){
        return userService.saveUser(user);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable("id") int id){
        userService.deleteUser(id);
    }

    @PostMapping("login")
    public String login(@RequestBody User user){
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if(authentication.isAuthenticated())
            return jwtService.generateToken(user.getUsername());
        else
            return "failure";
    }
}
