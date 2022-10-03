---
title: LeetCode腾讯精选练习50题-011.盛水最多的容器
copyright: true
toc: true
tags:
  - Java
  - LeetCode
  - 双指针
  - 贪心
  - 数组
categories:
  - LeetCode
date: 2022-10-03 11:00:00
---


### 题目描述
+ 给定一个长度为 n 的整数数组 height 。
+ 有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
+ 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
+ 返回容器可以储存的最大水量。
+ 说明：不能倾斜容器。

```bash
example
input  : [1,8,6,2,5,4,8,3,7]
output : 49

input  : [1,1]
output : 1

input  : [4, 4, 2, 11, 0, 11, 5, 11, 13, 8]
output : 55
```

<!--more-->

### 解题思路
+ 双指针+贪心

+ 双指针指向高度数组的首尾两端
+ 容器的面积取决于`左右两指针之间的横向距离差` 和 `左右两指针指向的数字中的较小值`
+ 如果向内移动指向的数字较大的那个指针，那么前者`左右两指针指向的数字中的较小值`不会增加（会不变或者变小），后者`左右两指针之间的横向距离差`会减小，则两者乘积会减小。
+ 因此，移动数字较大的那个指针是不合理的
+ 若想提高容量，能做的就是向内移动高度较小的指针（期望获得更高的高度），并比较移动后的容量是否大于当前最大容量


+ 时间复杂度:O(n)
+ 空间复杂度:O(1)

### 代码（Java）
```java
public class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(area, maxArea);
            if (height[left] >= height[right]) {
                right--;
            } else {
                left++;

            }
        }
        return maxArea;
    }
}
```