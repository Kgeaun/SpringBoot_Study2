package com.example.springboot_study2.domain.auth.service;

import com.example.springboot_study2.domain.auth.exception.PasswordMisMatchException;
import com.example.springboot_study2.domain.auth.presentation.dto.request.SignInRequest;
import com.example.springboot_study2.domain.auth.presentation.dto.response.TokenResponse;
import com.example.springboot_study2.domain.user.domain.User;
import com.example.springboot_study2.domain.user.domain.repository.UserRepository;
import com.example.springboot_study2.domain.user.exception.UserNotFoundException;
import global.security.jwt.JwtProperties;
import global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class SignInService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtProperties jwtProperties;

    public TokenResponse signIn(SignInRequest request) {
        User user = userRepository.findByAccountId(request.getAccountId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordMisMatchException.EXCEPTION;
        }

        String accessToken = jwtTokenProvider.generateAccessToken(request.getAccountId());
        String refreshToken = jwtTokenProvider.generateRefreshToken(request.getAccountId());
        LocalDateTime expiredAt = LocalDateTime.now().plusSeconds(jwtProperties.getAccessExp());

        return TokenResponse.builder()
                .accessToken(accessToken)
                .expiredAt(expiredAt)
                .refreshToken(refreshToken)
                .build();
    }
}