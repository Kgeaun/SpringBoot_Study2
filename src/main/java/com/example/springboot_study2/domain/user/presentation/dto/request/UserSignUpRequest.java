package com.example.springboot_study2.domain.user.presentation.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSignUpRequest {

    @NotNull
    @Size(min = 5, max = 20, message = "accountId는 5자 이상 20자 이하여야 하며, 필수항목입니다.")
    private String accountId;

    @NotNull
    @Size(min = 8, max = 20, message = "password는 8자 이상 20자 이하여야 하며, 필수항목입니다. (영문 대 소문자, 숫자, 특수문자를 사용하세요.)")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\\\W)(?=\\\\S+$).{7,20}")
    private String password;

    @NotNull
    @Size(min = 2, max = 5, message = "name은 2자 이상 5자 이하여야 하며, 필수 항목입니다.")
    private String name;
}