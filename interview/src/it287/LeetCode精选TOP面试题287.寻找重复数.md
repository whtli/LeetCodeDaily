---
title: LeetCode精选TOP面试题287.寻找重复数
copyright: true
data: 2021-11-21 21:00:00
toc: true
tags: [Java,LeetCode,数组,二分查找,双指针,哈希]
categories: [LeetCode]
---

### 题目描述

 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有一个重复的整数 ，找出 这个重复的数 。
 * 解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。
 * 提示：
 * 1 <= n <= 105
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次
 * 进阶：
	 * 如何证明 nums 中至少存在一个重复的数字?
	 * 设计一个线性级时间复杂度 O(n) 的解决方案
 
```bash
example
input  : nums = {1,3,4,2,2}
output : 2
input  : nums = {3,1,3,4,2}
output : 3
input  : nums = {1,1,2}
output : 1
```

<!--more-->

### 解题思路

**思路1: HashSet**
+ 借助 HashSet 存储数组元素，便于查重
+ 遍历数组，假设当前遍历的元素为 item
    * 若 item 不存在于 HashSet 中，则将其添加进 HashSet
    * 若 item 存在于 HashSet 中，直接返回 item
+ 时间复杂度O(n)
+ 空间复杂度O(n)
+ 题目不允许空间复杂度O(n)，虽然使用HashSet编写代码很快，但是违反了题目要求

**思路2: 双指针（快慢）**

+ 由索引找到元素，再将这个元素作为索引，继续找下一个元素，因为数组中有重复元素，故最终会形成一个循环
+ 定义快慢指针
    + 快指针 faster 每次遍历前进2次（以当前faster作为索引得到的元素值A（nums[faster]），再做为索引获得新的元素值B（nums[nums[faster]]），把B再赋值给快指针 faster，即 faster = num[nums[faster]]）
    + 慢指针 slower 每次遍历前进1次（以当前faster作为索引得到的元素值C（nums[slower]），把C再赋值给快指针 slower，即 slower = nums[slower]）
+ 当快慢指针相遇时，说明两者到了循环的入口，循环的入口不是重复的数字
+ 所以找到循环入口之后，还要再找重复的数字
    + 设置一个从数组起始位置出发的新指针 p ，前进形式与slower相同
    + 在不断循环之后， p 与 slower 两指针指向的值相等时，就得到了重复的数字

**思路3: 二分查找**
+ n+1个数，都属于[1, n]，只有一个重复的整数
+ 想象把 n+1 个无色球，放进n个颜色不同的染缸，必然有一个染缸中存在两个球
+ 即必然有一个数是出现了两次的（必然有两个球的颜色是相同的）
+ 考虑这个有序区间 [1, n]
    + 假设现在存在数组 array 包含了 **n 个不重复** 的整数，属于区间[1, n]
    + 遍历这个数组 array，不必考虑其排列顺序，统计小于或等于 mid 的数，累加到 count1 上
    + **则必然会有：count1 = mid** ！！！
    + ============分割线===============
    + 现在思考题目中给的数组，nums包含了n+1个属于区间[1, n]的数，**有一个重复的整数**
    + 遍历这个数组，不必考虑其排列顺序，统计 **小于或等于 mid**  的数，累加到 count2 上
    + 因为有一个数重复，故必然会有：count2 > mid 或者 count2 = mid
        - 若 count2 > mid，说明数组nums中，小于或等于mid的数里，出现了重复的整数
        - 若 count2 = mid，说明数组nums中，小于或等于mid的数里，没有重复的整数
+ ⭐设定 left = 1，right = n，mid = （left + right）/ 2，**此处的 left 、right 、mid 用于描述区间！只与区间有关！**        
+ 根据上述思路，借助 与数组[1, n]有关的变量left、right、mid，**对区间 [1, n] 进行二分查找！！！是对区间进行查找，不是对数组**
    + 查找过程中，统计**小于或等于 mid**  的数，累加到 count2 上
        + count2 > mid时，更新 right = mid
        + count2 = mid时，更新 left = mid + 1
+ 最后 left 和 right 相等时，查找结束，其值即为那个重复的整数。
+ 时间复杂度O(n logn)，在二分内部有for循环，时间复杂度为O(N)。
+ 空间复杂度O(1)

### 代码（Java）
**思路1代码**
```java
public class Solution1 {
    public int findDuplicate(int[] nums) {

        HashSet hashSet = new HashSet();
        for (int item : nums) {
            if (hashSet.contains(item)) {
                return item;
            }
            hashSet.add(item);
        }
        return 0;
    }
}
```
**思路2代码**
```java
public class Solution2 {
    public int findDuplicate(int[] nums) {
        int slower = nums[0];
        int faster = nums[nums[0]];
        while (faster != slower) {
            faster = nums[nums[faster]];
            slower = nums[slower];
        }
        //System.out.println("slower : " + slower + " , " + nums[slower]);
        //System.out.println("faster : " + faster + " , " + nums[faster]);

        int step1 = 0, step2 = slower;
        while (step1 != step2) {
            System.out.println("step1 : " + step1 + " , " + nums[step1]);
            System.out.println("step2 : " + step2 + " , " + nums[step2]);
            step1 = nums[step1];
            step2 = nums[step2];
        }
        return step1;
    }
}
```

**思路3代码**
```java
public class Solution3 {
    public int findDuplicate(int[] nums) {
        int left = 1, right = nums.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
```