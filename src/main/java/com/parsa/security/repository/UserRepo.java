package com.parsa.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parsa.security.model.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {

    Users findByUsername(String username);

}
