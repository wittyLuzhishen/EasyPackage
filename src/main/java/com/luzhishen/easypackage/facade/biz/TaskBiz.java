package com.luzhishen.easypackage.facade.biz;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luzhishen.easypackage.facade.model.CreateTaskRequest;

@Service
public class TaskBiz {
    private static final Logger logger = LoggerFactory.getLogger(TaskBiz.class);

    @Autowired
    private WorkerBiz workerBiz;

    public boolean createTaskGroup(CreateTaskRequest request) {
        logger.debug("{}", request);
        return true;
    }

    private int createTaskGroup0(CreateTaskRequest request) {
        return 1;
    }

    private boolean recordMailReceiver(List<Integer> mailReceiverIdList) {
        return true;
    }

    private boolean createTasks(int taskGroupId, CreateTaskRequest request) {
        // TODO - implement TaskBiz.createTasks
        throw new UnsupportedOperationException();
    }

    private boolean createTask(int taskGroupId, int platformId, int appId,
            String branchName, int channelId/* , String workerIp */) {
        return true;
    }

    public void getPendingTaskGroup() {
        // TODO - implement TaskBiz.getPendingTaskGroup
        throw new UnsupportedOperationException();
    }

}