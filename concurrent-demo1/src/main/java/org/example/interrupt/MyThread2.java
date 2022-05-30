package org.example.interrupt;

public class MyThread2 extends Thread{

    @Override
    public void run() {
        System.out.println("开始运行！");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("运行结束！");
    }
}
