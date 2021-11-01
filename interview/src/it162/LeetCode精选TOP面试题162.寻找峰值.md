---
title: LeetCode精选TOP面试题162.寻找峰值
copyright: true
data: 2021-11-01 21:00:00
toc: true
tags: [Java,LeetCode,二分查找,数组,面试]
categories: [LeetCode]
---
### 题目描述
+ 峰值元素是指其值严格大于左右相邻值的元素。
+ 给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
+ 可以假设 nums[-1] = nums[n] = -∞ 。

```bash
example
input  : nums = {1,2,3,1}
output : 2
input  : nums = {1,2,1,3,5,6,4}
output : 1 (或 5， 都对输出一个即可) 
```

<!--more-->

### 解题思路
**思路1 顺序遍历**
+ 找到第一个大于其后相邻元素值的元素返回下标即可
+ 若遍历结束没有找到，则直接返回 nums.length - 1，即数组的最后一个元素即是一个峰值，只不过没有右邻元素做比较
+ 因为元素值各不相等，所以找到第一个大于其后相邻元素值的元素（A）的时候，隐含的信息是A一定大于其前的所有元素
+ 如果在A之前，有B大于A，不管B是不是A的左邻元素 【 如 ： 1，4（B），2，3（A），0；或者 1，4（B），3（A），0】，B的下标肯定早就因为大于B的值右邻元素值被返回了
+ 时间复杂度O(n)

**思路 二分查找**
+ 评论区大佬们把这方法叫做爬坡法
+ 使用二分查找的方式，比较 nums[middle] 和  nums[middle + 1] 的大小
+ 若 nums[middle] > nums[middle + 1] 说明坡在左边，right 置为 middle
+ 若 nums[middle] <= nums[middle + 1] 说明坡在右边，left 置为 middle + 1
+ 等号在哪侧都可以
+ 时间复杂度O(log n)

### 代码（Java）
**思路1代码**
```java
public class Solution1 {
    public int findPeakElement(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        for (int i = 0; i < nums.length - 1; i ++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return nums.length - 1;
    }
}
```
**思路2代码**
```java
public class Solution2 {
    public int findPeakElement(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int middle = (right + left) / 2;
            // System.out.println(left + " , " + middle + " , "+ right);
            if (nums[middle] > nums[middle + 1]) {
                right = middle;
            } else if (nums[middle] <= nums[middle + 1]) {
                left = middle + 1;
            }
        }
        return left;
    }
}
```