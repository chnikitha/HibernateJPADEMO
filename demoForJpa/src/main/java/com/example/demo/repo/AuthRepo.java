package com.example.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Auth;


@Repository
public interface AuthRepo extends JpaRepository<Auth, Long> 
{
    default Optional<Auth> findByUsernameAndPassword(String username, String password) {
        return findAll().stream()
                        .filter(auth -> {
                            String authUsername = auth.getUsername();
                            return authUsername != null &&
                                   authUsername.equals(username) && 
                                   auth.getPassword().equals(password);
                        })
                        .findFirst();
    }
}
