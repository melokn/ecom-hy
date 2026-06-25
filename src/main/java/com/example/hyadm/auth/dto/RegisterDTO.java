package com.example.hyadm.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class RegisterDTO {

    @NotBlank
    @Size(min = 3, max = 20)
    private String username;
    @NotBlank
    @Email(message = "Invalid email format")
    private String email;
    @NotBlank
    @Size(min = 6, max = 30)
    private String password;
}