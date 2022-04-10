package tecent50.src.ts231;

/**
 * @Description 231. 2 的幂
 * 给定一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 如果存在一个整数 x 使得 n == 2^x ，则认为 n 是 2 的幂次方。
 * @Author liq
 * @Date 2022/04/10
 */
public class Solution3 {
    public boolean isPowerOfTwo(int n) {
        // 位运算思路1
        return n > 0 && (n & (n - 1)) == 0;
        // 位运算思路2
        // return n > 0 && (n & -n) == n;
    }
}
