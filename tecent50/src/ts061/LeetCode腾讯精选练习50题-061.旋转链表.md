---
title: LeetCode腾讯精选练习50题-061.旋转链表
copyright: true
toc: true
tags:
  - Java
  - LeetCode
  - 链表
  - 双指针
categories:
  - LeetCode
date: 2022-06-05 21:00:00
---

### 题目描述

 * 给定一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。

```bash
example
input  : head = [1,2,3,4,5], k = 2
output : [4,5,1,2,3]

input  : head = [0,1,2], k = 4
output : [2,0,1]
```

<!--more-->

### 解题思路
+ 如果满足以下条件，可以直接返回原链表
    - 链表为空，即 head = null
    - 链表只有一个节点，即 head.next = null
    - 旋转次数 k 为0
    - 旋转次数 k 是链表长度的倍数，即旋转后的链表还是原样
    
##### 思路1 双指针/快慢指针

+ 第一次遍历获取链表长度
+ 用快慢指针拉开遍历差距，并借助`慢指针`获取`结果链表的起始节`点，即
    - 先考虑简单情况 `k 严格小于 链表长度 n`，那么就是要找到原链表的倒数第k个节点作为结果链表的起始节点
    - 再拓展到`k > n`的情况，此时只需要刷新k，即令 `k = k % n`，转变成第一种简单情况即可
+ 使链表闭合，并断开新的起始节点与其之前节点的链接

+ 时间复杂度:O(n)
+ 空间复杂度:O(1)
##### 思路2 双指针的反向思考
+ 其实就是双指针思路的变形
+ 第一次遍历获取链表长
+ 反向思考旋转后结果链表起始节点的位置，使用`单个指针遍历`来获取`结果链表的起始节点`，即
    - 先考虑简单情况 `k 严格小于 链表长度 n`，那么就是要找到`原链表的倒数第k个节点`即`原始链表的正数第 n - k 个节点的后继结点`作为结果链表的起始节点
    - 再拓展到`k > n` 的情况，此时只需要将 `k % n`，转变成第一种简单情况即可，即刷新k，令 `k = n - k % n`
+ 使链表闭合，并断开新的起始节点与其之前节点的链接

+ 时间复杂度:O(n)
+ 空间复杂度:O(1)

### 代码（Java）
**思路1代码**
```java
public class Solution1 {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        ListNode iter = head;
        int len = 0;
        ListNode tail = null;
        while (iter != null) {
            if (iter.next == null) {
                tail = iter;
            }
            len++;
            iter = iter.next;
        }
        // 如果旋转次数恰好是链表长度的倍数，说明旋转后也是原样，所以不需要移动
        if (k % len == 0) {
            return head;
        }
        // 初始令计数器延后一位（即-1），以获取结果链表的起始位置的前一个位置
        // 此处若初始令计数器为0，则获得的是结果链表的其实位置，无法将它与之前的节点断开
        int cnt = -1;
        // 先令快指针向前遍历k%len步
        ListNode fast = head;
        while (cnt != k % len) {
            cnt++;
            fast = fast.next;
        }
        // 再同步开启慢指针的遍历
        // 当快指针为空时，说明慢指针已经到达了目标结果链表的起始节点的前一个位置
        ListNode second = head;
        while (fast != null) {
            fast = fast.next;
            second = second.next;
        }
        // 使原始链表闭合为环
        tail.next = head;
        // 获得新起点
        ListNode res = second.next;
        // 从新起点之前断开
        second.next = null;
        // 返回结果
        return res;
    }
}
```
**思路2代码**
```java
public class Solution2 {
    public ListNode rotateRight2(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        ListNode first = head;
        int len = 1;
        while (first.next != null) {
            len++;
            first = first.next;
        }
        if (k % len == 0) {
            return head;
        }
        // 第二次遍历
        ListNode second = head;
        int cnt = 1;
        // 移动k个位置，其实就是以 第len - k % len个节点的后继节点 作为新链表的头节点，并使其与其之前的节点断开链接
        // 所以此处可以做减法来替代快慢指针的同步遍历，只需要遍历一次即可。
        int step = len - k % len;
        while (cnt < step) {
            cnt++;
            second = second.next;
        }
        // 使之闭合为环
        first.next = head;
        ListNode res = second.next;
        second.next = null;
        return res;
    }
}
```