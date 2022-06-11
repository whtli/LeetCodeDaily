---
title: LeetCode腾讯精选练习50题-142.环形链表 II
copyright: true
toc: true
tags:
  - Java
  - LeetCode
  - 链表
  - 双指针
  - 哈希表
categories:
  - LeetCode
date: 2022-06-07 16:00:00
---


### 题目描述

 * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 
 * 如果链表无环，则返回 null。
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。
 * 注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * 不允许修改 链表。

```bash
example
input  : head = [3,2,0,-4], pos = 1
output : tail connects to node index 1
note   : 返回索引为 1 的链表节点，链表中有一个环，其尾部连接到第二个节点。

input  : head = [1,2], pos = 0
output : tail connects to node index 0
note   : 返回索引为 0 的链表节点，链表中有一个环，其尾部连接到第二个节点。

input  : head = [1], pos = -1
output : no cycle
note   : 返回 null，链表中没有环。
```

<!--more-->

### 解题思路

##### 思路1 快慢指针
+ 设快指针是fast，慢指针是slow，两者起点相同
+ 快指针以2倍速前进，慢指针以逐步前进；可知fast前进的路程s1是slow前进的路程s2的两倍，即 s1 = 2 * s2
+ 设从起点到入环节点的距离（节点个数）是a，入环节点顺序到fast和slow相遇节点的距离为b，相遇节点再顺序到入环节点的距离为c，则有
    - 环长（环内节点总数）为：s3 = b + c
    - fast走过的路程：s1 = a + n(b + c) + b
    - slow走过的路程：s2 = a + b
    - 以上则有：s1 = 2 * s2 => a + n(b + c) + b = 2(a + b)
        - 移项可得：a = c + (n - 1)(b + c)，即，a = c + (n - 1)s3 （⭐）
        - 由⭐可知，从链表起点出发到入环节点的距离a，等于从相遇节点出发向入环节点移动 n - 1 圈再走一个从相遇节点到入环节点的距离
        - 即，两个指针，一个从起始节点，另一个从相遇节点，同时出发，他们最终会经过相等数量的节点，在入环节点处相遇，其中第一个节点一直在环外走，第二个节点一直在环内走
+ 时间复杂度:O(N)
+ 空间复杂度:O(1)

##### 思路2 哈希表
+ 遍历链表，把遍历过的节点存入哈希表中
+ 当第一次出现被遍历到的节点已经存在于哈希表中的情况时，这个节点就是环形的入口节点
+ 时间复杂度:O(N)
+ 空间复杂度:O(N)

### 代码（Java）
**思路1代码**
```java
public class Solution1 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode p = head;
                while (p != slow) {
                    p = p.next;
                    slow = slow.next;
                }
                return p;
            }
        }
        return null;
    }
}
```
**思路2代码**
```java
public class Solution2 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        Set<ListNode> set = new LinkedHashSet<>();
        ListNode slow = head;
        while (slow != null){
            if (set.contains(slow)){
                return slow;
            }
            set.add(slow);
            slow = slow.next;
        }
        return null;
    }
}
```