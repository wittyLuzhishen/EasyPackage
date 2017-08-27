package com.luzhishen.easypackage.facade.constant;

public interface Constants {
    interface Git {
        String TEST_PROJECT_DIR = "/home/rongzhisheng/workspace2/backyard";
    }
    String RUN_PATH = System.getProperty("user.dir");// /xxx/apache-tomcat-xxx/bin
    String TOMCAT_PATH = RUN_PATH.substring(0,
            RUN_PATH.length() - "/bin".length());
    interface ParamName {
        String USER_NAME = "userName";
        String PASSWORD = "password";
        String FROM_URL = "fromUrl";
    }

    interface Path {
        String ROOT = "/";
        String INDEX = "/index";
        String LOGIN = "/login";
        String PACKAGE = "/package";
        String TASK_LIST = "/taskList";
    }

    interface PackageToolType {
        int GRADLE = 0;
    }
}
