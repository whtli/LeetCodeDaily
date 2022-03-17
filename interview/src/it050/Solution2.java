package interview.src.it050;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @Description 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn ）。
 * @Author liq
 * @Date 2022/03/10
 */
public class Solution2 {
    public double myPow(double x, int n) {
        if (x == 1) {
            return 1;
        }

        long m = n;
        if (m < 0) {
            x = 1.0 / x;
            m = -m;
        }

        double result = 1.0;

        while (m > 0) {
            if (m % 2 == 1) {
                result = result * x;
            }
            x = x * x;
            m /= 2;
        }
        return result;
    }
}
