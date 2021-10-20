package interview.src.it326;

/**
 * @Description 326. 3的幂
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 * 若是，返回 true ；否则，返回 false 。
 * @Author liq
 * @Date 2021/10/20
 */
public class Solution {
    public boolean isPowerOfThree(int n) {
        // solution1
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
        /* // solution2
        if (n % 3 != 0) {
            return false;
        }
        int i = 1;
        while (i < n) {
            i *= 3;
        }
        return n == i;*/
    }
}
