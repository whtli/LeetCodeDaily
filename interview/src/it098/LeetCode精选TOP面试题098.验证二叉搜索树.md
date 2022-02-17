---
title: LeetCode精选TOP面试题098.验证二叉搜索树
copyright: true
toc: true
tags:
  - Java
  - LeetCode
  - 中序遍历
  - 二叉树
  - 二叉搜索树
  - DFS
categories:
  - LeetCode
date: 2022-02-17 21:00:00
---


### 题目描述

 * 给定一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * 有效 二叉搜索树 定义如下：
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。

```bash
example
input  : root = [2,1,3]
output : true
input  : root = [5,1,4,null,null,3,6]
output : false
```

<!--more-->

### 解题思路

+ 深度优先搜索
+ 中序遍历

**思路1 递归**
+ 中序DFS，套模板，将树的各节点值存放到列表中
+ 遍历列表，如果出现后一个元素≤前一个元素的情况，则不是有效的二叉搜索树

**思路2 栈模拟**
+ 用栈模拟中序DFS，套模板，将树的各节点值存放到列表中
+ 遍历列表，如果出现后一个元素≤前一个元素的情况，则不是有效的二叉搜索树

### 代码（Java）
**思路1代码**
```java
public class Solution1 {
    public List<Integer> tree = new ArrayList<Integer>();

    public boolean isValidBST(TreeNode root) {
        // 中序遍历，DFS
        dfs(root);

        for (int i = 0; i < tree.size() - 1; i++) {
            if (tree.get(i) >= tree.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        tree.add(root.val);
        dfs(root.right);
    }
}
```
**思路2代码**
```java
public class Solution2 {
    public boolean isValidBST(TreeNode root) {
        List<Integer> tree = new ArrayList<Integer>();
        // 用栈模拟DFS中序遍历
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode tmp = stack.pop();
            if (!tree.isEmpty() && (tmp.val <= tree.get(tree.size() - 1))) {
                return false;
            }
            tree.add(tmp.val);
            root = tmp.right;
        }
        return true;
    }
}
```