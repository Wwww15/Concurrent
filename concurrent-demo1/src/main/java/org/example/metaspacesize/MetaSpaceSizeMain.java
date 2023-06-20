package org.example.metaspacesize;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

public class MetaSpaceSizeMain {

    public static void main(String[] args) {
        test1();
    }

    /**
     * 测试元空间(jdk 1.8存放类信息)内存溢出
     */
    private static void test1() {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> methodProxy.invokeSuper(o,objects));
            enhancer.create();
        }
    }

    static class OOMObject {

    }
}
