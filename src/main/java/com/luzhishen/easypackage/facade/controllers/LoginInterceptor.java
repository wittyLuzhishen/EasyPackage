package com.luzhishen.easypackage.facade.controllers;

import java.lang.annotation.Annotation;

import net.paoding.rose.web.ControllerInterceptorAdapter;
import net.paoding.rose.web.Invocation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.luzhishen.easypackage.facade.constant.Constants;
import com.luzhishen.easypackage.facade.util.Config;
import com.luzhishen.easypackage.facade.util.PathUtil;
import com.luzhishen.easypackage.facade.util.UserStateManager;
/**
 * 登录验证的拦截器
 */
public class LoginInterceptor extends ControllerInterceptorAdapter {
    private static final Logger logger = LoggerFactory
            .getLogger(LoginInterceptor.class);

    public LoginInterceptor() {
        setPriority(29600);
    }

    @Override
    public Class<? extends Annotation> getRequiredAnnotationClass() {
        return LoginCheckRequired.class; // 这是一个注解，只有标过的controller才会接受这个拦截器的洗礼。
    }

    @Override
    public Object before(Invocation inv) throws Exception {
        logger.debug("LoginInterceptor before");
        Config.setContextPath(inv.getRequest().getContextPath());
        if (UserStateManager.isLogined(inv.getRequest())) {
            return super.before(inv);
        } else {
            return PathUtil.getRedirectPath(Constants.Path.LOGIN);
        }
    }

    @Override
    public void afterCompletion(final Invocation inv, Throwable ex)
            throws Exception {
        logger.debug("LoginInterceptor afterCompletion");
    }

}
