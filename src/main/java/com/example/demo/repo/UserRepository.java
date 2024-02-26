package com.example.demo.repo;
import com.example.demo.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    // You can add custom query methods if needed
}
