package tecent50.src.ts231;

/**
 * @Description 231. 2 的幂
 * 给定一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 如果存在一个整数 x 使得 n == 2^x ，则认为 n 是 2 的幂次方。
 * @Author liq
 * @Date 2022/04/10
 */
public class Solution2 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return loop(n);
    }

    private boolean loop(int num) {
        if (num == 1) {
            return true;
        }
        if (num % 2 == 1) {
            return false;
        }
        return loop(num / 2);
    }

    /* 简洁写法
    public boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 2 == 1) {
            return false;
        }
        return isPowerOfTwo(n / 2);
    }
    */
}
