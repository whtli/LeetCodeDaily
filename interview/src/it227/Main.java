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
        Solution2 solution = new Solution2();
        // String string = " -3+5 / 2 ";
        String string = "1*2-3/4+5*6-7*8+9/10";
        int result = solution.calculate(string);
        System.out.println("result : " + result);
    }
}
