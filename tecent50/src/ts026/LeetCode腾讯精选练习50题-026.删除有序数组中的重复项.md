---
title: LeetCode腾讯精选练习50题-26.删除有序数组中的重复项
copyright: true
toc: true
tags:
  - Java
  - LeetCode
  - 数组
  - 双指针
categories:
  - LeetCode
date: 2022-05-04 15:00:00
---


### 题目描述

 * 给定一个 升序排列 的数组 nums，原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。
 * 更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个元素应该保存最终结果。
 * 将最终结果插入 nums 的前 k 个位置后返回 k 。
 * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

```bash
example
input  : nums = [1,1,2]
output : 2, nums = [1,2,_]
input  : nums = [0,0,1,1,1,2,2,3,3,4]
output : 5, nums = [0,1,2,3,4]
```

<!--more-->

### 解题思路
+ 双指针，一前一后，前fast，后slow
+ fast位置与slow位置的元素值不同时，slow前进，然后修改前进后slow位置的元素值，将其赋值为当前fast位置的元素值。
+ 当fast遍历到数组末尾时，返回slow在数组中的位置即可。

### 代码（Java）
```java
public class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 1;
        while (fast < nums.length) {
            if (nums[fast] == nums[slow]) {
                fast++;
            } else {
                nums[++slow] = nums[fast++];
            }
        }
        return slow + 1;
    }
}
```