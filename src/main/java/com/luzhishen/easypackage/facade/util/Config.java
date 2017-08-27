package com.luzhishen.easypackage.facade.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Config {
    private static final Logger logger = LoggerFactory.getLogger(Config.class);
    private static final String propertiesFileName = "/config.properties";

    private static volatile String sContextPath = "";
    private static boolean debug;

    static {
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

    private static void parseConfig(Properties p) {
        debug = Boolean.parseBoolean(p.getProperty("is.debug", "false"));
    }

    private Config() {
    }

    public static void setContextPath(@NonNull String contextPath) {
        if (StringUtils.isBlank(sContextPath) && contextPath != null) {
            synchronized (Config.class) {
                if (StringUtils.isBlank(sContextPath)) {
                    sContextPath = contextPath;
                    logger.info("contextPath:{}", contextPath);
                }
            }
        }
    }

    public static void setContextPath4Test(@NonNull String contextPath) {
        if (contextPath != null) {
            synchronized (Config.class) {
                sContextPath = contextPath;
                logger.info("contextPath:{}", contextPath);
            }
        }
    }

    /**
     * 
     * @return 空字符串或 /<应用名称>
     */
    public synchronized static String getContextPath() {
        return sContextPath;
    }

    public static boolean isDebug() {
        return debug;
    }

    @Nullable
    public static String getSelfIpV4() {
        try {
            Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface
                    .getNetworkInterfaces();
            if (allNetInterfaces == null) {
                return null;
            }
            while (allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = allNetInterfaces.nextElement();
                if (!netInterface.getName().startsWith("eth")) {
                    continue;
                }
                Enumeration<InetAddress> addresses = netInterface
                        .getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress ip = addresses.nextElement();
                    if (ip != null && ip instanceof Inet4Address) {
                        return ip.getHostAddress();
                    }
                }
            }
        } catch (SocketException e) {
            logger.error("get sefl IP failed, {}", e);
        }
        return null;
    }

    public static void main(String... args) {
        System.out.println(getSelfIpV4());
    }

}