package org.example.join;

public class ThreadTest1 extends Thread {

    private String name;

    private Thread thread;

    public ThreadTest1(String name, Thread thread) {
        this.name = name;
        this.thread = thread;
    }

    @Override
    public void run() {
        try {
            if(thread!= null) thread.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+"执行啦");
        if(thread!= null) thread.notify();
    }
}
