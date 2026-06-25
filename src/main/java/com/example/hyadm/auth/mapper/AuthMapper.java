package com.example.hyadm.auth.mapper;

import com.example.hyadm.auth.dto.RegisterDTO;
import com.example.hyadm.user.model.UserModel;
import org.springframework.stereotype.Component;

@Component
public class AuthMapper {

    public UserModel toUserModel(RegisterDTO dto) {
        UserModel userModel = new UserModel();
        userModel.setUsername(dto.getUsername());
        userModel.setEmail(dto.getEmail());
        userModel.setPassword(dto.getPassword());

        return userModel;
    }


}
