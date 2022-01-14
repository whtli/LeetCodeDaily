---
title: LeetCode精选TOP面试题328.奇偶链表
copyright: true
toc: true
tags:
  - Java
  - LeetCode
  - 链表
categories:
  - LeetCode
date: 2022-01-07 12:00:00
---


### 题目描述

 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
 * 这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 使用原地算法完成。空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。

```bash
example
input  : 1->2->3->4->5->NULL
output : 1->3->5->2->4->NULL
input  : 2->1->3->5->6->4->7->NULL 
output : 2->3->6->7->1->5->4->NULL
```

<!--more-->

### 解题思路

+ 空链表直接返回
+ 用odd代表奇位链表，even代表偶位链表
+ p起始指向链表头节点head，q起始指向链表头节点的第一个后继结点hexd.next
+ 用p遍历奇位节点，q遍历偶位节点
+ 最后当 q为空（防止节点总数为偶数时报错空指针）或者 q.next为空（防止节点总数为奇数时报错空指针）时，结束遍历
+ 令p指向even，则可得到重新排序后的奇偶链表（头节点为odd）

### 代码（Java）
```java
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode p = head;
        ListNode q = head.next;
        while (q != null && q.next != null) {
            p.next = q.next;
            p = p.next;
            q.next = p.next;
            q = q.next;

        }
        /*while (list1 != null){
            System.out.print(list1.val + " ");
            list1 = list1.next;
        }
        System.out.println();
        while (list2 != null){
            System.out.print(list2.val + " ");
            list2 = list2.next;
        }*/
        p.next = even;

        return odd;
    }
}
```