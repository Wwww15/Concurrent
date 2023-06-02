package org.example.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ExecutorsMain {

    public static void main(String[] args) {

    }

    private void test1() {
        //单线程线程池
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

        //固定线程线程池
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);

        //无限制缓存线程池（每收到一个请求，创建一个线程）
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        //定时任务线程池
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

    }
}
