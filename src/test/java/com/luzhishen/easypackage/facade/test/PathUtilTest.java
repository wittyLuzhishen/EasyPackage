package com.luzhishen.easypackage.facade.test;

import org.junit.Assert;
import org.junit.Test;

import com.luzhishen.easypackage.facade.util.Config;
import com.luzhishen.easypackage.facade.util.PathUtil;

public class PathUtilTest {
    @Test
    public void testGetPath() {
        System.out.println(Config.getInstance().getBasePath());
        System.out.println(Config.getInstance().isNeedPrefixRootPath());
        System.out.println(PathUtil.getPath(""));
        Assert.assertFalse(PathUtil.getPath("").equals("/"));
        Assert.assertTrue(PathUtil.getPath("index").equals(
                Config.getInstance().getBasePath() + "/index"));
        Assert.assertTrue(PathUtil.getPath("/index").equals(
                Config.getInstance().getBasePath() + "/index"));
    }
}
