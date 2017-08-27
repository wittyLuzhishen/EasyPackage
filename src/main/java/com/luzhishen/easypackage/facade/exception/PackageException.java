package com.luzhishen.easypackage.facade.exception;

import org.eclipse.jdt.annotation.NonNull;

import com.luzhishen.easypackage.facade.constant.ErrorCode;

public class PackageException extends Exception {
    /**
     * 1:first
     */
    private static final long serialVersionUID = 1L;
    private ErrorCode errorCode;

    private PackageException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public static PackageException of(@NonNull ErrorCode errorCode) {
        return new PackageException(errorCode);
    }

    @NonNull
    public ErrorCode getErrorCode() {
        return errorCode;
    }

}
