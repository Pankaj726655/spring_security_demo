package com.pankaj.spring_sec_demo.service;

import com.pankaj.spring_sec_demo.dao.UserRepo;
import com.pankaj.spring_sec_demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public User saveUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save((user));
    }

    public void deleteUser(int id){
        repo.deleteById(id);
    }


}
