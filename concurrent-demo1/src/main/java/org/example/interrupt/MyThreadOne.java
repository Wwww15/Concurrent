package org.example.interrupt;

/**
 * 继承thread
 */
public class MyThreadOne extends Thread{

    @Override
    public synchronized void run() {
       while(true) {
           System.out.println("开始运行");
           try {
               wait();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           System.out.println("结束运行");
       }
    }
}
