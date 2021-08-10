package org.example.implement;

/**
 * 实现Runnable
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("当前值:"+ i);
        }
    }
}
