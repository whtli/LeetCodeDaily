---
title: 腾讯精选练习50题-009.回文数
copyright: true
toc: true
tags:
  - Java
  - LeetCode
  - 数学
  - 字符串
  - 回文
categories:
  - LeetCode
date: 2022-4-06 21:00:00
---


### 题目描述

 * 给定一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 进阶：不将整数转为字符串来解决这个问题

```bash
example
input  : 121
output : true
input  : -121
output : false
```

<!--more-->

### 解题思路

+ 先把一些很明确的情况排除掉
+ 负数直接返回false即可，肯定不是回文数
+ [1, 10]内的数和10的倍数都肯定不是回文数

**思路1 借助字符串**

+ 转成字符串后取其反转，再使用equals()函数做对比
+ 时间复杂度：O(n)
+ 空间复杂度：O(1)

**思路2 同时取前后对比**

+ 先计算出x的长度len
+ 借助循环，每一步都取出当前x的首位和末尾做对比
    - 只要有一组不想等则直接返回false
    - 每一步中若相等则将x先去掉首位再除以10获取新的x，并将len除以100，对应于新的x长度
+ 时间复杂度：O(log(n))
+ 空间复杂度：O(1)

**思路3 反转一半后对比**

+ 将x的后半部分逐步取下，并通过数学运算不断拼接成新的整数 half
+ 当x不再大于后半部分（x的长度比half短，或者长度相等但是x<=half）时结束拼接
+ 判断以下两种情况是否成立，有一个成立则证明是回文数，可以返回true；两组都不成立则不是回文数
    + 当前x 和 half 相等 （原 x 长度为偶数）
    + 当前x 和 half / 10 相等 （原 x 长度为奇数；中间的数值x不论是几，x都是回文数）
+ 时间复杂度：O(log(n))
+ 空间复杂度：O(1)

### 代码（Java）
**思路1代码**
```java
public class Solution1 {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0) && x != 0) {
            return false;
        }
        String sb = new StringBuffer(String.valueOf(x)).reverse().toString();

        return sb.equals(x + "");
    }
}
```
**思路2代码**
```java
public class Solution2 {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0) && x != 0) {
            return false;
        }
        int len = 1;
        int y = x;
        while (y >= 10) {
            len *= 10;
            y /= 10;
        }
        y = x;
        while (y != 0) {
            if (y / len != y % 10) {
                return false;
            }
            y = (y % len) / 10;
            len /= 100;
        }
        return true;
    }
}
```
**思路3代码**
```java
public class Solution3 {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0) && x != 0) {
            return false;
        }
        int rightHalf = 0;
        int y = x;
        while (y > rightHalf) {
            rightHalf = rightHalf * 10 + y % 10;
            y /= 10;
        }
        // 前者是偶数位数，后者是奇数位数
        return y == rightHalf || y == rightHalf / 10;
    }
}
```