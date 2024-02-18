package com.example.demo;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "fiends")
public class Friends {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // Many friends can belong to one user
    @JoinColumn(name = "user_id")
    private User user;

    public String getName() {
        return name;
    }
    public String setName(String name) {
        return this.name;
    }

    @Column(name = "name")
    @JsonProperty("name")
    private String name;

    public String getPhoneNo() {
        return phoneNo;
    }
    public String setPhoneNo(String phoneNo) {
        return this.phoneNo;
    }


    @Column(name = "phoneNo")
    @JsonProperty("phoneNo")
    private String phoneNo;

    public String getAddress() {
        return address;
    }
    public String setAddress(String address) {
        return this.address;
    }


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


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}


