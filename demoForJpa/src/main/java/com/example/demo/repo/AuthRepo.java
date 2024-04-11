package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Auth;


@Repository
public interface AuthRepo extends JpaRepository<Auth, Long> {
	Auth findByUsernameAndPassword(String username, String password);

}
