---
title: LeetCode精选TOP面试题048.旋转图像.md
copyright: true
data: 2021-11-17 21:00:00
toc: true
tags: [Java,LeetCode,数组,面试]
categories: [LeetCode]
---

### 题目描述
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。
 * 将图像顺时针旋转 90 度。
 * 必须在 原地 旋转图像，这意味着需要直接修改输入的二维矩阵。
 * 不能使用另一个矩阵来旋转图像。
 
```bash
example
input  : matrix = {{1,2,3],[4,5,6],[7,8,9}}
output : matrix = {{7,4,1],[8,5,2],[9,6,3}}
input  : matrix = {{5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16}}
output : matrix = {{15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11}}
```

<!--more-->

### 解题思路
**思路1 两次翻转**
+ 按照n×n数组的翻转规律
+ 先按照主对角线镜像翻转，再按照水平反转（或者先水平后镜像也可以）
+ 翻转两次后就是目标数组

**思路2 原地旋转**
+ 每个数组元素，在该数组中会有另外三个元素与其对应，组成一个圈
+ 若把所有的四个数字组成的圈，都完成90°旋转，就可以形成整个数组的旋转
+ 遍历二维数组，按照数组元素排列规律，对同一个圈内的四个元素按照顺时针顺序进行数值覆盖，即完成了一个圈的旋转
+ 遍历结束后即可完成整个数组的顺时针90°旋转

### 代码（Java）
**思路1代码**
```java
public class Solution1 {
    public void rotate(int[][] matrix) {

        int length = matrix.length;

        // 查看原数组
        /*for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();*/

        // 主对角线翻转
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        
        // 查看主对角线翻转后的数组
        /*for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();*/

        // 水平翻转
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][length - j - 1];
                matrix[i][length - j - 1] = tmp;
            }
        }

        // 查看结果数组
        /*for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }*/
    }
}

```
**思路2代码**
```java
public class Solution2 {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        // 查看原数组
        /*for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();*/

        // 转圈赋值
        for (int i = 0; i < length / 2; i++) {
            for (int j = 0; j < (length + 1) / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[length - j - 1][i];
                matrix[length - j - 1][i] = matrix[length - i - 1][length - j - 1];
                matrix[length - i - 1][length - j - 1] = matrix[j][length - i - 1];
                matrix[j][length - i - 1] = tmp;
            }
        }

        // 查看结果数组
        /*for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();*/
    }
}
```