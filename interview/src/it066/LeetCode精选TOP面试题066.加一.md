---
title: LeetCode精选TOP面试题66.加一
copyright: true
data: 2021-10-21 21:00:00
toc: true
tags: [Java,LeetCode,数组,数值计算,面试]
categories: [LeetCode]
---
### 题目描述
给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
假设除了整数 0 之外，这个整数不会以零开头
```bash
example
input  : {0}
output : {1}
input  : {1,9}
output : {2,0}
input  : {9,9,9}
output : {1,0,0,0}
```
<!--more-->
### 解题思路
**思路1 借助大数BigDecimal**
+ 先将数组转换为StringBuilder sb
+ 再借助sb生成大数bd，使用大数的运算规则做加一
+ 将大数bd转换为字符串s，再将s转换为数组
+ 时间复杂度O(n)
+ 空间复杂度O(n)
**思路2 逆序遍历做加法**
+ 按照最基本的想法，做逆向遍历，做加法
+ 若最后一位加1后等于10则置0并进位，进入循环计算，直至某次计算不需要进位，或者进位到数组开头（此时需要扩展数组长度都+1，并将首位置1，后续全为0）
+ 若最后一位加1后不为10则直接为其赋新值并返回数组
+ 时间复杂度O(n)
+ 空间复杂度O(n)
**思路3 逆向遍历找最长的后缀“9……9”串**
+ 逆向遍历，找最长的连续“999……9”串string，直至找到第一个不为9的数值（记录位置index），或者全部为9逆向遍历到数组开头
+ 若string的长度不等于数组长度，则使index位置的数值加1，并置其后续所有数组元素为0
+ 若string的长度等于数组长度，则扩展数组长度+1，置首位为1，后续全为0
+ 时间复杂度O(n)
+ 空间复杂度O(n)
### 代码（Java）
**思路1代码**
```java
public class Solution1 {
    public int[] plusOne(int[] digits) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < digits.length; i++) {
            stringBuilder.append(digits[i]);
        }
        BigDecimal bigDecimal = new BigDecimal(stringBuilder.toString());
        bigDecimal = bigDecimal.add(new BigDecimal(1));
        System.out.println("big decimal:" + bigDecimal);
        String string = bigDecimal.toString();
        int[] result = new int[string.length()];
        for (int i = 0; i < string.length(); i++) {
            result[i] = string.charAt(i) - '0';
        }
        return result;
    }
}
```
**思路2代码**
```java
public class Solution2 {
    public int[] plusOne(int[] digits) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < digits.length; i ++) {
            stringBuilder.append(digits[i]);
        }
        int add = stringBuilder.charAt(stringBuilder.length() - 1) - '0' + 1;
        if (add != 10) {
            stringBuilder.setCharAt(stringBuilder.length() - 1,String.valueOf(add).charAt(0));
        } else {
            if (stringBuilder.length() == 1) {
                int[] result = {1,0};
                return result;
            } else if (stringBuilder.length() >= 1){
                stringBuilder.setCharAt(stringBuilder.length() - 1,'0');
                for (int j = stringBuilder.length() - 2; j >= 0; j --) {
                    add = stringBuilder.charAt(j) - '0' + 1;
                    if (add == 10) {
                        stringBuilder.setCharAt(j, '0');
                        continue;
                    } else {
                        stringBuilder.setCharAt(j, String.valueOf(add).charAt(0));
                        break;
                    }
                }
            }
        }
        if(add == 10){
            int[] result = new int[stringBuilder.length() + 1];
            result[0] = 1;
            for (int k = 1; k < result.length; k ++) {
                result[k] = stringBuilder.charAt(k - 1) - '0';
                System.out.print(result[k]);
            }
            return result;
        } else {
            int[] result = new int[stringBuilder.length()];
            for (int k = 0; k < result.length; k ++) {
                result[k] = stringBuilder.charAt(k) - '0';
                System.out.print(result[k]);
            }
            return result;
        }
    }
}
```
**思路3代码**
```java
public class Solution3 {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        int last = length - 1;
        while (last >= 0 && digits[last] == 9) {
            last--;
        }
        if (last + 1 != length) {
            if (last == -1) {
                int[] result = new int[digits.length + 1];
                result[0] = 1;
                return result;
            } else if (last != -1) {
                digits[last]++;
                for (int i = last + 1; i < length; i++) {
                    digits[i] = 0;
                }
                return digits;
            }
        } else if (last + 1 == length) {
            digits[length - 1]++;
            return digits;
        }
        return digits;
    }
}
```