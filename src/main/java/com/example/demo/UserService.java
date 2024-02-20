package com.example.demo;

import java.util.List;

import java.util.List;

public interface UserService {
    List<UsersDTO> getAllUsers();
    UsersDTO getUserById(Long id);
    UsersDTO createUser(UsersDTO user);
    void deleteUser(Long id);

}


