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
public class Solution4 {
    public int countPrimes(int n) {

        if (n <= 2) {
            return 0;
        }
        // 除了2以外，所有偶数肯定不是质数，假设所有奇数全是质数，然后所有奇数中排除非质数，此过程即做减法
        int count = n / 2;

        boolean[] notPrime = new boolean[n];
        // 因为是做减法，且循环内会有对倍数的遍历操作
        // 所以外层循环只需要以 sqrt(n) 为边界
        // 内层遍历会遍历到整个范围内的倍数并作减法
        // 所有 √n 到 n 之间的奇数，若它是 2 到 √n 内某个质数的倍数，则 count 肯定减1
        // 所有 √n 到 n 之间的奇数，若它不是 2 到 √n 内某个质数的倍数，则它肯定是
        for (int i = 3; i * i < n; i += 2) {

            if (notPrime[i]) {
                // 如果是合数，继续遍历
                continue;
            }
            // 此处遍历i的所有i倍及大于i倍的数，并全部标记为合数
            // 因为i的2到i-1倍的倍数在此之前肯定被遍历从2到i-1时标记过了，不需要重复遍历
            // 之所以每次循环加两倍的i，是因为所有的偶数倍数早已经在遍历之前就被默认减去了（n / 2），故不需要再对其做减法。
            // 举例，i = 5，则以下循环中只需遍历 5*5，7*5， 9*5， 因为 6*5，8*5肯定是偶数，在遍历之前就被默认减掉了。
            for (int k = i * i; k < n; k += 2 * i) {
                if (!notPrime[k]) {
                    // 把质数 i 的 大于等于i倍的倍数都标记为合数，且count对应减去这些倍数的个数
                    notPrime[k] = true;
                    count--;
                }
            }
        }
        return count;
    }
}
