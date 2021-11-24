---
title: LeetCode精选TOP面试题029.两数相除
copyright: true
data: 2021-11-24 21:00:00
toc: true
tags: [Java,LeetCode,数学,位运算,面试]
categories: [LeetCode]
---

### 题目描述

 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * 返回被除数 dividend 除以除数 divisor 得到的商。除数不为 0。
 * 整数除法的结果应当截去（truncate）其小数部分。
 * 被除数和除数均为 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。如果除法结果溢出，则返回 2^31 − 1。
```bash
example
input  : dividend = 10, divisor = 3
output : 3
input  : dividend = 7, divisor = -3
output : -2
input  : dividend = -2147483648, divisor = -1
output : 2147483646
note   : 若无限制，除法后结果为2147483648，越界，需要返回 Integer.MAX_VALUE
```

<!--more-->

### 解题思路
**思路： 位运算**
+ 先做越界判断，若把 dividend 为左右边界值，divisor 为1 or -1的情况都列举出来，会发现只需要判断 dividend = Integer.MIN_VALUE && divisor = -1 这一种越界需要处理
+ 提前把结果的符号 sign 摘出来，然后把后续的求商操作当作对两个正数的操作，避免处理负数出现错误
+ 使用long类型（不使用int，是因为dividend=Integer.MIN_VALUE时摘掉负号会越界）的m和n分别接收去除了符号的 dividend 和 divisor
+ 使用两层循环，外层循环 比较不断缩小的被除数m和除数n
    + 定义d初始化为被除数n，定义c初始化为1，d与c会同步翻2倍，以保证d与c的商为n，同时c是每次内层循环的近似解
    + 内层循环，比较不断缩小的被除数m和n×2^i，其中i是内存循环的次数
        + 内层的被除数m，是每次减去近似解后的剩余值，可以理解为每次减去一个最大近似解后的残差 error（与内层的m值相等）
        + 为防止残差 error 还可以包含2倍或更多倍的n（即能够使真实解res继续增大），需要使用循环对 error 继续缩小，直至其值不能 >= 2*n
        + 若残差 error 还可以包含2倍或更多倍的n，让d和c同时乘2，即翻倍
        + 当d足够接近每次的 error 时，d / n -> c，此时c就可以看作一个近似解，但不能保证完全相等，会有新的残差 error'
    + 把每次得到的近似解c累加求和，最终的和 result 就是真实解
    + m（旧残差 error） 减去d，得到新残差 error'，继续用于循环，可以将残差不断缩小，使得c的累加和result逐渐趋近于真实解
        
### 代码（Java）
```java
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
                d <<= 1;  // d扩大2倍
                c <<= 1;  // c扩大2倍，与d同步
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
```
