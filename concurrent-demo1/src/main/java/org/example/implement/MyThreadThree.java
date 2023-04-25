package org.example.implement;

import org.example.volatiletest.VolatileTest;

import java.util.Objects;

/**
 * 实现Callable
 */
public class MyThreadThree implements Runnable {

    private VolatileTest volatileTest;

    private int index;

    public MyThreadThree(VolatileTest volatileTest,int indx) {
        this.volatileTest = volatileTest;
        this.index = indx;
    }

    @Override
    public void run() {
        int temp = volatileTest.getVal();
        for (;;){
            if(temp != volatileTest.getVal()) {
                temp = volatileTest.getVal();
                System.out.println("当前"+index+"获取的值："+temp);
            }
        }
    }

}
