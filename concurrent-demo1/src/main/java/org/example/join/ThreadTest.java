package org.example.join;

public class ThreadTest extends Thread {

    private String name;

    private Thread thread;

    public ThreadTest(String name,Thread thread) {
        this.name = name;
        this.thread = thread;
    }

    @Override
    public void run() {
        try {
            if(thread!= null) thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+"执行啦");
    }
}
