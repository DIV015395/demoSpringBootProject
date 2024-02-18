package com.example.demo;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @JsonProperty("name")
    private String name;

    @Column(name = "phoneNo")
    @JsonProperty("phoneNo")
    private String phoneNo;

    @Column(name = "address")
    @JsonProperty("address")
    private String address;

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

}


