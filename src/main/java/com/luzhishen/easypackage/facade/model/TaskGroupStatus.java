package com.luzhishen.easypackage.facade.model;

import com.luzhishen.easypackage.facade.entity.App;
import com.luzhishen.easypackage.facade.entity.User;
import com.luzhishen.easypackage.facade.util.BaseJavaBean;

/**
 * 用于向用户展示任务状态的数据结构
 * 
 * @author luzhishen
 *
 */
public class TaskGroupStatus extends BaseJavaBean {
    public interface Status {
        int RUNNING = 0;
        int SUCCESS = 1;
        int PARTIAL_FAILED = 2;
        int ALL_FAILED = 3;
    }
    private int taskGroupId;
    private App app;
    private String branchName;
    private String versionName;
    private long createTime;
    private User user;
    private int taskCount;
    private int successTaskCount;
    private int status;

    public int getTaskGroupId() {
        return taskGroupId;
    }

    public void setTaskGroupId(int taskGroupId) {
        this.taskGroupId = taskGroupId;
    }

    public App getApp() {
        return app;
    }

    public void setApp(App app) {
        this.app = app;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getVersionName() {
        return versionName;
    }

    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getTaskCount() {
        return taskCount;
    }

    public void setTaskCount(int taskCount) {
        this.taskCount = taskCount;
    }

    public int getSuccessTaskCount() {
        return successTaskCount;
    }

    public void setSuccessTaskCount(int successTaskCount) {
        this.successTaskCount = successTaskCount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
