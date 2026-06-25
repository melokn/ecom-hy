package com.example.hyadm.auth.controller;


import com.example.hyadm.auth.dto.AuthResponseDTO;
import com.example.hyadm.auth.dto.LoginDTO;
import com.example.hyadm.auth.service.AuthService;
import com.example.hyadm.auth.dto.RegisterDTO;
import com.example.hyadm.user.dto.UserDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterDTO registerDTO) {
        UserDTO user = authService.register(registerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@Valid @RequestBody LoginDTO loginDTO) {
        AuthResponseDTO token = authService.login(loginDTO);
        return ResponseEntity.status(HttpStatus.OK).body(token);
    }
}
