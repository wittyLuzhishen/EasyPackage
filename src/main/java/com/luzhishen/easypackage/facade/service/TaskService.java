package com.luzhishen.easypackage.facade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luzhishen.easypackage.facade.biz.AppBiz;
import com.luzhishen.easypackage.facade.biz.ChannelBiz;
import com.luzhishen.easypackage.facade.biz.GitBiz;
import com.luzhishen.easypackage.facade.biz.MailReceiverBiz;
import com.luzhishen.easypackage.facade.biz.PlatformBiz;
import com.luzhishen.easypackage.facade.biz.UserBiz;
import com.luzhishen.easypackage.facade.entity.App;
import com.luzhishen.easypackage.facade.entity.Channel;
import com.luzhishen.easypackage.facade.entity.MailReceiver;
import com.luzhishen.easypackage.facade.entity.Platform;
import com.luzhishen.easypackage.facade.model.Commit;

@Service
public class TaskService {
    @Autowired
    private UserBiz userBiz;
    @Autowired
    private AppBiz appBiz;
    @Autowired
    private PlatformBiz platformBiz;
    @Autowired
    private GitBiz gitBiz;
    @Autowired
    private ChannelBiz channelBiz;
    @Autowired
    private MailReceiverBiz mailReceiverBiz;

    public boolean login(String userName, String password) {
        return userBiz.login(userName, password);
    }

    public List<App> findAppList() {
        return appBiz.findAppList();
    }

    public List<Platform> findPlatformList() {
        return platformBiz.findPlatformList();
    }

    public List<String> getBranchList(int platformId, int appId) {
        return gitBiz.getBranchList(platformId, appId);
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

    public boolean createTaskGroup() {
        // TODO - implement TaskService.createTaskGroup
        throw new UnsupportedOperationException();
    }

}