package com.example.springboot_study2.domain.user.exception;

import global.error.CustomException;
import global.error.ErrorCode;

public class UserExistException extends CustomException {

    public static final CustomException EXCEPTION =
            new UserExistException();

    private UserExistException() {
        super(ErrorCode.USER_EXIST);
    }
}