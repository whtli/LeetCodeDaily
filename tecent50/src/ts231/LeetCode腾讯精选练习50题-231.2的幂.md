---
title: LeetCode腾讯精选练习50题-231.2的幂
copyright: true
toc: true
tags:
  - Java
  - LeetCode
  - 数学
  - 位运算
  - 递归
categories:
  - LeetCode
date: 2022-04-10 20:00:00
---

### 题目描述

 * 给定一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 如果存在一个整数 x 使得 n == 2^x ，则认为 n 是 2 的幂次方。

```bash
example
input  : n = 1
output : true
input  : n = 16
output : true
input  : n = 5
output : false
input  : n = -16
output : false
```

<!--more-->

### 解题思路

+ 基本规律：
    - 小于等于 0 的数，必然不是
    - 1 必然是
    - 对 2 取余，余数不为0的，必然不是
    
**思路1 循环缩小**

+ 以 n 对 2 取余的余数为0作为循环条件，不断将 n 减半
+ 返回“最后的 n ”是否等于 1 的判断结果即可 
+ 时间复杂度 O(log n)
+ 空间复杂度 O(1)

**思路2 递归**

+ 参考思路1，将循环形式改为递归形式
+ 递归退出边界：
    - n <= 0，返回 false
    - n = 1，返回 true
    - n % 2 != 0，返回 false （这个必须放在最后，因为 1 % 2 = 1，需要让 n = 1 的情况时在上一个边界条件中就退出）
+ 正常递归时传参为 n / 2
+ 时间复杂度 O(log n)
+ 空间复杂度 O(n)

**思路3 位运算**
* 方法1
    + 若 n 是 2的幂，则n的二进制形式中，一定只存在一个 1
    + 例如 n = 8，二进制表示为 1000；n = 4，二进制表示为 100
    + 假设 n 是 2的幂，那么 n-1 的二进制形式中必然全为 1
    + 例如， n = 8（1000），n-1=7（111）；n = 4（100），n-1=3（11） 
    + 为了方便对比，将n-1的二进制中前置补0，与n长度对齐，则可以发现：
        - n = 8（1000）；n = 4（100）
        - n-1=7（0111）；n-1=3（011） 
    + 所以，可以判断 n 和 n-1 的 按位与 （&）结果，如果结果恰好为0，说明n必然是2的幂
    + 时间复杂度 O(1)
    + 空间复杂度 O(1)
    
* 方法2
    + 假设n > 0，则负数 -n 以补码的形式表示，规则为，n的二进制按位取反再加1
    + 若 n 是 2的幂，则n的二进制形式中，一定只存在一个 1 ，且在首位
        + 例如 n = 8，二进制表示为 1000；n = 4，二进制表示为 100
        + 假设 n 是 2的幂，那么按照补码表示的规则， -n 的二进制形式中必然与 n 相同
        + 例如:
            -  n = 8 （1000），-n = -8（1000 按位取反 -> 0111 -> +0001 -> 1000）
            -  n = 4 （100），-n = -4（100 按位取反 -> 011 -> +001 -> 100）
    + 所以，可以判断 n 与 -n 的按位与（&）结果，如果结果仍然为 n，则说明 n 必然是2的幂
    + 时间复杂度 O(1)
    + 空间复杂度 O(1)
    
### 代码（Java）
**思路1代码**
```java
public class Solution1 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }
}
```
**思路2代码**
```java
public class Solution2 {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return loop(n);
    }
    private boolean loop(int num) {
        if (num == 1) {
            return true;
        }
        if (num % 2 == 1) {
            return false;
        }
        return loop(num / 2);
    }

    /* 简洁写法
    public boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 2 == 1) {
            return false;
        }
        return isPowerOfTwo(n / 2);
    }
    */
}
```
**思路3代码**
```java
public class Solution3 {
    public boolean isPowerOfTwo(int n) {
        // 位运算方法1
        return n > 0 && (n & (n - 1)) == 0;
        // 位运算方法2
        // return n > 0 && (n & -n) == n;
    }
}
```