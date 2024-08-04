package com.benjamin.springbootrest.service;
import com.benjamin.springbootrest.model.User;
import com.benjamin.springbootrest.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserService {
    @Autowired
    private UserRepo repo;
    public User saveUser(User user) {
        return repo.save(user);
    }
}
