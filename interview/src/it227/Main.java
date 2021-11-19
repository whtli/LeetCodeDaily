package interview.src.it227;

/**
 * @Description 227.基本计算器II
 * 给定一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 整数除法仅保留整数部分。
 * @Author liq
 * @Date 2021/11/19
 */
public class Main {
    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        String string = "-3+2*2";
        int result = solution.calculate(string);
        System.out.println("result : " + result);
    }
}
