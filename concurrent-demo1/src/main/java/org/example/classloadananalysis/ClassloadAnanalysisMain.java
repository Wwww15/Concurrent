package org.example.classloadananalysis;

/**
 * 类加载分析测试案例
 *
 * -XX:TraceClassLoading
 */
public class ClassloadAnanalysisMain {

    static {
        a = 2;
        System.out.println(a=10);
    }
    static int a = 1;

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        System.out.println(1);
    }

}
