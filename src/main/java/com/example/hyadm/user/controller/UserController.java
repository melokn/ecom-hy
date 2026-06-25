package com.example.hyadm.user.controller;


import com.example.hyadm.user.dto.UserDTO;
import com.example.hyadm.user.mapper.UserMapper;
import com.example.hyadm.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController (UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping()
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserDTO>> getUserById(@PathVariable long id) {
        Optional<UserDTO> user = userService.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO newUser = userService.createUser(userMapper.map(userDTO));
        return ResponseEntity.ok(newUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTOUpdated, @PathVariable Long id) {
        UserDTO updatedUser = userService.updateUser(id, userDTOUpdated);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        }
        return ResponseEntity.notFound().build();
    }


}

