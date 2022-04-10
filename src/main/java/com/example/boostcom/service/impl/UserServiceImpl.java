package com.example.boostcom.service.impl;

import com.example.boostcom.model.dto.user.UserRegisterDto;
import com.example.boostcom.repository.UserRepository;
import com.example.boostcom.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public void registerUser(UserRegisterDto userServiceViewModel) {

    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
