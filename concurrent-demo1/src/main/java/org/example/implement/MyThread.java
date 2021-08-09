package org.example.implement;

/**
 * 继承thread
 */
public class MyThread  extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("当前值:"+ i);
        }
    }
}
