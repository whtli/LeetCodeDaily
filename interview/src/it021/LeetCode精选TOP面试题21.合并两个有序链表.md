---
title: LeetCode精选TOP面试题21.合并两个有序链表
copyright: true
toc: true
tags:
  - Java
  - LeetCode
  - 
categories:
  - LeetCode
date: 2020-03-06 21:00:00
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
+ 首先，一个链表为空时，直接返回另一个链表即可
+ 双指针同时遍历两个链表
+ 比较当前两个指针指向的节点值的大小
+ 将较小的节点放到结果链表中，并将对应的指针后移，另一个链表指针不移动
+ 重复上述操作，直至两个链表指针至少一个为 null
+ 将剩下的非空的链表节点整体放到结果链表的最后

### 代码（Java）
```java
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = new ListNode(0);
        ListNode q = p;
        while(l1 != null && l2 != null){
            if (l1.val < l2.val){
                q.next = l1;
                l1 = l1.next;
            }else { 
                q.next = l2;
                l2 = l2.next;
            }
            q = q.next;
        }
        if(l1 != null){
            q.next = l1;
        }
        if (l2 != null){
            q.next = l2;
        }
        return p.next;
    }
}
```