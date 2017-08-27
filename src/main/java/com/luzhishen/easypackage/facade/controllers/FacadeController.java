package com.luzhishen.easypackage.facade.controllers;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;

import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.luzhishen.easypackage.facade.constant.Constants;
import com.luzhishen.easypackage.facade.constant.ErrorCode;
import com.luzhishen.easypackage.facade.entity.App;
import com.luzhishen.easypackage.facade.model.Result;
import com.luzhishen.easypackage.facade.model.TaskParam;
import com.luzhishen.easypackage.facade.service.TaskService;
import com.luzhishen.easypackage.facade.util.PathUtil;
import com.luzhishen.easypackage.facade.util.UserStateManager;

@LoginCheckRequired
@Path(Constants.Path.ROOT)
public class FacadeController {
    private static final Logger logger = LoggerFactory
            .getLogger(FacadeController.class);

    @Autowired
    private TaskService taskService;


    @Get({ Constants.Path.ROOT, Constants.Path.INDEX })
    public String index(Invocation inv) {
        logger.debug("contextPath:{}", inv.getRequest().getContextPath());
        inv.addModel("appList", taskService.findAppList());
        return "/jsp/index.jsp";
    }


    @Get(Constants.Path.PACKAGE + "/{appId:\\d+}")
    public String packageIndex(Invocation inv, @Param("appId") Integer appId) {
        App app = null;
        if ((app = taskService.findApp(appId)) == null) {
            return "@" + Result.newInstance(ErrorCode.InvalidParam);
        }
        inv.addModel("app", app);
        // inv.addModel("branchNameList",
        // taskService.getBranchList(app.getId()));
        inv.addModel("channelList", taskService.findChannelList(app.getId()));
        inv.addModel("mailReceiverList", taskService.findMailReceiverList());
        return "/jsp/package.jsp";
    }

    @Post(Constants.Path.PACKAGE + "/{appId:\\d+}")
    public String submitPakcageTask(Invocation inv,
            @Param("appId") Integer appId, TaskParam taskParam) {
        taskParam.setUserId(UserStateManager.getLoginUserId(inv.getRequest()));
        Pair<Boolean, String> checkResult = taskParam.isValid(false);
        if (!checkResult.getLeft()) {
            logger.warn(
                    "create task param invalid, reason:{}, taskPara:{}, appId:{}",
                    checkResult.getRight(), taskParam, appId);
            return "@" + Result.newInstance(ErrorCode.InvalidParam);
        }
        App app = null;
        if ((app = taskService.findApp(appId)) == null) {
            return "@" + Result.newInstance(ErrorCode.InvalidParam);
        }
        taskParam.setApp(app);
        ErrorCode result = taskService.createTaskGroup(taskParam);
        if (result == ErrorCode.Success) {
            return PathUtil.getRedirectPath(Constants.Path.TASK_LIST + "/"
                    + appId);
        }
        return "@" + Result.newInstance(result);
    }

    @Get(Constants.Path.TASK_LIST + "/{appId:\\d+}")
    public String showTaskList(Invocation inv, @Param("appId") Integer appId) {
        App app = null;
        if ((app = taskService.findApp(appId)) == null) {
            return "@" + Result.newInstance(ErrorCode.InvalidParam);
        }
        // inv.addModel("statusList", taskService.getTaskGroupStatusList(app));
        return "@UnsupportedOperation, "
                + taskService.getTaskGroupStatusList(app);
    }
}
