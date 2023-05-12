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
 *扩容逻辑：
 * 1.默认大小？
 * 默认大小为16，加载因子为0.75，阈值为 12
 * 2.扩容时机？
 * 初始化 或者 当前数组大小超过阈值
 * 3.链表转树时机？
 * 链表长度大于8并且数组大小超过64
 * 4.树转为链表时机？
 * 链表长度小于等于6
 * 5.扩容逻辑
 *  1）判断当前是否有数据
 *   1.1)无，初始化当前容量和阈值，默认为16和12
 *   1.2)有，将数组容量扩大2倍，阈值扩大2倍
 *     1.2.1) 当前数据不为null，遍历当前数组的数组,是否只有第一个头结点
 *       1.2.1.1) 只有一个头结点，直接计算扩容后的数组所在位置，放入头结点
*        1.2.1.2) 不仅仅只有一个头结点，判断是否是红黑树
 *         1.2.1.2.1） 是红黑树，操作红黑树
 *         1.2.1.2.2） 不是红黑树，遍历当前节点所在链表的所有数据，直到null
*            1.2.1.2.2.1） 如果 e.hash & oldCap ==0，则当前数据还在老的位置上，将数据添加到老的链表上
*            1.2.1.2.2.2） 如果不是，则将当前数据添加到新的位置上
*          1.2.1.2.3）遍历完成后，将老的链表添加在老位置上，并将最后一个next置为null; 将新的链表添加在新位置上 j + oldCap 上，并将最后一个next置为null
 *
 *
 *
 *hash算法
 * 1.h >>> 16的作用？
 * 向右无符号移动16位，相当于将高位的16换到低16位，主要为了保证高位的特征性
 * 2.异或的作用？
 * 异或运算保证逻辑的随机公平性，1和0异或的情况结果比为：1:1，减少 &运算的hash冲突
 *
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
