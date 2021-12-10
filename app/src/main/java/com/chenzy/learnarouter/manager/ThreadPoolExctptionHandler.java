package com.chenzy.learnarouter.manager;

import android.util.Log;
import android.widget.Toast;

import com.chenzy.learnarouter.constant.Constants;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by zhangyu on 2021/12/3.
 */

public class ThreadPoolExctptionHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        Log.e(Constants.TAG,"线程池满了，新任务无法有序执行");
    }
}
