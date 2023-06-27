package org.example.classloadananalysis;

/**
 * 类初始化分析案例
 * 初始化过程就是调用类构造器方法过程
 */
public class CLassInitAnanalysisMain {

    static  {
        if (true) {
            System.out.println(11);
            while (true) {

            }
        }
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + "启动");
                CLassInitAnanalysisMain cLassInitAnanalysisMain = new CLassInitAnanalysisMain();
            }
        };

        new Thread(runnable).start();

        new Thread(runnable).start();
    }

}
