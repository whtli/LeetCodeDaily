---
title: LeetCode腾讯精选练习50题-160.相交链表
copyright: true
toc: true
tags:
  - Java
  - LeetCode
  - 链表
  - 链表
  - 双指针
  - 哈希表
categories:
  - LeetCode
date: 2022-05-06 21:00:00
---


### 题目描述

 * 给定两个单链表的头节点 headA 和 headB ，找出并返回两个单链表相交的起始节点。
 * 如果两个链表不存在相交节点，返回 null 。

```bash
example
input  : intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
output : Intersected at '8'
input  : intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
output : Intersected at '2'
input  : intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
output : null
```

<!--more-->

### 解题思路
**思路1 双指针**
+ 先通过遍历，分别求出链表a和链表b的长度，然后可以得到两个链表的长度差 sub
+ 再次遍历，这次先遍历较长的那个链表，遍历其前sub个节点
+ 然后两个链表同步遍历，即较长的链表从第sub+1个节点继续开始遍历，较短的链表从第1个节点开始遍历
+ 当遍历到相同的节点时，证明链表a和b是相交的，返回这个相同的节点即可
+ 若遍历结束始终没有发现相同的节点，说明链表a和b不相交

**思路2 Map**
+ 先遍历第1个链表，并将其所有节点都存放到Map<ListNode,ListNode>中，并规定键为当前节点，值为其后继结点
+ 再遍历第2个链表，遍历过程中判断每个节点是否已经作为 键 出现在map中
    - 若已经出现，说明有相交节点，且就是当前节点 
    - 若第2个链表遍历结束时它的所有节点都没有作为 键 出现在 map 中，说明两个链表不相交
    
### 代码（Java）
**思路1代码**
```java
public class Solution1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int alen = 0;
        int blen = 0;
        ListNode p = headA;
        while (p != null) {
            alen++;
            p = p.next;
        }
        ListNode q = headB;
        while (q != null) {
            blen++;
            q = q.next;
        }
        ListNode res = null;
        if (alen > blen) {
            res = getTarget(alen - blen, blen, headA, headB);
        } else {
            res = getTarget(blen - alen, alen, headB, headA);
        }
        return res;
    }

    public ListNode getTarget(int sub, int shorter, ListNode p, ListNode q) {
        for (int i = 0; i < sub; i++) {
            p = p.next;
        }
        for (int i = 0; i < shorter; i++) {
            if (p == q) {
                return p;
            }
            p = p.next;
            q = q.next;
        }
        return null;
    }
}
```
**思路2代码**
```java
public class Solution2 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<ListNode,ListNode> map = new HashMap<ListNode,ListNode>();
        while (headA != null) {
            map.put(headA, headA.next);
            headA = headA.next;
        }
        while(headB != null){
            if (map.containsKey(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
```