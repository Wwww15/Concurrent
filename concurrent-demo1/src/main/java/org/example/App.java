package org.example;

import org.example.callable.MyCallable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ExecutionException, InterruptedException {
        //最小优先级
        System.out.println(Thread.MIN_PRIORITY);
        //最大优先级
        System.out.println(Thread.MAX_PRIORITY);
        //默认优先级
        System.out.println(Thread.NORM_PRIORITY);
        Thread thread = Thread.currentThread();
        //判断是否是守护线程
        System.out.println(thread.isDaemon());
        //获取当前线程状态
        System.out.println(thread.getState());
        //获取线程id
        System.out.println(thread.getId());
        //获取线程名字
        System.out.println(thread.getName());
        //获取线程优先级
        System.out.println(thread.getPriority());
    }
}
