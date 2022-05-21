---
title: LeetCode腾讯精选练习50题-002.两数相加
copyright: true
toc: true
tags:
  - Java
  - LeetCode
  - 链表
  - 模拟
  - 递归
  - 数学
categories:
  - LeetCode
date: 2022-05-21 20:00:00
---


### 题目描述

 * 给定两个 非空 的链表，表示两个非负的整数。
 * 它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请将两个数相加，并以相同形式返回一个表示和的链表。
 * 可以假设除了数字 0 之外，这两个数都不会以 0 开头。

```bash
example
input  : l1 = [2,4,3], l2 = [5,6,4]
output : [7,0,8]
note   : 342 + 465 = 807.

input  : l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
output : [8,9,9,9,0,0,0,1]
```

<!--more-->

### 解题思路

##### 思路1 模拟
+ 同时遍历两个链表，并维护`进位标志`，都不为空时，对应位置的2个节点值和`进位标志`求和得到`sum`，在结果链表末尾创建新节点并将其赋值为`sum`
+ 其中一个为空时，继续维护`进位标志`，只遍历不空的那个链表，对应位置的1个节点值和`进位标志`求和得到`sum1`，在结果链表末尾创建新节点并将其赋值为`sum1`

+ 时间复杂度：O(max(m, n))
+ 空间复杂度：O(1)
##### 思路2 递归
+ 从思路1变形得到的
+ 递归退出边界：两个节点都为null，且进位标志为0，意味着不需要创建新节点；若两个节点为null，但进位标志不为0，说明结果链表末尾需要进位补1，即创建新节点且其值为1
+ 递归操作：创建新节点`node`，其值为两个参数节点的值与进位标志的值之和
+ 递归过程：因为原始数值本身以逆序存放在链表中，所以可以做正向的思考，直接把node.next的求解扔进递归即可

+ 时间复杂度：O(max(m, n))
+ 空间复杂度：O(max(m, n))
##### 思路3 BigInteger
+ 分别遍历两个链表，用StringBuilder记录其逆序数值
+ 分别反转两个链表，得到原始数值
+ 使用BigInteger分别接收两个原始数组并求和，得到的结果重新赋给StringBuilder
+ 逆序遍历结果字符串，将其字符转换成int类型并以此存放到结果链表种

+ 时间复杂度：O(max(m, n))
+ 空间复杂度：O(1)
### 代码（Java）
**思路1代码**
```java
public class Solution1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int jin = 0;
        int sum = 0;
        ListNode list = new ListNode(0);
        ListNode r = list;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + jin;
            jin = sum / 10;
            sum %= 10;
            r.next = new ListNode(sum);
            r = r.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            sum = l1.val + jin;
            jin = sum / 10;
            sum %= 10;
            r.next = new ListNode(sum);
            r = r.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            sum = l2.val + jin;
            jin = sum / 10;
            sum %= 10;
            r.next = new ListNode(sum);
            r = r.next;
            l2 = l2.next;
        }
        if (jin == 1) {
            r.next = new ListNode(1);
        }
        return list.next;
    }

    // 以下代码是上方代码的简化版
    public ListNode addTwoNumbersSim(ListNode l1, ListNode l2) {
        int jin = 0;
        ListNode list = new ListNode(0);
        ListNode r = list;
        while (l1 != null || l2 != null) {
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            int sum = n1 + n2 + jin;

            jin = sum / 10;
            sum %= 10;
            r.next = new ListNode(sum);
            r = r.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (jin == 1) {
            r.next = new ListNode(1);
        }
        return list.next;
    }
}

```
**思路2代码**
```java
public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return loop(l1, l2, 0);
    }

    public ListNode loop(ListNode l1, ListNode l2, int jin) {
        if (l1 == null && l2 == null && jin == 0){
            return null;
        }
        int n1 = l1 == null ? 0 : l1.val;
        int n2 = l2 == null ? 0 : l2.val;
        int sum = n1 + n2 + jin;

        jin = sum / 10;
        sum %= 10;

        ListNode node = new ListNode(sum);
        node.next = loop(l1 != null ? l1.next : null, l2 != null ? l2.next : null, jin);
        return node;
    }
}
```
**思路3代码**
```java
public class Solution3 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder m = new StringBuilder();
        StringBuilder n = new StringBuilder();
        while (l1 != null) {
            m.append(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            n.append(l2.val);
            l2 = l2.next;
        }
        BigInteger mm = new BigInteger(m.reverse().toString());
        BigInteger nn = new BigInteger(n.reverse().toString());
        BigInteger res = mm.add(nn);

        StringBuilder s = new StringBuilder(res.toString());

        ListNode list = new ListNode(0);
        ListNode r = list;
        for (int i = s.length() - 1; i >= 0; i--){
            r.next = new ListNode(s.charAt(i) - '0');
            r = r.next;
        }
        return list.next;
    }
}
```