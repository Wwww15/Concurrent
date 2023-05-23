package org.example.phaser;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Phaser;

/**
 * phaser 替换对应
 */
public class PhaserMain {

    public static void main(String[] args) {
        test2();
    }

    /**
     * 测试替换 countdownLatch
     */
    private static void test1() {
        Phaser phaser = new Phaser(5);
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + "正在上车！");
                        Thread.sleep(random.nextInt(10000));
                        phaser.arrive();
                        System.out.println(Thread.currentThread().getName() + "已经上车！");

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "线程" + i).start();
        }
        System.out.println("等待所有成员上车！");
        phaser.awaitAdvance(phaser.getPhase());
        System.out.println("所有成员已全部上车！");
    }

    /**
     * 测试2 替换 CyclicBarrier
     */
    private static void test2() {
        Phaser phaser = new Phaser(5);
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        String name = Thread.currentThread().getName();
                        Thread.sleep(random.nextInt(10000));
                        System.out.println(name + "已经到集合点啦！");
                        phaser.arriveAndAwaitAdvance();
                        System.out.println(name + "开始游玩");
                        Thread.sleep(random.nextInt(10000));
                        phaser.arriveAndAwaitAdvance();
                        System.out.println(name + "游玩结束回家！");
                    }catch (Exception exception) {
                        System.out.println(1);
                    }
                }
            }).start();
        }

    }
}
