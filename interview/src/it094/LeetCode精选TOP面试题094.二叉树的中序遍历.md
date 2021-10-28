---
title: LeetCode精选TOP面试题94.二叉树的中序遍历
copyright: true
data: 2021-10-28 21:00:00
toc: true
tags: [Java,LeetCode,树,遍历,列表,面试]
categories: [LeetCode]
---
### 题目描述
给定一个二叉树的根节点 root ，返回它的 中序 遍历。
```bash
example
input  : root = [1,null,2,3]
output : [1,3,2]
input  : root = []
output : []
input  : root = [1]
output : [1]
```
<!--more-->
### 解题思路
**思路1 递归**
典型的递归遍历树结构。

**思路2 迭代**
通过栈模拟递归的实现过程。
递归的时候隐式地维护了一个栈，而我们在迭代的时候需要显式地将这个栈模拟出来。

### 代码（Java）
**思路1代码**
```java
public class Solution1 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        middleReader(root, list);
        return list;
    }

    private void middleReader(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        middleReader(root.left, list);
        list.add(root.val);
        middleReader(root.right, list);
    }
}
```
**思路2代码**
```java
public class Solution2 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }
}
```