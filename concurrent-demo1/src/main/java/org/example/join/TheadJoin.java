package org.example.join;

import org.example.implement.MyThread;

public class TheadJoin {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("开始执行当前线程！"+Thread.currentThread().getName());
        MyThread thread = new MyThread();
        thread.start();;
        thread.join();
        System.out.println("结束执行当前线程！"+Thread.currentThread().getName());
    }
}
