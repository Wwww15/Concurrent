package org.example.queue;

import java.util.Objects;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * SynchronousQueueMain 测试案例
 * 1.SynchronousQueueMain需要多个线程之间测试
 */
public class SynchronousQueueMain {

    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronousQueue.put(1);
                    synchronousQueue.put(2);
                    synchronousQueue.put(1);
                    synchronousQueue.put(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Integer result = 0;
                    while(Objects.nonNull(result)) {
                        result = synchronousQueue.poll(15,TimeUnit.MILLISECONDS);
                        System.out.println(result);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
