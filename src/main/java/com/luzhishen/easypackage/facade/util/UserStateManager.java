package com.luzhishen.easypackage.facade.util;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.jdt.annotation.Nullable;

import com.luzhishen.easypackage.facade.entity.User;

public class UserStateManager {
    private UserStateManager() {
    }

    public static final String LOGIN_SESSION_USER = "userInfo";
    public static final String LOGIN_COOKIE_USERNAME = "cookie_uname";
    public static final String LOGIN_COOKIE_PASSWORD = "cookie_pwd";

    @Nullable
    public static User getLoginUser(HttpServletRequest request) {
        return (User) request.getSession().getAttribute(LOGIN_SESSION_USER);
    }

    public static boolean isLogined(HttpServletRequest request) {
        User user = getLoginUser(request);
        return user != null && user.getId() > 0;
    }

    public static void setLogined(HttpServletRequest request, User user) {
        request.getSession().setAttribute(LOGIN_SESSION_USER, user);
    }

    public static void setLogout(HttpServletRequest request) {
        request.getSession().removeAttribute(LOGIN_SESSION_USER);
    }
}
