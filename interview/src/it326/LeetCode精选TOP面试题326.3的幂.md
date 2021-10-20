---
title: LeetCode精选面试题326.3的幂
copyright: true
data: 2021-10-20 21:00:00
toc: true
tags: [Java,LeetCode,数值计算,面试]
categories: [LeetCode]
---
### 题目描述
给定一个整数，写一个函数来判断它是否是 3 的幂次方。若是，返回 true ；否则，返回 false 。
```bash
example
input  : n = 0
output : false
input  : n = 9
output : true
input  : n = 45
output : false
```
<!--more-->
### 解题思路
**思路1**
从n往1做除法
**思路2**
从1往n做乘法
### 代码（Java）
**思路1代码**
```java
public class Solution {
    public boolean isPowerOfThree(int n) {
        while (n != 0 && n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }
}
```
**思路2代码**
```java
public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n % 3 != 0) {
            // 防止超时，先做一次判断，把不能整除3的都筛除，对3取余是0的数值包含了3的幂次方
            return false;
        }
        int i = 1;
        while (i < n) {
            i *= 3;
        }
        return n == i;
    }
}
```