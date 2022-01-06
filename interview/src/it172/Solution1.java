package interview.src.it172;

/**
 * @Description 172. 阶乘后的零
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 * 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
 * @Author liq
 * @Date 2022/01/06
 */
public class Solution1 {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {

            n = n / 5;
            count += n;
        }
        return count;

    }
}
