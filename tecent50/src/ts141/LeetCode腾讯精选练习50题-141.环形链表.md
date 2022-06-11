---
title: LeetCode腾讯精选练习50题-141.环形链表
copyright: true
toc: true
tags:
  - Java
  - LeetCode
  - 链表
  - 哈希表
  - 双指针
categories:
  - LeetCode
date: 2022-04-XX 21:00:00
---

### 题目描述

 * 给定一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false 。

```bash
example
input  : head = [3,2,0,-4], pos = 1
output : true
input  : head = [1,2], pos = 0
output : true
input  : head = [1], pos = -1
output : false
```

<!--more-->

### 解题思路

##### 思路1 哈希表
+ 遍历链表，把遍历过的节点存入哈希表中
+ 当第一次出现被遍历到的节点已经存在于哈希表中的情况时，这个节点就是环形的入口节点
+ 时间复杂度:O(N)
+ 空间复杂度:O(N)

##### 思路2 快慢指针
+ 设快指针是fast，慢指针是slow
+ 快指针以2倍速前进，慢指针以逐步前进，则起始时将fast置于第2个节点，slow置于第1个节点
+ 如果两者最终相遇（不为空），则说明有环，反之无环

+ 时间复杂度:O(N)
+ 空间复杂度:O(1)

### 代码（Java）
**思路1代码**
```java
public class Solution1 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        Map<ListNode, ListNode> map = new HashMap<ListNode, ListNode>();
        ListNode p = head;
        while (p != null) {
            if (map.containsKey(p)) {
                return true;
            }
            map.put(p, p.next);
            p = p.next;
        }
        return false;
    }
}
```
**思路2代码**
```java
public class Solution2 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && slow != null) {
            if (fast == slow) {
                return true;
            }
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return false;
            }
        }
        return false;
        /*
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != slow){
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
         */
    }
}
```