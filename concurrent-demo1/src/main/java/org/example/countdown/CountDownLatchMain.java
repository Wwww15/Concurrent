package org.example.countdown;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch 测试案例
 * 1.通过await方式阻塞当前所有线程，并添加到阻塞队列（链表）
 * 2.countDown 方法会逐个减一直到state==0，然后唤醒阻塞队列中的所有线程
 * 3.有多少个count 就必须执行多个，不然一直阻塞
 */
public class CountDownLatchMain {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(8);
        countDownLatch.countDown();
        countDownLatch.await();
    }
}
