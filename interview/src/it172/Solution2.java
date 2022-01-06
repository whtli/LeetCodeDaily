package interview.src.it172;

/**
 * @Description 172. 阶乘后的零
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 * 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
 * @Author liq
 * @Date 2022/01/06
 */
public class Solution2 {
    public int trailingZeroes(int n) {
        if (n == 0) {
            return 0;
        }
        return (n / 5) + trailingZeroes(n / 5);
    }
}
