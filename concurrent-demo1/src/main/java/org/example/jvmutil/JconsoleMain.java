package org.example.jvmutil;

import java.util.ArrayList;

/**
 * jconsole工具测试类
 *
 * 1.minor GC发生的时候实际eden并未满
 */
public class JconsoleMain {

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(10000);
        test1();
//        test2();
    }

    /**
     * 观察堆内存的gc过程 jconsole可操作gc
     * @throws InterruptedException
     */
    private static void test1() throws InterruptedException {
        ArrayList<Object> objList = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            objList.add(new Object());
        }
        while (true) {
            System.out.println(1);
        }
    }

    /**
     * 产生死锁条件，观察死锁,jconsole和jstack以及arthas都可判断是有死锁
     */
    private static void test2() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (Integer.valueOf(1)) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (Integer.valueOf(2)) {
                        System.out.println(1);
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (Integer.valueOf(2)) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (Integer.valueOf(1)) {
                        System.out.println(2);
                    }
                }
            }
        }).start();
    }
}
