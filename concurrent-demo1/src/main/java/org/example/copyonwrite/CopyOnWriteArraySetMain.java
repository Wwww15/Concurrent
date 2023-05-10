package org.example.copyonwrite;

import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 写时复制set 测试实例
 * 特点：
 * 1.其主要是在添加之前判断是否存在来保证元素的单一
 * 2.写的时候自动复制为一个新的集合，然后根据操作增加/减少容量
 */
public class CopyOnWriteArraySetMain {

    public static void main(String[] args) {
        test3();
    }

    private static void test3() {
        CopyOnWriteArraySet set = new CopyOnWriteArraySet();
        new Thread(() -> {
            for (int i = 1000; i < 2000; i++) {
                set.add(i);
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                set.add(i);
            }
        }).start();
    }
}
