---
title:  
copyright: true
data: 2021-10-17 21:00:00
toc: true
tags: [Java,LeetCode,链表,面试]
categories: [LeetCode]
---
### 题目描述
给定一个单链表的头节点 head ，判断该链表是否为回文链表。若是，返回 true ；否则，返回 false 。
```bash
example
input  : head = 1->2->2->1
output : true
input  : head = 1->2
output : false 
```
<!--more-->
### 解题思路
**思路1**
+ 头插法改变后半部分链表
+ 时间复杂度O(n)
+ 空间复杂度O(n)
**思路2**
+ 头插法改变前半部分链表
+ 时间复杂度O(n)
+ 空间复杂度O(n)
**思路3**
+ 借助栈，不改变链表结构，只对比节点数值。
+ 时间复杂度O(n)
+ 空间复杂度O(n)
### 代码（Java）
**思路1代码**
```java
public class Solution1 {
    public boolean isPalindrome(ListNode head) {
        // 改变后半部分节点，头插法
        int length = 0;
        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }
        p = head;
        for (int i = 0; i < length / 2; i++) {
            p = p.next;
        }
        if (length % 2 != 0) {
            p = p.next;
        }
        ListNode q = p;
        ListNode newHead = new ListNode(0);
        newHead.next = null;
        for (int i = 0; i < length / 2 && p != null; i++) {
            p = p.next;
            q.next = newHead;
            newHead = q;
            q = p;
        }
        for (int j = 0; j < length / 2; j++) {
            if (newHead.val != head.val) {
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }
        return true;
    }
}
```
**思路2代码**
```java
public class Solution2 {
    public boolean isPalindrome(ListNode head) {
        // 改变前半部分节点，头插法
        int length = 0;
        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }
        p = head;
        for (int i = 0; i < length / 2; i++) {
            p = p.next;
        }

        ListNode newList = new ListNode(0);
        newList.next = null;
        p = head;
        ListNode q = p;

        for (int i = 0; i < length / 2; i++) {
            p = p.next;
            q.next = newList.next;
            newList.next = q;
            q = p;
        }
        if (length % 2 != 0) {
            p = p.next;
        }

        q = newList.next;
        for (int j = 0; j < length / 2; j++) {
            if (q.val != p.val) {
                return false;
            }
            p = p.next;
            q = q.next;
        }
        return true;
    }
}
```
**思路2代码**
```java
import java.util.Stack;

public class Solution3 {
    public boolean isPalindrome(ListNode head) {
        int length = 0;
        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }
        Stack<Integer> stack = new Stack<>();

        p = head;
        for (int i = 0; i < length / 2; i++) {
            stack.push(p.val);
            p = p.next;
        }

        if (length % 2 != 0) {
            p = p.next;
        }
        for (int i = 0; i < length / 2 && p != null; i++) {
            if (stack.pop() != p.val) {
                return false;
            }
            p = p.next;
        }
        return true;
    }
}
```
**链表类定义**
```java
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
```
** Main函数 **
```java
public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(1);
        ListNode p = head;

        p = head.next;
        while (p.next != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println(p.val);
        System.out.println("solution3 and solution2 will not change the structure of list, solution1 will change it.\n");
        System.out.println("==solution3=============");
        Solution3 solution3 = new Solution3();
        boolean result3 = solution3.isPalindrome(head.next);
        System.out.println("result3 : " + result3);
        System.out.println("==after solution3=======");
        p = head.next;
        while (p.next != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println(p.val);
        /**
         * solution 2 和 solution 3 不能同时调用
         * 因为使用其中一个后会改变链表结构。
         */
        System.out.println("\n==solution2=============");
        Solution2 solution2 = new Solution2();
        boolean result2 = solution2.isPalindrome(head.next);
        System.out.println("result2 : " + result2);
        System.out.println("==after solution2=======");
        p = head.next;
        while (p.next != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println(p.val);

        System.out.println("\n==solution1=============");
        Solution1 solution1 = new Solution1();
        boolean result1 = solution1.isPalindrome(head.next);
        System.out.println("result1 : " + result1);
        System.out.println("==after solution1=======");
        p = head.next;
        while (p.next != null) {
            System.out.print(p.val + "->");
            p = p.next;
        }
        System.out.println(p.val);
    }
}

```