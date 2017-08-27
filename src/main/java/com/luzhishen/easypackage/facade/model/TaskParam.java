package com.luzhishen.easypackage.facade.model;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;

import com.luzhishen.easypackage.facade.entity.App;
import com.luzhishen.easypackage.facade.util.BaseJavaBean;

/**
 * 创建打包任务参数
 * 
 * @author luzhishen
 *
 */
public class TaskParam extends BaseJavaBean {
    private Integer userId;
    private App app;
    private String branchName;
    private String versionName;
    private String packageNamePostfix;
    private List<Integer> channelIdList;
    private List<Integer> mailReceiverIdList;

    /**
     * 检查请求参数
     * 
     * @param checkApp
     *            是否检查app字段，app字段不是直接根据客户端字段设置的
     * @return <isValid, message>
     */
    public Pair<Boolean, String> isValid(boolean checkApp) {
        if (userId == null || userId <= 0) {
            return Pair.of(Boolean.FALSE, "invalid userId");
        }
        if (checkApp && app == null) {
            return Pair.of(Boolean.FALSE, "app is null");
        }
        if (StringUtils.isBlank(branchName)) {
            return Pair.of(Boolean.FALSE, "branchName is null");
        }
        if (StringUtils.isBlank(versionName)) {
            return Pair.of(Boolean.FALSE, "versionName is null");
        }
        if (CollectionUtils.isEmpty(channelIdList)) {
            return Pair.of(Boolean.FALSE, "channelIdList is empty");
        }
        for (Integer channelId : channelIdList) {
            if (channelId == null || channelId <= 0) {
                return Pair.of(Boolean.FALSE, "invalid channelId:" + channelId);
            }
        }
        if (CollectionUtils.isEmpty(mailReceiverIdList)) {
            return Pair.of(Boolean.FALSE, "mailReceiverIdList is empty");
        }
        for (Integer mailReceiverId : mailReceiverIdList) {
            if (mailReceiverId == null || mailReceiverId <= 0) {
                return Pair.of(Boolean.FALSE, "invalid mailReceiverId:"
                        + mailReceiverId);
            }
        }
        return Pair.of(Boolean.TRUE, "valid");
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getPackageNamePostfix() {
        return packageNamePostfix;
    }

    public void setPackageNamePostfix(String packageNamePostfix) {
        this.packageNamePostfix = packageNamePostfix;
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

}
