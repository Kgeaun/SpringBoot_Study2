package com.example.springboot_study2.domain.user.service;

import com.example.springboot_study2.domain.user.domain.User;
import com.example.springboot_study2.domain.user.domain.repository.UserRepository;
import com.example.springboot_study2.domain.user.exception.UserExistException;
import com.example.springboot_study2.domain.user.presentation.dto.request.UserSignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserSignUpService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signUp(UserSignUpRequest request) {

        if (userRepository.existsByAccountId(request.getAccountId())) {
            throw UserExistException.EXCEPTION;
        }

        userRepository.save(
                User.builder()
                        .accountId(request.getAccountId())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .name(request.getName())
                        .build());
    }
}