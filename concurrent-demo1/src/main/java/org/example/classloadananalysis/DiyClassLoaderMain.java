package org.example.classloadananalysis;

import com.sun.org.apache.xalan.internal.XalanConstants;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DiyClassLoaderMain {

    public static void main(String[] args){
        try {
            Class<?> testClass = new DiyClassLoader("d:\\").findClass("Test");
            Method main = testClass.getMethod("main",String[].class);
            main.invoke(null,(Object) new String[]{});
            System.out.println(1);
        } catch (IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
