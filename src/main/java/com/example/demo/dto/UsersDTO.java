package com.example.demo.dto;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class UsersDTO
{

    @Pattern(regexp = "^(?!\\d+$)[a-zA-Z ]*$", message = "Invalid entry not working")
    @NotNull(message = "Name cannot be null")
    private String name;

    @NotBlank
    private String phoneNo;

    @NotBlank
    private String address;
    // No need for explicit getters, setters, constructors, and toString with @Data
}
