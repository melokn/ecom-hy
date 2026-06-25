package com.example.hyadm.user.service;


import com.example.hyadm.exception.BadRequest;
import com.example.hyadm.exception.UserAlreadyExists;
import com.example.hyadm.user.dto.UserDTO;
import com.example.hyadm.user.mapper.UserMapper;
import com.example.hyadm.user.model.UserModel;
import com.example.hyadm.user.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public Optional<UserDTO> findById(long id) {
       return userRepository.findById(id)
               .map(userMapper::map);
    }
    public List<UserDTO> findAll() {
        List<UserModel> userList = userRepository.findAll();
        return userList.stream()
                .map(userMapper::map)
                .collect(Collectors.toList());

    }
    public UserDTO createUser(UserModel user) {
        if (user == null) {
            throw new BadRequest("User cannot be null");

        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new UserAlreadyExists("User with email " + user.getEmail() + " already exists");
        }

        UserModel createdUser = userRepository.save(user);
        return userMapper.map(createdUser);

    }

    public UserModel findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    public UserDTO updateUser(Long id, UserDTO userDTO) {
        if (userDTO == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new RuntimeException("User with email " + userDTO.getEmail() + " already exists");
        }
        Optional<UserModel> user = userRepository.findById(id);
        if (user.isPresent()) {
            UserModel updatedUser = userMapper.map(userDTO);
            updatedUser.setId(id);
            userRepository.save(updatedUser);
            return userMapper.map(updatedUser);
        }

        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        return userRepository.findByEmail(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Usuário não encontrado"));
    }
}
