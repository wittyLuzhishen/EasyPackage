package com.luzhishen.easypackage.facade.controllers;

import net.paoding.rose.web.ControllerErrorHandler;
import net.paoding.rose.web.Invocation;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ErrorHandler implements ControllerErrorHandler {
    private static final Logger logger = LoggerFactory
            .getLogger(ErrorHandler.class);

    @Override
    public Object onError(Invocation inv, Throwable ex) throws Throwable {
        logger.error("unexpected error: {}", ex);
        JSONObject json = new JSONObject();
        json.put("code", -1);
        json.put("msg", ex.getMessage());
        return json.toString();
    }

}
