---
title: LeetCode精选TOP面试题53.最大子序和
copyright: true
data: 2020-05-24 18:02:00
toc: true
tags: [Java,动态规划,贪心算法,LeetCode,面试]
categories: [LeetCode]
---
### 题目描述
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
```bash
example:
input : -2,1,-3,4,-1,2,1,-5,4
output: 6
note  : 连续子数组 [4,-1,2,1] 的和最大，为 6
```
<!--more-->
### 解题思路
**思路1**

动态规划 -- 时间复杂度O(N), 空间复杂度O(1)
- （1）从下标1开始遍历数组，当前元素item的前一个元素pre若大于0，则item更新为item+pre，否则继续遍历。
- （2）在遍历过程中比使用Math.max(max, item)函数对比当前最大值和item值的大小以确定最终的最大和。
**思路2**

贪心算法 -- 时间复杂度O(N), 空间复杂度O(1)
- 若当前元素之前的元素序列之和小于0，则舍弃这个“和”
- 定义temp用于比较“当前元素”与“当前元素之前的元素序列之和”谁更大
**思路3**

分治法 -- 时间复杂度O(N), 空间复杂度O(logN)
这个思路是查看官方题解才了解的，并不是最优的算法，最优算法依然是动态规划，但是并没有理解透彻，所以就不在这里做不准确的解释了。详细内容请到[Leetcode官方题解](https://leetcode-cn.com/problems/maximum-subarray/solution/zui-da-zi-xu-he-by-leetcode-solution/)中学习。

### 代码（Java）
**思路1代码**
```java
public class Solution2 {
    public int maxSubArray(int[] nums){
        int max = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (nums[i-1] > 0){
                nums[i] += nums[i-1];       // 当前元素item[i]的前驱元素item[i-1]>0,更新当前元素的值
            }
            max = Math.max(nums[i], max);   // 确定目前为止的最大值
        }

        return max;
    }
}
```
**思路2代码**
```java
public class Solution {
    public int maxSubArray(int[] nums){
        int temp = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++){
            temp = Math.max(nums[i], temp + nums[i]); // 等价于比较“当前元素”与“当前元素之前的元素序列之和”谁更大
                                                      // temp = Math.max(0, temp);
            max = Math.max(temp, max);                // 确定临时最大值
        }
        return max;
    }
}
```