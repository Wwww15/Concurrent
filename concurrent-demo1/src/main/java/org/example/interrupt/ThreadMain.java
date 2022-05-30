package org.example.interrupt;

public class ThreadMain {

    public static void main(String[] args) throws InterruptedException {
//        MyThread myThread = new MyThread();
//        myThread.start();
//        Thread.sleep(10000);
//        myThread.interrupt();
//        Thread.sleep(3000);
//        System.out.println("main中断状态检查-1：" + myThread.isInterrupted());
//        System.out.println("main中断状态检查-2：" + myThread.isInterrupted());
//        MyThread1 myThread1 = new MyThread1();
//        myThread1.start();
//        myThread1.interrupt();
//        System.out.println("MyThread1的中断标记："+myThread1.isInterrupted());
        MyThread2 thread2  = new MyThread2();
        thread2.start();
        int a=0;
        while(a<100) {
            a++;
            System.out.println("thread2中断状态: "+thread2.isInterrupted());
        }
        thread2.interrupt();
        System.out.println("thread2中断状态: "+thread2.isInterrupted());
    }
}

