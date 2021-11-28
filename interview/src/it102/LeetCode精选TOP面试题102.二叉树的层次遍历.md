---
title: LeetCode精选TOP面试题102.二叉树的层次遍历
copyright: true
data: 2021-11-28 21:00:00
toc: true
tags: [Java,LeetCode,二叉树,BFS,树,队列,面试]
categories: [LeetCode]
---

### 题目描述

 * 给定一个二叉树，返回按 层序遍历 得到的节点值。
 * 即逐层地，从左到右访问所有节点。
 * 相同层的节点值放在一个列表中

```bash
example
input  : [3, 9, 20, null, null, 15, 7]
output : [[3], [9,20], [15,7]]
note   :     3
            / \
           9  20
             /  \
            15   7
```

<!--more-->

### 解题思路
**思路**

 * 借助队列 queue 实现二叉树的层次遍历（广度优先遍历）
 * 根节点入队
 * 使用循环判断队列是否为空
    + 每次循环时，队列的长度 queue.size()，即为当前层的节点数量
        + 使用for循环，把队列中当前层的节点 treeNode 逐个移除队列并访问
        + 把每个 treeNode 的值逐个添加到每一层的列表中
        + 当前被访问的节点 treeNode 若有左子树（treeNode.left != null），则左子树入队
        + 当前被访问的节点 treeNode 若有右子树（treeNode.right != null），则右子树入队
    + 把每层的节点值列表，添加到结果列表 lists 中
 * 队列为空时，说明遍历结束，返回lists
 
 * 时间复杂度：O(n)，每个节点进队出队各一次。
 * 空间复杂度：O(n)，队列中元素的个数不超过 n 个。


### 代码（Java）
```java
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 空树直接返回空列表
        List<List<Integer>> lists = new LinkedList<>();
        if (root == null) {
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        // 根节点先入队
        queue.add(root);
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < currentSize; i++) {
                TreeNode treeNode = queue.poll();

                list.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
                // System.out.print(treeNode.val + ", ");
            }
            lists.add(list);
            // System.out.println();
        }
        return lists;
    }
}
```
