---
title: LeetCode精选TOP面试题075.颜色分类
copyright: true
data: 2021-11-14 21:00:00
toc: true
tags: [Java,LeetCode,数组,排序,面试]
categories: [LeetCode]
---

### 题目描述
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组。
 * 原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 
 * 进阶：
    - 可以不使用代码库中的排序函数来解题吗？
    - 有仅使用常数空间的一趟扫描算法吗？
    
```bash
example
input  : nums = {2, 0, 2, 1, 1, 0}
output : nums = {0, 0, 1, 1, 2, 2}
input  : nums = {2, 0, 1}
output : nums = {0, 1, 2}
input  : nums = {0}
output : nums = {0}
```

<!--more-->

### 解题思路
**思路1**

[参考自大佬的题解](https://leetcode-cn.com/problems/sort-colors/solution/kuai-su-pai-xu-partition-guo-cheng-she-ji-xun-huan/)。

+ “进阶”要求考察的是“快速排序”的子过程 partition，即：通过一次遍历，把数组分成三个部分。
    - 初始化index = 0，zero = 0，two = nums.length
    - index作为遍历的访问下标，zero作为0元素子集右侧边界，two作为2元素子集左侧边界，
    - 当访问元素为2时，向后与 **two先向左移动一次之后** 的位置的元素交换（因为two初始化为nums.length为越界状态，故先使其不越界），i不前进，因为交换来的元素很可能也是2，此时若前进会把交换到i下标位置的2忽略，导致排序失败，故原地等待，继续循环；
    - 当访问元素为1时，不交换，因为1本来就需要在中间，i不前进，zero和two也移动
    - 当访问元素为0时，向前与zero位置的元素交换 ，i前进，zero向右移动。
+ 时间复杂度：O(N) 
+ 空间复杂度：O(1) 

**思路2**
+ 调用Java中Arrays.sort()方法
+ 时间复杂度：O(N logN) 
+ 空间复杂度：O(1) 

### 代码（Java）
**思路1代码**
```java
public class Solution1 {
    /* public void sortColors(int[] nums) {
        int length = nums.length;
        int zero = 0, two = length - 1;
        int i = 0;
        while (i <= two) {
            if (nums[i] == 0) {
                nums[i] = nums[zero];
                nums[zero++] = 0;
                i++;
            } else if (nums[i] == 2) {
                nums[i] = nums[two];
                nums[two--] = 2;
            } else {
                i++;
            }
        }
    } */
    // 基于上方注释内容，抽出交换数据的方法
    public void sortColors(int[] nums) {
        int length = nums.length;
        // i作为遍历的访问下标，zero作为0元素子集右侧边界，two作为2元素子集左侧边界；
        int zero = 0, two = length;
        int i = 0;
        // 循环终止条件是 i == two，那么循环可以继续的条件是 i < two
        while (i < two) {
            if (nums[i] == 0) {
                // 当访问元素为0时，向前与zero位置的元素交换 ，i前进，zero向右移动。
                swap(nums, i, zero++);
                i++;
            } else if (nums[i] == 2) {
                // 向后与 two先向左移动一次之后 的位置的元素交换（因为two初始化为nums.length为越界状态，故先使其不越界），i不前进，因为交换来的元素很可能也是2，此时若前进会把交换到i下标位置的2忽略，导致排序失败，故原地等待，继续循环；
                swap(nums, i, --two);
            } else {
                // 当访问元素为1时，不交换，因为1本来就需要在中间，i不前进，zero和two也移动；
                i++;
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }
}
```
**思路2代码**
```java
public class Solution2 {
    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }
}
```