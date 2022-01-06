package interview.src.it172;
import java.math.BigInteger;

/**
 * @Description 172. 阶乘后的零
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 * 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
 * @Author liq
 * @Date 2022/01/06
 */
public class Solution3 {
    public int trailingZeroes(int n) {
        int count = 0;
        BigInteger x = new BigInteger(String.valueOf(n));
        for (int i = n - 1; i > 1; i --) {
            x = x.multiply(new BigInteger(String.valueOf(i)));
        }
        System.out.println(x);
        while (x.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
            count ++;
            x = x.divide(BigInteger.TEN);
        }

        return count;
    }
}
