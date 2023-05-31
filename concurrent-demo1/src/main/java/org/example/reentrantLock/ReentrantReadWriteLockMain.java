package org.example.reentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;

/**
 * ReentrantReadWriteLock 测试案例
 */
public class ReentrantReadWriteLockMain {


    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
        readLock.newCondition().signal();

    }

}
