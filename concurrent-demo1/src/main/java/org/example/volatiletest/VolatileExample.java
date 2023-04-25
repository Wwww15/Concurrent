package org.example.volatiletest;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VolatileExample {

    private static boolean BOOL = true;

    public static void main(String[] args) throws InterruptedException {
        test1();
    }

    private static void test1() throws InterruptedException {
        for (int i = 0; i < 5000; i++) {
            new Thread(() -> { while (BOOL) { } }).start();
        }
        TimeUnit.MILLISECONDS.sleep(500);
        BOOL = false;
    }


}
