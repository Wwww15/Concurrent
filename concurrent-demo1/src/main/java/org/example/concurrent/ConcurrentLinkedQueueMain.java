package org.example.concurrent;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 并发单向链表队列/并发双向链表队列
 * 特点：
 * 1.并发高，不依靠锁控制并发，仅靠CAS
 * 2.CAS控制出队和入队的设置，例如：UNSAFE.objectFieldOffset(k.getDeclaredField("next")) 用于获取next字段在k对象中的内存偏移地址
 * 3.入队大概逻辑：每入一次队列进行CAS操作，此外，每两次进行tail指针的移动
 * 4.出队大概逻辑：每一次出队进行CAS操作，此外，每两次进行head指针的移动
 * 5.为空大概逻辑：遍历head，找到第一个不为null的节点为止，直到结束为null
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
