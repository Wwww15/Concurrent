package org.example.constantpoolsize;

import java.util.HashSet;
import java.util.Set;

public class ConstantPoolSizeMain {

    public static void main(String[] args) {
        test1();
    }

    /**
     * 常量池(jdk 8在堆中)内存溢出
     */
    private static void test1() {
        Set<String> cacheSet = new HashSet<>();
        int i = 0;
        while(true) {
            cacheSet.add(String.valueOf(i++).intern());
        }
    }
}
