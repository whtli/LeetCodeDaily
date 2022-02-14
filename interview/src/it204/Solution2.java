package interview.src.it204;

import java.util.Arrays;

/**
 * @Description 204. 计数质数
 * 给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
 * @Author liq
 * @Date 2022/02/14
 */
public class Solution2 {
    public int countPrimes(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int result = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i] == 1) {
                result++;
                if ((long) i * i < n) {
                    for (int k = i; k * i < n; k++) {
                        isPrime[k * i] = 0;
                    }
                }
            }
        }
        return result;
    }
}