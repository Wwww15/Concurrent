package org.example.volatiletest;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.concurrent.TimeUnit;

public class VolatileExample {

    private volatile static boolean BOOL = true;

    public static void main(String[] args) throws InterruptedException {
        test1();
    }

    private static void test1() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> { while (BOOL) { } },"VolatileThread-"+i).start();
        }
        TimeUnit.MILLISECONDS.sleep(500);
        BOOL = false;
        RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
        String name = runtime.getName();
        System.out.println("当前进程的标识为：" + name);
    }

}
