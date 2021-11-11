---
title: LeetCode精选TOP面试题056.合并区间
copyright: true
data: 2021-11-11 21:00:00
toc: true
tags: [Java,LeetCode,数组,排序,列表]
categories: [LeetCode]
---
### 题目描述

```bash
example
input  : intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}}
output : {1, 6}, {8, 10}, {15, 18}
input  : intervals = {{1, 4}, {4, 18}}
output : {1, 18}
input  : intervals = {1, 4}, {0, 4}
output : {0, 4}
input  : intervals = {1, 4}, {2, 3}
output : {1, 4}
```
<!--more-->
### 解题思路
**思路1 排序+遍历**

+ 借助Arrays.sort()对原数组进行排序
+ 遍历数组，外层循环
    - 内层循环，对前一个数组元素[left1, right1]的右区间值right1和后一个数组元素[left2, right2]的左区间值left2作比较，若right1 >= left2，则令left1 = right1和right2中值较大的，继续内层循环
    - 每次内层循环结束，将最终的[leftx, rightx]作为新元素赋值到结果数组中

**思路2 列表+排序+遍历**

### 代码（Java）
**思路1代码**
```java
public class Solution {
    public int[][] merge(int[][] intervals) {
        int length = intervals.length;
        int count = 0;
        int[][] result = new int[length][2];
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
                         
        for (int i = 0, j = 1; i < length && j <= length; i = j, j = i + 1) {
            while (j < length && intervals[i][1] >= intervals[j][0]) {
                /* if (intervals[j][1] > intervals[i][1]) {
                    intervals[i][1] = intervals[j][1];
                } */
                intervals[i][1] = Math.max(intervals[j][1] , intervals[i][1]);
                j++;
            }
            // System.out.println(intervals[i][0] + " , " + intervals[i][1]);
            result[count] = intervals[i];
            count++;
        }
        int[][] merged = new int[count][2];
        for (int i = 0; i < count; i++) {
            merged[i] = result[i];
        }
        return merged;
    }
}
```
**思路2代码**
```java

```