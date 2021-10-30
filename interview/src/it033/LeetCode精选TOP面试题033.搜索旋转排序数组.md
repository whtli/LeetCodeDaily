---
title: LeetCode精选TOP面试题033.搜索旋转排序数组
copyright: true
data: 2021-10-30 21:00:00
toc: true
tags: [Java,LeetCode,数组,二分查找,面试]
categories: [LeetCode]
---
### 题目描述

整数数组 nums 按升序排列，数组中的值 互不相同 。
在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。

给定 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。

```bash
example
input  : nums = {4,5,6,7,0,1,2}, target = 0
output : 4
input  : nums = {4,5,6,7,0,1,2}, target = 3
output : -1
input  : nums = {3,1}, target = 1
output : 1
input  : nums = {1}, target = 0
output : -1
```
<!--more-->
### 解题思路
**思路 二分查找**
+ 先找到数组旋转后的分界线，即前后两个有序数组的分界线
+ 根据 target 的大小，决定在左侧有序数组还是右侧有序数组进行二分查找
+ 执行二分查找确定目标位置

### 代码（Java）
**代码**
```java
public class Solution {
    public int search(int[] nums, int target) {
        int div = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                div = i;
                break;
            }
        }
        // System.out.println(div);
        // 二分查找
        int left, right;
        int length = nums.length;
        if (nums[div] >= target && nums[0] <= target) {
            left = 0;
            right = div;
        } else if (nums[length - 1] >= target) {
            left = div + 1;
            right = length - 1;
        } else {
            return -1;
        }
        // System.out.println(left + "," + right);
        while (left <= right) {
            // 防止溢出，通常可写作 middle = (right + left) / 2
            int middle = (right - left) / 2 + left;
            if (target == nums[middle] && left <= right) {
                return middle;
            }
            if (target > nums[middle] && left <= right) {
                left = middle + 1;
            } else if (target < nums[middle] && left <= right) {
                right = middle - 1;
            }
        }
        return -1;
    }
}
```
