package interview.src.it050;

/**
 * @Description 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn ）。
 * @Author liq
 * @Date 2022/01/06
 */
public class Main {
    public static void main(String[] args) {

        double x = 2.00000;
        int n = 10;
        Solution2 solution1 = new Solution2();
        double result1 = solution1.myPow(x, n);
        System.out.println("solution1 : " + result1);
        Solution1 solution2 = new Solution1();
        double result2 = solution2.myPow(x, n);
        System.out.println("solution2 : " + result2);
    }
}
