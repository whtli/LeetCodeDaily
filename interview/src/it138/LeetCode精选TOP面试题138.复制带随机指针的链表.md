---
title: LeetCode精选TOP面试题138. 复制带随机指针的链表
copyright: true
toc: true
tags:
  - Java
  - LeetCode
  - 链表
  - 哈希表
  - 模拟
  - 回溯
categories:
  - LeetCode
date: 2022-03-03 16:00:00
---


### 题目描述

 * 给定一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
 * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
 * 返回复制链表的头节点。
 *
 * 用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 * 代码 只 接受原链表的头节点 head 作为传入参数。

```bash
example
input  : head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
output : [[7,null],[13,0],[11,4],[10,2],[1,0]]  
input  : head = [[3,null],[3,0],[3,null]]
output : [[3,null],[3,0],[3,null]]
```

<!--more-->

### 解题思路

**思路1 哈希表**

+ 遍历原链表，暂不考虑 random 指针，逐个深拷贝原节点并形成新链表，在此过程中用 哈希表map 记录每一对<老节点，新节点>。
+ 遍历原链表和新链表，判断当前原节点 oldNode 的 random 指针是否为空，若不为空，则可让 newNode.random 指向 map 中以 oldNode.random 作为键的值，即 newNode.random = map.get(oldNode.random)


+ 时间复杂度：O(n)
+ 空间复杂度：O(n)

**思路2 原地算法**

+ 暂不考虑 random 指针，先在原链表的每个节点后 深拷贝并插入 一个与其值相同的节点
+ 即，假设原链表为 1 -> 2 -> 3，遍历并插入后，列表更新为 1 -> 1 -> 2 -> 2 -> 3 -> 3
+ 再次遍历该链表，根据**当前链表中的前后关系**，把 原列表节点的 random 指针关系复制给间隔的新链表
+ 即假设当前节点为 node，则当 node.random 不为空时，node.next.random = node.random.next
+ 然后node前进两个位置，绕过新复制出来的链表节点
+ 最后把新老链表拆分开并返回新链表即可

+ 时间复杂度：O(n)
+ 空间复杂度：O(1)

**思路3 回溯 + 哈希表**

+ 利用 回溯 的方式，让每个节点的拷贝操作相互独立。
+ 对于当前节点 node ，首先要进行拷贝，用 哈希表 记录每一对<老节点，新节点>。
+ 递归创建 当前节点的后继节点 node.next 和 当前节点的随机指针指向的节点 node.random。
+ 由于一个节点可能被多个其他节点指向，因此可能会在递归过程中多次尝试拷贝某个节点。
+ 为防止重复拷贝，需要首先检查当前节点是否被拷贝过，即是否已经作为值存在于哈希表中，如果已经拷贝过，可以直接从哈希表中将其取出并返回。

+ 时间复杂度：O(n)
+ 空间复杂度：O(n)

### 代码（Java）
**思路1代码**
```java
public class Solution1 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();

        Node newHead = new Node(-1);
        Node scan = head;
        Node append = newHead;
        while (scan != null) {
            Node newNode = new Node(scan.val);
            map.put(scan, newNode);
            append.next = newNode;
            scan = scan.next;
            append = append.next;
        }
        scan = head;
        append = newHead.next;
        while (scan != null) {
            if (scan.random != null) {
                append.random = map.get(scan.random);
            }
            scan = scan.next;
            append = append.next;
        }
        return newHead.next;
    }
}
```
**思路2代码**
```java
public class Solution2 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node scan = head;
        while (scan != null) {
            Node newNode = new Node(scan.val);
            newNode.next = scan.next;
            scan.next = newNode;
            scan = newNode.next;
        }
        scan = head;
        while (scan != null) {
            if (scan.random != null) {
                scan.next.random = scan.random.next;
            }
            scan = scan.next.next;
        }

        Node newList = head.next;
        Node oldList = head;
        Node res = head.next;
        while (newList != null && oldList != null) {
            oldList.next = newList.next;
            oldList = oldList.next;
            if (oldList != null) {
                newList.next = oldList.next;
                newList = newList.next;
            }
        }
        return res;
    }
}
```
```java
public class Solution3 {
    private Map<Node, Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (!map.containsKey(head)) {
            Node headNew = new Node(head.val);
            map.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return map.get(head);

    }
}
```