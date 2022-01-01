---
title: LeetCode精选TOP面试题454.四数相加II
copyright: true
toc: true
tags:
  - Java
  - LeetCode
  - 数组
  = 哈希表
categories:
  - LeetCode
date: 2022-01-01 23:00:00
---


### 题目描述

 * 给定四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请计算有多少个元组 (i, j, k, l) 能满足：
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0

```bash
example
input  : nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
output : 2
note   : 两个元组如下：
         1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
         2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
input  : nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
output : 1
```

<!--more-->

### 解题思路
**思路**

+ 将四个数组分成两部分 A 和 B 为一组，C 和 D 为另外一组。
+ 对于 A 和 B，使用二重循环对它们进行遍历，得到所有 A[i]+B[j] 的值并存入哈希映射中，每个键表示一种 A[i]+B[j]，对应的值为 A[i]+B[j] 出现的次数。
+ 对于 C 和 D，使用二重循环对它们进行遍历，当遍历到 C[k]+D[l] 时，如果 -(C[k]+D[l]) 出现在哈希映射中，那么将 -(C[k]+D[l]) 对应的值累加进答案中。
+ 最终即可得到满足 A[i]+B[j]+C[k]+D[l]=0 的四元组数目
+ 时间复杂度O(n^2)，二重循环
+ 空间复杂度O(n^2)，最坏的情况下，A[i]+B[j] 的值均不相同，因此值的个数为 n^2

### 代码（Java）
```java
public class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int result = 0;
        Map<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                hashmap.put(num1 + num2, hashmap.getOrDefault(num1 + num2, 0) + 1);
            }
        }
        for (int num3 : nums3) {
            for (int num4 : nums4) {
                if (hashmap.containsKey(- num3 - num4)) {
                    result += hashmap.get(- num3 - num4);
                }
            }
        }
        return result;
    }
}

```
