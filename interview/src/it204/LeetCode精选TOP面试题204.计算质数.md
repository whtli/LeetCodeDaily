---
title: LeetCode精选TOP面试题204.计数质数
copyright: true
toc: true
tags:
  - Java
  - LeetCode
  - 数组
  - 数学
categories:
  - LeetCode
date: 2022-02-14 17:00:00
---


### 题目描述

 * 给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。

```bash
example
input  : n = 10
output : 4
input  : n = 499979
output : 41537
input  : n = 1
output : 0
```

<!--more-->

### 解题思路

+ 思路4在leetcode平台提交性能最好：
> 66 / 66 个通过测试用例
> 状态：通过
> 执行用时: 40 ms
> 内存消耗: 45.6 MB

**思路1 枚举**

+ 遍历 [2, n) 的所有整数，逐个判断是否未质数，若是则计数结果累加1
+ 时间复杂度：O(n √n})
+ 空间复杂度：O(1)

**思路2 埃氏筛**

+ 当前元素 x 如果是质数，则其倍数 2x, 3x, …… 一定是合数。
+ 每次遍历到一个质数，就可以筛掉众多是其倍数的合数。
+ 此方法存在的一个问题是重复筛选，如 15 是 3和5 的倍数，15会被筛两次，虽然不影响结果，但实际上只筛1次就足够了。
+ 时间复杂度：O(n log(log n))
+ 空间复杂度：O(n)

**思路3 线性筛**

+ 让每个合数只被标记一次，相较于埃氏筛，多维护一个 primes 数组表示当前得到的质数集合。
+ 从小到大遍历，如果当前的数 x 是质数，就将其加入 primes 数组。
+ 详见[官方题解给出的思路](https://leetcode-cn.com/problems/count-primes/solution/ji-shu-zhi-shu-by-leetcode-solution/)


**思路4 减法**

+ 首先，除2以外的所有偶数都不是质数，因此在 [1, n] 范围内有最多 n / 2 个质数
+ 其次，筛选所有奇数，把所有是合数的奇数都从 n / 2 这个最大值中减去
+ 最后，剩下的差值就是 [1, n] 内所有的质数了
+ 时间复杂度：O(n)。
+ 空间复杂度：O(n)。

### 代码（Java）
**思路1代码**
```java
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
```
**思路2代码**
```java
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
```
**思路3代码**
```java
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
```
**思路4代码**
```java
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
```