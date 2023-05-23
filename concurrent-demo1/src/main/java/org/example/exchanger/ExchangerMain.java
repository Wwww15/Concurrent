package org.example.exchanger;

import java.util.concurrent.Exchanger;

/**
 * exchanger 测试案例
 * 1.数据未交换完，会一直执行等待交换 C
 *
 * 交换大概逻辑：
 * 1.new Exchanger的时候会初始化一个 Participant 对象，里面包含一个Node节点，Participant实现了 ThreadLocal，所以获取的都是当前线程的东西
 * 2.调用exchange的时候，多核以及两个以上的线程会调用arenaExchange，单核调用slotExchange
 *
 *  slotExchange执行逻辑：
 *  1.会判断当前SLOT变量是否为null，该变量存储着对应的交换变量与线程
 *   1.1 不为null，通过CAS替换SLOT的值为null。并将自己蒋交换的值放入match
 *   1.2 为null，通过CAS设置SLOT的值为对象，并通过自旋判断match值是否修改，获取交换的值
 *
 *
 * 交换底层实现：CAS+PARK/UNPARK
 */
public class ExchangerMain {

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {

        Exchanger exchanger = new Exchanger();
        new Thread(() -> {
            try {
                Object otherData = exchanger.exchange("交换数据1");
                System.out.println(Thread.currentThread().getName()+"获取的数据:"+otherData);
                Object otherData1 = exchanger.exchange("交换数据1+1");
                System.out.println(Thread.currentThread().getName()+"获取的数据:"+otherData1);
                Object otherData2 = exchanger.exchange("交换数据1+1");
                System.out.println(Thread.currentThread().getName()+"获取的数据:"+otherData2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"线程1").start();

        new Thread(() -> {
            try {
                Object otherData = exchanger.exchange("交换数据2");
                System.out.println(Thread.currentThread().getName()+"获取的数据:"+otherData);
                Object otherData1 = exchanger.exchange("交换数据2+2");
                System.out.println(Thread.currentThread().getName()+"获取的数据:"+otherData1);
                Object otherData2 = exchanger.exchange("交换数据2+2");
                System.out.println(Thread.currentThread().getName()+"获取的数据:"+otherData2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"线程2").start();

        new Thread(() -> {
            try {
                Object otherData = exchanger.exchange("交换数据3");
                System.out.println(Thread.currentThread().getName()+"获取的数据:"+otherData);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"线程3").start();



    }
}
