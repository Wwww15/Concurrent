package org.example.waitandnotify;

public class ThreadMain {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        ProducerThread producerThread = new ProducerThread(myQueue);
        ConsumerThread consumerThread = new ConsumerThread(myQueue);
        producerThread.start();
        consumerThread.start();
    }
}

