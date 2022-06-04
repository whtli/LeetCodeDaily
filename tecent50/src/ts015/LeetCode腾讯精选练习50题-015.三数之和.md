---
title: LeetCode腾讯精选练习50题-015.三数之和
copyright: true
toc: true
tags:
  - Java
  - LeetCode
  - 双指针
  - 数组
  - 排序
categories:
  - LeetCode
date: 2022-05-30 21:00:00
---

### 题目描述

 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
 * 请找出所有和为 0 且不重复的三元组。


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

##### 思路1 双指针
+ 排序
+ 外层循环从头开始遍历，逐个固定遍历到的元素作为三数的第1个数，然后内层循环是在其后方区间使用首尾双指针
+ 根据三数之和确定移动首部指针还是尾部指针
+ 移动指针的过程中遇到相同则跳过，以避免重复解
+ 遇到符合要求的三数之和则将其记录到结果列表中

+ 执行用时：17 ms, 在所有 Java 提交中击败了99.71%的用户
+ 内存消耗：45 MB, 在所有 Java 提交中击败了92.86%的用户
+ 时间复杂度:O(n^2)
+ 空间复杂度:O(n))
##### 思路2 Map
+ 排序
+ 外层循环从中部（1 ~ n-1）开始遍历，逐个固定遍历到的元素作为三数的第2个数，内层循环是在其前后两个小的区间内依次顺序遍历，以确定其他两个元素
+ 内层循环中，对当前第2个数的前方区间的遍历，记录所有第1个数和已经固定的第2个数的求和组合
+ 然后继续在内层循环中，遍历当前第2个数的后方区间，找到map中是否存在某个键，等于当前元素的相反数
    + 若存在，则说明当前找到的三个数符合要求，将它们记录到结果列表中
    + 额外再使用一个map来记录前两个数组成的map和第三个数
+ 两层循环的遍历过程中遇到相同则跳过，以避免重复解

+ 执行用时: 266 ms
+ 内存消耗: 46.9 MB
+ 时间复杂度:O(n^2)
+ 空间复杂度:O(n))

### 代码（Java）
**思路1代码**
```java
public class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        // 排序
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> lists = new ArrayList<>(256);
        if (n < 3 || nums[0] > 0 || nums[n - 1] < 0) {
            return lists;
        }
        // 转换成 a + b = -c
        int i, j, k;
        for (i = 0; i < n - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            j = i + 1;
            k = n - 1;
            while (j < k) {
                int target = nums[j] + nums[k];
                if (target < -nums[i]) {
                    j++;
                } else if (target > -nums[i]) {
                    k--;
                } else {
                    lists.add(Arrays.asList(new Integer[]{nums[i], nums[j], nums[k]}));
                    k--;
                    j++;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }
        return lists;
    }
}

```
**思路2代码**
```java
public class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        // 排序
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> lists = new ArrayList<>(256);
        if (n < 3 || nums[0] > 0 || nums[n - 1] < 0) {
            return lists;
        }
        // 转换成 a + b = -c
        int i, j, k;
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Map<Integer, Integer>> ansHash = new HashMap<>();
        for (i = 1; i < n - 1; i++) {
            // i是中间元素，j是从0到i找元素，k是从i到n找元素
            // 即借助中间元素来缩小两侧的查找范围
            map.clear();
            for (j = 0; j < i; j++) {
                int x = nums[i] + nums[j];
                map.put(x, 1);
            }
            for (k = i + 1; k < n; k++) {
                if (k > i + 1 && nums[k] == nums[k - 1]) {
                    continue;
                }
                if (map.containsKey(-nums[k])) {
                    int b = nums[i];
                    int c = nums[k];
                    int a = -(nums[i] + nums[k]);
                    if (!ansHash.containsKey(a) || !ansHash.get(a).containsKey(b)) {
                        ansHash.put(a, new HashMap<>());
                        ansHash.get(a).put(b, 1);
                        lists.add(Arrays.asList(new Integer[] {a, b, c}));
                    }
                }
            }
        }
        return lists;
    }
}
```
**思路3代码（思路2代码的改写，修改了map的使用方式）**
```java
public class Solution3 {
    public List<List<Integer>> threeSum(int[] nums) {
        // 排序
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> lists = new ArrayList<>(256);
        if (n < 3 || nums[0] > 0 || nums[n - 1] < 0) {
            return lists;
        }
        // 转换成 a + b = -c
        int i, j, k;
        Map<Integer, Integer> map = new HashMap<>();
        Map<Map<Integer, Integer>, Integer> ansHash = new HashMap<>();
        for (j = 1; j < n - 1; j++) {
            // i是中间元素，j是从0到i找元素，k是从i到n找元素
            // 即借助中间元素来缩小两侧的查找范围
            map.clear();
            for (i = 0; i < j; i++) {
                int x = nums[i] + nums[j];
                map.put(x, 1);
            }
            for (k = j + 1; k < n; k++) {
                if (k > j + 1 && nums[k] == nums[k - 1]) {
                    continue;
                }
                if (map.containsKey(-nums[k])) {
                    int a = -(nums[j] + nums[k]);
                    int b = nums[j];
                    int c = nums[k];
                    Map<Integer, Integer> t = new HashMap<>();
                    t.put(a, b);
                    if (!ansHash.containsKey(t)) {
                        ansHash.put(t, 1);
                        lists.add(Arrays.asList(new Integer[]{a, b, c}));
                    }
                }
            }
        }
        return lists;
    }
}
```