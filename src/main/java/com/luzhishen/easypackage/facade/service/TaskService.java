package com.luzhishen.easypackage.facade.service;

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luzhishen.easypackage.facade.biz.AppBiz;
import com.luzhishen.easypackage.facade.biz.ChannelBiz;
import com.luzhishen.easypackage.facade.biz.GitBiz;
import com.luzhishen.easypackage.facade.biz.MailReceiverBiz;
import com.luzhishen.easypackage.facade.biz.TaskBiz;
import com.luzhishen.easypackage.facade.biz.UserBiz;
import com.luzhishen.easypackage.facade.constant.ErrorCode;
import com.luzhishen.easypackage.facade.entity.App;
import com.luzhishen.easypackage.facade.entity.Channel;
import com.luzhishen.easypackage.facade.entity.MailReceiver;
import com.luzhishen.easypackage.facade.exception.PackageException;
import com.luzhishen.easypackage.facade.model.Commit;
import com.luzhishen.easypackage.facade.model.TaskGroupStatus;
import com.luzhishen.easypackage.facade.model.TaskParam;

@Service
public class TaskService {
    private static final Logger logger = LoggerFactory
            .getLogger(TaskService.class);

    @Autowired
    private UserBiz userBiz;
    @Autowired
    private AppBiz appBiz;
    @Autowired
    private GitBiz gitBiz;
    @Autowired
    private ChannelBiz channelBiz;
    @Autowired
    private MailReceiverBiz mailReceiverBiz;
    @Autowired
    private TaskBiz taskBiz;

    public Integer findUserId(String userName, String password) {
        return userBiz.findUserId(userName, password);
    }

    public List<App> findAppList() {
        return appBiz.findAppList();
    }

    @Nullable
    public App findApp(Integer appId) {
        App app = null;
        if (appId == null
                || appId <= 0
                || (app = appBiz.findApp(appId)) == null) {
            return null;
        }
        return app;
    }

    @NonNull
    public List<String> getBranchList(int appId) {
        return gitBiz.getBranchList(appId);
    }

    public List<Channel> findChannelList(int appId) {
        return channelBiz.findChannelList(appId);
    }

    public List<MailReceiver> findMailReceiverList() {
        return mailReceiverBiz.findMailReceiverList();
    }

    public List<Commit> getCommitList(int platformId, int appId,
            String branchName) {
        return gitBiz.getCommitList(platformId, appId, branchName);
    }

    public ErrorCode createTaskGroup(TaskParam taskParam) {
        logger.debug("createTaskGroup, taskParam:{}", taskParam);
        try {
            taskBiz.createTaskGroup(taskParam);
        } catch (PackageException e) {
            return e.getErrorCode();
        } catch (Exception e) {
            return ErrorCode.Unknown;
        }
        return ErrorCode.Success;
    }

    @NonNull
    public List<TaskGroupStatus> getTaskGroupStatusList(@NonNull App app) {
        return taskBiz.getTaskGroupStatusList(app);
    }

}