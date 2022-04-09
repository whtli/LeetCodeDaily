---
title: LeetCode腾讯精选练习50题-235.二叉搜索树的最近公共祖先
copyright: true
toc: true
tags:
  - Java
  - LeetCode
  - 二叉树
  - 二叉搜索树
  - DFS
  - 树
categories:
  - LeetCode
date: 2022-04-09 21:00:00
---


### 题目描述

 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 最近公共祖先的定义为：
 * 对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。

```bash
example
input  : root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
output : 6
note   : 节点 2 和节点 8 的最近公共祖先是节点 6。
input  : root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
output : 2
note   : 节点 2 和节点 4 的最近公共祖先是节点 2。
```

<!--more-->

### 解题思路

**思路1 公共路径法1**

+ 利用二叉搜索树的性质
+ 先借助DFS记录从根到 节点 p 的路径，以及根到 节点q 的路径
+ 同时遍历两条路径，当节点不同时，就是进入了不同的子路径，分岔口的前一个节点就是 p 和 q 的最近公共祖先
+ 时间复杂度：O(n)
+ 空间复杂度：O(n)，需要存储根节点到 p 和 q 的路径。在最坏的情况下，路径的长度为 O(n)。
             
**思路2 公告路径2法**

+ 利用二叉搜索树的性质

+ 一次循环遍历，不断缩小范围，遍历子树
+ 若 p 的值和 q 的值都小于当前子树的根节点值，说明 p 和 q 都在当前根节点的左子树中，则根节点左移，取其左子树继续遍历
+ 若 p 的值和 q 的值都大于当前子树的根节点值，说明 p 和 q 都在当前根节点的右子树中，则根节点右移，取其右子树继续遍历
+ 若 p 的值和 q 的值不再同时大于或者小于当前子树的根节点值，说明 p 和 q 分别位于当前根节点的左右子树中，即当前的根节点就是p和q的最近公共祖先了
+ 时间复杂度：O(n)
+ 空间复杂度：O(1)

**思路3 递归**

+ 这是一个通用思路，不仅适用于二叉搜索树，且适用于所有的二叉树

+ 递归的出口是，当前节点位空时返回null
+ 记当前节点为 node，如果node是p（或q），直接返回 node 即可，表明找到了p或q所在的位置
+ 递归 node 的左子树，得到子树 left
+ 递归 node 的右子树，得到子树 right
+ 对left和right进行判断
    - 若 left 为空，说明 p 和 q 都在 node 的右子树中，返回 node 的右子树
    - 若 right 为空，说明 p 和 q 都在 node 的左子树中，返回 node 的左子树
    - 若 left 和 right 都不为空，说明 p 和 q 分别位于 node 的左、右子树中，即 node 已经是 p 和 q 的最近公共祖先，直接返回 node 即可
+ 时间复杂度：O(n)，n 是二叉树的节点数。二叉树的所有节点有且只会被访问一次。
+ 空间复杂度：O(n)，n 是二叉树的节点数。递归调用的栈深度取决于二叉树的高度，二叉树最坏情况下为一条链，此时高度为 n。

**思路4 存储父节点**

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
public class Solution1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathLeft = findPath(root, p);
        List<TreeNode> pathRight = findPath(root, q);
        /*int len = Math.max(pathLeft.size(), pathRight.size());
        for (int i = 0; i < len; i++) {
            if (i == pathLeft.size()) {
                return pathLeft.get(i - 1);
            }
            if (i == pathRight.size()) {
                return pathRight.get(i - 1);
            }
            if (pathLeft.get(i).val != pathRight.get(i).val) {
                return pathLeft.get(i - 1);
            }
        }
        return root;*/
        // 下方代码比上方注释掉的代码写起来更简洁一些
        TreeNode res = root;
        for (int i = 0; i < pathLeft.size() && i < pathRight.size(); i++) {
            if (pathLeft.get(i).val == pathRight.get(i).val) {
                res = pathLeft.get(i);
            }else{
                break;
            }
        }
        return res;
    }

    // 记录从根节点到某一个指定节点的路径
    private List<TreeNode> findPath(TreeNode root, TreeNode node) {
        List<TreeNode> path = new ArrayList<>();
        while (node != root) {
            path.add(root);
            if (node.val < root.val) {
                root = root.left;
            } else if (node.val > root.val) {
                root = root.right;
            }
        }
        path.add(root);
        return path;
    }
}

```
**思路2代码**
```java
public class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode res = root;
        while (true) {
            if (res.val > p.val && res.val > q.val){
                res = res.left;
            }
            else if (res.val < p.val && res.val < q.val){
                res = res.right;
            } else {
                break;
            }
        }
        return res;
    }
}
```
**思路3代码**
```java
public class Solution3 {
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
**思路4代码**
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