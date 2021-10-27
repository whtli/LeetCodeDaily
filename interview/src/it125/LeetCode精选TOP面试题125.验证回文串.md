---
title: LeetCode精选TOP面试题125.验证回文串
copyright: true
data: 2021-10-27 21:00:00
toc: true
tags: [Java,LeetCode,字符串,面试]
categories: [LeetCode]
---
### 题目描述
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 将空字符串定义为有效的回文串。
 * 1 <= s.length <= 2 * 10^5
 * 字符串 s 由 ASCII 字符组成
```bash
example
input  : "A man, a plan, a canal: Pana
output : true
input  : "race a car"
output : false
input  : "0p"
output : false
```
<!--more-->
### 解题思路
+ 首先对字符串进行大小写转换，全部转成小写toLowerCase（也可以是大写toUpperCase），然后使用trim去掉空格，得到string。

**思路1 for 循环**
从0到string.length/2循环，比较下标 i 和对应下标 string.length - 1 - i 处元素是否相同。若否则直接return false，是则继续循环。
**思路2 while 循环 原理同1**
设置left = 0， right = string.length - 1, left 不断向右加1，right 不断向左减1，比较对应元素是否相同。若否则返回false，是则继续循环。 
**思路3 借助Java中字符串的reserve()方法**
创建一个新的字符串 newString 为 string的反转串，此处借助reserve()方法。直接返回newString.equals(string)的判断结果。
### 代码（Java）
**思路1代码**
```java
public class Solution1 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().trim();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                stringBuilder.append(ch);
            } else if (ch >= '0' && ch <= '9') {
                stringBuilder.append(ch);
            }
        }
        int length = stringBuilder.length();
        for (int i = 0; i < length / 2; i++) {
            if (stringBuilder.charAt(i) != stringBuilder.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
```
**思路2代码**
```java
public class Solution3 {
    public boolean isPalindrome(String s) {
        String str = s;
        str = str.toLowerCase().trim();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                stringBuilder.append(ch);
            } else if (ch >= '0' && ch <= '9') {
                stringBuilder.append(ch);
            }
        }
        int left = 0;
        int right = stringBuilder.length() - 1;
        while (left < right) {
            if (stringBuilder.charAt(left++) != stringBuilder.charAt(right--)) {
                return false;
            }
        }

        return true;
    }
}
```
**思路3代码**
```java
public class Solution2 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().trim();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                stringBuilder.append(ch);
            } else if (ch >= '0' && ch <= '9') {
                stringBuilder.append(ch);
            }
        }
        StringBuilder reserve = new StringBuilder(stringBuilder).reverse();
        return reserve.toString().equals(stringBuilder.toString());
    }
}
```