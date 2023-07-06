package org.example.gc.finalizer;

/**
 * 垃圾回收算法-对象是否已死
 * 根搜索算法（可达性分析算法）
 * 1.finalize方法会在对象第一次被标记（被标记为 GC ROOT 不可达）的时候进行调用，调用过程中可以进行自救（在执行的过程中重新对引用对象赋值）
 * 2.被标记的对象会被放入一个F-Queue队列中，由虚拟机内部自建的Finalizer线程去调用finalize方法
 * 3.finalize方法至多会被调用一次，被调用过的就不会再被调用
 */
public class FinalizerMain {

    private static FinalizerMain escapeFinalizer = null;

    public static void main(String[] args) throws InterruptedException {
        escapeFinalizer = new FinalizerMain();
        escapeFinalizer = null;
        System.gc();
        Thread.sleep(1000);
        escapeFinalizer.say();
        escapeFinalizer = null;
        Thread.sleep(4000);
        escapeFinalizer.say();
    }

    private void say() {
        System.out.println("I am still alive！");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method excute！");
        escapeFinalizer = this;
    }
}
