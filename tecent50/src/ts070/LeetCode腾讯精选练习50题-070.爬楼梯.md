---
title: LeetCode腾讯精选练习50题-070.爬楼梯
copyright: true
toc: true
tags:
  - Java
  - LeetCode
  - 动态规划
  - 数学
categories:
  - LeetCode
date: 2022-05-20 21:00:00
---


### 题目描述



```bash
example
input  : n = 2
output : 2
note   : 有两种方法可以爬到楼顶。
         1. 1 阶 + 1 阶
         2. 2 阶

input  : n = 3
output : 3
note   : 有三种方法可以爬到楼顶。
         1. 1 阶 + 1 阶 + 1 阶
         2. 1 阶 + 2 阶
         3. 2 阶 + 1 阶
```

<!--more-->

### 解题思路
+ 列举几个简单的台阶数，做总结，可以发现爬楼梯的方案数满足斐波那契数列。如：
    - 2阶，2种
    - 3阶，3种
    - 4阶，5种
    - 5阶，8种
##### 思路1 动态规划

+ 状态转移方程：dp[i] = dp[i-1] + dp[i-2]
+ 初始，dp[1] = 1, dp[2] = 2
+ 从3到n遍历结束后，返回dp[n]即是爬楼梯的方案数

+ 可以维护dp数组，保留每一个n可以产生的方案数
+ 也可以不维护数组，动过迭代变量保留最后的方案数

##### 思路2 递归（会超出时间限制）
+ 从动态规划变形得到的
+ 递归出口：
    - n = 1，返回1
    - n = 2，返回2
+ 递归过程：
    - 返回 loop(n - 1) + loop(n - 2)

##### 思路3 数学通项公式

+ 斐波那契数列的通项公式为：
  + *f(n)*=[((1+√5) / 2)^n^−((1−√5)/2)^n^] / √5
  
### 代码（Java）
**思路1代码**
```java
public class Solution1 {
    public int climbStairs(int n) {
        if (n == 1){
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    // 不借助dp数组的写法
    public int climbStairs2(int n){
        int p = 0;
        int q = 1;
        int r = p + q;
        for (int i = 2; i <= n; i++){
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
```
**思路2代码**
```java
public class Solution2 {
    public int climbStairs(int n) {
        // 超出时间限制O(2^n)
        if (n <= 1) {
            return 1;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}
```
**思路3代码**
```java
public class Solution3 {
    public int climbStairs(int n) {
        double sqrt5 = Math.sqrt(5);
        double fibn = Math.pow((1 + sqrt5) / 2, n + 1) - Math.pow((1 - sqrt5) / 2, n + 1);
        return (int) Math.round(fibn / sqrt5);
    }
}
```