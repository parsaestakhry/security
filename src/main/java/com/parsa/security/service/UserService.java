package com.parsa.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parsa.security.model.Users;
import com.parsa.security.repository.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    public Users register(Users user) {
        return repo.save(user);
    }
}
