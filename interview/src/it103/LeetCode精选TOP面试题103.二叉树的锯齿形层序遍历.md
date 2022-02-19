---
title: LeetCode精选TOP面试题103.二叉树的锯齿形层序遍历
copyright: true
toc: true
tags:
  - Java
  - LeetCode
  - 二叉树
  - BFS
  - 树
  - 队列
categories:
  - LeetCode
date: 2022-02-19 15:00:00
---


### 题目描述

 * 给定二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。
 * 即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行。

```bash
example
input  : root = [3,9,20,null,null,15,7]
output : [[3],[20,9],[15,7]]
note   :     3
            / \
           9  20
             /  \
            15   7
input  : root = []
output : []
```

<!--more-->

### 解题思路

 * 原理仍然是二叉树的层次遍历，见题目 102.二叉树的层次遍历

 * 借助队列 queue 实现二叉树的层次遍历（广度优先搜索）
 * 根节点入队
 * 使用循环判断队列是否为空
    + 每次循环时，队列的长度 queue.size()，即为当前层的节点数量
        + 使用for循环，把队列中当前层的节点 treeNode 逐个移除队列并访问
        + 把每个 treeNode 的值逐个添加到每一层的列表中
        + 当前被访问的节点 treeNode 若有左子树（treeNode.left != null），则左子树入队
        + 当前被访问的节点 treeNode 若有右子树（treeNode.right != null），则右子树入队
    + 把每层的节点值列表，添加到结果列表 lists 中
 * 队列为空时，说明遍历结束
 * 然后遍历lists，将奇数下标的子列表中元素顺序反转，即可满足锯齿遍历的要求
 
 * 时间复杂度：O(n) 
 * 空间复杂度：O(n)

### 代码（Java）
```java
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // 空树直接返回空列表
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        // 根节点先入队
        queue.add(root);
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < currentSize; i++) {
                TreeNode treeNode = queue.poll();
                list.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            lists.add(list);
        }
        for (int i = 0; i < lists.size(); i++) {
            if (i % 2 == 1) {
                Collections.reverse(lists.get(i));
            }
            /* 输出检查
            for (Integer item : lists.get(i)) {
                System.out.print(item + " ");
            }
            System.out.println();
            */
        }
        return lists;
    }
}
```