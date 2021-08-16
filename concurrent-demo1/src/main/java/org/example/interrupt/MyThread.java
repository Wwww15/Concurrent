package org.example.interrupt;

/**
 * 继承thread
 */
public class MyThread extends Thread{

    @Override
    public void run() {
       while(true) {
           int i = 0;
           while (true) {
               boolean interrupted = isInterrupted();
               System.out.println("中断标记：" + interrupted);
               ++i;
               if (i > 200) { // 检查并重置中断标志。
                   boolean interrupted1 = Thread.interrupted();
                   System.out.println("重置中断状态：" + interrupted1);
                   interrupted1 = Thread.interrupted();
                   System.out.println("重置中断状态：" + interrupted1);
                   interrupted = isInterrupted();
                   System.out.println("中断标记：" + interrupted);
                   return;
               }
           }
       }
    }
}
