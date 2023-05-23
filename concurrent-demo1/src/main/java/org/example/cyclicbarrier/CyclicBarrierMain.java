package org.example.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier 测试案例
 */
public class CyclicBarrierMain {

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(random.nextInt(5000));
                    System.out.println("出去旅游啦，"+Thread.currentThread().getName()+"等候上车~");
                    cyclicBarrier.await();
                    Thread.sleep(random.nextInt(5000));
                    System.out.println(Thread.currentThread().getName()+"上车！");
                    cyclicBarrier.await();
                    Thread.sleep(random.nextInt(5000));
                    System.out.println("全部上车,出去啦！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },"线程"+i).start();
        }
    }
}
