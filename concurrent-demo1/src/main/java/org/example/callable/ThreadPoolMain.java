package org.example.callable;

import java.util.concurrent.*;

/**
 * 线程池测试afterExecute
 */
public class ThreadPoolMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable callable = new MyCallable();
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 10, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10), new ThreadPoolExecutor.AbortPolicy()) {

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println("程序错误1："+r);
                System.out.println("程序错误2："+t);
                System.out.println("程序运行结束:" + Thread.currentThread().getName());
            }
        };
        Future<String> submit = poolExecutor.submit(callable);
        String result = submit.get();
        System.out.println(result);
    }
}
