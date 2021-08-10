package org.example.waitandnotify;

public class ThreaPoolMain {

    public static void main(String[] args) {
        MyQueue2 myQueue = new MyQueue2();
        for (int i = 0; i < 1; i++) {
            new ConsumerThread(myQueue).start();
        }
        for (int i = 0; i < 5; i++) {
            new ProducerThread(myQueue).start();
        }
    }
}

