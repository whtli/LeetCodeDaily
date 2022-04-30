---
title: LeetCode腾讯精选练习50题-14.最长公共前缀
copyright: true
toc: true
tags:
  - Java
  - LeetCode
  - 字符串
categories:
  - LeetCode
date: 2022-04-30 20:00:00
---


### 题目描述

 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成

```bash
example
input  : strs = ["flower","flow","flight"]
output : "fl"
input  : strs = ["dog","racecar","car"]
output : ""
note   : 不存在公共前缀
```

<!--more-->

### 解题思路
**思路1**
+ 纵向遍历
+ 双重循环，同步对比数组中所有字符串的相同位置的字符
+ 有不同时（或者某一字符串结束时），就可以最长公共前缀。
+ 时间复杂度：O(mn)，其中 m 是字符串数组中的字符串的平均长度，n 是字符串数组的长度。最坏情况下，字符串数组中的每个字符串的每个字符都会被比较一次。
+ 空间复杂度：O(1)

**思路2**
+ 横向遍历
+ 初始将结果定义 result 为字符串数组的第一个元素
+ 遍历数组，对比之后的每一个元素，与当前 result 的公共前缀，并将 result 更新为当前能得到的最长公共前缀
+ 遍历结束时，result 中存放的就是数组中所有元素的最长公共前缀
+ 时间复杂度：O(mn)，其中 m 是字符串数组中的字符串的平均长度，n 是字符串数组的长度。最坏情况下，字符串数组中的每个字符串的每个字符都会被比较一次。
+ 空间复杂度：O(1)

**思路3**
+ 时间复杂度：O(mn)，其中 m 是字符串数组中的字符串的平均长度，n 是字符串数组的长度。最坏情况下，字符串数组中的每个字符串的每个字符都会被比较一次。
+ 空间复杂度：O(1)
+ 排序，取巧的方法
+ 把字符串数组排序后，只取第一个和最后一个字符串进行比较，找的两者的公共前缀，就是整个字符串数组的公共前缀。
+ O(n logn)，排序的时间复杂度。
+ 空间复杂度：O(1)

### 代码（Java）
**思路1代码**
```java
public class Solution1 {
    public String longestCommonPrefix(String[] strs) {
        int minLen = 201;
        for (String s : strs) {
            if (s.length() < minLen) {
                minLen = s.length();
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < minLen; i++) {
            char ch = strs[0].charAt(i);
            boolean flag = true;
            for (String s : strs) {
                if (ch != s.charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                break;
            }
            res.append(ch);

        }
        return res.toString();
        /*
        StringBuilder res = new StringBuilder(strs[0]);
        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            for (String s : strs) {
                if (i == s.length() || ch != s.charAt(i)) {
                    return res.substring(0, i);
                }
            }
        }
        return res.toString();
        */
    }
}
```
**思路2代码**
```java
public class Solution2 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder(strs[0]);
        for (int i = 1; i < strs.length; i ++) {
            int len = strs[i].length();
            if (len < res.length()) {
                res.replace(len, res.length(), "");
            }
            for (int j = 0; j < len; j ++){
                if (j >= res.length()) {
                    break;
                }
                if (res.charAt(j) != strs[i].charAt(j)) {
                    res.replace(j, len, "");
                    break;
                }
            }
        }
        return res.toString();
    }
}
```
**思路3代码**
```java
public class Solution3 {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        StringBuilder res = new StringBuilder(strs[0]);
        for (int i = 0; i < strs[0].length() && i < strs[strs.length - 1].length(); i++) {
            if (strs[0].charAt(i) != strs[strs.length - 1].charAt(i)) {
                res.replace(i, res.length(), "");
                break;
            }
        }
        return res.toString();
    }
}
```