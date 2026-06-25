package com.example.hyadm.auth.service;


import com.example.hyadm.auth.dto.AuthResponseDTO;
import com.example.hyadm.auth.dto.LoginDTO;
import com.example.hyadm.auth.dto.RegisterDTO;
import com.example.hyadm.auth.mapper.AuthMapper;
import com.example.hyadm.exception.BadRequest;
import com.example.hyadm.exception.InvalidCredentials;
import com.example.hyadm.user.dto.UserDTO;
import com.example.hyadm.user.model.UserModel;
import com.example.hyadm.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthMapper authMapper;
    private final JwtService jwtService;

    public AuthService(UserService userService, PasswordEncoder passwordEncoder,AuthMapper authMapper,  JwtService jwtService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.authMapper = authMapper;
        this.jwtService = jwtService;
    }

    public UserDTO register(RegisterDTO registerDTO){
        String encodedPassword = passwordEncoder.encode(registerDTO.getPassword());
        registerDTO.setPassword(encodedPassword);
        registerDTO.setEmail(registerDTO.getEmail().toLowerCase());


        return userService.createUser(authMapper.toUserModel(registerDTO));
    }

    public AuthResponseDTO login(LoginDTO loginDTO){
        UserModel user = userService.findByEmail(loginDTO.getEmail());
        if(!passwordEncoder.matches(loginDTO.getPassword(),user.getPassword())){
            throw new InvalidCredentials("Invalid Credentials");
        }

        return new AuthResponseDTO(jwtService.generateToken(user));

    }
}
