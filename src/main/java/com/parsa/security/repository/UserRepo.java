package com.parsa.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parsa.security.model.Users;

public interface UserRepo extends JpaRepository<Users, Integer>  {

}
