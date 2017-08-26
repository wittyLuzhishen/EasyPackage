package com.luzhishen.easypackage.facade.controllers;

import net.paoding.rose.web.ControllerErrorHandler;
import net.paoding.rose.web.Invocation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.luzhishen.easypackage.facade.constant.ErrorCode;
import com.luzhishen.easypackage.facade.model.Result;

public class ErrorHandler implements ControllerErrorHandler {
    private static final Logger logger = LoggerFactory
            .getLogger(ErrorHandler.class);

    @Override
    public Object onError(Invocation inv, Throwable ex) throws Throwable {
        logger.error("unexpected error: {}", ex);
        return Result.newInstance(ErrorCode.Unknown, ex.getMessage())
                .toString();
    }

}
