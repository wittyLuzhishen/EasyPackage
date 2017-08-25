package com.luzhishen.easypackage.facade.biz;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luzhishen.easypackage.facade.model.CreateTaskRequest;

@Service
public class TaskBiz {
    private static final Logger logger = LoggerFactory.getLogger(TaskBiz.class);

    @Autowired
    private MachineBiz workerBiz;

    public boolean createTaskGroup(CreateTaskRequest request) {
        logger.debug("{}", request);
        return true;
    }

    /**
     * 
     * @param request
     * @return taskGroupId
     */
    private int createTaskGroup0(CreateTaskRequest request) {
        return 1;
    }

    private boolean recordMailReceiver(List<Integer> mailReceiverIdList) {
        return true;
    }

    private boolean createTasks(int taskGroupId, CreateTaskRequest request) {
        if (CollectionUtils.isEmpty(request.getChannelIdList())) {
            return false;
        }
        boolean result = true;
        for (Integer channelId : request.getChannelIdList()) {
            if (!createTask(taskGroupId, request.getPlatformId(),
                    request.getAppId(), request.getBranchName(), channelId)) {
                result = false;
                logger.error(
                        "create task failed, platform:{}, appId:{}, branchName:{}, channelId:{}",
                        request.getPlatformId(), request.getAppId(),
                        request.getBranchName(), channelId);
            }
        }
        return result;
    }

    private boolean createTask(int taskGroupId, int platformId, int appId,
            String branchName, int channelId/* , String workerIp */) {
        return true;
    }

    /**
     * 
     * @return taskGroupId
     */
    public int getPendingTaskGroup() {
        long lockId = System.currentTimeMillis();
        /*
         int affectedRowCount = UPDATE TaskGroup SET facadeIp=getLocaleIp(), lockedTime=lockId WHERE facadeIp is null OR facadeIp='' LIMIT 1
         if (affectedRowCount > 0) {
             return SELECT id FROM TaskGroup WHERE lockedTime=lockId AND facadeIp=getLocaleIp LIMIT 1
         }
        */
        throw new UnsupportedOperationException();
    }

}