package com.example.demo;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User signUp(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // Set other properties like jwtToken, createdDate if needed
        return userRepository.save(user);
    }

    @Override
    public String login(String email, String password) {
        // Find the user by email
        User user = userRepository.findByUsername(email);

        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            // Generate a JWT token with a secret key
            String token = Jwts.builder()
                    .setSubject(user.getUsername()) // You can set the subject to be any identifier you prefer
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + 864000000)) // Token valid for 10 days
                    .signWith(SignatureAlgorithm.HS512, "yourSecretKey") // Replace "yourSecretKey" with your actual secret key
                    .compact();

            // Save the generated token in the user entity (optional)
            user.setJwtToken(token);
            userRepository.save(user);

            return token;
        }

        // Return null or throw an exception indicating login failure
        return null;
    }

    // Other methods for managing users, if needed
    // ...

}
