---
title: LeetCode腾讯精选练习50题-169.多数元素
copyright: true
toc: true
tags:
  - Java
  - LeetCode
  - 数组
  - 数学
  - 排序
  - Map
categories:
  - LeetCode
date: 2022-05-14 21:00:00
---


### 题目描述

 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。
 * 多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 可以假设数组是非空的，并且给定的数组总是存在多数元素。

```bash
example
input  : nums = [3,2,3]
output : 3
input  : nums = [2,2,1,1,1,2,2]
output : 2 
```

<!--more-->

### 解题思路

##### 思路1 排序

+ 使用Arrays.sort()对数组排序
+ 直接返回数组中下标是  n/2 的元素即可
+ 因为题目明确指出，一定存在 **出现次数大于⌊n/2⌋** 的多数元素，那么排序后下标是n/2的位置，一定是多数元素
+ 极端情况就是多数元素为数组中的最小值或最大值，其个数为 ⌊n/2⌋+1，那么下标为n/2的位置，也必定恰好是多数元素
+ 时间复杂度：O(n×log(n))
+ 空间复杂度：O(log(n))

##### 思路2 Map

+ 遍历数组，把数组中元素按照<元素值，出现次数>的形式存入Map中
+ 遍历Map，找到出现次数的最大值，返回其对应的键值（即元素值）即可
+ 时间复杂度：O(n)
+ 空间复杂度：O(n)

##### 思路3 Boyer-Moore 投票算法
+ 前提：假设数组中多数元素的个数为 p，所有非多数元素的个数和为 q，则必然有 p > q

+ （1）所有非多数元素看作一个整体：
    - 假设多数元素中的任意q个元素 x1, …… , xq 可以和 非多数元素（整体） 中所有的元素 y1, …… ,yq 两两组成一对抵消掉
    - 则根据多数元素的定义，多数元素的集合中，还剩 p-q 个元素，且 p - q >= 1 必然成立
    - 则遍历数组，把元素值当作候选者，按照投票法，遇到相同值，票数+1，遇到不同值，票数-1，由上面的分析可知，多数元素的票数最终一定是 p - q >= 1
    - 如 [1,1,2,2,2]，顺序遍历后，`元素值2`的`票数是 1` 
+ （2）非多数元素`不看作`一个整体
    - 则所有非多数元素的值，并不是全部相同的
    - 则在遍历过程中，非多数元素内部还会因值的不相同也产生抵消
    - 这就导致多数元素的票数在 >=1 的基础上`可能`会更大
    - 如 [1,2,3,3,3]，顺序遍历后，`元素值3`的`票数是 3`
    - 但若是多数元素都在数组前方，则又可以回归到（1）中那样的结果
    - 如 [3,3,3,1,2]，顺序遍历后，`元素值3`的`票数是 1`
    
+ 时间复杂度：O(n)，只需要顺序遍历1次数组
+ 空间复杂度：O(1)

### 代码（Java）
**思路1代码**
```java
public class Solution1 {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
```
**思路2代码**
```java
public class Solution2 {
    public int majorityElement(int[] nums) {
        TreeMap<Integer,Integer> map = new TreeMap<>(Comparator.reverseOrder());
        for (int i : nums){
            int cnt = map.containsKey(i) ? map.get(i) + 1 : 1;
            map.put(i, cnt);
        }
        int max = map.firstKey();
        for (Integer key : map.keySet()) {
            // System.out.println("key= " + key + " and value= " + map.get(key));
            if (map.get(key) > map.get(max)){
                max = key;
            }
        }
        return max;
    }
}

```
**思路3代码**
```java
public class Solution3 {
    public int majorityElement(int[] nums) {
        int res = nums[0];
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (cnt == 0) {
                res = nums[i];
            }

            if (nums[i] == res) {
                cnt++;
            } else {
                cnt--;
            }
        }
//        System.out.println("res : " + res + " , cnt : " + cnt);
//        if (cnt == 0) {
//            System.out.println("There is no mode in this array.");
//        }
        return res;
    }
}

```