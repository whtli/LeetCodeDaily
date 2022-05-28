package tecent50.src.ts007;

/**
 * @Description 7. 整数反转
 * 给定一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−2^31,  2^(31 − 1)] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * @Author liq
 * @Date 2022/05/28
 */
public class Solution2 {
    public int reverse(int x) {
        if (x < 0 && x == -x) {
            return 0;
        }
        boolean flag = false;
        if (x < 0) {
            flag = true;
            x = -x;
        }
        int y = 0;
        while (x > 0) {
            if (y > Integer.MAX_VALUE / 10) {
                return 0;
            }
            y = y * 10 + x % 10;
            x /= 10;
        }
        return flag ? -y : y;
    }
    // 以下为简化代码
    public int reverse2(int x) {
        int y = 0;
        int max = Integer.MAX_VALUE / 10;
        int min = Integer.MIN_VALUE / 10;
        while (x != 0) {
            if (y > max || y < min) {
                return 0;
            }
            y = y * 10 + x % 10;
            x /= 10;
        }
        return y;
    }
}
