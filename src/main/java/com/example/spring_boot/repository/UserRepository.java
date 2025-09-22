package com.example.spring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring_boot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // You get basic CRUD methods automatically:
    // save(), findAll(), findById(), deleteById(), etc.

    // You can also define custom finders:
    User findByUsername(String username);
    User findByEmail(String email);
}
