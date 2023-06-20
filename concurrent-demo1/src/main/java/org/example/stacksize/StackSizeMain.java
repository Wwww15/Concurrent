package org.example.stacksize;

public class StackSizeMain {

    private int length;

    public static void main(String[] args) {
        test4();
    }

    /**
     * 栈测试
     */
    private static void test1() {
        StackSizeMain stackSizeMain = new StackSizeMain();
        try {
//            stackSizeMain.test2();
            stackSizeMain.test3();
        } catch (Throwable exception) {
            System.out.println("栈的深度：" + stackSizeMain.length);
            throw exception;
        }
    }

    /**
     * 栈溢出测试案例 StackOverflowError
     */
    private void test2() {
        length++;
        test2();
    }

    /**
     * 栈溢出测试案例
     */
    private void test3() {
        long a, b, c, d, e, f, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, a1, b1, c1, d1, e1, f1, h1, i1, j1, k1, l1, m1, n1, o1, p1, q1, r1, s1, t1, u1, v1, w1, x1, y1, z1, a2, b2, c2, d2, e2, f2, h2, i2, j2, k2, l2, m2, n2, o2, p2, q2, r2, s2, t2, u2, v2, w2, x2, y2, z2;
        a = b = c = d = e = f = h = i = j = k = l = m = n = o = p = q = r = s = t = u = v = w = x = y = z = a1 = b1 = c1 = d1 = e1 = f1 = h1 = i1 = j1 = k1 = l1 = m1 = n1 = o1 = p1 = q1 = r1 = s1 = t1 = u1 = v1 = w1 = x1 = y1 = z1 = a2 = b2 = c2 = d2 = e2 = f2 = h2 = i2 = j2 = k2 = l2 = m2 = n2 = o2 = p2 = q2 = r2 = s2 = t2 = u2 = v2 = w2 = x2 = y2 = 1;
        a = a + b + c + d + e + f + h + i + j + k + l + m + n + o + p + q + r + s + t + u + v + w + x + y + z + a1 + b1 + c1 + d1 + e1 + f1 + h1 + i1 + j1 + k1 + l1 + m1 + n1 + o1 + p1 + q1 + r1 + s1 + t1 + u1 + v1 + w1 + x1 + y1 + z1 + a2 + b2 + c2 + d2 + e2 + f2 + h2 + i2 + j2 + k2 + l2 + m2 + n2 + o2 + p2 + q2 + r2 + s2 + t2 + u2 + v2 + w2 + x2 + y2;
        System.out.println(a);
        length++;
        test3();
    }

    /**
     * 栈内存溢出
     */
    private static void test4() {
       while(true) {
           new Thread(() -> {
               while(true) {
               }
           }).start();
       }
    }
}
