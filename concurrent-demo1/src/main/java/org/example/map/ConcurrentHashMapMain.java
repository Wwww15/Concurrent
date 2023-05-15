package org.example.map;

import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap 研究案例
 *
 * 存放数据步骤：
 * 1.计算当前 key 的 hash 值
 * 2.循环遍历当前 table ，判断当前 table 是否为 null 或者长度为0
 *  2.1 如果为 null 或者长度为0，初始化当前 table -> 初始化过程
 * 3.判断当前 key 的 hash 所在位置上的 node 是否为null
 *  3.1 为null，通过 cas 设置当前位置的 node
*  4.判断当前节点 f 的 hash 是否为 -1，-1表示当前正在扩容
 *  4.1 为-1 -> 扩容过程
 * 5.分段锁，锁住当前节点，再次判断当前 i 位置的节点是否为 f(锁住的节点)
 *  5.1 如果是，判断当前节点 f 的 hash 是否大于0
 *   5.1.1 是，循环当前节点，直到设置了值或者为节点null
 *    5.1.1.1 判断当前节点 f 的 key 是否等于 存入 key 并且当前节点的 hash 是否等于存入 hash
 *    5.1.1.1.1 是，设置当前节点的值为新值
 *    5.1.1.2 通过 next 往下遍历，如果为null，则表示到达尾部，新建一个节点挂载到尾部
 *   5.2 如果当前节点是红黑树，操作红黑树 ->操作红黑树
 * 6.判断当前 binCount是否大于 8
 *  6.1 是，链表转为红黑树 —> 转化红黑树
 *
 * 7.添加计数
 *
 *
 * 初始化过程：
 * 1.循环判断当前 table 为null或者长度为0
 * 2.判断当前 sizeCtl 是否小于0
 *  2.1 小于0，表明当前 table 正在进行初始化，当前线程释放当前占用的CPU资源，进入就绪状态
 *  2.2 不小于0，表明当前 table 需要初始化，通过 cas 对 SIZECTL 进行设置，设置值为-1，表明当前正在进行初始化
 *   2.2.1 设置成功后，再次按断当前 table 为null或者长度为0
 *    2.2.1.1 满足条件，初始化当前 Node 数组，默认长度为 16，设置 SIZECTL 为 0.75
 * 3.返回当前 table
 *
 * 扩容过程：
 *
 *
 * 操作红黑树：
 *
 *
 * 转化红黑树：
 */
public class ConcurrentHashMapMain {

    public static void main(String[] args) {
        ConcurrentHashMap hashMap = new ConcurrentHashMap();
        hashMap.put(1,1);

        Object o = hashMap.get(1);
        System.out.println(o);
    }
}
