package com.example.demo;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Data
@Table(name = "friend")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @Pattern(regexp = "^[a-zA-Z ]*$", message = "{agent.name.invalid}")
//    @NotBlank(message = "{agent.name.notnull}")
    @Pattern(regexp = "^(?!\\d+$)[a-zA-Z ]*$", message = "{agent.name.invalid}")
    @NotNull (message = "it can not be null")
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


