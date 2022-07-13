---
title: LeetCode腾讯精选练习50题-054.螺旋矩阵
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
date: 2022-07-13 14:00:00
---


### 题目描述

 * 给定一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。

```bash
example
input  : matrix = [[1,2,3],[4,5,6],[7,8,9]]
output : [1,2,3,6,9,8,7,4,5]

input  : matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
output : [1,2,3,4,8,12,11,10,9,5,6,7]
```

<!--more-->

### 解题思路 按层模拟

+ 按照题目要求的转圈遍历顺序，使用上下左右四个界限坐标来标记每圈的位置，模拟整个向内环绕的元素获取过程。
+ 时间复杂度:O(m×n)
+ 空间复杂度:O(1)

### 代码（Java）
```java
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int length = matrix.length;
        int width = matrix[0].length;
        int left = 0, right = width - 1, top = 0, bottom = length - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            for (int j = top + 1; j <= bottom; j++) {
                list.add(matrix[j][right]);
            }
            if (left < right && top < bottom) {
                for (int p = right - 1; p >= left; p--) {
                    list.add(matrix[bottom][p]);
                }
                for (int q = bottom - 1; q > top; q--) {
                    list.add(matrix[q][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return list;
    }
}
```