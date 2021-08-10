package org.example.waitandnotify;

import java.util.Random;

public class ConsumerThread extends Thread {

    private final MyQueue myQueue;
    private final Random random = new Random();

    public ConsumerThread(MyQueue myQueue) {
        this.myQueue = myQueue;
    }

    @Override
    public void run() {
        while (true) {
            String s = myQueue.get();
            System.out.println("\t\t消费元素：" + s);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

