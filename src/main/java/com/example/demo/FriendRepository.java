package com.example.demo;
import org.springframework.data.jpa.repository.JpaRepository;
public interface FriendRepository extends JpaRepository<Friends, Long> {
    // Add any custom queries if needed
}

