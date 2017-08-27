package com.luzhishen.easypackage.facade.util;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.jdt.annotation.Nullable;

public class UserStateManager {
    private UserStateManager() {
    }

    public static final String LOGIN_SESSION_USER = "userInfo";
    public static final String LOGIN_COOKIE_USERNAME = "cookie_uname";
    public static final String LOGIN_COOKIE_PASSWORD = "cookie_pwd";

    @Nullable
    public static Integer getLoginUserId(HttpServletRequest request) {
        return (Integer) request.getSession().getAttribute(LOGIN_SESSION_USER);
    }

    public static boolean isLogined(HttpServletRequest request) {
        Integer userId = getLoginUserId(request);
        return userId != null && userId > 0;
    }

    public static void setLogined(HttpServletRequest request, Integer userId) {
        request.getSession().setAttribute(LOGIN_SESSION_USER, userId);
    }

    public static void setLogout(HttpServletRequest request) {
        request.getSession().removeAttribute(LOGIN_SESSION_USER);
    }
}
