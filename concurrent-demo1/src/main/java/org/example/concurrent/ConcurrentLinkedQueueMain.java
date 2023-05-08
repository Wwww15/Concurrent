package org.example.concurrent;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 并发单向链表队列/并发双向链表队列
 * 1.UNSAFE.objectFieldOffset(k.getDeclaredField("next")) 用于获取next字段在k对象中的内存偏移地址
 */
public class ConcurrentLinkedQueueMain {

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        ConcurrentLinkedQueue linkedQueue = new ConcurrentLinkedQueue();
        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                linkedQueue.add(i);
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                linkedQueue.add(i);
            }
        }).start();
    }
}
