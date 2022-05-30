package org.example.yield;

/**
 * yield实例
 */
public class ThreadYield extends Thread{

    private String name;

    private int index = 0;

    private boolean yieldFlag = false;

    public ThreadYield(String name) {
        this.name = name;
    }

    public void setYieldFlag(boolean yieldFlag) {
        this.yieldFlag = yieldFlag;
    }

    @Override
    public void run() {
        while(true) {
            if(yieldFlag) {
                Thread.yield();
            }
            System.out.println(name+"-----"+(index++));
        }
    }
}
