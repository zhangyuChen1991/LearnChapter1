package com.chenzy.learnarouter.manager;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhangyu on 2021/12/3.
 */

public class ThreadPoolManager {
    private static class InstanceHolder {
        public static ThreadPoolManager INSTANCE = new ThreadPoolManager();
    }

    public static ThreadPoolManager getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private ThreadPoolExecutor mThreadPool;

    public ThreadPoolManager() {
        mThreadPool = new ThreadPoolExecutor(5, 10, 1000, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10), Executors.defaultThreadFactory(), new ThreadPoolExctptionHandler());
    }

    public void execute(Runnable command) {
        mThreadPool.execute(command);
    }
}
