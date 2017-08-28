package com.luzhishen.easypackage.facade.biz;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.jdt.annotation.Nullable;
import org.springframework.stereotype.Service;

import com.luzhishen.easypackage.facade.entity.User;

@Service
public class UserBiz {
    /**
     * 
     * @param userName
     * @param password
     * @return
     */
    @Nullable
    public User findUser(String userName, String password) {
        // TODO
        if (StringUtils.isNotBlank(userName)
                && StringUtils.isNoneBlank(password)
                && StringUtils.equals(userName, password)) {
            User user = new User();
            user.setId(1);
            return user;
        }
        return null;
    }

}