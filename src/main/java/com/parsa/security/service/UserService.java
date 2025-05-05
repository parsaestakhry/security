package com.parsa.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.parsa.security.model.Users;
import com.parsa.security.repository.UserRepo;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    @Autowired
    AuthenticationManager manager;

    @Autowired
    private JwtService jwtService;

    public Users register(Users user) {
        return repo.save(user);
    }

    public String verify(Users user) {
        org.springframework.security.core.Authentication authentication = manager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken();
        }

        return "fail";
    }
}
