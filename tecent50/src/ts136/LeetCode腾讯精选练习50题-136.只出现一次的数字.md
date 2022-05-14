---
title: LeetCode腾讯精选练习50题-136.只出现一次的数字
copyright: true
toc: true
tags:
  - Java
  - LeetCode
  - 数组
  - 位运算
  - 排序
categories:
  - LeetCode
date: 2022-05-06 14:00:00
---

### 题目描述

 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 算法应该具有线性时间复杂度。 可以不使用额外空间来实现吗？

```bash
example
input  : nums = {2,1,2}
output : 1
input  : nums = {4,3,2,3,2}
output : 4
```

<!--more-->

### 解题思路
**思路1 借助排序**
+ 先排序
+ 遍历排序后的数组，遍历步长设为2
+ 若当前位置元素 nums[i] 和其后相邻元素nums[i+1]不想等，则返回当前位置元素
+ 时间复杂度O(n * log(n))，排序时间复杂度为O(n * log(n))
+ 空间复杂度O(1)

**思路2 位运算**
+ 异或运算（符号表示：^=）可知：1 ^= 0 = 1, 0 ^= 1 = 1, 1 ^= 1 = 0, 0 ^= 0 = 0
+ 异或运算的性质：
    - 一个数异或其本身，结果为0，a ^= a 等于0
    - 一个数异或0，结果为其本身，a ^= 0 等于a
+ 由上述性质和数组的特点（除了某个元素只出现一次以外，其余每个元素均出现两次）可知，数组中所有元素的异或结果，必然是那个只出现一次的数值
+ 因此只需要遍历一次数组，对所有的元素做异或操作，最终返回异或的结果即可。

### 代码（Java）
**思路1代码**
```java
public class Solution1 {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }
}
```
**思路2代码**
```java
public class Solution2 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i : nums) {
            result ^= i;
        }
        return result;
    }
}
```