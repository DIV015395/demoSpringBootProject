package com.example.demo;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public String getUsername() {
        return username;
    }
    public String setUsername() {
        return username;
    }
    @Column(name = "username")
    @JsonProperty("username")
    private String username;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Column(name = "password")
    @JsonProperty("password")
    private String password;
    public String getJwtToken() {
        return jwtToken;
    }
    public String setJwtToken(String token) {
        return jwtToken;
    }
    private String jwtToken;
    private String createdDate;
}

