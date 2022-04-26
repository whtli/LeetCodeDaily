---
title: LeetCode其他-1629.按键持续时间最长的键
copyright: true
toc: true
tags:
  - Java
  - LeetCode
  - 数组
  - 字符串
  - 其他
categories:
  - LeetCode
date: 2022-04-26 23:00:00
---


### 题目描述

* LeetCode 设计了一款新式键盘，正在测试其可用性。
* 测试人员将会点击一系列键（总计 n 个），每次一个。
* 给你一个长度为 n 的字符串 keysPressed ，其中 keysPressed[i] 表示测试序列中第 i 个被按下的键。
* releaseTimes 是一个升序排列的列表，其中 releaseTimes[i] 表示松开第 i 个键的时间。
* 字符串和数组的 下标都从 0 开始 。第 0 个键在时间为 0 时被按下，接下来每个键都 恰好 在前一个键松开时被按下。
* 测试人员想要找出按键 持续时间最长 的键。
* 第 i 次按键的持续时间为 releaseTimes[i] - releaseTimes[i - 1] ，第 0 次按键的持续时间为 releaseTimes[0] 。
* 注意，测试期间，同一个键可以在不同时刻被多次按下，而每次的持续时间都可能不同。
* 请返回单次按键 持续时间最长 的键，如果有多个这样的键，则返回 按字母顺序排列最大 的那个键。
  
```bash
example
input  : releaseTimes = [9,29,49,50], keysPressed = "cbcd"
output : 'c'
note   : 按键顺序和持续时间如下：
         按下 'c' ，持续时间 9（时间 0 按下，时间 9 松开）
         按下 'b' ，持续时间 29 - 9 = 20（松开上一个键的时间 9 按下，时间 29 松开）
         按下 'c' ，持续时间 49 - 29 = 20（松开上一个键的时间 29 按下，时间 49 松开）
         按下 'd' ，持续时间 50 - 49 = 1（松开上一个键的时间 49 按下，时间 50 松开）
         按键持续时间最长的键是 'b' 和 'c'（第二次按下时），持续时间都是 20
         'c' 按字母顺序排列比 'b' 大，所以答案是 'c'
input  : releaseTimes = [12,23,36,46,62], keysPressed = "spuda"
output : 'a'
```

<!--more-->

### 解题思路

+ 一次遍历，对比并记录最大持续时间，同时按字母序要求更新对应的字符即可
+ 时间复杂度：O(n)
+ 空间复杂度：O(1)

### 代码（Java）
**代码1**
```java
public class Solution1 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        char resKey = keysPressed.charAt(0);
        int maxTime = releaseTimes[0];
        int len = releaseTimes.length;
        for (int i = 1; i < len; i++) {
            int time = releaseTimes[i] - releaseTimes[i - 1];
            // if的后半段，比较当前字符与当前最长持续时间字符的字母序大小的时候
            // 为了美观可以提前把当前字符定义在if前面，然后放到if的后半段比较，但是这样会浪费测试时间
            // 测试结果表明，提前定义运行时间为1s，不定义运行时间为0s
            // 用到的时候才比较字母序，取当前字符，用不到的时候提前定义就是浪费资源
            if (time > maxTime || (time == maxTime && keysPressed.charAt(i) > resKey)) {
                resKey = keysPressed.charAt(i);
                maxTime = time;
            }
        }
        return resKey;
    }
}
```
**代码2**
```java
public class Solution2 {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int resKey = 0;
        int maxTime = releaseTimes[0];
        int len = releaseTimes.length;
        for (int i = 1; i < len; i++) {
            int time = releaseTimes[i] - releaseTimes[i - 1];
            int sub = keysPressed.charAt(i) - keysPressed.charAt(resKey);
            if (time > maxTime || (time == maxTime && sub > 0)) {
                resKey = i;
                maxTime = time;
            }
        }
        return keysPressed.charAt(resKey);
    }
}
```