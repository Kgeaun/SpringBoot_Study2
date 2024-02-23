package com.example.springboot_study2.domain.auth.presentation;

import com.example.springboot_study2.domain.auth.presentation.dto.request.SignInRequest;
import com.example.springboot_study2.domain.auth.presentation.dto.response.TokenResponse;
import com.example.springboot_study2.domain.auth.service.ReissueService;
import com.example.springboot_study2.domain.auth.service.SignInService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final SignInService loginService;
    private final ReissueService reissueService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/sign_in")
    public TokenResponse signIn(@RequestBody @Valid SignInRequest request) {
        return loginService.signIn(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/token")
    public TokenResponse reissue(String refreshToken) {
        return reissueService.reissue(refreshToken);
    }
}