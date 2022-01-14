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
public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int sign = 1;
        if (dividend / divisor < 0) {
            sign = -1;
        }

        long m = Math.abs((long) dividend);
        long n = Math.abs((long) divisor);
        int res = 0;

        while (m >= n) {
            // d与c会同步翻2倍，以保证d与c的商为n
            long d = n, c = 1;
            // 内层while的m，是每次减去近似解后的剩余值，可以理解为每次减去一个最大近似解后的残差 m'
            // 为防止残差 m' 还可以包含2倍或更多倍的n（即能够使真实解res继续增大），需要使用循环对 m' 继续缩小，直至其大小不能>=2*n
            while (m >= (d << 1)) {
                // d扩大2倍
                d <<= 1;
                // c扩大2倍，与d同步
                c <<= 1;
                // 当d足够接近每次的剩余m时，d / n -> c，此时c就可以看作一个近似解，但不能保证完全相等，会有误差
            }
            // 把每次得到的近似解c累加求和，就是真实解
            res += c;
            // m减去d，然后把剩余的m用于循环，可以将误差不断缩小，使得c的累加和res逐渐趋近于真实解
            m -= d;
        }

        return sign * res;
    }
}
