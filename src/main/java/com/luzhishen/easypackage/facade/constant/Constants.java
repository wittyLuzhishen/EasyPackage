package com.luzhishen.easypackage.facade.constant;

public interface Constants {
    String RUN_PATH = System.getProperty("user.dir");// /xxx/apache-tomcat-xxx/bin
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
    }

    interface PackageToolType {
        int GRADLE = 0;
    }
}
