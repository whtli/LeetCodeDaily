---
title: LeetCode精选TOP面试题236.二叉树的最近公共祖先
copyright: true
toc: true
tags:
  - Java
  - LeetCode
  - 二叉树
  - DFS
  - 树
  - 递归
categories:
  - LeetCode
date: 2022-02-20 23:00:00
---


### 题目描述

 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 最近公共祖先的定义为：
 * 对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。


```bash
example
input  : root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
output : 3
input  : root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
output : 5
input  : root = [1,2], p = 1, q = 2
output : 1
```

<!--more-->

### 解题思路

+ 深度优先搜索

**思路1 递归**
+ 递归，dfs
+ 若当前被递归的节点 i 是 p 或者 q，则直接返回
+ 递归 i 的左子树
+ 递归 i 的右子树
+ 若左子树递归结果为空，说明 p 和 q 都在 i 的右子树里，返回右子树的递归结果
+ 若右子树递归结果为空，说明 p 和 q 都在 i 的左子树里，返回左子树的递归结果
+ 若左右子树的递归结果都不为空，说明 p 和 q 分别位于 i 的两侧，直接返回 i 即可。
+ 时间复杂度：O(n)，n 是二叉树的节点数。二叉树的所有节点有且只会被访问一次。
+ 空间复杂度：O(n)，n 是二叉树的节点数。递归调用的栈深度取决于二叉树的高度，二叉树最坏情况下为一条链，此时高度为 n。

**思路2 存储父节点**

+ 借助map和set
+ 先对二叉树进行一次dfs，借助map存储每个节点的父节点，键值对设置为<当前节点的值，当前节点的父节点>
+ 节点 node 的祖先节点：从 root 到 node 的最短路径中，除了 node 以外的节点，都是 node 的祖先节点
+ 对 p 节点进行祖先节点的追溯，在set中记录已经被访问过的节点（从 p 一直到根节点 root ）
+ 对 p 节点进行祖先节点的追溯，如果set中已经包含了 q 或 q 的某个祖先节点 i （i可以为q），说明节点 i 是 p 和 q 的最近公共祖先 LCA
+ 时间复杂度：O(n)，n 是二叉树的节点数。二叉树的所有节点有且只会被访问一次。
+ 空间复杂度：O(n)，n 是二叉树的节点数。递归调用的栈深度取决于二叉树的高度，二叉树最坏情况下为一条链，此时高度为 n；哈希表存储每个节点的父节点也需要 O(n) 的空间复杂度；最后总的空间复杂度为 O(n)。

### 代码（Java）
**思路1代码**
```java
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
}
```
**思路2代码**
```java
public class Solution2 {
    Map<Integer, TreeNode> map = new HashMap<Integer, TreeNode>();
    Set<Integer> visited = new HashSet<Integer>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);

        while (p != null){
            visited.add(p.val);
            p = map.get(p.val);
        }
        while (q != null){
            if (visited.contains(q.val)) {
               return q;
            }
            q = map.get(q.val);
        }
        return root;
    }

    private void dfs(TreeNode root) {
        if (root.left != null) {
            map.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            map.put(root.right.val, root);
            dfs(root.right);
        }
    }
}
```