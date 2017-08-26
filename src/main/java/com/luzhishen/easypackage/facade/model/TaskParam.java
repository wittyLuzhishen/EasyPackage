package com.luzhishen.easypackage.facade.model;

import com.luzhishen.easypackage.facade.entity.App;
import com.luzhishen.easypackage.facade.util.BaseJavaBean;

public class TaskParam extends BaseJavaBean {
    private App app;
    private String branchName;
    private String versionName;
    private String packageNamePostfix;

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

}
