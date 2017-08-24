package com.luzhishen.easypackage.facade.util;

import org.apache.commons.lang3.StringUtils;

import com.luzhishen.easypackage.facade.constant.Constants;

public class PathUtil {
    private static final String DEFAULT_PATH = Constants.Path.INDEX;
    private PathUtil() {
    }

    public static String getPath(String path) {
        if (StringUtils.isBlank(path)) {
            path = StringUtils.EMPTY;
        }
        if (!path.startsWith("/")) {
            path = "/" + path;
        }
        if (Config.getInstance().isNeedPrefixRootPath()
                && !StringUtils.startsWith(path, Config.getInstance().getRootPath())) {
            path = Config.getInstance().getRootPath() + path;
        }
        return path;
    }

    public static String getDefaultPath() {
        return getPath(DEFAULT_PATH);
    }

    public static String getRedirectPath(String path) {
        return "r:" + getPath(path);
    }

}
