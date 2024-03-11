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

    private final SignInService signInService;
    private final ReissueService reissueService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/signIn")
    public TokenResponse signIn(@RequestBody @Valid SignInRequest request) {
        return signInService.signIn(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/token")
    public TokenResponse reissue(String refreshToken) {
        return reissueService.reissue(refreshToken);
    }
}