package com.example.demo.service;

import com.example.demo.dto.UsersDTO;

import java.util.List;

public interface UserService
{
    List<UsersDTO> getAllUsers();
    UsersDTO getUserById(Long id);
    UsersDTO createUser(UsersDTO user);
    void deleteUser(Long id);
}


