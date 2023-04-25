package org.example.implement;

import org.example.volatiletest.VolatileTest;

import java.util.Objects;

/**
 * 实现Callable
 */
public class MyThreadTwo implements Runnable {

    private VolatileTest volatileTest;

    public MyThreadTwo(VolatileTest volatileTest) {
        this.volatileTest = volatileTest;
    }

    @Override
    public void run() {
        while (volatileTest.getVal() < 8) {
            System.out.println(volatileTest.getVal());
            volatileTest.incr();
            System.out.println(volatileTest.getVal());
        }
    }

}
