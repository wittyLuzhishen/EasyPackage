package com.luzhishen.easypackage.facade.test;

import org.junit.Assert;
import org.junit.Test;

import com.luzhishen.easypackage.facade.util.Config;
import com.luzhishen.easypackage.facade.util.PathUtil;

public class PathUtilTest {
    @Test
    public void testGetPath1() {
        Config.setContextPath4Test("/appName");

        System.out.println(PathUtil.getPath(""));

        Assert.assertTrue(PathUtil.getPath("").equals(
                Config.getContextPath() + "/"));
        Assert.assertTrue(PathUtil.getPath("/").equals(
                Config.getContextPath() + "/"));
        Assert.assertTrue(PathUtil.getPath("index").equals(
                Config.getContextPath() + "/index"));
        Assert.assertTrue(PathUtil.getPath("/index").equals(
                Config.getContextPath() + "/index"));
    }

    @Test
    public void testGetPath2() {
        Config.setContextPath4Test("");

        System.out.println(PathUtil.getPath(""));

        Assert.assertTrue(PathUtil.getPath("").equals("/"));
        Assert.assertTrue(PathUtil.getPath("/").equals("/"));
        Assert.assertTrue(PathUtil.getPath("index").equals("/index"));
        Assert.assertTrue(PathUtil.getPath("/index").equals("/index"));
    }
}
