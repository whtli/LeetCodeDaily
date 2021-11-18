---
title: LeetCode精选TOP面试题015.三数之和
copyright: true
data: 2021-11-18 21:00:00
toc: true
tags: [Java,LeetCode,数组,排序,双指针,面试]
categories: [LeetCode]
---

### 题目描述
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 找出所有和为 0 且不重复的三元组。
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
```bash
example
input  : nums = [-1,0,1,2,-1,-4]
output : [[-1,-1,2],[-1,0,1]]
input  : nums = []
output : []
input  : nums = [0]
output : []
```

<!--more-->

### 解题思路
**思路： 排序+双指针**
+ 若数组为空，返回空列表
+ 将数组进行排序
+ 若数组长度小于3，不满足题意，返回空列表
+ 遍历数组查找是否存在三数之和为 0 ，外层循环
    - 若当前元素nums[i] > 0，说明该元素和其后任意两个元素之和肯定不可能为0，则直接返回当前结果列表即可；之所以不使用nums[i] >= 0作为返回条件，是因为存在数组为{0,0,0}的情况也满足题意，若添加了等号为返回条件，则会返回空，不满足题意
    - 若当前访问元素和其前一个元素值相同，不进行求和判断，防止出现重复的结果
    - 固定i，令指针left和指针right移动，求和并判断；其中left初始化为i + 1，right初始化为length - 1；开始内层循环
    - 内层循环以 left < right 为结束条件，若相等，则说明访问到了同一个元素，不满足三数的要求，可作为循环结束的条件
        + 三数之和为0，将这三个数组成的列表添加进结果列表，且移动左右指针；然后判断左右指针移动后访问的元素值，是否和其移动前的元素值相等，相等则继续移动，防止重复结果
        + 三数之和 > 0，右指针左移，使下一次求和结果变小，向0趋近
        + 三数之和 < 0，左指针右移，使下一次求和结果变大，向0趋近
+ 时间复杂度：O(n^2)
    排序 O(N logN)，
    遍历数组 O(n)，
    双指针遍历 O(n)，
    总体 O(N logN)+O(n)∗O(n)，O(n^2)
+ 空间复杂度：O(1)

### 代码（Java）
**代码**
```java
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        // 数组为空，返回空列表
        if (nums == null) {
            return lists;
        }
        // 数组排序
        Arrays.sort(nums);
        // 数组长度小于3，不满足题意，返回空列表
        int length = nums.length;
        if (nums.length < 3) {
            return lists;
        }

        // 遍历数组查找是否存在三数之和为0
        for (int i = 0; i < length; i++) {
            // 当前元素大于零，说明该元素和其后任意两个元素之和肯定不可能为0，则直接返回当前结果即可
            // 之所以不使用nums[i] >= 0作为返回条件，是因为存在数组为{0,0,0}的情况也满足题意，若添加了等号为返回条件，则会返回空，不满足题意
            if (nums[i] > 0) {
                return lists;
            }
            // 当前访问元素和其前一个元素值相同，不进行求和判断，防止出现重复的结果
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 固定i，令指针left和指针right移动，求和并判断；其中left初始化为i + 1，right初始化为length - 1
            int left = i + 1;
            int right = length - 1;
            // left 和 right 相等时，访问到了同一个元素，不满足三数的要求，可作为循环结束的条件
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    // 三数之和为0
                    // 将这三个数组成的列表添加进结果列表
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    lists.add(tmp);
                    // 左右指针移动
                    left++;
                    right--;
                    // 判断左右指针移动后访问的元素值，是否和其移动前的元素值相等，相等则继续移动，防止重复结果
                    while (left <= right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (right >= left && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum > 0) {
                    // 三数之和 > 0，右指针左移，使下一次求和结果变小，向0趋近
                    right--;
                } else {
                    // 三数之和 < 0，左指针右移，使下一次求和结果变大，向0趋近
                    left++;
                }
            }
        }
        return lists;
    }
}

```