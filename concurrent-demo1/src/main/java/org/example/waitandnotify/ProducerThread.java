package org.example.waitandnotify;

import java.util.Random;

public class ProducerThread extends Thread {

    private final MyQueue myQueue;
    private final Random random = new Random();
    private int index = 0;

    public ProducerThread(MyQueue myQueue) {
        this.myQueue = myQueue;
    }

    @Override
    public void run() {
        while (true) {
            String tmp = "ele-" + index;
            myQueue.put(tmp);
            System.out.println("添加元素：" + tmp);
            index++;
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

