package interview.src.it069;

/**
 * @Description 69. Sqrt(x)
 * 给定一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被舍去 。
 * 不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * @Author liq
 * @Date 2021/10/22
 */
public class Solution3 {
    public int mySqrt(int x) {
        int c = x;
        if (x == 0) return 0;
        return (int) sqrt(x, c);
    }

    public double sqrt(double x, int c) {
        double result = (x + c / x) / 2;
        if (result == x) {
            return result;
        } else {
            return sqrt(result, c);
        }
    }
}
