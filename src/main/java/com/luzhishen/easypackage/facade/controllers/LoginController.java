package com.luzhishen.easypackage.facade.controllers;

import static com.luzhishen.easypackage.facade.constant.Constants.ParamName.PASSWORD;
import static com.luzhishen.easypackage.facade.constant.Constants.ParamName.USER_NAME;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;

import org.springframework.beans.factory.annotation.Autowired;

import com.luzhishen.easypackage.facade.constant.Constants;
import com.luzhishen.easypackage.facade.constant.ErrorCode;
import com.luzhishen.easypackage.facade.entity.User;
import com.luzhishen.easypackage.facade.model.Result;
import com.luzhishen.easypackage.facade.service.TaskService;
import com.luzhishen.easypackage.facade.util.Config;
import com.luzhishen.easypackage.facade.util.PathUtil;
import com.luzhishen.easypackage.facade.util.UserStateManager;

@Path(Constants.Path.ROOT)
public class LoginController {
    @Autowired
    private TaskService taskService;

    @Get(Constants.Path.LOGIN)
    public String loginGet(Invocation inv) {
        Config.setContextPath(inv.getRequest().getContextPath());
        if (UserStateManager.isLogined(inv.getRequest())) {
            return PathUtil.getRedirectPath(Constants.Path.INDEX);
        } else {
            return "/jsp/login.jsp";
        }
    }

    @Post(Constants.Path.LOGIN)
    public String loginPost(Invocation inv, @Param(USER_NAME) String userName,
            @Param(PASSWORD) String password) {
        Config.setContextPath(inv.getRequest().getContextPath());
        User user;
        if ((user = taskService.findUser(userName, password)) != null) {
            UserStateManager.setLogined(inv.getRequest(), user);
            return PathUtil.getRedirectPath(Constants.Path.INDEX);
        }
        UserStateManager.setLogout(inv.getRequest());
        return "@" + Result.newInstance(ErrorCode.LoginFailed);
    }
}
