package com.luzhishen.easypackage.facade.constant;

public enum ErrorCode {
    Unknown(-1, "未知错误"),
    Success(0, "成功"),
    InvalidParam(1, "非法参数"),
    LoginFailed(2, "用户名或密码错误"),
    ;
    private int code;
    private String message;
    
    private ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
    public int getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
