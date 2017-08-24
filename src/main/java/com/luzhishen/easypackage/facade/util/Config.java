package com.luzhishen.easypackage.facade.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Config {
    private static final Logger logger = LoggerFactory.getLogger(Config.class);
    private static final String propertiesFileName = "/config.properties";
    private String rootPath = "/";
    private boolean needPrefixRootPath = false;

    private static class ConfigHolder {
        private static Config instance = new Config();
    }

    private Config() {
        long startTime = System.currentTimeMillis();
        logger.debug("begin parse {}", propertiesFileName);
        InputStream inputStream = Config.class
                .getResourceAsStream(propertiesFileName);
        Properties p = new Properties();
        try {
            p.load(inputStream);
        } catch (IOException e) {
            logger.error("load {} failed", propertiesFileName);
        }
        parseConfig(p);
        logger.debug("end parse {}, cost {}ms", propertiesFileName,
                System.currentTimeMillis() - startTime);
    }

    private void parseConfig(Properties p) {
        rootPath = "/" + p.getProperty("root.path", StringUtils.EMPTY);
        needPrefixRootPath = Boolean.parseBoolean(p.getProperty(
                "need.prefix.root.path", "false"));
    }

    public static Config getInstance() {
        return ConfigHolder.instance;
    }

    public void getSelfIp() {
        // TODO - implement Config.getSelfIp
        throw new UnsupportedOperationException();
    }

    /**
     * 
     * @return / 或者 /easypackage
     */
    public String getRootPath() {
        return rootPath;
    }

    public boolean isNeedPrefixRootPath() {
        return needPrefixRootPath;
    }

}