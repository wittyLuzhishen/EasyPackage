package com.luzhishen.easypackage.facade.model;

import java.util.List;

import com.luzhishen.easypackage.facade.util.BaseJavaBean;

public class CreateTaskRequest extends BaseJavaBean {
    private int userId;
    private int platformId;
    private int appId;
    private String branchName;
    private String packageNameTemplate;// 批量打包时用到
    private List<Integer> channelIdList;
    private List<Integer> mailReceiverIdList;
    private String fromCommitHash;// 起始的commit hash

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPlatformId() {
        return platformId;
    }

    public void setPlatformId(int platformId) {
        this.platformId = platformId;
    }

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getPackageNameTemplate() {
        return packageNameTemplate;
    }

    public void setPackageNameTemplate(String packageNameTemplate) {
        this.packageNameTemplate = packageNameTemplate;
    }

    public List<Integer> getChannelIdList() {
        return channelIdList;
    }

    public void setChannelIdList(List<Integer> channelIdList) {
        this.channelIdList = channelIdList;
    }

    public List<Integer> getMailReceiverIdList() {
        return mailReceiverIdList;
    }

    public void setMailReceiverIdList(List<Integer> mailReceiverIdList) {
        this.mailReceiverIdList = mailReceiverIdList;
    }

    public String getFromCommitHash() {
        return fromCommitHash;
    }

    public void setFromCommitHash(String fromCommitHash) {
        this.fromCommitHash = fromCommitHash;
    }

}
