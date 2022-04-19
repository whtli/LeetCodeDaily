---
title: LeetCode腾讯精选练习50题-237.删除链表中的节点
copyright: true
toc: true
tags:
  - Java
  - LeetCode
  - 链表
categories:
  - LeetCode
date: 2022-04-13 11:00:00
---


### 题目描述

 * 请编写一个函数，用于 删除单链表中某个特定节点 。在设计函数时需要注意，你无法访问链表的头节点 head ，只能直接访问 要被删除的节点 。
 * 题目数据保证需要删除的节点不是末尾节点。
 * 链表中每个节点的值都是 唯一 的

```bash
example
input  : head = [4,5,1,9], node = 5
output : [4,1,9]
input  : head = [4,5,1,9], node = 1
output : head = [4,5,1,9], node = 1
```

<!--more-->

### 解题思路
+ 假设需要删除的节点为 node
+ 将 node 的值，替换为其后继节点的值
+ 将 node 的后继指针，指向node的后继节点的后继指针所指向的内容

### 代码（Java）
```java
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
```
