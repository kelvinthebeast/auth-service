package com.nhanthanhle.research.identity_service.dto.response;

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "UNCATEGORIZED_EXCEPTION"),
    USER_EXISTED(1001, "User existed"),
    MESSAGEKEY_INVALID(1005, "INVALID message key"),
    USERNAME_INVALID(1003,"Username must be at least 5 character"),
    PASSWORD_INVALID(1004, "Password must be at least 5 character")
    ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
