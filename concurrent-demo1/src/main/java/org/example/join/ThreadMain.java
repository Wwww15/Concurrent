package org.example.join;

public class ThreadMain {

    public static void main(String[] args) {
        ThreadTest1 threadTest1 = new ThreadTest1("线程1",null);
        ThreadTest1 threadTest2 = new ThreadTest1("线程2",threadTest1);
        ThreadTest1 threadTest3 = new ThreadTest1("线程3",threadTest2);
        threadTest1.start();
        threadTest2.start();
        threadTest3.start();
    }
}
