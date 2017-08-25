package com.luzhishen.easypackage.facade.biz;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.luzhishen.easypackage.facade.constant.Constants;
import com.luzhishen.easypackage.facade.entity.Platform;

@Service
public class PlatformBiz {

    public List<Platform> findPlatformList() {
        List<Platform> platformList = new ArrayList<>();
        platformList.add(new Platform(1, "and", "Android",
                Constants.PackageToolType.GRADLE));
        return platformList;
	}

}