package global.exception;

import global.error.CustomException;
import global.error.ErrorCode;

public class InvalidJwtException extends CustomException {

    public static final CustomException EXCEPTION =
            new InvalidJwtException();

    private InvalidJwtException() {
        super(ErrorCode.INVALID_JWT);
    }
}