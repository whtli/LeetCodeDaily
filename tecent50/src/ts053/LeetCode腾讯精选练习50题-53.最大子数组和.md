---
title: LeetCode腾讯精选练习50题-53.最大子数组和
copyright: true
toc: true
tags:
  - Java
  - LeetCode
  - 数组
  - 动态规划
categories:
  - LeetCode
date: 2022-05-15 14:00:00
---

### 题目描述

 * 给定一个整数数组 nums ，请找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。

```bash
example
input  : nums = [-2,1,-3,4,-1,2,1,-5,4]
output : 6
input  : nums = [1]
output : 1
```

<!--more-->

### 解题思路 动态规划
+ 

### 代码（Java）
```java
public class Solution {
    public int maxSubArray(int[] nums) {
        int pre = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] + pre > nums[i]) {
                nums[i] = nums[i] + pre;
            }
            pre = nums[i];
            if (max < nums[i]) {
                max = nums[i];
            }
        }
//        for (int i = 0; i < nums.length; i++){
//            System.out.print(nums[i]+ " ");
//        }
//        System.out.println();
        return max;
    }
    
    public int maxSubArray2(int[] nums) {
        int pre = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(nums[i] + pre, nums[i]);
            max = Math.max(pre, max);
        }
        return max;
    }
}

```