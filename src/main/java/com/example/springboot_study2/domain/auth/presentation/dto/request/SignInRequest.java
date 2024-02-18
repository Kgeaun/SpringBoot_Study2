package com.example.springboot_study2.domain.auth.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SignInRequest {

    @NotBlank(message = "accountId는 null이 불가합니다.")
    private String accountId;

    @NotBlank(message = "password는 null이 불가합니다.")
    private String password;
}