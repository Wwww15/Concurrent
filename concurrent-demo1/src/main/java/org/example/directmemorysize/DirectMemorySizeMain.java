package org.example.directmemorysize;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class DirectMemorySizeMain {

    public static void main(String[] args) throws IllegalAccessException {
        test1();
    }

    /**
     * 直接内存溢出
     */
    private static void test1() throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        int i = 1;
        while (true) {
            System.out.println(i++);
            unsafe.allocateMemory(1024*1024);
        }
    }
}
