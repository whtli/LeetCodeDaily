package interview.src.it069;

/**
 * @Description 69. Sqrt(x)
 * 给定一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被舍去 。
 * 不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * @Author liq
 * @Date 2021/10/22
 */
public class Solution1 {
    public int mySqrt(int x) {
        long y = x;
        long result = 0;
        int middle = x / 2 + 1;
        for (result = 1; result <= middle; result++) {
            long compare = result * result;
            if (compare > y) {
                return (int)result - 1;
            } else if (compare == y) {
                return (int)result;
            }
        }
        return (int)result;
    }
}
