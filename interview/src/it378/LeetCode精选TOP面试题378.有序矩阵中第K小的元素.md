---
title: LeetCode精选TOP面试题378.有序矩阵中第 K 小的元素
copyright: true
toc: true
tags:
  - Java
  - LeetCode
  - 矩阵
  - 数组
  - 排序
  - 二分查找
categories:
  - LeetCode
date: 2022-01-14 21:00:00
---

### 题目描述

 * 给定一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。

```bash
example
input  : matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
output : 13
input  : matrix = [[-5]], k = 1
output : -5
```

<!--more-->

### 解题思路
**思路1 排序**


+ 将二维数组转换为一维数组
+ 对一维数组进行排序
+ 第k小的元素即一维数组中第k个元素，下标为k-1


**思路2 二分查找**

+ 因为二维数组在行和列方向上都是递增的，因此，第k小的元素的 左上方，都是小于或等于它的元素
+ 即，假设 target 是矩阵中第k小的元素，则矩阵中有 k 个元素是小于或等于target的，这些元素在矩阵中的位置，都处于target的左上方
+ 利用数组的行列递增性质，实现二分查找定位
    - 初始选中左上角元素和右下角元素作为区间两端，即left = matrix[0][0]，right = matrix[n - 1][n - 1]，则 mid = (left + right) / 2
    - 可知矩阵中其他元素x都满足：left < x < right
    - ⭐从左下角开始，统计矩阵中值小于或等于mid的元素个数 count ，此时的mid就可以看作target，当count = k时，说明有k个小于或等于mid的元素，此时的mid就是结果
    - 利用数组性质完成count的计数
        - 当前元素 matrix[i][j] <= mid 时，count 累加 i - 1，因为该行上面的所有行，在这第j列的值都小于mid，然后令j右移，扩大搜索范围
        - 当前元素 matrix[i][j] > mid 时，说明当前元素在mid的右下角矩阵中，令i上移，缩小所搜范围
    - 当 count < k 时，说明有 不足k个 不大于mid的元素，即第k小的元素位于 mid 右下方的矩阵中，令left = mid + 1
    - 当 count >= k 时，说明有 超过（或刚好）k个 不大于mid的元素，即第k小的元素位于 mid 左上方的矩阵中，令right = mid
    - 当 left = right 时，代表 mid 就是要找的第k小的元素target（同⭐）


### 代码（Java）
**思路1代码**
```java
public class Solution1 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int[] array = new int[n * n];
        int t = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[t++] = matrix[i][j];
            }
        }
        Arrays.sort(array);
        return array[k - 1];
    }
}
```
**思路2代码**
```java
public class Solution2 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            int count = findSmaller(matrix, mid, n);
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    private int findSmaller(int[][] matrix, int mid, int n) {
        int count = 0;
        int i = n - 1;
        int j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                count += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return count;
    }
}
```