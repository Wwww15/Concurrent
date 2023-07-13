package org.example.gc.gcgatherer;

/**
 * 垃圾收集器测试案例
 *
 * JVM参数
 * 新生代：
 * serial收集器: -XX:+UseSerialGC
 * parNew收集器: -XX:+UseParNewGC  -XX:ParllGCThreads 线程数
 * parallel Scavenge收集器: -XX:+UseParallelGC  -XX:MaxGCPauseMills 最大垃圾停顿回收时间 -XX:GCTimeRatio 吞吐量大小 -XX:ParllGCThreads 年轻代线程数
 *
 * 老年代：
 * serial old收集器: -XX:+UseSerialGC
 * parallel old GC收集器: -XX:+UseParallelOldGC
 * CMS收集器: -XX:CMSInitiatingOccu-pancyFraction 垃圾收集器触发百分比 -XX:UseCMS-CompactAtFullCollection CMS收集器Full GC的时候，开启整理碎片参数
 *           -XX:CMSFullGCsBeforeCompaction Full GC多少次后，才开始整理碎片，默认为0（每次Full GC都会整理碎片）
 *
 * 新/老年代：
 * G1 收集器: -XX:+UseG1GC  -XX:MaxGCPauseMills 最大垃圾回收停顿时间 -XX:InitiatingHeapOccupancyPercent 老年代达到触发mixed gc收集的百分比，默认为45
 *          -XX:NewRatio  新生代与老年代的大小比例，默认为2  -XX:SurvivorRatio eden和survivor的大小比例，默认为8  -XX:MaxTenuringThreshold 提升到老年代的阈值，默认15
 *
 * GC日志打印：
 * -XX:SurvivorRatio=8 设置年轻代与survivor的比例
 * -XX:+PrintGCDetails 设置打印GC的详情
 * -XX:+UseGCLogFileRotation 使用日志滚动
 * -Xloggc:D:/Study/temp/gc/gc.log 输出gc日志到文件
 */
public class GCGathererMain {

    public static void main(String[] args) throws InterruptedException {
        test2();
    }

    private static void test1() {
        System.out.println(1);
        while(true) {

        }
    }

    /**
     * 大对象直接分配到老年代
     */
    private static void test2() throws InterruptedException {
        Thread.sleep(10000);
        byte[] allocateByte = new byte[4*1024*1024];
        System.out.println(allocateByte.length);
        while (true) {

        }
    }

}
