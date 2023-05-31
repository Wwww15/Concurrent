package org.example.reentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 重入锁ReentrantLock 测试案例
 *
 * 获取锁过程：
 * 1.首先调用sync的lock方法
 * 2.然后调用内部类的lock方法
 * 3.调用acquire(1)
 * 4.acquire方法
 *  1) tryAcquire: 根据state状态以及当前是否重入线程判断获取锁，返回boolean
 *  2) addWaiter： 将当前未获取到锁的线程放入tail后面，也就是阻塞队列中，通过cas的方式
 *  3) acquireQueue： 阻塞当前线程，直到获取到锁，未获取到锁，就阻塞，可响应中断
 *
 * 释放锁过程：
 * 1.调用sync方法中的unlock方法
 * 2.调用release(1)
 * 3.release(1)
 *  1）tryRelease：根据当前独占的线程是否是当前线程并且state状态释放锁
 *  2）unparkSuccessor：唤醒队列中head的下一个线程
 *
 *
 * 公平锁和非公平锁差异：
 * 1.在acquire之前，非公平锁会首先尝试获取锁，并设置独占线程，失败后，才会去acquire(1)
 * 2.在acquire步骤中，公平锁的tryAcquire方法中，获取锁的时候会首先判断当前队列中是否有其他线程（判断当前线程是否是head后的第一个节点）
 */
public class ReentrantLockMain {

    final static ReentrantLock lock = new ReentrantLock();

    final static Condition empty = lock.newCondition();

    final static Condition full = lock.newCondition();

    public static void main(String[] args) {
        test1();
    }

    private static void test1(){
        new Thread(() -> {
            try {
                lock.lock();
                empty.await();
                System.out.println("consumer1");
                lock.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                lock.lock();
                full.await();
                System.out.println("consumer2");
                lock.unlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            lock.lock();
            empty.signal();
            full.signal();
            full.notify();
            lock.unlock();
        }).start();
    }

}
