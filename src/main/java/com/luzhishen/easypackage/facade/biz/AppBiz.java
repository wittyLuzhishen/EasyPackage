package com.luzhishen.easypackage.facade.biz;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.annotation.Nullable;
import org.springframework.stereotype.Service;

import com.luzhishen.easypackage.facade.constant.Constants;
import com.luzhishen.easypackage.facade.entity.App;

@Service
public class AppBiz {
    private App app1 = new App(1, "app1", "应用1", Constants.Git.TEST_PROJECT_DIR);
    private App app2 = new App(2, "app2", "应用2", Constants.Git.TEST_PROJECT_DIR);

    public List<App> findAppList() {
        List<App> appList = new ArrayList<>();
        appList.add(app1);
        appList.add(app2);
        return appList;
    }

    @Nullable
    public App findApp(int appId) {
        switch (appId) {
        case 1:
            return app1;
        case 2:
            return app2;
        default:
            return null;
        }
    }

}