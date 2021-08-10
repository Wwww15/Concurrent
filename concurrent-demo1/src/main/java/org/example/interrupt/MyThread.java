package org.example.interrupt;

/**
 * 继承thread
 */
public class MyThread extends Thread{

    @Override
    public void run() {
       while(true) {
           boolean  interrupted = isInterrupted();
           System.out.println("中断标记："+interrupted);
       }
    }
}
