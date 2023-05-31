package org.example.reentrantLock;

import java.util.concurrent.locks.StampedLock;

public class StampedLockMain {

    private static int a = 1;

    public static void main(String[] args) {

    }

    private void test1() {
        StampedLock stampedLock = new StampedLock();
        for (int i = 0; i < 30; ++i) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //读锁（悲观读）
                    long stamp = stampedLock.readLock();
                    int b = a;
                    stampedLock.unlockRead(stamp);
                    System.out.println("read" + b);
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    //写锁
                    long stamp = stampedLock.writeLock();
                    a++;
                    int b = a;
                    stampedLock.unlockWrite(stamp);
                    System.out.println("write" + b);
                }
            }).start();
        }
    }

    private void test2() {
        StampedLock stampedLock = new StampedLock();
        for (int i = 0; i < 30; ++i) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //乐观读
                    long stamp = stampedLock.tryOptimisticRead();
                    int b = a;
                    if (!stampedLock.validate(stamp)){
                        stamp = stampedLock.readLock();
                        b = a;
                        stampedLock.unlockRead(stamp);
                    }
                    System.out.println("read" + b);
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    //写锁
                    long stamp = stampedLock.writeLock();
                    a++;
                    int b = a;
                    stampedLock.unlockWrite(stamp);
                    System.out.println("write" + b);
                }
            }).start();
        }

    }
}
