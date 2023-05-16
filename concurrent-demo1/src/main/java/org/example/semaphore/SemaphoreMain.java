package org.example.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.LockSupport;

/**
 * Semaphore 测试案例
 *
 * acquire 过程：
 * 1.尝试 state -1，非公平的话直接去修改，公平的需要判断当前等待的链表有没有节点
 * 2.如果尝试失败
 *  2.1 将当前线程加入等待的链表尾部，没有就创建，然后添加
 *  2.2 完成添加后，根据当前线程状态阻塞当前线程   LockSupport.park();
 *
 * release 过程：
 * 1.尝试state +1
 * 2.成功后，解锁当前head下的第一个线程 LockSupport.unpark();
 *
 *
 * 总结：semaphore 就是对state变量的增减过程，对线程在链表中的增删过程
 */
public class SemaphoreMain {

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(10, true);
        for (int i = 0; i < 50; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName() + "开始吃饭");
                        Thread.sleep((long) (Math.random() * 10000 + 10000));
                        System.out.println(Thread.currentThread().getName() + "吃完啦");
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "Thread-" + i).start();
        }
        ;
    }
}
