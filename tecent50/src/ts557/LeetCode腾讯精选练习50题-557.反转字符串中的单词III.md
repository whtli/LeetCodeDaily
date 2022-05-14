---
title: LeetCode腾讯精选练习50题-557.反转字符串中的单词III
copyright: true
toc: true
tags:
  - Java
  - LeetCode
  - 字符串
categories:
  - LeetCode
date: 2022-05-13 21:00:00
---


### 题目描述
 * 给定一个字符串 s ，需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

```bash
example
input  : s = "Let's take LeetCode contest"
output : "s'teL ekat edoCteeL tsetnoc"
```

<!--more-->

### 解题思路
+ 把原字符串按空格分割为多个字符串
+ 借助StringBuilder的reverse()方法实现所有子字符串的反转
+ 然后把每个反转后的字符串拼接到一起，拼接时需注意添加空格
+ 返回拼接结果即可。

### 代码（Java）
```java
public class Solution {
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < strs.length; i++) {
            StringBuilder t = new StringBuilder(strs[i]);
            sb.append(t.reverse().append(" "));
        }
        // 循环得到的结果，末尾会多出一个空格，所以返回的结果需要把它截取掉
        return sb.substring(0, s.length());
    }
}
```