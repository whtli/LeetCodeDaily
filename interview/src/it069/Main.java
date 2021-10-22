package interview.src.it069;

import java.util.Scanner;

/**
 * @Description 69. Sqrt(x)
 * 给定一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被舍去 。
 * 不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * @Author liq
 * @Date 2021/10/22
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        Solution3 solution = new Solution3();
        int sqrt = solution.mySqrt(number);
        System.out.println("sqrt: " + sqrt);
    }
}
