---
title: LeetCode精选TOP面试题344.反转字符串
copyright: true
toc: true
tags:
  - Java
  - LeetCode
  - 字符串
  - 双指针
  - 递归
categories:
  - LeetCode
date: 2022-04-13 21:00:00
---


### 题目描述

 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * 不要给另外的数组分配额外的空间，必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。

```bash
example
input  : s = ["h","e","l","l","o"]
output : ["o","l","l","e","h"]
input  : s = ["H","a","n","n","a","h"]
output : ["h","a","n","n","a","H"]
```

<!--more-->

### 解题思路
**思路1 双指针**

+ 左右同时向内遍历
+ 遍历的同时交换左右指针的元素值
+ 时间复杂度：O(n)，其中 n 为字符数组的长度，只需要执行n/2次交换即可完成反转
+ 空间复杂度：O(1)，只使用了常数空间来存放若干变量

**思路2 递归**
+ 递归需要使用栈空间，所以用递归不符合题目的空间复杂度要求
+ 还是双指针的路子，只不过换成了递归的写法
+ 初始传参为：数组s，left = 0，right = s.length - 1
+ 递归的退出边界：left >= right
+ 交换left和right位置处的元素值
+ 递归调用，参数为 数组s，++left，--right；即左右指针向内移动，进行下一次交换
+ 时间复杂度：O(n)
+ 空间复杂度：O(n)

### 代码（Java）
**思路1代码**
```java
public class Solution1 {
    public void reverseString(char[] s) {
        int len = s.length;
        if (len == 0) {
            return;
        }
        int i = 0;
        while (i < len / 2) {
            char temp = s[i];
            s[i] = s[len - i - 1];
            s[len - i - 1] = temp;
            i ++;
        }
    }
}
```
**思路2代码**
```java
public class Solution2 {
    public void reverseString(char[] s) {
        int len = s.length;
        if (len == 0) {
            return;
        }
        loop(s, 0, len - 1);
    }

    private void loop(char[] s, int left, int right) {
        if (left >= right) {
            return;
        }

        char tmp = s[left];
        s[left] = s[right];
        s[right] = tmp;

        loop(s, ++left, --right);
    }
}
```