package com.example.hyadm.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString

    public class UserDTO {

        private Long id;
        @NotBlank
        private String username;
        @NotBlank
        @Email(message = "Invalid email format")
        private String email;
        @NotBlank
        private String password;
}
