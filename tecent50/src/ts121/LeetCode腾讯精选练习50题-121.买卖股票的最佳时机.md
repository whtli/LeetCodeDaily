---
title: LeetCode腾讯精选练习50题-121.买卖股票的最佳时机
copyright: true
toc: true
tags:
  - Java
  - LeetCode
  - 数组
  - 动态规划
  - 暴力法
categories:
  - LeetCode
date: 2022-05-15 21:00:00
---


### 题目描述

 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。
 * 设计一个算法来计算所能获取的最大利润。
 * 返回可以从这笔交易中获取的最大利润。
 * 如果不能获取任何利润，返回 0 。

```bash
example
input  : prices = [7,1,5,3,6,4]
output : 5
note   : 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
         注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，不能在买入前卖出股票。

input  : prices = [7,6,4,3,1]
output : 0
note   : 在这种情况下, 没有交易完成, 所以最大利润为 0。
```

<!--more-->

### 解题思路

##### 思路1 动态规划

+ 维护最大利润数组
    - 借助额外的数组 `dp`，记录在价格数组中，从开始到每个位置的共 `n-1` 个子区间内，可以获得的最大利润
    - `dp[i]`表示前i天的子区间内，可以获得的最大利润
    - 初始`dp[0] = 0`，因为不能在当天操作，所以无法获得利润
    - 动态规划的状态转移方程：`dp[i] = Math.max(prices[i] - minPrice, dp[i - 1])`
    - 状态转移方程解释：如果当天的价格`prices[i]`与`历史最低价格`的差`sub`，大于前一天可以获得的最大利润`dp[i-1]`，则把当天可获得的最大利润`dp[i]`设置为`sub`；否则把`dp[i]`设置为与`dp[i-1]`相同的值，说明可以获得的最大利润的卖出时间在之前的某天，所以只要保证在今天之前卖出，持续到今天依然是能够保证最大利润。
    - 那么遍历结束后，数组`dp`的最后一个元素值，就是整个时间区间内，可以获得的最大利润值。
    - 时间复杂度O(n)
    - 空间复杂度O(n)
+ 只维护最大利润变量
    - 其实是 维护最大利润数组 做法的变形，即直接在遍历过程中通过比较记录最大差额
    - 时间复杂度O(n)
    - 空间复杂度O(1)
##### 思路2 暴力法（会超出时间限制）
+ 仅供参考，实际提交无法通过测试，会超出时间限制
+ 双重循环，找到满足以下条件的最大差值就是最大利润，即：
    - Max(prices[j] - prices[i]) && j > i
    - 0 < i < prices.length - 1, i + 1 < j < prices.length
+ 时间复杂度O(n^2)
+ 空间复杂度O(1)

### 代码（Java）
**思路1代码**
```java
public class Solution1 {
    public int maxProfitDp1(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];
        dp[0] = 0;
        int minPrice = prices[0];
        for (int i = 1; i < n; i++) {
            // dp[i] = Math.max(prices[i] - minPrice, dp[i - 1]);
            // minPrice = Math.min(minPrice, prices[i]);
            
            if (prices[i] - minPrice > dp[i - 1]) {
                dp[i] = prices[i] - minPrice;
            } else {
                dp[i] = dp[i - 1];
            }

            if (minPrice > prices[i]) {
                minPrice = prices[i];
            }
        }
        return dp[n - 1];
    }
    
    // DP2为动态规划的简化，放弃额外的数组记录，只维护一个最大利润变量，是从DP衍生而来的
    public int maxProfitDp2(int[] prices) {
        int len = prices.length;
        int maxProfile = 0;
        int minPrice = prices[0];
        for (int i = 1; i < len; i++) {
            // maxProfile = Math.max(prices[i] - minPrice, maxProfile);
            // minPrice = Math.min(minPrice, prices[i]);
            if (prices[i] - minPrice > maxProfile) {
                maxProfile = prices[i] - minPrice;
            }
            if (minPrice > prices[i]){
                minPrice = prices[i];
            }
        }
        return maxProfile;
    }
}
```
**思路2代码**
```java
public class Solution2 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int maxProf = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                maxProf = Math.max(prices[j] - prices[i], maxProf);
            }
        }
        return maxProf;
    }
}
```