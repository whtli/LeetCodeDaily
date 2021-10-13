---
title: LeetCode精选TOP面试题26.删除排序数组中的重复项
copyright: true
data: 2020-05-25 19:41:00
toc: true
tags: [Java,数组,遍历,LeetCode,面试]
categories: [LeetCode]
---
### 题目描述
给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
```bash
example1:
input  : [1,1,2] 
output : [1,2]
note   : 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。 
```
```bash
example2:
input  : [0,0,1,1,1,2,2,3,3,4]
output : [0,1,2,3,4]
note   : 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
```
<!--more-->
### 解题思路
**思路**
双指针遍历，一个指针i用于遍历数组，另一个指针len用于修改数组。
当前元素的值num[i]与其前一个元素的值num[i-1]不相等的时候，num[len]的值更新为num[i]，以此实现对数组的修改。

### 代码（Java）

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int len = 1;
        for (int i = 1; i < nums.length; i++){ // 下标从1开始是为了访问i-1时防止出现溢出。
            if (nums[i] != nums[i-1]){
                nums[len ++] = nums[i];
            }
        }
        return len;
    }
}
```
