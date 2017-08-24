package com.luzhishen.easypackage.facade.biz;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.luzhishen.easypackage.facade.entity.App;

@Service
public class AppBiz {

    public List<App> findAppList() {
        List<App> appList = new ArrayList<>();
        appList.add(new App(1, "walilive", "小米直播", ""));
        appList.add(new App(2, "miliao", "米聊", ""));
        return appList;
	}

}