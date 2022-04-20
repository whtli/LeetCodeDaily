---
title: LeetCode腾讯精选练习50题-104.二叉树的最大深度
copyright: true
toc: true
tags:
  - Java
  - LeetCode
  - 二叉树
  - DFS
  - BFS
  - 树
categories:
  - LeetCode
date: 2022-04-20 21:00:00
---


### 题目描述

+ 给定一个二叉树，找出其最大深度。
+ 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

```bash
example
input  : [3,9,20,null,null,15,7]
output : 3
note   : 该二叉树的最大深度为 3 
                    3
                   / \
                  9  20
                    /  \
                   15   7
```

<!--more-->

### 解题思路
**思路1 递归**
+ 从下向上，每次返回的都是当前节点的具备最大深度的子树的深度，那么最终返回的就是整个二叉树的最大深度
+ 递归退出条件：当前节点是空节点，返回0，即往下没有深度了
+ 不为空，则分别递归左子树和右子树，求其最大深度
+ 比较左右子树的最大深度并返回其中较大者

**思路2 DFS**
+ 深度优先搜索
+ 借助栈，实现非递归形式的深度优先搜索，先序、中序、后续都可以
+ 在遍历过程中记录当前深度，并在切换左右子树的时候通过比较获取当前最大深度
+ 不断更新最大深度，遍历结束后就可以获得整个二叉树的最大深度

**思路3 BFS**
+ 广度优先搜索
+ 借助队列，实现非递归形式的广度优先搜索
+ 在遍历过程中，首先获取队列的长度，在这个长度内的节点，就是在同一层的
+ 每次遍历完一层，就可以让深度加1，最终就可以获得最大深度

### 代码（Java）
**思路1代码**
```java
public class Solution1 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return loop(root);
    }

    public int loop(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = 1 + loop(node.left);
        int right = 1 + loop(node.right);
        return Math.max(left, right);
    }
}
```
**思路2代码**
```java
public class Solution2 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int curDepth = 0;
        int maxDepth = 0;
        Stack<Integer> allDepth = new Stack<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        // DFS
        while (node != null || !stack.empty()) {
            curDepth++;
            while (node != null) {
                //System.out.println(node.val);
                stack.push(node);
                allDepth.push(curDepth);
                curDepth++;
                node = node.left;
            }
            if (!stack.empty()) {
                TreeNode tmp = stack.pop();
                curDepth = allDepth.pop();
                if (curDepth > maxDepth) {
                    maxDepth = curDepth;
                }
                node = tmp.right;
            }
        }
        return maxDepth;
    }
}
```
**思路3代码**
```java
public class Solution3 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxDepth = 0;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        // BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode tmp = queue.poll();
                size --;
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
            }
            maxDepth ++;
        }
        return maxDepth;
    }
}

```