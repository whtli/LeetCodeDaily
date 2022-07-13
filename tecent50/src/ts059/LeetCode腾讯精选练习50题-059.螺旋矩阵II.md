---
title: LeetCode腾讯精选练习50题-059.螺旋矩阵II
copyright: true
toc: true
tags:
  - Java
  - LeetCode
  - 数组
  - 矩阵
  - 模拟
categories:
  - LeetCode
date: 2022-07-13 12:00:00
---


### 题目描述

 * 给定一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。

```bash
example
input  : n = 3
output : [[1,2,3],[8,9,4],[7,6,5]]

input  : n = 1
output : [[1]]
```

<!--more-->

### 解题思路 按层模拟

+ 按照题目要求的转圈填充顺序，使用上下左右四个界限坐标来标记每圈的位置，模拟整个向内环绕的填充过程。
+ 时间复杂度:O(n^2)
+ 空间复杂度:O(1)

### 代码（Java）
```java
public class Solution {
    public int[][] generateMatrix(int n) {
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int[][] matrix = new int[n][n];
        int c = 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = c++;
            }
            for (int j = top + 1; j <= bottom; j++) {
                matrix[j][right] = c++;
            }
            for (int p = right - 1; p >= left; p--) {
                matrix[bottom][p] = c++;
            }
            for (int q = bottom - 1; q > top; q--) {
                matrix[q][left] = c++;
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return matrix;
    }
}
```