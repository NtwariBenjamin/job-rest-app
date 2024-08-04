package com.benjamin.springbootrest.controller;


import com.benjamin.springbootrest.model.User;
import com.benjamin.springbootrest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);
    @Autowired
    private UserService service;
    @PostMapping("register")
    public User saveUser(@RequestBody User user){
        user.setPassword(encoder.encode(user.getPassword()));
        System.out.println(user.getPassword());
        return service.saveUser(user);
    }
}
