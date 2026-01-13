package com.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	
    List<User> findByRole(String role);
    User findByEmail(String email);
    

}