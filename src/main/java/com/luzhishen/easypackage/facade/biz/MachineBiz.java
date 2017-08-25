package com.luzhishen.easypackage.facade.biz;

import org.springframework.stereotype.Service;

@Service
public class MachineBiz {
    /**
     * 
     * @param platformId
     * @return 闲置的PackageWorkerId
     */
    public int getIdleWorker(int platformId) {
        long now = System.currentTimeMillis();
        long minLastHeartBeatTime = now - 60_000;
        /*
         * SELECT * FROM PackageWorker WHERE lastHeartBeatTime > (now - T)
         * UPDATE Platform_PackageWorker SET status=1, facadeIp=getLocalIp(),
         * lockedTime=now WHERE status=0 AND packageWorkerId in ()
         */
        // TODO - implement WorkerBiz.getIdelWorker
        throw new UnsupportedOperationException();
    }

}