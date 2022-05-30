package org.example.interrupt;

/**
 * 继承thread
 */
public class MyThread1 extends Thread{

    @Override
    public void run() {
       while(true) {
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println("当前运行状态："+Thread.currentThread().getState());
       }
    }
}
