package tecent50.src.ts007;

import tecent50.src.ts053.Solution;

/**
 * @Description 7. 整数反转
 * 给定一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^(31 − 1)] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * @Author liq
 * @Date 2022/05/28
 */
public class Main {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        Solution2 s2 = new Solution2();
//        int x = -2147483648;
//        int x = 7463847412;
        int x = -2;
        int res = s.reverse(x);
        int res21 = s2.reverse(x);
        int res22 = s2.reverse2(x);
        System.out.println(res);
        System.out.println(res21);
        System.out.println(res22);
        System.out.println(x == -x);
    }
}
