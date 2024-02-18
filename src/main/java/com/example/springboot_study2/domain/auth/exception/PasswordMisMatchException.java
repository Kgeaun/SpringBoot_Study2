package com.example.springboot_study2.domain.auth.exception;

import global.error.CustomException;
import global.error.ErrorCode;

public class PasswordMisMatchException extends CustomException {

    public static final CustomException EXCEPTION =
            new PasswordMisMatchException();

    private PasswordMisMatchException() {
        super(ErrorCode.PASSWORD_MIS_MATCH);
    }
}