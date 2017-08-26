package com.luzhishen.easypackage.facade.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

public class UserStateManager {
    private UserStateManager() {
    }

    public static final String LOGIN_SESSION_USER = "userInfo";
    public static final String LOGIN_COOKIE_USERNAME = "cookie_uname";
    public static final String LOGIN_COOKIE_PASSWORD = "cookie_pwd";

    public static boolean isLogined(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return StringUtils.isNotBlank((String) session
                .getAttribute(LOGIN_SESSION_USER));
    }

    public static void setLogined(HttpServletRequest request, String userName) {
        request.getSession().setAttribute(LOGIN_SESSION_USER, userName);
    }

    public static void setLogout(HttpServletRequest request) {
        request.getSession().removeAttribute(LOGIN_SESSION_USER);
    }
}
