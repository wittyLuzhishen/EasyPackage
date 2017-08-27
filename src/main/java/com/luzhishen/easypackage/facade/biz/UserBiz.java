package com.luzhishen.easypackage.facade.biz;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.jdt.annotation.Nullable;
import org.springframework.stereotype.Service;

@Service
public class UserBiz {
    /**
     * 
     * @param userName
     * @param password
     * @return
     */
    @Nullable
    public Integer findUserId(String userName, String password) {
        // TODO
        if (StringUtils.isNotBlank(userName)
                && StringUtils.isNoneBlank(password)
                && StringUtils.equals(userName, password)) {
            return 1;
        }
        return null;
    }

}