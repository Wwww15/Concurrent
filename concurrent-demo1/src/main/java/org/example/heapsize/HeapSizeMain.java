package org.example.heapsize;

/**
 * 堆内存测试案例
 * 其他命令：
 * jps
 * jinfo -flag
 *
 */
public class HeapSizeMain {

    public static void main(String[] args) {

        int m  = 1024 * 1024;

        byte[] bytes = new byte[3 * m];

        Runtime runtime = Runtime.getRuntime();
        System.out.println("最大内存:" + runtime.maxMemory()/m);
        System.out.println("剩余内存:" + runtime.freeMemory()/m);
        System.out.println("当前总内存:" + runtime.totalMemory()/m);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    System.out.println(1);
                }
            }
        }).start();
    }
}
