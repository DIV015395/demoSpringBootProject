package com.example.demo;

import java.util.List;

import java.util.List;

public interface UserService {
    List<Users> getAllUsers();
    Users getUserById(Long id);
    Users createUser(Users user);
    void deleteUser(Long id);

}


