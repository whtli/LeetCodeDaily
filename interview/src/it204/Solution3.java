package interview.src.it204;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 204. 计数质数
 * 给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
 * @Author liq
 * @Date 2022/02/14
 */
public class Solution3 {
    public int countPrimes(int n) {
        List<Integer> primes = new ArrayList<Integer>();
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        for (int i = 2; i < n; i++) {
            if (isPrime[i] == 1) {
                primes.add(i);
            }
            for (int k = 0; k < primes.size() && primes.get(k) * i < n; k++) {
                isPrime[primes.get(k) * i] = 0;
                if (i % primes.get(k) == 0) {
                    break;
                }
            }

        }
        return primes.size();
    }
}
