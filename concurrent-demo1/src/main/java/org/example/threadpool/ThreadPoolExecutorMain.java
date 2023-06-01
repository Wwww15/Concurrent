package org.example.threadpool;

/**
 * ThreadPoolExecutor 测试案例
 * ThreadPoolExecutor内部结构：
 * 1.阻塞队列 BlockQueue workQueue，用于存放还未被执行的任务
 * 2.内部变量锁 ReentrantLock mainLock，用于操作内部变量
 * 3.工作线程集合 HashSet<Worker> workers，用于存放当前的线程集合
 *
 * Worker内部结构:
 * 1.当前线程 thread
 * 2.第一个任务 firstTask
 * 3.完成任务个数 completeTasks
 *
 * shutdown与shutdownNow的区别：
 * 1.shutdown中断所有空闲线程，不清空任务队列，线程池状态变为shutdown
 * 2.shutdownNow中断所有线程，清空任务对立，线程池状态变为stop
 *
 * 线程池状态：
 * RUNNING、SHUTDOWN、STOP、TIDYING、TERMINATED
 * 线程池的状态只能由小到大，不能由大到小
 */
public class ThreadPoolExecutorMain {

    public static void main(String[] args) {

    }

    private static void test() {

    }
}
