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
        return "结果:"+ new Random().nextInt(1000);
    }


}
