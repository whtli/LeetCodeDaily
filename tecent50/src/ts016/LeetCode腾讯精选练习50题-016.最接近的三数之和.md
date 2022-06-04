---
title: LeetCode腾讯精选练习50题-016.最接近的三数之和
copyright: true
toc: true
tags:
  - Java
  - LeetCode
  - 双指针
  - 排序
  - 数组
categories:
  - LeetCode
date: 2022-06-04 12:00:00
---


### 题目描述
 * 给定一个长度为 n 的整数数组 nums 和 一个目标值 target。
 * 请从 nums 中选出三个整数，使它们的和与 target 最接近。
 * 返回这三个数的和。
 * 假定每组输入只存在恰好一个解。
```bash
example
input  : nums = [-1,2,1,-4], target = 1
output : 2
note   : 与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。

input  : nums = [0,0,0], target = 1
output : 0
```

<!--more-->

### 解题思路 排序+双指针

+ 先把数组排序
+ 外层循环从头开始遍历，逐个固定遍历到的元素作为三数的第1个数，然后内层循环是在其后方区间使用首尾双指针
+ 根据三数之和确定移动首部指针还是尾部指针
+ 对比每组三数之和`tmpSum`与`target`的`差值绝对值`，不断保留差值绝对值最小的三数之和
+ 最终保留下来的结果就是与`target`差值绝对值最小的三数之和，即最接近`target`的三数之和

+ 时间复杂度:O(n^2)
+ 空间复杂度:O(1)
### 代码（Java）
```java
public class Solution {
    // 推荐参考下方的写法2
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        int n = nums.length;
        int bigger = Integer.MAX_VALUE;
        int smaller = Integer.MIN_VALUE;
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int tmpSum = nums[i] + nums[j] + nums[k];
                if (tmpSum > target) {
                    if (tmpSum <= bigger) {
                        bigger = tmpSum;
                    }
                    k--;
                } else if (tmpSum < target) {
                    if (tmpSum >= smaller) {
                        smaller = tmpSum;
                    }
                    j++;
                } else {
                    return target;
                }
            }
        }
        if (bigger == Integer.MAX_VALUE) {
            return smaller;
        }
        if (smaller == Integer.MIN_VALUE) {
            return bigger;
        }
        int left = target - smaller;
        int right = bigger - target;
        if (left > right) {
            return bigger;
        } else {
            return smaller;
        }
    }

    // 以下为与思路描述更加一一对应的写法
    // 相较于写法1更易读
    public int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best = 10001;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int tmpSum = nums[i] + nums[j] + nums[k];
                int cur = Math.abs(tmpSum - target);
                int old = Math.abs(best - target);
                if (cur < old) {
                    best = tmpSum;
                }
                if (tmpSum > target) {
                    k--;
                } else if (tmpSum < target) {
                    j++;
                } else {
                    return target;
                }
            }
        }
        return best;
    }
}
```