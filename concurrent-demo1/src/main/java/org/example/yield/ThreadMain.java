package org.example.yield;

public class ThreadMain {

    public static void main(String[] args) {
        ThreadYield yield1 = new ThreadYield("线程One");
        ThreadYield yield2 = new ThreadYield("线程Two");
        yield1.start();
        yield2.start();
        int a = 0;
        while(a++<10000) {
            int randomMath = (int)Math.random() * 100 + 1;
            System.out.println("当前random:"+randomMath);
            if(randomMath<=50) {
                yield1.setYieldFlag(true);
                yield2.setYieldFlag(false);
            }else {
                yield1.setYieldFlag(false);
                yield2.setYieldFlag(true);
            }
        }
    }
}
