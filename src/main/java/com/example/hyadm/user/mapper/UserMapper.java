package com.example.hyadm.user.mapper;


import com.example.hyadm.user.dto.UserDTO;
import com.example.hyadm.user.model.UserModel;
import org.springframework.stereotype.Component;

@Component

public class UserMapper {

    public UserModel map(UserDTO dto) {
      UserModel userModel = new UserModel();
      userModel.setId(dto.getId());
      userModel.setUsername(dto.getUsername());
      userModel.setEmail(dto.getEmail());
      userModel.setPassword(dto.getPassword());

      return userModel;
    }

    public UserDTO map(UserModel model){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(model.getId());
        userDTO.setUsername(model.getUsername());
        userDTO.setEmail(model.getEmail());
        userDTO.setPassword(model.getPassword());
        return userDTO;
    }
}
