---
title: LeetCode腾讯精选练习50题-217.存在重复元素
copyright: true
toc: true
tags:
  - Java
  - LeetCode
  - 数组
  - 排序
  - 哈希表
  - 暴力
  - stream
categories:
  - LeetCode
date: 2022-05-11 14:00:00
---


### 题目描述
 * 给定一个整数数组 nums 。
 * 如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。


```bash
example
input  : nums = [1,2,3,1]
output : true
input  : nums = [1,2,3,4]
output : false
```

<!--more-->

### 解题思路
**思路1 排序**
+ 先把数组排序，调用Arrays.sort()即可
+ 遍历数组，如果存在相邻的两个元素值相等，返回true；如果所有元素互不相同，返回false。
+ 时间复杂度O(n×log(n))
+ 空间复杂度O(1)
**思路2 哈希表**
+ 借助HashSet，遍历数组时把数组中的元素都添加进HashSet，如果在添加时哈希表中已经有了某个元素值，说明有重复，返回tru
+ 遍历结束则说明没有重复

**思路3 暴力**
+ 双重循环，判断是否有相同的元素值即可
+ 会超出时间限制

**思路4 stream**
+ 借助stream，将int[]转换为Set<Integer>
+ 使用stream的distinc()和count()，与原数组长度做比较
+ 相等则不存在重复元素，不想等则存在重复元素

### 代码（Java）
**思路1代码**
```java
public class Solution1 {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++){
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }
}

```
**思路2代码**
```java
public class Solution2 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i : nums){
            if (set.contains(i)){
                return true;
            }
            set.add(i);
        }
        return false;
    }
}
```
**思路3代码**
```java
public class Solution3 {
    public boolean containsDuplicate(int[] nums) {
        // 会超出时间限制
        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < nums.length; j++) {
                if (j != i && nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
```
**思路4代码**
```java
public class Solution4 {
    public boolean containsDuplicate(int[] nums) {
        int dist = (int) IntStream.of(nums).distinct().count();
        return dist != nums.length;
    }
}
```