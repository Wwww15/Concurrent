package org.example.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Hello world!
 *
 */
public class ThreadMain
{
    public static void main( String[] args ) throws ExecutionException, InterruptedException {
        MyCallable callable = new MyCallable();

        FutureTask<String> futureTask = new FutureTask<>(callable);

        Thread thread = new Thread(futureTask);

        thread.start();

//        String result = futureTask.get();
//
//        System.out.println("结果是："+result);

        System.out.println("线程运行结束！");
    }
}
