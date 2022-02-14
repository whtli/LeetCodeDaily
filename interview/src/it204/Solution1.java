package interview.src.it204;

/**
 * @Description 204. 计数质数
 * 给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
 * @Author liq
 * @Date 2022/02/14
 */
public class Solution1 {
    public int countPrimes(int n) {
        int result = 0;
        for (int i = 2; i < n; i++) {
            if (judgePrime(i)) {
                result++;
            }
        }
        return result;
    }

    private boolean judgePrime(int number) {
        for (int j = 2; j * j <= number; j++) {
            if (number % j == 0) {
                return false;
            }
        }
        return true;
    }
}
