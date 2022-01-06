---
title: LeetCode精选TOP面试题172.阶乘后的零
copyright: true
toc: true
tags:
  - Java
  - LeetCode
  - 数学
  - 递归
categories:
  - LeetCode
date: 2022-01-06 12:00:00
---


### 题目描述

 * 给定一个整数 n ，返回 n! 结果中尾随零的数量。
 * 提示 n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1

```bash
example
input  : n = 3
output : 0
note   : 3! = 6 ，不含尾随 0
input  : n = 5
output : 1
note   : 5! = 120 ，有一个尾随 0
input  : n = 0
output : 0
```

<!--more-->

### 解题思路

+ 基本思路：n中包含多少个5，其阶乘值就有多少个尾随的0
+ n的阶乘尾随0，可以理解为不断乘10得到的，所以找到n中包含多少因数10，就可以知道阶乘值有多少尾随0
+ 将因数10拆分，是由因数5和因素2得到的，而因数2每隔两个数出现一次，因数5每隔5个数出现一次，故因数2的个数远多于因数5
+ 所以，有多少个因数5，就有多少个尾随0
+ 除了每隔5个数出现一次因数5之外，每隔25个数也会多出现一次因数5，因为25 = 5 × 5，即n中有多少个25，就多包含了几个因数5；以此类推，每隔125个数……
+ 因此，n中包含的因数5的个数应当为： 
  - > n / 5 + n / 25 + n / 125 + ……
+ 时间复杂度： O(log n)
+ 空间复杂度：O(1)

作者：LeetCode
链接：https://leetcode-cn.com/problems/factorial-trailing-zeroes/solution/jie-cheng-hou-de-ling-by-leetcode/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

**思路1 循环**

+ 循环，用n累除5，并把每次除以5的数量累加到结果上

**思路2 递归**

+ 每次把 n / 5 作为新的参数投入到新一轮递归计算中
+ 递归边界为 n = 0

**思路3 BigInteger**

+ 借助Java的大数，先计算阶乘，再不断取余判断是否余数为0，若为0则结果加1，阶乘值除10
+ 会超出时间限制

### 代码（Java）
**思路1代码**
```java
public class Solution1 {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            n = n / 5;
            count += n;
        }
        return count;

    }
}
```
**思路2代码**
```java
public class Solution2 {
    public int trailingZeroes(int n) {
        if (n == 0) {
            return 0;
        }
        return (n / 5) + trailingZeroes(n / 5);
    }
}
```
**思路2代码**
```java
public class Solution3 {
    public int trailingZeroes(int n) {
        int count = 0;
        BigInteger x = new BigInteger(String.valueOf(n));
        for (int i = n - 1; i > 1; i --) {
            x = x.multiply(new BigInteger(String.valueOf(i)));
        }
        System.out.println(x);
        while (x.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
            count ++;
            x = x.divide(BigInteger.TEN);
        }

        return count;
    }
}
```

