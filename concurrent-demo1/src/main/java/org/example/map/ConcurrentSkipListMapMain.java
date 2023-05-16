package org.example.map;

import java.util.concurrent.ConcurrentSkipListMap;

/**
 * ConcurrentSkipListMap 测试案例
 * 1.底层实现为跳表
 * 2.删除和添加的时候都需要为查找到的节点添加一个Marker节点，用于标记
 */
public class ConcurrentSkipListMapMain {

    public static void main(String[] args) {
        ConcurrentSkipListMap skipListMap = new ConcurrentSkipListMap();
        skipListMap.put(2,2);
        skipListMap.put(1,1);
        skipListMap.put(3,3);

        System.out.println(skipListMap);
    }
}
