---
title: LeetCode精选TOP面试题88.合并两个有序数组
copyright: true
data: 2021-10-25 21:00:00
toc: true
tags: [Java,LeetCode,数组,排序,面试]
categories: [LeetCode]
---
### 题目描述
+ 给定两个 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数m和n，分别表示nums1和nums2中的元素数目。
+ 合并nums2到nums1中，使合并后的数组同样按 非递减顺序 排列。最终合并后数组不应由函数返回，而是存储在数组 nums1 中。
+ 为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
+ nums1.length == m + n; 
+ nums2.length == n
+ 0 <= m, n <= 200
+ 1 <= m + n <= 200
+ -109 <= nums1[i], nums2[j] <= 109

```bash
example
input  : nums1 = {1,2,3,0,0,0}, m = 3, nums2 = {2,5,6}, n = 3
output : {1,2,2,3,5,6}
input  : nums1 = {1}, m = 1, nums2 = {}, n = 0
output : {1}
input  : nums1 = {0}, m = 0, nums2 = {2}, n = 1
output : {2}
```
<!--more-->
### 解题思路
#### 关键点：两个数组都是有序数组

**思路1 逆序双指针**
+ 因为nums1的后几位是与nums2等长的0元素，所以逆序用双指针分别指向两个数组末尾，找到最大元素，将其值赋给nums1尾部，依次循环向前
+ 当某个指针遍历结束时停止第一轮遍历，此时肯定有一个数组已经被完全纳入到nums1尾部
+ 且此时并不会对nums1和nums2这两个数组的未排序元素造成影响
+ 之后，若nums1未被全部遍历，则不需要继续处理，因为此时数组必定已经有序；若nums2未被全部遍历，则需继续逆序遍历nums2，将其元素值依次赋值到nums1中

**思路2 合并数组后排序**

### 代码（Java）
**思路1代码**
```java
public class Solution1 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        int length = m + n;
        int i = m - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            nums1[--length] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        while (i >= 0) {
            nums1[--length] = nums1[i--];
        }
        while (j >= 0) {
            nums1[--length] = nums2[j--];
        }
    }
}
```
**思路2代码**
```java
public class Solution2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        for (int i = 0; i < n; i++) {
            nums1[i + m] = nums2[i];
        }
        Arrays.sort(nums1);
    }
}
```