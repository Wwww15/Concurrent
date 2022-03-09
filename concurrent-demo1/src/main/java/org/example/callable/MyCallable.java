package org.example.callable;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * 实现Callable
 */
public class MyCallable  implements Callable {

    @Override
    public String call() throws Exception {
        Thread.sleep(5000);
        System.out.println("执行完毕！");
        //测试afterExecute方法是否能处理异常
        int a= 2/0;
        return "结果:"+ new Random().nextInt(1000);
    }


}
