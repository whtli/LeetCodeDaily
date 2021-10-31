---
title: LeetCode精选TOP面试题034.在排序数组中查找元素的第一个和最后一个位置
copyright: true
data: 2021-10-XX 21:00:00
toc: true
tags: [Java,LeetCode,]
categories: [LeetCode]
---
### 题目描述
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
```bash
example
input  : nums = {5,7,7,8,8,10}, target = 8
output : {3,4}
input  : nums = {5,7,7,8,8,10}, target = 6
output : {-1,-1}
input  : nums = {}, target = 0
output : {-1,-1}
```
<!--more-->
### 解题思路

**思路1 二分查找**
+ 第一个位置是找nums[i] >= target
+ 最后一个位置是找nums[i] > target
+ 时间复杂度O(log n)

**思路2 双指针**
+ 双向遍历，向中间收缩
+ 第一个位置找第一个不小于 target 的元素下标
+ 最后一个位置找第一个不大于 target 的元素下标
+ 时间复杂度O(n)

### 代码（Java）
**思路1代码**
```java
public class Solution1 {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) {
            return new int[]{-1, -1};
        }
        int left = findIndex(nums, target);
        int right = findIndex(nums, target + 1) - 1;
        if (left > right) {
            return new int[]{-1, -1};
        }
        return new int[]{left, right};
    }

    private int findIndex(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            // System.out.println(left + " , " + right);
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
```
**思路2代码**
```java
public class Solution2 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int length = nums.length;
        if (nums.length == 0 || target < nums[0] || target > nums[length - 1]) {
            return result;
        }
        int left = 0, right = length - 1;
        while (nums[left] < target) {
            left++;
        }
        if (nums[left] == target) {
            result[0] = left;
        }

        while (nums[right] > target) {
            right--;
        }
        if (nums[right] == target) {
            result[1] = right;
        }
        // 执行到此处，若left为-1，说明数组中没有target元素，则right一定为-1，不需要额外的判断了。
        return result;
    }
}
```