package org.example.forkjoinpool;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;


public class ForkJoinPoolMain1 {

    static class SortTask extends RecursiveAction {
        final long[] array;
        final int lo;
        final int hi;

        public SortTask(long[] array) {
            this.array = array;
            this.lo = 0;
            this.hi = array.length - 1;
        }

        public SortTask(long[] array, int lo, int hi) {
            this.array = array;
            this.lo = lo;
            this.hi = hi;
        }

        private int partition(long[] array, int lo, int hi) {
            for (int j = lo; j + 1 <= hi; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
            return hi;
        }

        private void swap(long[] array, int i, int j) {
            long temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        @Override
        protected void compute() {
            if (lo < hi) {
                // 找到分区的元素下标
                int pivot = partition(array, lo, hi);
                // 将数组分为两部分
                SortTask left = new SortTask(array, lo, pivot - 1);

                left.fork();
                left.join();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long[] array = new long[1000000];
        for (int i = 0; i < 1000000; i++) {
            array[i] = (long) (Math.random()*10000+1000);
        }
        // ⼀个任务
        ForkJoinTask sort = new SortTask(array);
        // ⼀个pool
        ForkJoinPool pool = new ForkJoinPool();
        // ForkJoinPool开启多个线程，同时执⾏上⾯的⼦任务
        long timeMillis1 = System.currentTimeMillis();
        pool.submit(sort);
        // 结束ForkJoinPool
        pool.shutdown();
        // 等待结束Pool
        while(!pool.isTerminated()){

        }
        long timeMillis2 = System.currentTimeMillis();
        System.out.println(timeMillis2-timeMillis1);

    }
}
