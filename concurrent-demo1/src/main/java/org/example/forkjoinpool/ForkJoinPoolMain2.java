package org.example.forkjoinpool;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;


public class ForkJoinPoolMain2 {

    static class SortTask extends RecursiveAction {
        final long[] array;
        final int lo;
        final int hi;

        public SortTask(long[] array) {
            this.array = array;
            this.lo = 0;
            this.hi = array.length-1;
        }

        public SortTask(long[] array, int lo, int hi) {
            this.array = array;
            this.lo = lo;
            this.hi = hi;
        }

        @Override
        protected void compute() {
            if (lo < hi) {
                // 找到分区的元素下标
                int pivot = (lo + hi) / 2;
                Long compareValue = array[pivot];
                int r = hi;
                int l = lo;
                for (; l < r; ) {
                    while (array[l] < compareValue) {
                        l++;
                    }
                    while (array[r] > compareValue) {
                        r--;
                    }
                    if (l >= r) {
                        break;
                    }
                    Long temp = array[l];
                    array[l] = array[r];
                    array[r] = temp;
                    if (array[l] == compareValue) {
                        r--;
                    }
                    if (array[r] == compareValue) {
                        l++;
                    }
                }
                //防止到最后r = 1 = 某个值的时候造成死循环
                if(r == l) {
                    r--;
                    l++;
                }
                // 向左
                SortTask left = new SortTask(array, lo, r);
                // 向右
                SortTask right = new SortTask(array, l, hi);

                left.fork();
                right.fork();
                left.join();
                left.join();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long[] array = new long[10];
        for (int i = 0; i < 10; i++) {
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
        while (!pool.isTerminated()) {

        }
        long timeMillis2 = System.currentTimeMillis();
        System.out.println(timeMillis2 - timeMillis1);
        System.out.println(Arrays.toString(array));
    }
}
