package com.example.demo;


import javax.persistence.*;

@Entity
@Table(name = "experi")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Constructors, getters, and setters

    public User() {
        // Default constructor
    }

    public User(Long id, String name, String password) {
        this.id = id;
        this.name = name;
    }

    // Getter and Setter methods

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

