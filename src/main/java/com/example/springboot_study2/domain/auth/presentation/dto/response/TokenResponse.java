package com.example.springboot_study2.domain.auth.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class TokenResponse {

    private final String accessToken;
    private final LocalDateTime expiredAt;
    private final String refreshToken;
}