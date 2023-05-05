package org.example.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 重入锁ReentrantLock 测试案例
 */
public class LockMain {

    final static ReentrantLock lock = new ReentrantLock();

    final static Condition empty = lock.newCondition();

    final static Condition full = lock.newCondition();

    public static void main(String[] args) {
        test1();
    }

    private static void test1(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    empty.await();
                    System.out.println("consumer1");
                    lock.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    full.await();
                    System.out.println("consumer2");
                    lock.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();
                empty.signal();
                full.signal();
                lock.unlock();
            }
        }).start();
    }

}
