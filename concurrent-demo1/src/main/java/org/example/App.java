package org.example;

import org.example.implement.MyThreadOne;
import org.example.implement.MyThreadThree;
import org.example.implement.MyThreadTwo;
import org.example.volatiletest.VolatileTest;

import java.util.concurrent.ExecutionException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ExecutionException, InterruptedException {
        test3();
    }

    private static void test1(){
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

    private static void test2() throws InterruptedException {
        VolatileTest volatileTest = new VolatileTest();

        new Thread(new MyThreadOne(volatileTest)).start();
    }

    private static void test3() {
        VolatileTest volatileTest = new VolatileTest();
        new Thread(new MyThreadThree(volatileTest,1)).start();
        new Thread(new MyThreadThree(volatileTest,2)).start();
        new Thread(new MyThreadThree(volatileTest,3)).start();
        new Thread(new MyThreadThree(volatileTest,4)).start();
        new Thread(new MyThreadThree(volatileTest,5)).start();
        new Thread(new MyThreadThree(volatileTest,6)).start();
        new Thread(new MyThreadThree(volatileTest,7)).start();


        new Thread(new MyThreadTwo(volatileTest)).start();
    }
}
