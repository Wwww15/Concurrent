package org.example.atomic;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * AtomicStampedReference 测试案例
 * 特点：
 * 1.通过stamp版本解决CAS的ABA问题
 * 2.比较逻辑：
 *  1）里面封装了一个 Pair对象，对象里面两个属性分别是reference（值引用）和stamp（版本号标记）
 *  2）交换比较时分别比较 reference和 stamp
 *  3) 如果一直则 调用 UNSAFE.compareAndSwapObject(this, pairOffset, cmp, val) 方法;
 */
public class AtomicStampedReferenceMain {

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        String temp = "a";
        int version = 1;
        AtomicStampedReference atomicStampedReference = new AtomicStampedReference(temp, version);

        //正确的设置（版本与值都一直）
        String swapVal1 = "b";
        int swapVersion1 = version + 1;
        boolean result1 = atomicStampedReference.compareAndSet(temp, swapVal1, version, swapVersion1);
        System.out.println(result1);
        System.out.println(atomicStampedReference.getReference());


        //错误的设置（版本不一致）
        String swapVal2 = "c";
        int swapVersion2 = swapVersion1 + 1;
        boolean result2 = atomicStampedReference.compareAndSet(swapVal1, swapVal2, swapVersion2, swapVersion2);
        System.out.println(result2);
        System.out.println(atomicStampedReference.getReference());

        //错误的设置（值不一致）
        String swapVal3 = "d";
        int swapVersion3 = swapVersion2 + 1;
        boolean result3 = atomicStampedReference.compareAndSet(swapVal2, swapVal3, swapVersion1, swapVersion3);
        System.out.println(result3);
        System.out.println(atomicStampedReference.getReference());


        //正确的设置
        String swapVal4 = "d";
        int swapVersion4 = swapVersion2 + 1;
        boolean result4 = atomicStampedReference.compareAndSet(swapVal1, swapVal4, swapVersion1, swapVersion4);
        System.out.println(result4);
        System.out.println(atomicStampedReference.getReference());

    }
}
