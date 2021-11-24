package interview.src.it029;

/**
 * @Description 29. 两数相除
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。除数不为 0。
 * 整数除法的结果应当截去（truncate）其小数部分。
 * 被除数和除数均为 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。如果除法结果溢出，则返回 2^31 − 1。
 * @Author liq
 * @Date 2021/11/24
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int dividend = 29;
        int divisor = 3;
        int result = solution.divide(dividend, divisor);
        System.out.println("result : " + result);
    }
}
