package tecent50.src.ts007;

/**
 * @Description 7. 整数反转
 * 给定一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^(31 − 1)] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * @Author liq
 * @Date 2022/05/28
 */
public class Solution1 {
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE){
            // 因为输入保证为32位整数，所以不需要考虑更小的数值，判断到Integer的最小值即可
            return 0;
        }
        boolean flag = false;
        if (x < 0) {
            flag = true;
            x = -x;
        }
        StringBuilder s = new StringBuilder(x + "");
        String str = s.reverse().toString();
        if (s.length() >= 10) {
            if (!flag && str.compareTo("2147483647") > 0) {
                return 0;
            }
            if (flag && str.compareTo("2147483648") > 0) {
                return 0;
            }
        }
        return flag ? -Integer.parseInt(str) : Integer.parseInt(str);
    }
}
