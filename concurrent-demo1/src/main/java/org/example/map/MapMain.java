package org.example.map;

import java.util.HashMap;

/**
 * map 研究案例
 * 存放数据步骤：
 * 1.计算key的hash值
 * 2.判断当前数组是否需要扩容或者初始化
 * 3.根据hash值按照数组大小进行与运算
 * 4.判断当前数组上的位置结点是否为null
 *  4.1如果是，直接放入当前添加的值
 *  4.2如果不是，比较当前第一个位置上的hash值与key是否相等
 *    4.2.1相等直接操作该节点赋值
 *    4.2.2不相等，判断当前是红黑树
 *      4.2.2.1 是，操作红黑树 TODO
 *      4.2.2.2 不是，遍历当前的结点，直到最后为null 或者 找到hash和key相等的结点
 *
 * 取值数据步骤：
 * 1.计算当前key的hash值
 * 2.判断当前数组是否为null 或者 当前数组大小为零 或者 当前key的hash值所在数组位置第一个节点为null
 *  2.1 如果是，返回null
 *  2.2 如果不是，判断当前第一节点的key和hash值是否同当前查找的key以及hash值相等
 *    2.2.1 是，返回当前的值
 *    2.2.2 不是，判断当前是否是红黑树
 *      2.2.2.1 是，红黑树中查找
 *      2.2.2.2 不是，从头节点依次遍历，比较每一个节点的key以及hash值，直到为null
 *
 */
public class MapMain {

    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put(0,1);
        hashMap.put(1,1);
        hashMap.put(2,3);
        hashMap.put(3,10);
        hashMap.put(16,10);

        Object o = hashMap.get(4);
        System.out.println(o);
    }
}
