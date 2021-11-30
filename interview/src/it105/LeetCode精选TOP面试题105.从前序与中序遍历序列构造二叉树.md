---
title: LeetCode精选TOP面试题105.从前序与中序遍历序列构造二叉树
copyright: true
data: 2021-11-30 21:00:00
toc: true
tags: [Java,LeetCode,树,数组,二叉树,分治,面试]
categories: [LeetCode]
---

### 题目描述

 * 给定一棵树的前序遍历 preorder 与中序遍历  inorder 。请构造二叉树并返回其根节点。
 * preorder 和 inorder 均无重复元素
 
```bash
example
input  : preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
output : [3,9,20,null,null,15,7]
input  : preorder = [-1], inorder = [-1]
output : [-1]
```

<!--more-->

### 解题思路
**思路 递归**
+ 根据前序遍历和中序遍历序列的性质，以及数组不含重复元素的性质
+ 前序遍历的首个元素，是树的根节点，其后依次为根节点左子树的前序遍历序列（可为空）、根节点右子树的前序遍历序列（可为空）
+ 中序遍历的根节点元素两侧，分别是根节点的左子树的中序遍历序列（可为空）、右子树的中序遍历序列（可为空）
+ 每个子树的前序遍历和中序遍历序列依然符合上述性质
+ 故使用 迭代 不断构建子树，退出标志是数组为空
    + 先取每次迭代中 前序遍历序列的首个元素 tree ，找到中序遍历序列中的值相等的元素位置
    + 获取 tree 的 左子树 在前序遍历和中序遍历序列中的 子序列，复制到新的可用于新一轮迭代的数组leftPre、leftIn中
    + 使用 tree 节点的前序遍历和中序遍历序列进行新一轮迭代，构建 tree节点的左子树    
    + 获取 tree 的 右子树 在前序遍历和中序遍历序列中的 子序列，复制到新的可用于新一轮迭代的数组rightPre、rightIn中
    + 使用 tree 节点的前序遍历和中序遍历序列进行新一轮迭代，构建 tree节点的右子树

### 代码（Java）
```java
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (null == preorder || preorder.length == 0) {
            return null;
        }
        int length = preorder.length;
        // 从前序遍历数组中获取每一轮的根节点
        TreeNode tree = new TreeNode(preorder[0]);

        // 从中序遍历数组中找到根的位置，以便接下来获取其左右子树
        int index = 0;
        while (index < length) {
            if (inorder[index] == tree.val) {
                break;
            }
            index++;
        }

        // 以下开始分别构建当前节点的左右子树

        // 构建左子树
        if (index > 0) {
            // 左子树不为空，获取tree的左子树在前序遍历和中序遍历序列中的子序列，复制到新的可用于新一轮迭代的数组中
            int[] leftPre = Arrays.copyOfRange(preorder, 1, index + 1);
            int[] leftIn = Arrays.copyOfRange(inorder, 0, index);
            // 递归构建左子树
            tree.left = buildTree(leftPre, leftIn);
        } else {
            // 左子树为空
            tree.left = null;
        }

        // 构建右子树
        int rlen = length - index - 1;
        if (rlen > 0) {
            // 右子树不为空，获取tree的右子树在前序遍历和中序遍历序列中的子序列，复制到新的可用于新一轮迭代的数组中
            int[] rightPre = Arrays.copyOfRange(preorder, index + 1, index + 1 + rlen);
            int[] righIn = Arrays.copyOfRange(inorder, index + 1, index + 1 + rlen);
            // 递归构建左子树
            tree.right = buildTree(rightPre, righIn);
        } else {
            // 右子树为空
            tree.right = null;
        }

        return tree;
    }
}
```