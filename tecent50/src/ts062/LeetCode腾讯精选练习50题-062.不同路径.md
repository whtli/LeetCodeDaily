---
title: LeetCode腾讯精选练习50题-062.不同路径
copyright: true
toc: true
tags:
  - Java
  - LeetCode
  - 动态规划
  - 数学
categories:
  - LeetCode
date: 2022-09-23 21:00:00
---


### 题目描述

 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？

```bash
example
input  : m = 3, n = 2
output : 3
note   : 从左上角开始，总共有 3 条路径可以到达右下角。
         1. 向右 -> 向下 -> 向下
         2. 向下 -> 向下 -> 向右
         3. 向下 -> 向右 -> 向下

input  : m = 7, n = 3
output : 28
```

<!--more-->

### 解题思路

##### 思路1 动态规划
+ 这是一个标准的动态规划问题，可以完成状态转移
+ 转移方程：dp[i][j] = dp[i-1][j] + dp[i][j-1]
+ 因为只能向右或向下移动，所以：
    - 对于第一行和第一列的所有格子，都有且仅有一条路径可以直达其位置
    - 对于非第一行或非第一列的格子，`到达其位置的路径数` = `到达其上方格子的路径数`+`到达其左方格子的路径数`
+ 绘制网格图后，可以通过举例测试确定上述规律

+ 时间复杂度:O(m x n)
+ 空间复杂度:O(m x n)
##### 思路2 组合数学
从左上角到右下角的过程中，需要移动 m+n-2 次，其中有 m-1 次向下移动，n-1 次向右移动。
因此路径的总数，就等于从 m+n-2 次移动中选择 m-1 次向下移动的方案数，即组合数：

C = (m + n - 2)! / (m - 1)! * (n - 1)!
因此直接计算出这个组合数即可。
化简可得：C = (m + n - 2) * (m + n - 3) * ··· * n / (m - 1)!
 
+ 时间复杂度:O(m)
+ 空间复杂度:O(1)


### 代码（Java）
**思路1代码**
```java
public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] pathNum = new int[m][n];
        /*
        for (int j = 0; j < n; j++) {
            pathNum[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            pathNum[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                pathNum[i][j] = pathNum[i - 1][j] + pathNum[i][j - 1];
            }
        }
        */

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    pathNum[i][j] = 1;
                } else {
                    pathNum[i][j] = pathNum[i - 1][j] + pathNum[i][j - 1];
                }

            }
        }
        /* 打印动态规划得到的二维数组
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(pathNum[i][j] + "\t");
            }
            System.out.println();
        }
        */
        return pathNum[m - 1][n - 1];
    }
}
```
**思路2代码**
```java
public class Solution2 {
    public int uniquePaths(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; x++, y++) {
            // x和y同时前进 m - 2 次，刚好满足化简后的公式
            ans = ans * x / y;
        }
        return (int) ans;
    }
}
```