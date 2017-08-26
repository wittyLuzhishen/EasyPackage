package com.luzhishen.easypackage.facade.controllers;

import java.util.List;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.luzhishen.easypackage.facade.constant.ErrorCode;
import com.luzhishen.easypackage.facade.entity.App;
import com.luzhishen.easypackage.facade.model.Result;
import com.luzhishen.easypackage.facade.service.TaskService;

@Path("/data")
@LoginCheckRequired
public class DataController {
    private static final Logger logger = LoggerFactory
            .getLogger(DataController.class);

    @Autowired
    private TaskService taskService;

    @Get("getBranchList")
    public String getAllBranch(Invocation inv, @Param("appId") Integer appId) {
        App app = null;
        if ((app = taskService.findApp(appId)) == null) {
            return "@" + Result.newInstance(ErrorCode.InvalidParam);
        }
        List<String> branchList = taskService.getBranchList(app.getId());
        Result result = Result.newInstance(ErrorCode.Success, branchList);
        logger.debug("result:{}", result);
        return "@" + result;
    }
    
    @Get("getVersionName")
    public String getVersionName(Invocation inv, @Param("appId") Integer appId,
            @Param("branchName") String branchName) {
        return "@" + Result.newInstance(ErrorCode.Success, "1.2.3");
    }

    /**
     * 从数据库中读取频道信息并不慢，不用在页面用Ajax异步获取
     * 
     * @param inv
     * @param appId
     * @return
     */
    @Deprecated
    @Get("getChannelList")
    public String getChannelList(Invocation inv, @Param("appId") Integer appId) {
        App app = null;
        if ((app = taskService.findApp(appId)) == null) {
            return "@" + Result.newInstance(ErrorCode.InvalidParam);
        }
        return "@"
                + Result.newInstance(ErrorCode.Success,
                        taskService.findChannelList(app.getId()));
    }
}
