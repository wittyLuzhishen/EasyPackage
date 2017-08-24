package com.luzhishen.easypackage.facade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luzhishen.easypackage.facade.biz.AppBiz;
import com.luzhishen.easypackage.facade.biz.UserBiz;
import com.luzhishen.easypackage.facade.entity.App;

@Service
public class TaskService {
    @Autowired
    private UserBiz userBiz;
    @Autowired
    private AppBiz appBiz;

    public boolean login(String userName, String password) {
        return userBiz.login(userName, password);
    }

    public List<App> findAppList() {
        return appBiz.findAppList();
    }

    public void findPlatformList() {
        // TODO - implement TaskService.findPlatformList
        throw new UnsupportedOperationException();
    }

    public void getBranchList() {
        // TODO - implement TaskService.getBranchList
        throw new UnsupportedOperationException();
    }

    public void findChannelList() {
        // TODO - implement TaskService.findChannelList
        throw new UnsupportedOperationException();
    }

    public void findMailReceiverList() {
        // TODO - implement TaskService.findMailReceiverList
        throw new UnsupportedOperationException();
    }

    public void getCommitList() {
        // TODO - implement TaskService.getCommitList
        throw new UnsupportedOperationException();
    }

    public void createTaskGroup() {
        // TODO - implement TaskService.createTaskGroup
        throw new UnsupportedOperationException();
    }

}