package org.example.escapeanalysis;

public class EscapeAnalysisMain {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000000; i++) {
            Object a = new Object();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
