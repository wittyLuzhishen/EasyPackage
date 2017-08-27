package com.luzhishen.easypackage.facade.entity;

import com.luzhishen.easypackage.facade.util.BaseJavaBean;

/**
 * 任务组
 * 
 * <pre>
 * 包名格式：
 * appName-branchName-channelName-release-versionName
 * 例子：
 * app1-DEBUG-test_channel-release-4.7.12
 * </pre>
 */
public class TaskGroup extends BaseJavaBean {
    public interface Status {
        int BUILDING = 0;
        int WAIT_FOR_DISTRIBUTION = 1;
        int DISTRIBUTED = 2;
        int RUNNING = 3;
    }
}
