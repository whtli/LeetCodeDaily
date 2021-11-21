---
title: LeetCode精选TOP面试题287.寻找重复数
copyright: true
data: 2021-11-21 21:00:00
toc: true
tags: [Java,LeetCode,双指针,哈希,数组]
categories: [LeetCode]
---

### 题目描述

 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
 * 解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。
 * 提示：
 * 1 <= n <= 105
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次
 *
 * 进阶：
 * 如何证明 nums 中至少存在一个重复的数字?
 * 设计一个线性级时间复杂度 O(n) 的解决方案
 
```bash
example
input  : nums = {1,3,4,2,2}
output : 2
input  : nums = {3,1,3,4,2}
output : 3
input  : nums = {1,1,2}
output : 1
```

<!--more-->

### 解题思路


**思路1: HashSet**
+ 借助 HashSet 存储数组元素，便于查重
+ 遍历数组，假设当前遍历的元素为 item
    * 若 item 不存在于 HashSet 中，则将其添加进 HashSet
    * 若 item 存在于 HashSet 中，直接返回 item
    
**思路2: 双指针**
+ 待更新

### 代码（Java）
**思路1代码**
```java
public class Solution1 {
    public int findDuplicate(int[] nums) {

        HashSet hashSet = new HashSet();
        for (int item : nums) {
            if (hashSet.contains(item)) {
                return item;
            }
            hashSet.add(item);
        }
        return 0;
    }
}
```
**思路2代码**
```java

```