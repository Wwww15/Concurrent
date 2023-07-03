package org.example.classloadananalysis;

import java.io.*;

/**
 * 自定义classLoader
 */
public class DiyClassLoader extends ClassLoader{

    private String path;

    private String suffix = ".class";

    public DiyClassLoader(String path) {
        this.path = path;
    }

    /**
     * 重写加载class方法
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String filePath = path + name + suffix;
        FileInputStream fileIs = null;
        ByteArrayOutputStream byteOs = new ByteArrayOutputStream();
        try {
            fileIs = new FileInputStream(filePath);
            BufferedInputStream byteIs = new BufferedInputStream(fileIs);

            int len;
            byte[] bytes = new byte[1024];
            while((len = byteIs.read(bytes)) != -1  ) {
                byteOs.write(bytes,0,len);
            }
            byte[] byteArray = byteOs.toByteArray();
            return defineClass(name,byteArray,0,byteArray.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileIs != null) {
                try {
                    fileIs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(byteOs != null) {
                try {
                    byteOs.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
