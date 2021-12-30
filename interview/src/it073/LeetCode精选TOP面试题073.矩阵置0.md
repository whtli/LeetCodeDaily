---
title: LeetCode精选TOP面试题073.矩阵置零
copyright: true
toc: true
tags:
  - Java
  - LeetCode
  - 数组
  - 矩阵
categories:
  - LeetCode
date: 2021-12-30 18:00:00
---

### 题目描述

+ 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素原地都设为 0 。

```bash
example
input  : matrix = [[1,1,1],[1,0,1],[1,1,1]]
output : [[1,0,1],[0,0,0],[1,0,1]]
input  : matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
output : [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
```

<!--more-->

### 解题思路
**思路1 辅助标记**

+ 定义两个标记变量，记录第一行、第一列是否初始时就存在0
+ 以第一行和第一列作为该行/列是否存在0的标记空间
+ 首先遍历第一行，若第一行初始就存在0，则置标记flagRow = true
+ 然后遍历第一列，若第一列初始就存在0，则置标记flagCol = true
+ 然后遍历数组中除了第一行和第一列之外的部分，若matrix[i][j] = 0，则置为该元素对应行、列的首元素为0，即令 matrix[i][0] = matrix[0][j] = 0
+ 遍历数组中除了第一行和第一列之外的部分，若某元素matrix[i][j]对应行的首元素和该元素对应列的首元素均为0，即matrix[i][0] = matrix[0][j] = 0，则置matrix[i][j]=0
+ 检查标记flagRow，若flagRow = true，则将首行元素全部置为0
+ 检查标记flagCol，若flagCol = true，则将首列元素全部置为0
+ 单独标记和遍历首行和首列元素，可能会导致不必要的置0操作，将不应该置为0的元素也置0了
+ 空间复杂度 O(1)

**思路2 辅助数组**

+ 定义两个标记数组flagRow[matrix.length]、flagCol[matrix[0].length]，分别记录发现0的行列位置
+ 当某元素 matrix[i][j] = 0 时，置对应的行列标记数组中的元素为0，即flagRow[i] = flagCol[j] = true
+ 遍历整个二维数组，以遍历到元素 matrix[i][j] 为例，当行 / 列标记数组对应位置元素值为 true 时，证明当前元素位于需要被全部置为0的 行 / 列，将该元素置为0，即matrix[i][j] = 0
+ 空间复杂度O(m + n)

### 代码（Java）
**思路1代码**
```java
public class Solution1 {
    public void setZeroes(int[][] matrix) {
        boolean flagRow = false;
        boolean flagCol = false;
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                flagRow = true;
            }
        }
        for (int j = 0; j < matrix.length; j++) {
            if (matrix[j][0] == 0) {
                flagCol = true;
            }
        }
        System.out.println("flagRow : " + flagRow);
        System.out.println("flagCol : " + flagCol);

        System.out.println("set flag---------");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t          ");
            }
            System.out.println();
        }

        System.out.println("set zero---------");
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t          ");
            }
            System.out.println();
        }

        System.out.println("judge first ---------");
        if (flagRow) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
        if (flagCol) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][0] = 0;
            }
        }

    }
}
```
**思路2代码**
```java
public class Solution2 {
    // 辅助数组
    public void setZeroes(int[][] matrix) {
        boolean[] flagRow = new boolean[matrix.length];
        boolean[] flagCol = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    flagRow[i] = true;
                    flagCol[j] = true;
                }
            }
        }

        System.out.println("set zero---------");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (flagRow[i] || flagCol[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

```