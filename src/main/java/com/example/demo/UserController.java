package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping("/users")
public class UserController
{
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UsersDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Long id) {
        UsersDTO users = userService.getUserById(id);

        if (users != null) {
            System.out.println("Users found: " + users);
            return null;
//            return ResponseEntity.ok(users);
        } else {
            System.out.println("Users not found for ID: " + id);
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public UsersDTO createUser(@RequestBody @Validated UsersDTO users) {
        try
        {
            return userService.createUser(users);
        }
        catch (Exception e)
        {
            throw new RuntimeException("Run time exception");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}




