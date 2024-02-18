package com.example.demo;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public interface UserService {
    // Method to sign up a new user
    User signUp(User user);

    // Method to log in and generate a JWT token
    String login(String email, String password);

    // Other methods for managing users, if needed
    // ...
}
