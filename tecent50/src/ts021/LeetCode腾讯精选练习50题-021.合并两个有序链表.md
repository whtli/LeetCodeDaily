---
title: LeetCode腾讯精选练习50题-21.合并两个有序链表
copyright: true
toc: true
tags:
  - Java
  - LeetCode
  - 链表
  - 递归
  - 迭代
categories:
  - LeetCode
date: 2022-05-03 14:00:00
---


### 题目描述

 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

```bash
example
input  : l1 = [1,2,4], l2 = [1,3,4]
output : [1,1,2,3,4,4]
input  : l1 = [], l2 = []
output : []
input  : l1 = [], l2 = [0]
output : [0]
```

<!--more-->

### 解题思路
**思路1**

+ 先把最简单的情况排除，一个链表为空时直接返回另一个链表即可
+ 同时遍历两个链表，比较节点值的大小
+ 将较小的节点放到结果链表中，并将值较小的节点的指针后移，另一个链表指针不移动
+ 继续上述操作，直至两个链表指针至少一个为null
+ 将剩下的那部分非空的链表节点整体放到结果链表的最后

+ 时间复杂度O(m + n)
+ 空间复杂度O(1)

**思路2**

+ 把思路1的内容转化成递归写法
+ 退出边界就是一个为空时直接返回另一个链表
+ 时间复杂度O(m + n)
+ 空间复杂度O(m + n)

### 代码（Java）
**思路1代码**
```java
public class Solution1 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode list = new ListNode(-1);
        ListNode res = list;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                res.next = list1;
                list1 = list1.next;
            } else {
                res.next = list2;
                list2 = list2.next;
            }
            res = res.next;
        }
        // res.next = list1 != null ? list1 : list2;
        if (list1 != null) {
            res.next = list1;
        }
        if (list2 != null) {
            res.next = list2;
        }
        return list.next;
    }
}

```
**思路2代码**
```java
public class Solution2 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}

```