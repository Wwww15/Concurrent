package org.example.classloadananalysis;

/**
 * 自定义classLoader
 */
public class DiyClassLoader extends ClassLoader{

    /**
     * 重写加载class方法
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }
}
