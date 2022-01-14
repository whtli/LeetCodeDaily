---
title: LeetCode精选TOP面试题008.字符串转换整数 (atoi)
copyright: true
data: 2021-11-06 21:00:00
toc: true
tags: [Java,LeetCode,字符串,面试]
categories: [LeetCode]
---
### 题目描述

 * 实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * 函数 myAtoi(string s) 的算法如下：
 * 1、读入字符串并丢弃无用的前导空格
 * 2、检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 3、读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 4、将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 5、如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 6、返回整数作为最终结果。
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 * 0 <= s.length <= 200
 * s 由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成

```bash
example
input  : s = "42"
output : 42
note   : 加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
         第 1 步："42"（当前没有读入字符，因为没有前导空格）
                  ^
         第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
                  ^
         第 3 步："42"（读入 "42"）
                    ^
         解析得到整数 42 。
         由于 "42" 在范围 [-231, 231 - 1] 内，最终结果为 42 。
input  : s = "   -42"
output : -42
note   : 第 1 步："   -42"（读入前导空格，但忽视掉）
                     ^
         第 2 步："   -42"（读入 '-' 字符，所以结果应该是负数）
                      ^
         第 3 步："   -42"（读入 "42"）
                        ^
         解析得到整数 -42 。
         由于 "-42" 在范围 [-231, 231 - 1] 内，最终结果为 -42 。
input  : s = "4193 with words"
output : 4193
note   : 第 1 步："4193 with words"（当前没有读入字符，因为没有前导空格）
                  ^
         第 2 步："4193 with words"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
                  ^
         第 3 步："4193 with words"（读入 "4193"；由于下一个字符不是一个数字，所以读入停止）
                      ^
         解析得到整数 4193 。
         由于 "4193" 在范围 [-231, 231 - 1] 内，最终结果为 4193 。
input  : s = "words and 987"
output : 0
note   : 第 1 步："words and 987"（当前没有读入字符，因为没有前导空格）
                  ^
         第 2 步："words and 987"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
                  ^
         第 3 步："words and 987"（由于当前字符 'w' 不是一个数字，所以读入停止）
                  ^
         解析得到整数 0 ，因为没有读入任何数字。
         由于 0 在范围 [-231, 231 - 1] 内，最终结果为 0 。
input  : s = "-91283472332"
output : -2147483648
note   : 第 1 步："-91283472332"（当前没有读入字符，因为没有前导空格）
                  ^
         第 2 步："-91283472332"（读入 '-' 字符，所以结果应该是负数）
                   ^
         第 3 步："-91283472332"（读入 "91283472332"）
                              ^
         解析得到整数 -91283472332 。
         由于 -91283472332 小于范围 [-231, 231 - 1] 的下界，最终结果被截断为 -231 = -2147483648 。
```
<!--more-->
### 解题思路
**思路1 借助Long**

+ 1、去空格
+ 2、获取正负号
+ 3、借助stringBuilder获取数字字符
+ 4、删除前缀0
+ 5、长度判断，过长则截取
+ 6、判断是否越界
+ 7、返回结果

**思路2 借助字符串**
+ 1、去空格
+ 2、获取正负号
+ 3、借助stringBuilder获取数字字符
+ 4、删除前缀0
+ 5、借助字符串和int类型整数进行数值转换，提前进行越界判断，对界值进行缩小来和当前值比较，而不是放大当前值去和界值比较，因为会越界。
+ 6、返回结果

### 代码（Java）
**思路1代码**
```java
public class Solution1 {
    public int myAtoi(String s) {
        if (s.length() == 0) {
            return 0;
        }
        // 去空格
        String string = s.trim();
        if (string.length() == 0) {
            return 0;
        }
        int length = string.length();
        // 获取正负号
        int symbol = 1;
        if (string.charAt(0) == '-') {
            symbol = -1;
        }

        int index = 0;
        if (symbol == -1 || string.charAt(0) == '+') {
            index = 1;
        }
        // 获取数字字符
        while (index < length && string.charAt(index) >= '0' && string.charAt(index) <= '9') {
            stringBuilder.append(string.charAt(index));
            index++;
        }
        if (stringBuilder.length() == 0) {
            return 0;
        }
        // 删除前缀0
        int i = 0;
        while (i < stringBuilder.length() && stringBuilder.charAt(i++) == '0') {};
        String input = stringBuilder.toString().substring(i - 1);
        // 长度判断，过长则截取
        long number;
        if (input.length() > 10) {
            number = Long.parseLong(input.substring(0, 11));
        } else {
            number = Long.parseLong(input);
        }
        // 判断是否越界
        if (symbol == 1 && number > ((int) (Math.pow(2, 31)) - 1)) {
            return 2147483647;
        }
        if (symbol == -1 && -number < -((int) (Math.pow(2, 31)) + 1)) {
            return -2147483648;
        }
        return (int) (symbol * number);
    }
}
```
**思路2代码**
```java
public class Solution2 {
    public int myAtoi(String s) {
        if (s.length() == 0) {
            return 0;
        }
        // 去空格
        String string = s.trim();
        if (string.length() == 0) {
            return 0;
        }
        // 获取正负号
        int symbol = 1;
        if (string.charAt(0) == '-') {
            symbol = -1;
        }

        int index = 0;
        if (symbol == -1 || string.charAt(0) == '+') {
            index = 1;
        }

        int length = string.length();
        StringBuilder stringBuilder = new StringBuilder();
        while (index < length && string.charAt(index) >= '0' && string.charAt(index) <= '9') {
            stringBuilder.append(string.charAt(index));
            index++;
        }
        if (stringBuilder.length() == 0) {
            return 0;
        }

        // 去除前导0
        int i = 0;
        while (i < stringBuilder.length() && stringBuilder.charAt(i++) == '0') {};
        String input = stringBuilder.toString().substring(i - 1);

        // 有效数值转换
        int number = 0;
        for (i = 0; i < input.length(); i++) {
            if (symbol == 1 && (number > Integer.MAX_VALUE / 10
                    || (number == Integer.MAX_VALUE / 10 && (input.charAt(i) - '0') > Integer.MAX_VALUE % 10))) {
                return Integer.MAX_VALUE;
            }
            if (symbol == -1 && (number > Integer.MIN_VALUE / (-10)
                    || (number == Integer.MIN_VALUE / (-10) && (input.charAt(i) - '0') > -(Integer.MIN_VALUE % 10)))) {
                return Integer.MIN_VALUE;
            }
            number = number * 10 + (input.charAt(i) - '0');
        }
        return symbol * number;
    }
}
```