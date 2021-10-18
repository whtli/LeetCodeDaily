---
title: LeetCode精选面试题14.最长公共前缀
copyright: true
data: 2021-10-17
toc: true
tags: [Java,LeetCode,字符串]
categories: [LeetCode]
---
### 题目描述
编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
```bash
example
input  : str1 = {"flower","flow","flight"}
output : "fl"
input  : str2 = {"dog","race","car"}
output : ""
```
<!--more-->
### 解题思路
**思路1**
+ 纵向扫描，直接遍历对比。从前向后遍历所有字符串的每一列，比较相同列上的字符是否相同。
如果相同则继续对下一列进行比较，如果不相同则当前列不再属于公共前缀，当前列之前的部分就是最长公共前缀。
```bash
1   2   3   4   5   6
---------------------
f   l   o   w   e   r

f   l   o   w

f   l   i   g   h   t
```
+ 时间复杂度：O(mn)，m是数组中的字符串的平均长度，n是字符串数量。最坏情况下数组中每个字符串的每个字符都会被比较一次。
+ 空间复杂度：O(1)。使用的额外空间复杂度为常数。

**思路2**

+ 分治策略
+ LCP的计算满足结合律
```bash
LCP(S1,……,Sn) = LCP(LCP(S1,……,Sk),LCP(Sk+1,……,Sn))
```
### 代码（Java）
**思路1代码**
```java
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // solution1
        int length = strs[0].length();
        for(int k = 0; k < length; k ++){
            char ch = strs[0].charAt(k);
            for (int i = 1; i < strs.length; i++) {
                if(k == strs[i].length() || strs[i].charAt(k) != ch){
                    return strs[0].substring(0, k);
                }
            }
        }
        return strs[0];
    }
}

public class Main {
    public static void main(String[] args) {
        String[] strings = {"abc","ab", "abd"};
        Solution solution = new Solution();
        String result = solution.longestCommonPrefix(strings);
        System.out.println("result: " + result);
    }
}
```
