package com.pankaj.spring_sec_demo.service;

import com.pankaj.spring_sec_demo.dao.UserRepo;
import com.pankaj.spring_sec_demo.model.User;
import com.pankaj.spring_sec_demo.model.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repo.findByUsername(username);
        System.out.println(user);
        if(user == null){
            System.out.println("Invalid user !!");
            throw new UsernameNotFoundException("User 404");
        }
        else {
            System.out.println("User :::"+username);
        }
        return new UserDetailsImpl(user);
    }
}
