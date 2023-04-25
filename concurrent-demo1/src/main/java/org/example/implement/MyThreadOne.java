package org.example.implement;

import org.example.volatiletest.VolatileTest;

import java.util.Objects;
import java.util.concurrent.Callable;

/**
 * 实现Callable
 */
public class MyThreadOne implements Runnable {

    private VolatileTest volatileTest;

    public MyThreadOne(VolatileTest volatileTest) {
        this.volatileTest = volatileTest;
    }

    @Override
    public void run() {
        while (Objects.isNull(volatileTest.getVal()) || volatileTest.getVal() < 15) {
            System.out.println("继续等待:"+volatileTest.getVal());
        }
        System.out.println(volatileTest.getVal());
    }

}
