package com.luzhishen.easypackage.facade.controllers;

import static com.luzhishen.easypackage.facade.constant.Constants.ParamName.PASSWORD;
import static com.luzhishen.easypackage.facade.constant.Constants.ParamName.USER_NAME;
import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.luzhishen.easypackage.facade.constant.Constants;
import com.luzhishen.easypackage.facade.service.TaskService;
import com.luzhishen.easypackage.facade.util.PathUtil;
import com.luzhishen.easypackage.facade.util.UserStateManager;

@Path(Constants.Path.ROOT)
public class FacadeController {
    private static final Logger logger = LoggerFactory
            .getLogger(FacadeController.class);

    @Autowired
    private TaskService taskService;

    @LoginCheckRequired
    @Get({ Constants.Path.ROOT, Constants.Path.INDEX })
    public String index(Invocation inv) {
        inv.addModel("appList", taskService.findAppList());
        inv.addModel("platformList", taskService.findPlatformList());
        inv.addModel("rootPath", PathUtil.getPath(Constants.Path.ROOT));
        return "/jsp/index.jsp";
    }

    @Get(Constants.Path.LOGIN)
    public String login(Invocation inv) {
        if (UserStateManager.isLogined(inv.getRequest())) {
            return PathUtil.getRedirectPath(Constants.Path.INDEX);
        } else {
            inv.addModel("actionPath", PathUtil.getPath(Constants.Path.LOGIN));
            return "/jsp/login.jsp";
        }
    }

    @Post(Constants.Path.LOGIN)
    public String login1(Invocation inv,
            @Param(USER_NAME) String userName,
            @Param(PASSWORD) String password) {
        if (taskService.login(userName, password)) {
            UserStateManager.setLogined(inv.getRequest(), userName);
            return PathUtil.getRedirectPath(Constants.Path.INDEX);
        }
        return "@用户名或密码错误";
    }

    @LoginCheckRequired
    @Get(Constants.Path.PACKAGE + "/{appName:\\w+}")
    public String packageIndex(Invocation inv, @Param("appName") String appName) {
        inv.addModel("appName", appName);
        return "/jsp/package.jsp";
    }

}
