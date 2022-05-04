---
title: LeetCode腾讯精选练习50题-88.合并两个有序数组
copyright: true
toc: true
tags:
  - Java
  - LeetCode
  - 数组
  - 双指针
  - 排序
categories:
  - LeetCode
date: 2022-05-04 21:00:00
---


### 题目描述

 * 给定两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：
 * 最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。
 * 为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。
 * nums2 的长度为 n 。

```bash
example
input  : nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
output : [1,2,2,3,5,6]
input  : nums1 = [1], m = 1, nums2 = [], n = 0
output : [1]
note   : 
```

<!--more-->

### 解题思路
**思路1**
+ 遍历数组nums2，将其元素逐个放入nums1初始的后n个位置
+ 对数组nums1排序
+ 时间复杂度：O(N×log(N))，其中 N = m+n
+ 空间复杂度：O(1)

**思路2**
+ 双指针，同时逆序遍历数组nums1和nums2，其中nums1从第m个元素遍历到第1个元素，nums2从第n个元素遍历到第1个元素
+ 假设当前nums1被遍历的元素为 a， nums2被遍历的元素为b，则取a和b中的较大者，放入nums1的最后
+ 即从nums1的真正末尾位置 m+n 开始向前填充值，将遍历过程中m和n的较大者逐个放入nums1的后方，并且后方存放元素的指针不断前移
+ 因为nums1和nums2本身是有序递增的，所以填充得到的结果依然是有序的
+ 若nums1遍历结束，而nums2未结束，则继续遍历nums2并将其所有元素逐个移动到nums1的剩余位置中
+ 当nums2遍历结束，而nums1未结束，则不需要继续操作，此时未遍历完的nums1的部分元素一定还是有序递增的排列在nums1的前方，没有被变动过，且一定都小于其当前的所有后方元素
+ 时间复杂度：O(N)，其中 N = m+n
+ 空间复杂度：O(1)

### 代码（Java）
**思路1代码**
```java
public class Solution1 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            nums1[i + m] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}
```
**思路2代码**
```java
public class Solution2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n - 1;
        int i = m - 1, j = n - 1;
        while (i >=0 && j >=0){
            nums1[len--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        while(j >= 0){
            nums1[len--] = nums2[j--];
        }
    }
}

```