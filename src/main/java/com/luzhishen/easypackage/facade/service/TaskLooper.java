package com.luzhishen.easypackage.facade.service;

import java.util.concurrent.atomic.AtomicBoolean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TaskLooper {
    private static final Logger logger = LoggerFactory
            .getLogger(TaskLooper.class);

    private static final AtomicBoolean running = new AtomicBoolean(false);

    public void loop() {
        long startTime = System.currentTimeMillis();
        logger.debug("begin scan pending taskgroup, Thread:{}",
                Thread.currentThread());
        if (running.get()) {
            logger.warn("another scan in progress, skip");
            return;
        }
        running.set(true);
        try {
            loop0();
        } catch (Exception e) {
            logger.error(
                    "error occurred when scanning pending taskgroup, msg:{}",
                    e.getMessage());
        } finally {
            running.set(false);
            logger.debug("end scan pending taskgroup, cost {}ms",
                    System.currentTimeMillis() - startTime);
        }
    }

    private void loop0() {
        // TODO Auto-generated method stub

    }

}