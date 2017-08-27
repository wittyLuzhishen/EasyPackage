package com.luzhishen.easypackage.facade.util;

import javax.servlet.http.HttpServletRequest;

import net.paoding.rose.web.Invocation;

import org.eclipse.jdt.annotation.NonNull;

/**
 * 用于调试时查看{@link Invocation}信息的类
 * @author luzhishen
 *
 */
public class InvocationUtil {
    private InvocationUtil() {}

    public static String getInfo(@NonNull Invocation inv) {
        HttpServletRequest request = inv.getRequest();
        return "requestURI:" + request.getRequestURI()
                + ", resourceId:" + inv.getResourceId()
                + ", queryString:" + request.getQueryString()
                + ", requestURL:" + request.getRequestURL()
                + ", parameterMap:" + request.getParameterMap()
                + ", requestPath:" + inv.getRequestPath();
    }
}
