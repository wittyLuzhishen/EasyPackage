package com.luzhishen.easypackage.facade.biz;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class UserBiz {

    public boolean login(String userName, String password) {
        // TODO
        return StringUtils.isNotBlank(userName)
                && StringUtils.isNoneBlank(password)
                && StringUtils.equals(userName, password);
    }

}