package org.example.interrupt;

public class ThreadMain {

    public static void main(String[] args) throws InterruptedException {
        MyThread2 myThread = new MyThread2();
        myThread.start();
        Thread.sleep(10000);
        myThread.interrupt();
        Thread.sleep(3000);
        System.out.println("main中断状态检查-1：" + myThread.isInterrupted());
        System.out.println("main中断状态检查-2：" + myThread.isInterrupted());
    }
}

