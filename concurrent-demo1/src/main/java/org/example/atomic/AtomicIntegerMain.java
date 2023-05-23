package org.example.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerMain {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.getAndIncrement();
    }
}
