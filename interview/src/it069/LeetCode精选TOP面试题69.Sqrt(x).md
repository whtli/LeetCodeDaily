---
title: LeetCode精选TOP面试题69.Sqrt(x).md
copyright: true
data: 2021-10-22 21:00:00
toc: true
tags: [Java,LeetCode,数值计算,二分查找,迭代,面试]
categories: [LeetCode]
---
### 题目描述
给定一个非负整数 x ，计算并返回 x 的 算术平方根 。
由于返回类型是整数，结果只保留 整数部分 ，小数部分将被舍去 。
不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
```bash
example
input  : x = 4
output : 2
input  : x = 8
output : 2
note   : 8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
input  : x = 2147483647
output : 46340
note   : 可能会存在溢出情况的计算边界，需要注意
```
<!--more-->
### 解题思路
**思路1 直接比较**
+ 从1遍历到x的一半，遍历过程中不断比较，效率较低
+ 时间复杂度O(n)
+ 空间复杂度O(1)
**思路2 二分查找**
使用二分查找并做比较，效率比思路1高
+ 时间复杂度O(log n)
+ 空间复杂度O(1)
**思路3 牛顿迭代法**
递归使用[牛顿迭代法](https://leetcode-cn.com/problems/sqrtx/solution/niu-dun-die-dai-fa-by-loafer/)，该方法为二次收敛，效率比思路2略高
+ 时间复杂度O(log n)
+ 空间复杂度O(1)
### 代码（Java）
**思路1代码**
```java
public class Solution1 {
    public int mySqrt(int x) {
        long y = x;
        long result = 0;
        int middle = x / 2 + 1;
        for (result = 1; result <= middle; result++) {
            long compare = result * result;
            if (compare > y) {
                return (int)result - 1;
            } else if (compare == y) {
                return (int)result;
            }
        }
        return (int)result;
    }
}
```
**思路2代码**
```java
public class Solution2 {
    public int mySqrt(int x) {
        int result = 0;
        int left = 0;
        int right = x;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if ((long) middle * middle <= x) {
                left = middle + 1;
                result = middle;
            } else {
                right = middle - 1;
            }
        }
        return result;
    }
}
```
```java
public class Solution3 {
    public int mySqrt(int x) {
        int c = x;
        if (x == 0) return 0;
        return (int) sqrt(x, c);
    }

    public double sqrt(double x, int c) {
        double result = (x + c / x) / 2;
        if (result == x) {
            return result;
        } else {
            return sqrt(result, c);
        }
    }
}
```