package com.luzhishen.easypackage.facade.biz;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.eclipse.jdt.annotation.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luzhishen.easypackage.facade.constant.ErrorCode;
import com.luzhishen.easypackage.facade.entity.App;
import com.luzhishen.easypackage.facade.entity.TaskGroup;
import com.luzhishen.easypackage.facade.entity.User;
import com.luzhishen.easypackage.facade.exception.PackageException;
import com.luzhishen.easypackage.facade.model.TaskGroupStatus;
import com.luzhishen.easypackage.facade.model.TaskParam;

@Service
public class TaskBiz {
    private static final Logger logger = LoggerFactory.getLogger(TaskBiz.class);

    @Autowired
    private MachineBiz workerBiz;

    public void createTaskGroup(TaskParam request)
            throws PackageException {
        logger.debug("{}", request);
        int newTaskGroupId = createTaskGroup0(request);
        if (newTaskGroupId <= 0) {
            throw PackageException.of(ErrorCode.CreateTaskGroupFailed);
        }
        createTasks(newTaskGroupId, request);
        if (!recordMailReceiver(newTaskGroupId, request.getMailReceiverIdList())) {
            throw PackageException.of(ErrorCode.RecordMailReceiverFailed);
        }
        if (!modifyTaskGroupStatus(newTaskGroupId,
                TaskGroup.Status.WAIT_FOR_DISTRIBUTION)) {
            throw PackageException.of(ErrorCode.ModifyTaskGroupStatusFailed);
        }
    }

    /**
     * 
     * @param request
     * @return taskGroupId (>0)
     */
    private int createTaskGroup0(TaskParam request) {
        return 1;
    }

    private boolean modifyTaskGroupStatus(int taskGroupId, int status) {
        return true;
    }

    private void createTasks(int taskGroupId, TaskParam request)
            throws PackageException {
        if (CollectionUtils.isEmpty(request.getChannelIdList())) {
            throw PackageException.of(ErrorCode.CreateTaskFailed);
        }
        for (Integer channelId : request.getChannelIdList()) {
            if (!createTask(taskGroupId, request.getApp().getId(), channelId)) {
                logger.error(
                        "create task failed, taskGroupId:{}, channelId:{}, request:{}",
                        taskGroupId, channelId, request);
            }
        }
    }

    private boolean createTask(int taskGroupId, int appId, int channelId/* , String workerIp */) {
        return true;
    }

    private boolean recordMailReceiver(int taskGroupId,
            List<Integer> mailReceiverIdList) {
        if (CollectionUtils.isEmpty(mailReceiverIdList)) {
            return false;
        }
        return true;
    }

    /**
     * 
     * @return taskGroupId
     */
    public int getPendingTaskGroup() {
        long lockId = System.currentTimeMillis();
        /*
         int affectedRowCount = UPDATE TaskGroup SET facadeIp=getLocaleIp(), lockedTime=lockId WHERE status=0 AND (facadeIp is null OR facadeIp='') LIMIT 1
         if (affectedRowCount > 0) {
             return SELECT id FROM TaskGroup WHERE lockedTime=lockId AND facadeIp=getLocaleIp LIMIT 1
         }
        */
        throw new UnsupportedOperationException();
    }

    @NonNull
    public List<TaskGroupStatus> getTaskGroupStatusList(@NonNull App app) {
        ArrayList<TaskGroupStatus> list = new ArrayList<>();
        TaskGroupStatus status = new TaskGroupStatus();
        status.setApp(app);
        status.setBranchName("testBranch");
        status.setCreateTime(System.currentTimeMillis());
        status.setStatus(TaskGroupStatus.Status.RUNNING);
        status.setSuccessTaskCount(1);
        status.setTaskCount(3);
        status.setTaskGroupId(1);
        status.setUser(new User());
        status.setVersionName("1.2.3");
        list.add(status);
        return list;
    }

}