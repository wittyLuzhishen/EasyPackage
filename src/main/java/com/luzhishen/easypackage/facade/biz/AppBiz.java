package com.luzhishen.easypackage.facade.biz;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.luzhishen.easypackage.facade.entity.App;

@Service
public class AppBiz {

    public List<App> findAppList() {
        List<App> appList = new ArrayList<>();
        appList.add(new App(1, "app1", "应用1"));
        appList.add(new App(2, "app2", "应用2"));
        return appList;
	}

}