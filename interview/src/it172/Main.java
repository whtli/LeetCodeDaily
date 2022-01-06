package interview.src.it172;

/**
 * @Description
 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 * 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
 * @Author liq
 * @Date 2022/01/06
 */
public class Main {
    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        int n = 5;
        int res = solution.trailingZeroes(n);
        System.out.println(res);
    }
}
