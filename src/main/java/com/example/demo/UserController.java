package com.example.demo;


import com.example.demo.User;
import com.example.demo.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        // Retrieve the existing user by ID
        User existingUser = userService.getUserById(id);

        // Check if the existing user is found
        if (existingUser == null) {
            // Handle the case where the user with the given ID is not found
            // You might return an error response or throw an exception
            return null;
        }

        // Update the properties of the existing user with the values from the updated user
        existingUser.setName(updatedUser.getName());

        // Save the updated user in the database
        return userService.updateUser(existingUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
