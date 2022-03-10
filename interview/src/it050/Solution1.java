package interview.src.it050;

/**
 * @Description 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn ）。
 * @Author liq
 * @Date 2022/03/10
 */
public class Solution1 {
    public double myPow(double x, int n) {
        long m = n;
        return m > 0 ? loop(x, m) : 1.0 / loop(x, -m);
    }

    private double loop(double x, long m){
        if (m == 0) {
            return 1.0;
        }
        double y = loop(x, m /2);
        return m % 2 == 0 ? y * y : y * y * x;
    }
}
