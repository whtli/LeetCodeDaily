---
title: LeetCode腾讯精选练习50题-206.反转链表
copyright: true
toc: true
tags:
  - Java
  - LeetCode
  - 链表
  - 迭代
  - 递归
categories:
  - LeetCode
date: 2022-05-12 21:00:00
---

### 题目描述

 * 给定单链表的头节点 head ，请反转链表，并返回反转后的链表。

```bash
example
input  : head = [1,2,3,4,5]
output : [5,4,3,2,1]
input  : head = []
output : []
```

<!--more-->

### 解题思路
**思路1 迭代**
+ 双指针，头插法，迭代
+ 遍历链表，使用头插法将链表反转即可
+ 时间复杂度O(n)
+ 空间复杂度O(1)

**思路2 头插法**
+ 头插法，遍历时不断创建新节点
+ 初始创建空节点 rev = null
+ 遍历链表，利用ListNode类新建节点的方法ListNode(val, next)
+ 在遍历过程中，把当前节点 cur 的值作为第一个参数val，当前创建的不完整链表作为第二个参数next，并将创建的新节点不断赋值给 rev，即rev = new ListNode(cur.val, rev)
+ 直到遍历结束，这样实际上也是头插法实现反转，但与方法一的区别是这里额外使用了新的空间
+ 时间复杂度O(n)
+ 空间复杂度O(n)

**思路3 递归**
+ 递归边界：当前节点的后继结点为空，返回当前节点
+ 关于递归的过程，可以做如下考虑：
    - 假设当前节点为 node， 把其后的所有节点 node.next 当作一个整体，且已经完成递归，记为 loop(node.next)
    - 那么递归过程可以写为，ListNode revList = loop(node.next)
    - 需要注意，revList作为部分反转链表的头部，始终指向的实际上是原始链表的末尾节点，而反转后当前节点 node 的后继节点 node.next，实际上处于以 revList 为头节点的链表的尾部
    - 即在对当前节点进行操作之前，先让其后的所有节点通过 递归 完成反转
    - 此时考虑 递归的退出边界，若节点i的后继为空，没有可以继续用于下一次递归的节点了，则节点i（实际上就是链表的末尾节点）就是在递归过程中首先要完成反转的节点了，返回其本身，就完成了反转过程
    - 然后考虑继续处理当前节点node，把node节点放到通过递归得到的部分反转链表revList的末尾
    - 即，让当前位于部分反转链表revList尾部的node.next的后继指针指向node，然后让node的后继指针指向空，就完成了从node到末尾的反转 
+ 时间复杂度O(n)
+ 空间复杂度O(n)

### 代码（Java）
**思路1代码**
```java
public class Solution1 {
    public ListNode reverseList(ListNode head) {
        ListNode rev = null;
        ListNode p = head;
        ListNode q;
        while (p != null){
            q = p.next;
            p.next = rev;
            rev = p;
            p = q;
        }
        return rev;
    }
}
```
**思路2代码**
```java
public class Solution2 {
    public ListNode reverseList(ListNode head) {
        ListNode rev = null;
        for (ListNode p = head; p != null; p = p.next){
            rev = new ListNode(p.val, rev);
        }
        return rev;
    }
}

```
**思路3代码**
```java
public class Solution3 {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return head;
        }
        return loop(head);
    }
    private ListNode loop(ListNode node){
        if (node.next == null){
            return node;
        }
        ListNode newList = loop(node.next);
        node.next.next = node;
        node.next = null;
        return newList;
    }
}
```